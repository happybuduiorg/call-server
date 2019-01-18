package com.happybudui.callserver.entity;

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
}