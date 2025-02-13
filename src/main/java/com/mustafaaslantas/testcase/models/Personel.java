package com.mustafaaslantas.testcase.models;

public class Personel {
    private String TC;
    private String Ad;
    private String Soyad;

    public Personel(String TC, String Ad, String Soyad) {
        this.TC = TC;
        this.Ad = Ad;
        this.Soyad = Soyad;
    }

    public String getTC() {
        return TC;
    }
    public void setTC(String TC) {
        this.TC = TC;
    }
    public String getAd() {
        return Ad;

    }
    public void setAd(String Ad) {
        this.Ad = Ad;
    }
    public String getSoyad() {
        return Soyad;

    }
    public void setSoyad(String Soyad) {
        this.Soyad = Soyad;
    }
}
