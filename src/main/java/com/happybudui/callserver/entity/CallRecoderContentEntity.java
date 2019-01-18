package com.happybudui.callserver.entity;

import java.util.Objects;

public class CallRecoderContentEntity {
    private int callIndex;
    private String callText;
    private String callAudio;

    public CallRecoderContentEntity(int callIndex, String callText, String callAudio) {
        this.callIndex = callIndex;
        this.callText = callText;
        this.callAudio = callAudio;
    }

    public void setCallIndex(int callIndex) {
        this.callIndex = callIndex;
    }

    public void setCallText(String callText) {
        this.callText = callText;
    }

    public void setCallAudio(String callAudio) {
        this.callAudio = callAudio;
    }

    @Override
    public String toString() {
        return "CallRecoderContentEntity{" +
                "callIndex=" + callIndex +
                ", callText='" + callText + '\'' +
                ", callAudio='" + callAudio + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CallRecoderContentEntity that = (CallRecoderContentEntity) o;
        return callIndex == that.callIndex &&
                Objects.equals(callText, that.callText) &&
                Objects.equals(callAudio, that.callAudio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(callIndex, callText, callAudio);
    }
}