package ru.kolyukaev.testreso.data.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Graf {

    @SerializedName("SBEGIN")
    @Expose
    private String sBegin;
    @SerializedName("NDAY")
    @Expose
    private Integer nDay;
    @SerializedName("SEND")
    @Expose
    private String send;

    public String getSbegin() {
        if (sBegin.length() == 4) {
            return "0" + sBegin;
        }
        return sBegin;
    }

    public void setSbegin(String sBegin) {
        this.sBegin = sBegin;
    }

    public Integer getNday() {
        return nDay;
    }

    public void setNday(Integer nday) {
        this.nDay = nday;
    }

    public String getSend() {
        if (send.length() == 4) {
            return "0" + send;
        }
        return send;
    }

    public void setSend(String send) {
        this.send = send;
    }

}