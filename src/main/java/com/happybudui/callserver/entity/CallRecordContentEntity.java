package com.happybudui.callserver.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class CallRecordContentEntity {
    private int callRecordId;
    private int callIndex;
    private String callText;
    private String callAudio;

    public CallRecordContentEntity(int callRecordId, int callIndex, String callText, String callAudio) {
        this.callRecordId = callRecordId;
        this.callIndex = callIndex;
        this.callText = callText;
        this.callAudio = callAudio;
    }


    public int getCallRecordId() {
        return callRecordId;
    }

    public void setCallRecordId(int callRecordId) {
        this.callRecordId = callRecordId;
    }

    public int getCallIndex() {
        return callIndex;
    }

    public void setCallIndex(int callIndex) {
        this.callIndex = callIndex;
    }

    public String getCallText() {
        return callText;
    }

    public void setCallText(String callText) {
        this.callText = callText;
    }

    public String getCallAudio() {
        return callAudio;
    }

    public void setCallAudio(String callAudio) {
        this.callAudio = callAudio;
    }

    @Override
    public String toString() {
        return "CallRecordContentEntity{" +
                "callRecordId=" + callRecordId +
                ", callIndex=" + callIndex +
                ", callText='" + callText + '\'' +
                ", callAudio='" + callAudio + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CallRecordContentEntity that = (CallRecordContentEntity) o;
        return callRecordId == that.callRecordId &&
                callIndex == that.callIndex &&
                Objects.equals(callText, that.callText) &&
                Objects.equals(callAudio, that.callAudio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(callRecordId, callIndex, callText, callAudio);
    }
}