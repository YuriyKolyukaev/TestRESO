package ru.kolyukaev.testreso.data.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Idunderground {

    @SerializedName("SNAME")
    @Expose
    private String sname;
    @SerializedName("ID")
    @Expose
    private Integer id;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
