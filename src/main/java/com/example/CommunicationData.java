package com.example;

import java.io.Serializable;
import java.net.InetAddress;

public class CommunicationData implements Serializable {
    private static final long serialVersionUID = 1234567890L;
    String from;
    String to;
    String message;
    Integer type;
    String fromIPAddress;

    public CommunicationData(String from, String to, String message, Integer type) {
        this.from = from;
        this.to = to;
        this.message = message;
        this.type = type;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFromIPAddress() {
        return fromIPAddress;
    }

    public void setFromIPAddress(InetAddress fromIPAddress) {
        this.fromIPAddress = fromIPAddress.getHostAddress();
    }

    public String toString() {
        return "Message: \"" + message + " from: " + from + fromIPAddress + " to:" + to;
    }

}
