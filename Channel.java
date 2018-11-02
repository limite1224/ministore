package com.zeno.util;

/**
 * 通道信息
 */
public class Channel {

    private int nChlType;
    private int nChlNum;
    private String szChlName;


    public int getnChlType() {
        return nChlType;
    }

    public void setnChlType(int nChlType) {
        this.nChlType = nChlType;
    }

    public int getnChlNum() {
        return nChlNum;
    }

    public void setnChlNum(int nChlNum) {
        this.nChlNum = nChlNum;
    }

    public String getSzChlName() {
        return szChlName;
    }

    public void setSzChlName(String szChlName) {
        this.szChlName = szChlName;
    }
}
