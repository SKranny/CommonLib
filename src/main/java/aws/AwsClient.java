package aws;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AwsClient {
    private String bucket = "skillboxjava31";

    private String path = "https://storage.yandexcloud.net/";


    private final S3Client s3;

    public String uploadImage(MultipartFile file) throws Exception {
        String partName = UUID.randomUUID().toString();
        PutObjectResponse putObjectResponse = s3.putObject(PutObjectRequest.builder()
                    .bucket(bucket)
                    .key(partName + file.getOriginalFilename())
                    .build(), RequestBody.fromBytes(file.getBytes()));
        return path + partName + file.getOriginalFilename();
    }
}
