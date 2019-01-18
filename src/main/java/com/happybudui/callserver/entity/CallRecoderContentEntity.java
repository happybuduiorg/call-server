package com.happybudui.callserver.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class CallRecoderContentEntity {
    private int callRecoderId;
    private int callIndex;
    private String callText;
    private String callAudio;

    public CallRecoderContentEntity(int callRecoderId, int callIndex, String callText, String callAudio) {
        this.callRecoderId = callRecoderId;
        this.callIndex = callIndex;
        this.callText = callText;
        this.callAudio = callAudio;
    }

    public int getCallRecoderId() {
        return callRecoderId;
    }

    public void setCallRecoderId(int callRecoderId) {
        this.callRecoderId = callRecoderId;
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
        return "CallRecoderContentEntity{" +
                "callRecoderId=" + callRecoderId +
                ", callIndex=" + callIndex +
                ", callText='" + callText + '\'' +
                ", callAudio='" + callAudio + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CallRecoderContentEntity that = (CallRecoderContentEntity) o;
        return callRecoderId == that.callRecoderId &&
                callIndex == that.callIndex &&
                Objects.equals(callText, that.callText) &&
                Objects.equals(callAudio, that.callAudio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(callRecoderId, callIndex, callText, callAudio);
    }
}