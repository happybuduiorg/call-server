package com.happybudui.callserver.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Timestamp;
import java.util.Objects;

@EntityScan
public class CallRecoderEntity {
    private int callRecordId;
    private long callFromNumber;
    private long callToNumber;
    private int callType;
    private Timestamp callStartTime;
    private int callLastedTime;

    public CallRecoderEntity(int callRecordId, long callFromNumber, long callToNumber, int callType, Timestamp callStartTime, int callLastedTime) {
        this.callRecordId = callRecordId;
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

    public long getCallFromNumber() {
        return callFromNumber;
    }

    public void setCallFromNumber(long callFromNumber) {
        this.callFromNumber = callFromNumber;
    }

    public long getCallToNumber() {
        return callToNumber;
    }

    public void setCallToNumber(long callToNumber) {
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
        return "CallRecoderEntity{" +
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
        CallRecoderEntity that = (CallRecoderEntity) o;
        return callRecordId == that.callRecordId &&
                callFromNumber == that.callFromNumber &&
                callToNumber == that.callToNumber &&
                callType == that.callType &&
                callLastedTime == that.callLastedTime &&
                Objects.equals(callStartTime, that.callStartTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(callRecordId, callFromNumber, callToNumber, callType, callStartTime, callLastedTime);
    }
}
