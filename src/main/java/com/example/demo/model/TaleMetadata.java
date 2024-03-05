package com.example.demo.model;

import com.example.demo.MediaConverter;
import com.example.demo.UserConverter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

@Setter
@DynamoDbBean
public class TaleMetadata extends BaseMetadata {

    private Media cover;
    private Media thumbnail;
    private String title;
    private String GSI1PK;
    private String GSI1SK;

    public TaleMetadata() {}

    public TaleMetadata(String PK, String SK, String id, User creator, Media cover, Media thumbnail, String title, String GSI1PK, String GSI1SK) {
        super(PK, SK, id, creator);
        this.cover = cover;
        this.thumbnail = thumbnail;
        this.title = title;
        this.GSI1PK = GSI1PK;
        this.GSI1SK = GSI1SK;
    }

    @DynamoDbConvertedBy(MediaConverter.class)
    @DynamoDbAttribute(value = "cover")
    public Media getCover() {
        return cover;
    }

    @DynamoDbConvertedBy(MediaConverter.class)
    @DynamoDbAttribute(value = "thumbnail")
    public Media getThumbnail() {
        return thumbnail;
    }

    @DynamoDbAttribute(value = "title")
    public String getTitle() {
        return title;
    }

    @DynamoDbSecondaryPartitionKey(indexNames = {"GSI1"})
    @DynamoDbAttribute(value = "GSI1PK")
    public String getGSI1PK() {
        return GSI1PK;
    }

    @DynamoDbSecondarySortKey(indexNames = {"GSI1"})
    @DynamoDbAttribute(value = "GSI1SK")
    public String getGSI1SK() {
        return GSI1SK;
    }

    @Override
    public String toString() {
        return "TaleMetadata{" +
                "PK='" + this.getPK() + '\'' +
                ", SK='" + this.getSK() + '\'' +
                ", id'" + this.getId() + '\'' +
                ", creator='" + this.getCreator() + '\'' +
                ", cover=" + cover +
                ", thumbnail=" + thumbnail +
                ", title='" + title + '\'' +
                ", GSI1PK='" + GSI1PK + '\'' +
                ", GSI1SK='" + GSI1SK + '\'' +
                '}';
    }

}
