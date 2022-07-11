package com.exercise.app;

import java.util.UUID;

public class User {

    //Create user class with all required info

    private UUID uuid;
    private String userName;
    private String password;
    private String city;
    private String ipAddress;

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public User(UUID uuid, String userName, String password, String ipAddress, String city) {
        this.uuid = uuid;
        this.userName = userName;
        this.password = password;
        this.ipAddress = ipAddress;
        this.city = city;

    }

    public User() {
       
    }

    
   

    

}