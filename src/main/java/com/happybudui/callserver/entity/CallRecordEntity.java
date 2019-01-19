package com.happybudui.callserver.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

//CopyRight © 2018-2018 Happybudui All Rights Reserved.
//Written by Happybudui

@EntityScan
public class CallRecordEntity {
    private int callRecordId;
    private BigDecimal callFromNumber;
    private BigDecimal callToNumber;
    private int callType;
    private Timestamp callStartTime;
    private int callLastedTime;

    public CallRecordEntity() {
    }

    public CallRecordEntity(int callRecordId, BigDecimal callFromNumber, BigDecimal callToNumber, int callType, Timestamp callStartTime, int callLastedTime) {
        this.callRecordId = callRecordId;
        this.callFromNumber = callFromNumber;
        this.callToNumber = callToNumber;
        this.callType = callType;
        this.callStartTime = callStartTime;
        this.callLastedTime = callLastedTime;
    }

    public CallRecordEntity(int callRecordId, long callFromNumber, long callToNumber, int callType, Timestamp callStartTime, int callLastedTime) {
        this.callRecordId = callRecordId;
        this.callFromNumber = new BigDecimal(String.valueOf(callFromNumber));
        this.callToNumber = new BigDecimal(String.valueOf(callToNumber));
        this.callType = callType;
        this.callStartTime = callStartTime;
        this.callLastedTime = callLastedTime;
    }

    public CallRecordEntity(BigDecimal callFromNumber, BigDecimal callToNumber, int callType, Timestamp callStartTime, int callLastedTime) {
        this.callFromNumber = callFromNumber;
        this.callToNumber = callToNumber;
        this.callType = callType;
        this.callStartTime = callStartTime;
        this.callLastedTime = callLastedTime;
    }

    public int getCallRecordId() {
        return callRecordId;
    }

    public void setCallRecordId(int callRecordId) {
        this.callRecordId = callRecordId;
    }

    public BigDecimal getCallFromNumber() {
        return callFromNumber;
    }

    public void setCallFromNumber(BigDecimal callFromNumber) {
        this.callFromNumber = callFromNumber;
    }

    public BigDecimal getCallToNumber() {
        return callToNumber;
    }

    public void setCallToNumber(BigDecimal callToNumber) {
        this.callToNumber = callToNumber;
    }

    public int getCallType() {
        return callType;
    }

    public void setCallType(int callType) {
        this.callType = callType;
    }

    public Timestamp getCallStartTime() {
        return callStartTime;
    }

    public void setCallStartTime(Timestamp callStartTime) {
        this.callStartTime = callStartTime;
    }

    public int getCallLastedTime() {
        return callLastedTime;
    }

    public void setCallLastedTime(int callLastedTime) {
        this.callLastedTime = callLastedTime;
    }

    @Override
    public String toString() {
        return "CallRecordEntity{" +
                "callRecordId=" + callRecordId +
                ", callFromNumber=" + callFromNumber +
                ", callToNumber=" + callToNumber +
                ", callType=" + callType +
                ", callStartTime=" + callStartTime +
                ", callLastedTime=" + callLastedTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CallRecordEntity that = (CallRecordEntity) o;
        return callRecordId == that.callRecordId &&
                callType == that.callType &&
                callLastedTime == that.callLastedTime &&
                Objects.equals(callFromNumber, that.callFromNumber) &&
                Objects.equals(callToNumber, that.callToNumber) &&
                Objects.equals(callStartTime, that.callStartTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(callRecordId, callFromNumber, callToNumber, callType, callStartTime, callLastedTime);
    }
}