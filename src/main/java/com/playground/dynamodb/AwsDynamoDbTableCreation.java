package com.playground.dynamodb;

import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import javax.inject.Inject;
import java.net.URI;

public class AwsDynamoDbTableCreation {

    public static void main(String[] args) {
        Region region = Region.US_EAST_1;
        try {
            DynamoDbClient dynamoDbClient = DynamoDbClient.builder()
                    .region(region)
                    .endpointOverride(URI.create("http://localhost:8000"))
                    .credentialsProvider(new AwsCredentialsProvider() {
                        @Override
                        public AwsCredentials resolveCredentials() {
                            return new AwsCredentials() {
                                @Override
                                public String accessKeyId() {
                                    return "i3raob";
                                }

                                @Override
                                public String secretAccessKey() {
                                    return "lqvo4a";
                                }
                            };
                        }
                    })
                    .build();

            DynamoDbEnhancedClient dynamoDbEnhancedClient = DynamoDbEnhancedClient.builder()
                    .dynamoDbClient(dynamoDbClient)
                    .build();

            DynamoDbTable<Catalog1> catalogDynamoDbTable = dynamoDbEnhancedClient.table("Catalog1", TableSchema.fromBean(Catalog1.class));
            System.out.println(catalogDynamoDbTable.tableName());
            catalogDynamoDbTable.createTable();
            System.out.println("Table Created Successfully");
            //catalogDynamoDbTable.;
        } catch (Exception exception) {
            System.out.println(exception);
        }



    }
}
