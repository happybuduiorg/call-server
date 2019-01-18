package com.happybudui.callserver.entity;

public class CallRecoderEntity {
    private int callRecordId;
    private long callFromNumber;
    private long callToNumber;
    private int callType;
    private int callStartTime;
    private int callLastedTime;

    public CallRecoderEntity(int callRecordId, long callFromNumber, long callToNumber, int callType, int callStartTime, int callLastedTime) {
        this.callRecordId = callRecordId;
        this.callFromNumber = callFromNumber;
        this.callToNumber = callToNumber;
        this.callType = callType;
        this.callStartTime = callStartTime;
        this.callLastedTime = callLastedTime;
    }

    public void setCallRecordId(int callRecordId) {
        this.callRecordId = callRecordId;
    }

    public void setCallFromNumber(long callFromNumber) {
        this.callFromNumber = callFromNumber;
    }

    public void setCallToNumber(long callToNumber) {
        this.callToNumber = callToNumber;
    }

    public void setCallType(int callType) {
        this.callType = callType;
    }

    public void setCallStartTime(int callStartTime) {
        this.callStartTime = callStartTime;
    }

    public void setCallLastedTime(int callLastedTime) {
        this.callLastedTime = callLastedTime;
    }
}