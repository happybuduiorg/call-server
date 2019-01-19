package com.happybudui.callserver.entity;

import java.math.BigDecimal;
import java.util.Objects;

//CopyRight © 2018-2018 Happybudui All Rights Reserved.
//Written by Happybudui

public class BlackListEntity {

    private BigDecimal blackUserNumber;
    private BigDecimal blackBannedNumber;

    public BlackListEntity() {
    }

    public BlackListEntity(BigDecimal blackUserNumber, BigDecimal blackBannedNumber) {
        this.blackUserNumber = blackUserNumber;
        this.blackBannedNumber = blackBannedNumber;
    }

    public BigDecimal getBlackUserNumber() {
        return blackUserNumber;
    }

    public void setBlackUserNumber(BigDecimal blackUserNumber) {
        this.blackUserNumber = blackUserNumber;
    }

    public BigDecimal getBlackBannedNumber() {
        return blackBannedNumber;
    }

    public void setBlackBannedNumber(BigDecimal blackBannedNumber) {
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
