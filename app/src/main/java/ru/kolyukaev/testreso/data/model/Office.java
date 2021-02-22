package ru.kolyukaev.testreso.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import ru.kolyukaev.testreso.data.network.response.Graf;


public class Office {
    @SerializedName("SSHORTNAME")
    @Expose
    private String sShortName;

    @SerializedName("SSHORTADDRESS")
    @Expose
    private String sShortAddress;

    @SerializedName("SGRAF")
    @Expose
    private String sGraf;

    @SerializedName("GRAF")
    @Expose
    private List<Graf> graf = null;

    private boolean isOpen;

    public String getsShortName() {
        return sShortName;
    }

    public void setsShortName(String sShortName) {
        this.sShortName = sShortName;
    }

    public String getsShortAddress() {
        return sShortAddress;
    }

    public void setsShortAddress(String sShortAddress) {
        this.sShortAddress = sShortAddress;
    }

    public String getsGraf() {
        return sGraf;
    }

    public void setsGraf(String sGraf) {
        this.sGraf = sGraf;
    }

    public List<Graf> getGraf() {
        if (graf == null)
            return new ArrayList<Graf>();
        return graf;
    }

    public void setGraf(List<Graf> graf) {
        this.graf = graf;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
