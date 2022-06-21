package com.quiztaker.Models;

public class UserDetails {
    String username;
    String bio;
    String image;
    String email;
    double askingPrice;
    boolean acceptOffer;
    int notification_status;
    String walletTypeName;
    String walletAddress;
    int user_id,peekCredits;
    String preferred_category;
    String last_login_time;
      long       current_time;

    public UserDetails(String username, String bio, String image, String email, double askingPrice, boolean acceptOffer, int notification_status, String walletTypeName, String walletAddress, int user_id, int peekCredits, String preferred_category) {
        this.username = username;
        this.bio = bio;
        this.image = image;
        this.email = email;
        this.askingPrice = askingPrice;
        this.acceptOffer = acceptOffer;
        this.notification_status = notification_status;
        this.walletTypeName = walletTypeName;
        this.walletAddress = walletAddress;
        this.user_id = user_id;
        this.peekCredits = peekCredits;
        this.preferred_category = preferred_category;
    }

    public UserDetails() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getAskingPrice() {
        return askingPrice;
    }

    public void setAskingPrice(double askingPrice) {
        this.askingPrice = askingPrice;
    }

    public boolean isAcceptOffer() {
        return acceptOffer;
    }

    public void setAcceptOffer(boolean acceptOffer) {
        this.acceptOffer = acceptOffer;
    }

    public int getNotification_status() {
        return notification_status;
    }

    public void setNotification_status(int notification_status) {
        this.notification_status = notification_status;
    }

    public String getWalletTypeName() {
        return walletTypeName;
    }

    public void setWalletTypeName(String walletTypeName) {
        this.walletTypeName = walletTypeName;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPeekCredits() {
        return peekCredits;
    }

    public void setPeekCredits(int peekCredits) {
        this.peekCredits = peekCredits;
    }

    public String getPreferred_category() {
        return preferred_category;
    }

    public void setPreferred_category(String preferred_category) {
        this.preferred_category = preferred_category;
    }

    public String getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(String last_login_time) {
        this.last_login_time = last_login_time;
    }

    public long getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(long current_time) {
        this.current_time = current_time;
    }
}
