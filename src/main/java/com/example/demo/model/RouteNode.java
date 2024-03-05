package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
public class RouteNode {

    private String placeId;
    private String name;
    private String address;
    private Coordinates coord;

    public RouteNode(String placeId, String name, String address, Coordinates coord) {
        this.placeId = placeId;
        this.name = name;
        this.address = address;
        this.coord = coord;
    }

    public String getPlaceId() {
        return placeId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Coordinates getCoord() {
        return coord;
    }

    @Override
    public String toString() {
        return "RouteNode{" +
                "placeId='" + placeId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", coord=" + coord +
                '}';
    }

}
