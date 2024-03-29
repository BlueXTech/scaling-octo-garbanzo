package com.example.demo.model;

import com.example.demo.MediaConverter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

@Setter
@DynamoDbBean
public class FeedMetadata extends BaseMetadata {

    private Media thumbnail;
    private String taleId;
    private String GSI1PK;
    private String GSI1SK;

    public FeedMetadata() {}

    public FeedMetadata(String PK, String SK, String id, User creator, Media thumbnail, String taleId, String GSI1PK, String GSI1SK) {
        super(PK, SK, id, creator);
        System.out.println("PK: " + PK + " | SK: " + SK);
        this.thumbnail = thumbnail;
        this.taleId = taleId;
        this.GSI1PK = GSI1PK;
        this.GSI1SK = GSI1SK;
    }

    @DynamoDbConvertedBy(MediaConverter.class)
    @DynamoDbAttribute("thumbnail")
    public Media getThumbnail() {
        return thumbnail;
    }

    @DynamoDbAttribute("taleId")
    public String getTaleId() {
        return taleId;
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
        return "FeedMetadata{" +
                "PK='" + this.getPK() + '\'' +
                ", SK='" + this.getSK() + '\'' +
                ", id'" + this.getId() + '\'' +
                ", creator='" + this.getCreator() + '\'' +
                ", thumbnail=" + thumbnail +
                ", taleId='" + taleId + '\'' +
                ", GSI1PK='" + GSI1PK + '\'' +
                ", GSI1SK='" + GSI1SK + '\'' +
                '}';
    }

}
