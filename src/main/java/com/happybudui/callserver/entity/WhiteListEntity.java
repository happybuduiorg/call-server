package com.happybudui.callserver.entity;

import java.math.BigDecimal;
import java.util.Objects;

//CopyRight © 2018-2018 Happybudui All Rights Reserved.
//Written by Happybudui

public class WhiteListEntity {

    private BigDecimal whiteUserNumber;
    private BigDecimal whiteAllowedNumber;
    private int whiteLevel;

    public WhiteListEntity() {
    }

    public WhiteListEntity(BigDecimal whiteUserNumber, BigDecimal whiteAllowedNumber, int whiteLevel) {
        this.whiteUserNumber = whiteUserNumber;
        this.whiteAllowedNumber = whiteAllowedNumber;
        this.whiteLevel = whiteLevel;
    }

    public BigDecimal getWhiteUserNumber() {
        return whiteUserNumber;
    }

    public void setWhiteUserNumber(BigDecimal whiteUserNumber) {
        this.whiteUserNumber = whiteUserNumber;
    }

    public BigDecimal getWhiteAllowedNumber() {
        return whiteAllowedNumber;
    }

    public void setWhiteAllowedNumber(BigDecimal whiteAllowedNumber) {
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
