package com.happybudui.callserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.math.BigDecimal;
import java.util.Objects;

@EntityScan
public class UserEntity {
    private BigDecimal userNumber;

    @JsonIgnore
    private String userPassword;

    private int userStatus;
    private int userScene;
    private double userLongitude;
    private double userLatitude;
    private String userToken;

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public UserEntity(BigDecimal userNumber, String userPassword, int userStatus, int userScene, double userLongitude, double userLatitude) {
        this.userNumber = userNumber;
        this.userPassword = userPassword;
        this.userStatus = userStatus;
        this.userScene = userScene;
        this.userLongitude = userLongitude;
        this.userLatitude = userLatitude;
    }

    public UserEntity(long userNumber, String userPassword, int userStatus, int userScene, double userLongitude, double userLatitude) {
        this.userNumber = new BigDecimal(String.valueOf(userNumber));
        this.userPassword = userPassword;
        this.userStatus = userStatus;
        this.userScene = userScene;
        this.userLongitude = userLongitude;
        this.userLatitude = userLatitude;
    }

    public BigDecimal getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(BigDecimal userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public int getUserScene() {
        return userScene;
    }

    public void setUserScene(int userScene) {
        this.userScene = userScene;
    }

    public double getUserLongitude() {
        return userLongitude;
    }

    public void setUserLongitude(double userLongitude) {
        this.userLongitude = userLongitude;
    }

    public double getUserLatitude() {
        return userLatitude;
    }

    public void setUserLatitude(double userLatitude) {
        this.userLatitude = userLatitude;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userNumber=" + userNumber +
                ", userPassword='" + userPassword + '\'' +
                ", userStatus=" + userStatus +
                ", userScene=" + userScene +
                ", userLongitude=" + userLongitude +
                ", userLatitude=" + userLatitude +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userNumber == that.userNumber &&
                userStatus == that.userStatus &&
                userScene == that.userScene &&
                Double.compare(that.userLongitude, userLongitude) == 0 &&
                Double.compare(that.userLatitude, userLatitude) == 0 &&
                Objects.equals(userPassword, that.userPassword);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userNumber, userPassword, userStatus, userScene, userLongitude, userLatitude);
    }
}
