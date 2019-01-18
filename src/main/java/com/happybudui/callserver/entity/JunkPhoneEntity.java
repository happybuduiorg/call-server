package com.happybudui.callserver.entity;

import com.happybudui.callserver.mapper.JunkPhoneMapper;

import java.math.BigDecimal;
import java.util.Objects;

public class JunkPhoneEntity {
    private BigDecimal junkNumber;
    private int junkType;

    public JunkPhoneEntity(BigDecimal junkNumber, int junkType) {
        this.junkNumber = junkNumber;
        this.junkType = junkType;
    }

    public JunkPhoneEntity(long junkNumber, int junkType){
        this.junkNumber = new BigDecimal(String.valueOf(junkNumber));
        this.junkType = junkType;
    }

    public BigDecimal getJunkNumber() {
        return junkNumber;
    }

    public void setJunkNumber(BigDecimal junkNumber) {
        this.junkNumber = junkNumber;
    }

    public int getJunkType() {
        return junkType;
    }

    public void setJunkType(int junkType) {
        this.junkType = junkType;
    }

    @Override
    public String toString() {
        return "JunkPhoneEntity{" +
                "junkNumber=" + junkNumber +
                ", junkType=" + junkType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JunkPhoneEntity that = (JunkPhoneEntity) o;
        return junkNumber == that.junkNumber &&
                junkType == that.junkType;
    }

    @Override
    public int hashCode() {

        return Objects.hash(junkNumber, junkType);
    }
}


