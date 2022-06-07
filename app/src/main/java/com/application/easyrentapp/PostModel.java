package com.application.easyrentapp;

public class PostModel {
    private String ALAMAT;
    private String DAERAH;
    private String NEGERI;
    private String KELENGKAPAN;
    private String CATEGORY;
    private String MAKLUMAT;
    private String DEPOSIT;
    private String SEWA;
    private String PENDAHULUAN;
    private String BILIK;
    private String TANDAS;
    private String mImageUrl;

    public PostModel() {
    }

    public PostModel(String Alamat, String Daerah, String Negeri, String Kelengkapan, String Category, String Maklumat, String Deposit, String Sewa, String Pendahuluan, String Bilik, String Tandas, String mImageUrl) {

        ALAMAT = Alamat;
        DAERAH = Daerah;
        NEGERI = Negeri;
        KELENGKAPAN = Kelengkapan;
        CATEGORY = Category;
        MAKLUMAT = Maklumat;
        DEPOSIT = Deposit;
        SEWA = Sewa;
        PENDAHULUAN = Pendahuluan;
        BILIK = Bilik;
        TANDAS = Tandas;
        this.mImageUrl = mImageUrl;
    }

    public String getALAMAT() {
        return ALAMAT;
    }

    public void setALAMAT(String Alamat) {
        ALAMAT = Alamat;
    }

    public String getDAERAH() { return DAERAH; }

    public void setDAERAH(String Daerah) { DAERAH = Daerah; }

    public String getNEGERI() { return NEGERI; }

    public void setNEGERI(String negeri) { NEGERI = negeri; }

    public String getKELENGKAPAN() { return KELENGKAPAN; }

    public void setKELENGKAPAN(String kelengkapan) { KELENGKAPAN = kelengkapan; }

    public String getCATEGORY() { return CATEGORY; }

    public void setCATEGORY(String masaProgram) { CATEGORY = masaProgram; }

    public String getMAKLUMAT() { return MAKLUMAT; }

    public void setMAKLUMAT(String masaProgram) { MAKLUMAT = masaProgram; }

    public String getDEPOSIT() { return DEPOSIT; }

    public void setDEPOSIT(String masaProgram) { DEPOSIT = masaProgram; }

    public String getSEWA() { return SEWA; }

    public void setSEWA(String masaProgram) { SEWA = masaProgram; }

    public String getPENDAHULUAN() { return PENDAHULUAN; }

    public void setPENDAHULUAN(String masaProgram) { PENDAHULUAN = masaProgram; }

    public String getBILIK() { return BILIK; }

    public void setBILIK(String masaProgram) { BILIK = masaProgram; }

    public String getTANDAS() { return TANDAS; }

    public void setTANDAS(String masaProgram) { TANDAS = masaProgram; }

    public String getmImageUrl() { return mImageUrl; }

    public void setmImageUrl(String mImageUrl) { this.mImageUrl = mImageUrl; }
}
