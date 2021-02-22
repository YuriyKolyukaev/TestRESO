package ru.kolyukaev.testreso.data.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FullResponceOfOffices {

    @SerializedName("IDOKRUG")
    @Expose
    private Integer idokrug;
    @SerializedName("NLONG")
    @Expose
    private Double nlong;
    @SerializedName("SADDRESS")
    @Expose
    private String saddress;
    @SerializedName("SSHORTNAME")
    @Expose
    private String sShortName;
    @SerializedName("SSHORTADDRESS")
    @Expose
    private String sShortAddress;
    @SerializedName("LBANKOMAT")
    @Expose
    private Boolean lBankomat;
    @SerializedName("LSPR")
    @Expose
    private Boolean lspr;
    @SerializedName("IDUNDERGROUND")
    @Expose
    private List<Idunderground> idunderground = null;
    @SerializedName("LPAYBYCARD")
    @Expose
    private Boolean lPayByCard;
    @SerializedName("SPHONE")
    @Expose
    private String sPhone;
    @SerializedName("SGRAF")
    @Expose
    private String sgraf;
    @SerializedName("GRAF")
    @Expose
    private List<Graf> graf = null;
    @SerializedName("NLAT")
    @Expose
    private Double nLat;
    @SerializedName("CPHONE")
    @Expose
    private List<Cphone> cphone = null;
    @SerializedName("NTIMEZONE")
    @Expose
    private String nTimezone;
    @SerializedName("ID")
    @Expose
    private Integer id;
    @SerializedName("SEMAIL")
    @Expose
    private String semail;

    public Integer getIdokrug() {
        return idokrug;
    }

    public void setIdokrug(Integer idokrug) {
        this.idokrug = idokrug;
    }

    public Double getNlong() {
        return nlong;
    }

    public void setNlong(Double nlong) {
        this.nlong = nlong;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public String getSshortname() {
        return sShortName;
    }

    public void setSshortName(String sShortName) {
        this.sShortName = sShortName;
    }

    public String getSshortAddress() {
        return sShortAddress;
    }

    public void setSshortAddress(String sShortAddress) {
        this.sShortAddress = sShortAddress;
    }

    public Boolean getLbankomat() {
        return lBankomat;
    }

    public void setLbankomat(Boolean lBankomat) {
        this.lBankomat = lBankomat;
    }

    public Boolean getlspr() {
        return lspr;
    }

    public void setLSPR(Boolean lspr) {
        this.lspr = lspr;
    }

    public List<Idunderground> getIdunderground() {
        return idunderground;
    }

    public void setIdunderground(List<Idunderground> idunderground) {
        this.idunderground = idunderground;
    }

    public Boolean getLpayByCard() {
        return lPayByCard;
    }

    public void setPayByCard(Boolean lPayByCard) {
        this.lPayByCard = lPayByCard;
    }

    public String getSphone() {
        return sPhone;
    }

    public void setSphone(String sPhone) {
        this.sPhone = sPhone;
    }

    public String getsGraf() {
        return sgraf;
    }

    public void setsGraf(String sgraf) {
        this.sgraf = sgraf;
    }

    public List<Graf> getGraf() {
        return graf;
    }

    public void setGraf(List<Graf> graf) {
        this.graf = graf;
    }

    public Double getNlat() {
        return nLat;
    }

    public void setNlat(Double nLat) {
        this.nLat = nLat;
    }

    public List<Cphone> getCphone() {
        return cphone;
    }

    public void setCphone(List<Cphone> cphone) {
        this.cphone = cphone;
    }

    public String getNtimezone() {
        return nTimezone;
    }

    public void setNtimezone(String ntimezone) {
        this.nTimezone = ntimezone;
    }

    public Integer getId() {
        return id;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

}
