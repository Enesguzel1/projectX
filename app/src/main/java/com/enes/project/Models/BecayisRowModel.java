package com.enes.project.Models;

public class BecayisRowModel {

    String username,bulunulanYurt,gidilecekYurt,aciklama;

    public BecayisRowModel(String username, String bulunulanYurt, String gidilecekYurt, String aciklama) {
        this.username = username;
        this.bulunulanYurt = bulunulanYurt;
        this.gidilecekYurt = gidilecekYurt;
        this.aciklama = aciklama;
    }

    public String getUsername() {
        return username;
    }

    public String getBulunulanYurt() {
        return bulunulanYurt;
    }

    public String getGidilecekYurt() {
        return gidilecekYurt;
    }

    public String getAciklama() {
        return aciklama;
    }
}
