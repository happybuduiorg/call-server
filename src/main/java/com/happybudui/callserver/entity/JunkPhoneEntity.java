package com.happybudui.callserver.entity;

import java.util.Objects;

public class JunkPhoneEntity {
    private long junkNumber;
    private int junkType;

    public JunkPhoneEntity(long junkNumber, int junkType) {
        this.junkNumber = junkNumber;
        this.junkType = junkType;
    }

    public long getJunkNumber() {
        return junkNumber;
    }

    public void setJunkNumber(long junkNumber) {
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


