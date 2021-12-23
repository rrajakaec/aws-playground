package com.playground.s3;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

public class AwsS3Upload {

    public static void main(String[] args) {
        Region region = Region.US_EAST_1;

        S3Client s3Client = S3Client.builder()
                                .region(region)
                                .build();
        s3Client.putObject(PutObjectRequest.builder()
                        .bucket("rintu-lambda-s3")
                        .key("newFolder/key4")
                        .build(), RequestBody.fromString("Hello S3 from AWS Java SDK"));
        System.out.println("Uploaded Successfully");
        s3Client.close();
        System.out.println("S3 client closed successfully");
    }
}
