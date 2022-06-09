package com.application.easyrentapp.model;

public class User {

    private String id;
    private String username;
    private String fullname;
    private String address;
    private String phone;
    private String email;
    private String imageurl;
    private String bio;

    public User() {
    }

    public User(String id, String username, String fullname,String address,
                String phone,String email, String imageurl, String bio) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.imageurl = imageurl;
        this.bio = bio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
