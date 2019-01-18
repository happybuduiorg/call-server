package com.happybudui.callserver.entity;

import java.util.Objects;

public class BlackListEntity {

    private long blackUserNumber;
    private long blackBannedNumber;

    public BlackListEntity() {
    }

    public BlackListEntity(long blackUserNumber, long blackBannedNumber) {
        this.blackUserNumber = blackUserNumber;
        this.blackBannedNumber = blackBannedNumber;
    }

    public long getBlackUserNumber() {
        return blackUserNumber;
    }

    public void setBlackUserNumber(long blackUserNumber) {
        this.blackUserNumber = blackUserNumber;
    }

    public long getBlackBannedNumber() {
        return blackBannedNumber;
    }

    public void setBlackBannedNumber(long blackBannedNumber) {
        this.blackBannedNumber = blackBannedNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlackListEntity that = (BlackListEntity) o;
        return blackUserNumber == that.blackUserNumber &&
                blackBannedNumber == that.blackBannedNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(blackUserNumber, blackBannedNumber);
    }

    @Override
    public String toString() {
        return "BlackListEntity{" +
                "blackUserNumber=" + blackUserNumber +
                ", blackBannedNumber=" + blackBannedNumber +
                '}';
    }
}
