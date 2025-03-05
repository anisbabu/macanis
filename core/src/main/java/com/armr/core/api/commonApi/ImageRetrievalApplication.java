import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

@SpringBootApplication
@RestController
@RequestMapping("/images")
public class ImageRetrievalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImageRetrievalApplication.class, args);
    }

    @GetMapping("/{companyCode}/{imageType}/{filename:.+}")
    public ResponseEntity<Resource> getImage(
            @PathVariable String companyCode,
            @PathVariable String imageType,
            @PathVariable String filename) {

        if (!isValidImageType(imageType)) {
            return ResponseEntity.badRequest().build();
        }

        try {
            Path filePath = Paths.get("public/images/" + imageType + "/" + companyCode + "/" + filename);
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists() && resource.isReadable()) {
                String contentType = Files.probeContentType(filePath);

                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(contentType))
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    private boolean isValidImageType(String imageType) {
        return imageType.equals("logo") || imageType.equals("icon") || imageType.equals("bg");
    }
}