package com.example.demo.model;

import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbFlatten;

import java.util.List;

@Setter
public class Itinerary extends BaseMetadata {

    private final BaseMetadata metadata;
    private final List<Route> routes;

    public Itinerary(BaseMetadata metadata, List<Route> routes) {
        this.metadata = metadata;
        this.routes = routes;
    }

    public BaseMetadata getMetadata() {
        return metadata;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    @Override
    public String toString() {
        return "Itinerary{" +
                "metadata=" + metadata +
                ", routes=" + routes +
                '}';
    }

}
