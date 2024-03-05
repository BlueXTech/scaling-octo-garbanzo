package com.example.demo.model;

import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.internal.converter.attribute.EnhancedAttributeValue;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.HashMap;
import java.util.Map;

public class KeyConverter implements AttributeConverter<Key> {

    @Override
    public AttributeValue transformFrom(Key key) {
        Map<String, AttributeValue> map = new HashMap<>();
        map.put("PK", key.partitionKeyValue());
        if (key.sortKeyValue().isPresent()) {
            map.put("SK", key.sortKeyValue().get());
        }

        return EnhancedAttributeValue.fromMap(map).toAttributeValue();
    }

    @Override
    public Key transformTo(AttributeValue attributeValue) {
        Map<String, AttributeValue> map = attributeValue.m();
        return Key.builder()
                .partitionValue(map.get("PK"))
                .sortValue(map.get("SK"))
                .build();
    }

    @Override
    public EnhancedType<Key> type() {
        return EnhancedType.of(Key.class);
    }

    @Override
    public AttributeValueType attributeValueType() {
        return AttributeValueType.M;
    }

}
