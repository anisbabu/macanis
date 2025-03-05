package com.armr.core.config;


import com.armr.core.model.AuthUser;
import com.armr.core.repo.AuthPermissionRepo;
import com.armr.core.repo.AuthUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.Optional;

@Service
public class CustomUserDetailsService  implements UserDetailsService {
    @Autowired
    private AuthUserRepo userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AuthUser> userx = userRepository.findByUsername(username);


        if (!userx.isPresent()) {
            throw new UsernameNotFoundException("User Not Found with username: " + username);
        }
        AuthUser user= (AuthUser) userx.get();

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.emptyList()
        );
    }
}