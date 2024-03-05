package com.example.demo;

import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.*;
import software.amazon.awssdk.enhanced.dynamodb.model.BatchGetItemEnhancedRequest;
import software.amazon.awssdk.enhanced.dynamodb.model.BatchGetResultPageIterable;
import software.amazon.awssdk.enhanced.dynamodb.model.ReadBatch;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.net.URI;

@Configuration
public class DynamoDbConfig {

    private final Region region = Region.AP_SOUTHEAST_1;
    private final TableSchema<User> userTableSchema = TableSchema.fromBean(User.class);
    private final TableSchema<BaseMetadata> baseMetadataTableSchema = TableSchema.fromBean(BaseMetadata.class);
    private final TableSchema<FeedMetadata> feedMetadataTableSchema = TableSchema.fromBean(FeedMetadata.class);
    private final TableSchema<FeedItem> feedItemTableSchema = TableSchema.fromBean(FeedItem.class);
    private final TableSchema<TaleMetadata> taleMetadataTableSchema = TableSchema.fromBean(TaleMetadata.class);
    private final TableSchema<Route> routeTableSchema = TableSchema.fromBean(Route.class);
    private final TableSchema<StoryItem> storyItemTableSchema = TableSchema.fromBean(StoryItem.class);
    @Value("${AWS_DYNAMODB_TABLE_NAME}")
    private String AWS_DYNAMODB_TABLE_NAME;
    @Value("${AWS_ACCESS_KEY_ID}")
    private String AWS_ACCESS_KEY_ID;
    @Value("${AWS_SECRET_ACCESS_KEY}")
    private String AWS_SECRET_ACCESS_KEY;
    @Value("${AWS_DYNAMODB_ENDPOINT}")
    private String AWS_DYNAMODB_ENDPOINT;

    @Bean
    public DynamoDbEnhancedClient dynamoDbEnhancedClient() {
        System.out.println("DynamoDbEnhancedClient bean created");
        AwsBasicCredentials credentials = AwsBasicCredentials.create(AWS_ACCESS_KEY_ID, AWS_SECRET_ACCESS_KEY);

        DynamoDbClient dynamoDbClient = DynamoDbClient.builder()
                .region(region)
                .endpointOverride(URI.create(AWS_DYNAMODB_ENDPOINT))
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();

        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient)
                .build();
    }

    @Bean
    public DynamoDbTable<BaseMetadata> baseMetadataTable() {
        System.out.println("DynamoDbTable<BaseMetadata> bean created");
        return dynamoDbEnhancedClient().table(AWS_DYNAMODB_TABLE_NAME, baseMetadataTableSchema);
    }

    @Bean
    public DynamoDbTable<User> userTable() {
        System.out.println("DynamoDbTable<User> bean created");
        return dynamoDbEnhancedClient().table(AWS_DYNAMODB_TABLE_NAME, userTableSchema);
    }

    @Bean
    public DynamoDbTable<FeedMetadata> feedMetadataTable() {
        System.out.println("DynamoDbTable<FeedMetadata> bean created");
        return dynamoDbEnhancedClient().table(AWS_DYNAMODB_TABLE_NAME, feedMetadataTableSchema);
    }

    @Bean
    public DynamoDbTable<FeedItem> feedItemTable() {
        System.out.println("DynamoDbTable<FeedItem> bean created");
        return dynamoDbEnhancedClient().table(AWS_DYNAMODB_TABLE_NAME, feedItemTableSchema);
    }

    @Bean
    public DynamoDbTable<TaleMetadata> taleMetadataTable() {
        System.out.println("DynamoDbTable<TaleMetadata> bean created");
        return dynamoDbEnhancedClient().table(AWS_DYNAMODB_TABLE_NAME, taleMetadataTableSchema);
    }

    @Bean
    public DynamoDbTable<Route> routeTable() {
        System.out.println("DynamoDbTable<Route> bean created");
        return dynamoDbEnhancedClient().table(AWS_DYNAMODB_TABLE_NAME, routeTableSchema);
    }

    @Bean
    public DynamoDbTable<StoryItem> storyItemTable() {
        System.out.println("DynamoDbTable<StoryItem> bean created");
        return dynamoDbEnhancedClient().table(AWS_DYNAMODB_TABLE_NAME, storyItemTableSchema);
    }

}