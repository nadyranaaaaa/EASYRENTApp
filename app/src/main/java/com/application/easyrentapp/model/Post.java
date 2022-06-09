package com.application.easyrentapp.model;

import com.google.firebase.firestore.DocumentId;

public class Post {

    @DocumentId
    private String postid;
    private String alamat;
    private String daerah;
    private String negeri;
    private String category;
    private String kelengkapan;
    private String description;
    private String deposit;
    private String sewa;
    private String pendahuluan;
    private String bilik;
    private String tandas;
    private String postimage;
    private String publisher;



    public Post() {
    }

    public Post(String postid,
                String alamat,
                String daerah,
                String negeri,
                String category,
                String kelengkapan,
                String description,
                String deposit,
                String sewa,
                String pendahuluan,
                String bilik,
                String tandas,
                String postimage, String publisher) {
        this.postid = postid;
        this.alamat = alamat;
        this.daerah = daerah;
        this.negeri = negeri;
        this.category = category;
        this.kelengkapan = kelengkapan;
        this.description = description;
        this.deposit = deposit;
        this.sewa = sewa;
        this.pendahuluan = pendahuluan;
        this.bilik = bilik;
        this.tandas = tandas;
        this.postimage = postimage;
        this.publisher = publisher;

    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getPostimage() { return postimage; }

    public void setPostimage(String postimage) { this.postimage = postimage; }

    public String getPublisher() { return publisher; }

    public void setPublisher(String publisher) { this.publisher = publisher; }

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

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

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

}

