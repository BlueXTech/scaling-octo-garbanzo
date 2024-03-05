package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class Media {

    private String id;
    private String type;
    private String uri;
    private Integer height;
    private Integer width;

    public Media() {}

    public Media(String id, String type, String uri, Integer height, Integer width) {
        this.id = id;
        this.type = type;
        this.uri = uri;
        this.height = height;
        this.width = width;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Media{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", uri='" + uri + '\'' +
                ", height=" + height +
                ", width=" + width +
                '}';
    }

}
