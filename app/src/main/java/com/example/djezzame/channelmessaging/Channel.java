package com.example.djezzame.channelmessaging;

/**
 * Created by djezzame on 05/02/2018.
 */
public class Channel {
    private int channelID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChannelID() {
        return channelID;
    }

    public void setChannelID(int channelID) {
        this.channelID = channelID;
    }

    public int getConnectedusers() {
        return connectedusers;
    }

    public void setConnectedusers(int connectedusers) {
        this.connectedusers = connectedusers;
    }

    private String name;
    private int connectedusers;
}
