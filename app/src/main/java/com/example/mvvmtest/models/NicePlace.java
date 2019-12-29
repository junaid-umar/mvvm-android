package com.example.mvvmtest.models;

public class NicePlace {

    private String userImage;
    private String userName;

    public NicePlace(String userImage, String userName) {

        this.userImage = userImage;
        this.userName = userName;

    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
