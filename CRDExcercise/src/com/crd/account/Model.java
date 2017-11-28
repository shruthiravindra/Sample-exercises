package com.crd.account;

public class Model {

    private String sec;

    private Long percent;

    public Model(String sec, long percent ){
        this.sec = sec;
        this.percent = percent;
    }

    public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }


    public Long getPercent() {
        return percent;
    }

    public void setPercent(Long percent) {
        this.percent = percent;
    }

}
