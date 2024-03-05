//package com.example.demo.model;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
//import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
//import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
//import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
//
//import java.util.Map;
//
//public class ItineraryConverter implements AttributeConverter<Itinerary> {
//
//    @Autowired
//    private UserConverter userConverter;
//
//    @Override
//    public AttributeValue transformFrom(Itinerary itinerary) {
//
//        return AttributeValue.fromM(
//                Map.of(
//                        "id", AttributeValue.fromS(itinerary.getId()),
//                        "creator", userConverter.transformFrom(itinerary.getCreator()),
//                        "routes", AttributeValue.fromL(itinerary.getRoutes());
//                )
//        );
//    }
//
//    @Override
//    public Itinerary transformTo(AttributeValue attributeValue) {
//        return null;
//    }
//
//    @Override
//    public EnhancedType<Itinerary> type() {
//        return null;
//    }
//
//    @Override
//    public AttributeValueType attributeValueType() {
//        return null;
//    }
//}
