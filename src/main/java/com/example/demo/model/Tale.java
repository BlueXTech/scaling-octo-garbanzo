package com.example.demo.model;

import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

import java.util.List;

//@Getter(onMethod = @__({
//        @DynamoDbAttribute("snapshot"),
//        @DynamoDbConvertedBy(SnapshotConverter.class)
//}))
@Setter
public class Tale {

    private TaleMetadata metadata;
    private Itinerary itinerary;
    private List<StoryItem> story;

    public Tale(TaleMetadata metadata, Itinerary itinerary, List<StoryItem> story) {
        this.metadata = metadata;
        this.itinerary = itinerary;
        this.story = story;
    }

    public TaleMetadata getMetadata() {
        return metadata;
    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    public List<StoryItem> getStory() {
        return story;
    }

    @Override
    public String toString() {
        return "Tale{" +
                "metadata=" + metadata +
                ", itinerary=" + itinerary +
                ", story=" + story +
                '}';
    }

}
