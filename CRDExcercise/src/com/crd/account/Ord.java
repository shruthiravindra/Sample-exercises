package com.crd.account;

public class Ord {

    private String sec;

    private char trans;

    private Float amt;


    public Ord(String sec, char trans,Float amt){
        this.sec = sec;
        this.trans  = trans;
        this.amt = amt;
    }

    public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }

    public Character getTrans() {
        return trans;
    }

    public void setTrans(Character trans) {
        this.trans = trans;
    }

    public Float getAmt() {
        return amt;
    }

    public void setAmt(Float amt) {
        this.amt = amt;
    }
}
