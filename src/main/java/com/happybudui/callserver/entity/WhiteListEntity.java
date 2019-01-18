package com.happybudui.callserver.entity;

import java.util.Objects;

public class WhiteListEntity {

    private long whiteUserNumber;
    private long whiteAllowedNumber;
    private int whiteLevel;

    public WhiteListEntity() {
    }

    public WhiteListEntity(long whiteUserNumber, long whiteAllowedNumber, int whiteLevel) {
        this.whiteUserNumber = whiteUserNumber;
        this.whiteAllowedNumber = whiteAllowedNumber;
        this.whiteLevel = whiteLevel;
    }

    public long getWhiteUserNumber() {
        return whiteUserNumber;
    }

    public void setWhiteUserNumber(long whiteUserNumber) {
        this.whiteUserNumber = whiteUserNumber;
    }

    public long getWhiteAllowedNumber() {
        return whiteAllowedNumber;
    }

    public void setWhiteAllowedNumber(long whiteAllowedNumber) {
        this.whiteAllowedNumber = whiteAllowedNumber;
    }

    public int getWhiteLevel() {
        return whiteLevel;
    }

    public void setWhiteLevel(int whiteLevel) {
        this.whiteLevel = whiteLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WhiteListEntity that = (WhiteListEntity) o;
        return whiteUserNumber == that.whiteUserNumber &&
                whiteAllowedNumber == that.whiteAllowedNumber &&
                whiteLevel == that.whiteLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(whiteUserNumber, whiteAllowedNumber, whiteLevel);
    }

    @Override
    public String toString() {
        return "WhiteListEntity{" +
                "whiteUserNumber=" + whiteUserNumber +
                ", whiteAllowedNumber=" + whiteAllowedNumber +
                ", whiteLevel=" + whiteLevel +
                '}';
    }
}
