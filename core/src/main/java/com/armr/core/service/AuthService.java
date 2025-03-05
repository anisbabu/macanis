package com.armr.core.service;


import com.armr.core.config.JwtUtil;
import com.armr.core.dto.*;
import com.armr.core.model.AuthUser;
import com.armr.core.model.Company;
import com.armr.core.repo.AuthUserRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class AuthService {


    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private AuthUserRepo userRepo;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private AuthPermissionService authPermissionService;
    //    @Autowired
//    private PasswordEncoder passwordEncoder;
    @Autowired
    private CompanyService companyService;

    //final Map<String, List<String>> store = new HashMap();

    public ResponseEntity<?> login(LoginRequestDto request) {
        System.out.println("login req 2424" + request);
        Optional<AuthUser> userOptional = userRepo.findByUsername(request.getUsername());
        if (userOptional.isPresent()) {
            AuthUser authUser = userOptional.get();
            if (request.getPassword().equals(authUser.getPassword())) {
//            if (passwordEncoder.matches(request.getPassword(), authUser.getPassword())) {
                String token = jwtUtil.generateToken(request.getUsername());

//chek conany info
                List<Company> companies = authPermissionService.findUserActiveCompany(authUser);

                String companyCode = null;

                if (companies == null || companies.isEmpty() || companies.size() == 0) {
                    //todo
                    System.out.println("no company found");
                } else if (companies.size() == 1) {
                    companyCode = companies.get(0).getCode();
                } else {

                    if (request.getCompanyCode() != null) {
                        for (Company company : companies) {
                            if (company.getCode().equals(request.getCompanyCode())) {
                                companyCode = company.getCode();
                                break;
                            }
                        }

                        if (companyCode != null) {

                            LoginResponseDTO response = new LoginResponseDTO(
                                    token,
                                    authUser.getUsername(),
                                    companyCode,
                                    "USER",  // Example role, you can retrieve the actual role from the service
                                    "Login successful"
                            );
                            return ResponseEntity.ok().body(response);
                        } else {

                            LoginOptionResponseDto responsex = doMultiCOmpayHandle(companies, authUser.getId());

                            return ResponseEntity.ok().body(responsex);
                        }
                    } else {
                        System.out.println("Interdinate response no choosen comapy but has many comapy");

                        LoginOptionResponseDto responsex = doMultiCOmpayHandle(companies, authUser.getId());

                        return ResponseEntity.ok().body(responsex);
                    }

                    //  return null;
                }

                LoginResponseDTO response = new LoginResponseDTO(
                        token,
                        authUser.getUsername(),
                        companyCode,
                        "USER",  // Example role, you can retrieve the actual role from the service
                        "Login successful"
                );
                return ResponseEntity.ok().body(response);
            } else
                return ResponseEntity.status(401).body("Invalid password");
        } else {
            return ResponseEntity.status(401).body("Invalid username");
        }
    }

    private LoginOptionResponseDto doMultiCOmpayHandle(List<Company> companies, String userId) {
        String uuid = UUID.randomUUID().toString();

        List<Map<String, String>> companySelectionMap = getMapOfCodeAndName(companies);
        List<String> companySelectionCodes = getListOfCode(companies);

        System.out.println("Interdinate response more thene on company , your wNTEDN NOT IN lis");

        LoginOptionResponseDto responsex = new LoginOptionResponseDto(
                uuid,
                userId,
                companySelectionMap,
                IntermediateProcessType.COMPANY_SELECTION_REQUIRED,
                "Please Choose One Company"
        );

        try {
            String sss = objectMapper.writeValueAsString(companySelectionCodes);
            redisTemplate.opsForValue().set(uuid + "~" + userId, sss, 3, TimeUnit.MINUTES);

        } catch (Exception dggdd) {

        }

//        redisTemplate.put(uuid + "~" + userId, companySelectionCodes);

        return responsex;

    }

    private List<String> getListOfCode(List<Company> companies) {
        List<String> ddd = new ArrayList<>();
        for (Company company : companies) {

            ddd.add(company.getCode());
        }
        return ddd;
    }

    private List<Map<String, String>> getMapOfCodeAndName(List<Company> companies) {

        List<Map<String, String>> ddd = new ArrayList<>();

        for (Company company : companies) {

            Map mmm = new HashMap<>();
            mmm.put("code", company.getCode());
            mmm.put("caption", company.getName());

            ddd.add(mmm);
        }
        return ddd;

    }

    public Optional<AuthUser> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public ResponseEntity<?> intermediateProcess(IntermediateProcessRequestDto request) {

        if (request.getIntermediateProcessType() == IntermediateProcessType.COMPANY_SELECTION_REQUIRED) {
            if (request.getSelectedCompanyCode() == null) {
                return ResponseEntity.status(401).body("Invalid request");
            }
        }
        if (request.getIntermediateProcessType() == IntermediateProcessType.OTP_REQUIRED) {
            if (request.getOtp() == null) {
                return ResponseEntity.status(401).body("Invalid request");
            }
        }
        if (request.getIntermediateProcessType() == IntermediateProcessType.OTP_WITH_COMPANY_SELECTION_REQUIRED) {
            if (request.getOtp() == null || request.getSelectedCompanyCode() == null) {
                return ResponseEntity.status(401).body("Invalid request");
            }
        }

        String storedToken = redisTemplate.opsForValue().get(request.getRequestId() + "~" + request.getAuthUserId());
        // List<String> companySelectionCodes = store.get(request.getRequestId() + "~" + request.getUserId());


        List<String> companySelectionCodes = null;
        try {
            companySelectionCodes = objectMapper.readValue(storedToken, List.class);
        } catch (Exception jk) {

        }

        if (companySelectionCodes == null) {
            return ResponseEntity.status(401).body("Invalid request");
        } else if (companySelectionCodes.contains(request.getSelectedCompanyCode())) {

            AuthUser eeee = userRepo.getReferenceById(request.getAuthUserId());
            String token = jwtUtil.generateToken(eeee.getUsername());

            LoginResponseDTO response = new LoginResponseDTO(
                    token,
                    eeee.getUsername(),
                    request.getSelectedCompanyCode(),
                    "USER",  // Example role, you can retrieve the actual role from the service
                    "Login successful with choosen company"
            );

            redisTemplate.delete(request.getRequestId() + "~" + request.getAuthUserId());
            return ResponseEntity.ok().body(response);
        }

        return null;
    }
}
