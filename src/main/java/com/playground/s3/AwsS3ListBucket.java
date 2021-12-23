package com.playground.s3;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListBucketsRequest;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;

public class AwsS3ListBucket {

    public static void main(String[] args) {
        Region region = Region.US_EAST_1;

        S3Client s3Client = S3Client.builder()
                .region(region)
                .build();

        ListBucketsRequest request = ListBucketsRequest.builder().build();
        ListBucketsResponse response = s3Client.listBuckets(request);
        response.buckets()
                .forEach(b -> System.out.println(b.name()));
    }
}
