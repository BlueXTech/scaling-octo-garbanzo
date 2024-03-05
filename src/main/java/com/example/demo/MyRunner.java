package com.example.demo;

import com.example.demo.model.Tale;
import com.example.demo.model.User;
import com.example.demo.repository.FeedRepository;
import com.example.demo.repository.TaleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Expression;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.PutItemEnhancedRequest;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private DynamoDbEnhancedClient dynamoDbEnhancedClient;
    @Autowired
    private DynamoDbTable<User> userTable;
    @Autowired
    private UserService userService;
    @Autowired
    private TaleRepository taleRepository;
    @Autowired
    private FeedRepository feedRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running......");
//        taleRepository.getNextTalesMetadataPage();
//        taleRepository.getTaleByTaleId("tale1");
//        feedRepository.getFeedByFeedId("feed1");
//        feedRepository.deleteFeedById("feed1");
//        Tale tale = taleRepository.getTaleById("tale1");

    }

}
