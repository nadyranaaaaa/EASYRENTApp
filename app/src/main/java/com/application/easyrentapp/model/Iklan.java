package com.application.easyrentapp.model;

import com.google.firebase.firestore.DocumentId;

public class Iklan {

    @DocumentId
    private String alamat;
    private String daerah;
    private String negeri;
    private String category;
    private String kelengkapan;
    private String maklumat;
    private String deposit;
    private String sewa;
    private String pendahuluan;
    private String bilik;
    private String tandas;
    private String gambar;


    public Iklan() {
    }

    public Iklan(String alamat,
                 String daerah,
                 String negeri,
                 String category,
                 String kelengkapan,
                 String maklumat,
                 String deposit,
                 String sewa,
                 String pendahuluan,
                 String bilik,
                 String tandas,
                 String gambar) {

        this.alamat = alamat;
        this.daerah = daerah;
        this.negeri = negeri;
        this.category = category;
        this.kelengkapan = kelengkapan;
        this.maklumat = maklumat;
        this.deposit = deposit;
        this.sewa = sewa;
        this.pendahuluan = pendahuluan;
        this.bilik = bilik;
        this.tandas = tandas;
        this.gambar = gambar;
    }


    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getDaerah() {
        return daerah;
    }

    public void setDaerah(String daerah) {
        this.daerah = daerah;
    }

    public String getNegeri() {
        return negeri;
    }

    public void setNegeri(String negeri) {
        this.negeri = negeri;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getKelengkapan() {
        return kelengkapan;
    }

    public void setKelengkapan(String kelengkapan) {
        this.kelengkapan = kelengkapan;
    }

    public String getMaklumat() {
        return maklumat;
    }

    public void setMaklumat(String maklumat) {
        this.maklumat = maklumat;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getSewa() {
        return sewa;
    }

    public void setSewa(String sewa) {
        this.sewa = sewa;
    }

    public String getPendahuluan() {
        return pendahuluan;
    }

    public void setPendahuluan(String pendahuluan) {
        this.pendahuluan = pendahuluan;
    }

    public String getBilik() {
        return bilik;
    }

    public void setBilik(String bilik) {
        this.bilik = bilik;
    }

    public String getTandas() {
        return tandas;
    }

    public void setTandas(String tandas) {
        this.tandas = tandas;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}

