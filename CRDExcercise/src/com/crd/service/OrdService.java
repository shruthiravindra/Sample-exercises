package com.crd.service;

import com.crd.account.Ord;
import java.util.List;

public class OrdService {
    /**
     * Method to insert data into ORD table.
     * @param ordList
     */
    public void insertOrd(List<Ord> ordList){
        for (Ord ord : ordList) {
            String sqlQuery = "insert into ORD(SEC, TRANS, AMT) VALUES(?,?,?)";
            System.out.println( ord.getSec() +"       " +ord.getTrans()+"           "+ ord.getAmt());
        }
    }

    /**
     * Print the template heading
     */
    public void displayTemplate(){
        System.out.println("SEC" +"       " +"TRANS"+"           "+ "AMT");
    }

}
