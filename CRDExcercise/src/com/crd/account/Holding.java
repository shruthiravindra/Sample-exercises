package com.crd.account;

public class Holding {

   private String sec;

   private Long amt;

   private boolean isProcessed;

   public Holding(String sec, long amt){
       this.sec = sec;
       this.amt = amt;
   }

   public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }

    public Long getAmt() {
        return amt;
    }

    public void setAmt(Long amt) {
        this.amt = amt;
    }

    public boolean isProcessed() {
        return isProcessed;
    }

    public void setProcessed(boolean processed) {
        isProcessed = processed;
    }
}
