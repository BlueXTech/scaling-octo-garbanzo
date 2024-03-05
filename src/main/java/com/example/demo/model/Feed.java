package com.example.demo.model;

import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbFlatten;

import java.util.List;

@Setter
public class Feed {

    private FeedMetadata metadata;
    private List<FeedItem> feedItems;

    public Feed(FeedMetadata metadata, List<FeedItem> feedItems) {
        System.out.println("METADATA:" + metadata);
        this.metadata = metadata;
        this.feedItems = feedItems;
    }

    public FeedMetadata getMetadata() {
        return metadata;
    }

    public List<FeedItem> getFeedItems() {
        return feedItems;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "metadata=" + metadata +
                ", feedItems=" + feedItems +
                '}';
    }

}
