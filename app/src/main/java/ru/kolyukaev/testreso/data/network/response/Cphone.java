package ru.kolyukaev.testreso.data.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Cphone {

    @SerializedName("SPHONE")
    @Expose
    private String sPhone;
    @SerializedName("SPHONETYPE")
    @Expose
    private String sPhoneType;
    @SerializedName("SPHONEADD")
    @Expose
    private String sPhoneAdd;

    public String getSphone() {
        return sPhone;
    }

    public void setSphone(String sPhone) {
        this.sPhone = sPhone;
    }

    public String getSphoneType() {
        return sPhoneType;
    }

    public void setSphoneType(String sPhoneType) {
        this.sPhoneType = sPhoneType;
    }

    public String getSphoneAdd() {
        return sPhoneAdd;
    }

    public void setSphoneAdd(String sPhoneAdd) {
        this.sPhoneAdd = sPhoneAdd;
    }

}