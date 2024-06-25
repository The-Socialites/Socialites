package com.makersacademy.acebook.service;

import com.makersacademy.acebook.model.Event;
import com.makersacademy.acebook.model.User;
import com.makersacademy.acebook.repository.EventRepository;
import com.makersacademy.acebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import java.util.*;
import javax.transaction.Transactional;
import java.io.IOException;

@Service
public class EventService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private S3Service s3Service;

    @Autowired
    private final S3Client s3Client;
    private final S3Presigner s3Presigner;
    private final String bucketName;

    @Autowired
    public EventService(
            @Value("${aws.region}") String region,
            @Value("${aws.accessKeyId}") String accessKeyId,
            @Value("${aws.secretAccessKey}") String secretAccessKey,
            @Value("${aws.s3.bucket.name}") String bucketName) {

        this.bucketName = bucketName;
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(accessKeyId, secretAccessKey);

        this.s3Client = S3Client.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();

        this.s3Presigner = S3Presigner.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();
    }

    public String saveProfilePicture(MultipartFile image) throws IOException {
        String filename = "profile_pictures/" + System.currentTimeMillis() + "_" + image.getOriginalFilename();
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(filename)
                .build();
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", image.getContentType());
        PutObjectResponse response = s3Client.putObject(putObjectRequest,
                software.amazon.awssdk.core.sync.RequestBody.fromBytes(image.getBytes()));
        GetObjectPresignRequest getObjectPresignRequest = GetObjectPresignRequest.builder()
                .getObjectRequest(r -> r.bucket(bucketName).key(filename))
                .signatureDuration(java.time.Duration.ofDays(7))
                .build();
        return s3Presigner.presignGetObject(getObjectPresignRequest).url().toString();
    }


    @Transactional
    public void savePost(Event event, MultipartFile image) throws IOException {
        if (!image.isEmpty()) {
            String imageUrl = s3Service.saveImage(image);
            event.setEventImageUrl(imageUrl);
        }
        eventRepository.save(event);
    }

//    public void saveProfilePicture(User user, MultipartFile image) throws IOException {
//        if (!image.isEmpty()) {
//            String imageUrl = s3Service.saveImage(image);
//            user.setProfilePictureUrl(imageUrl);
//        }
//        userRepository.save(user);
//    }
}

