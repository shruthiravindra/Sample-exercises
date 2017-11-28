package com.crd.service;

import com.crd.account.Holding;
import com.crd.account.Ord;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HoldingService {

    private float totalHolding;

    public float getTotalHolding() {
        return totalHolding;
    }

    private void setTotalHolding(long totalHolding) {
        this.totalHolding = totalHolding;
    }


    /**
     * Queries Holding table and returns the list of Holdings .
     * @return List
     */
    public List<Holding> getAllHolding() {

        // query to get all the holding.
        String sqlQuery = "SELECT T.SEC, T.AMT FROM HOLDING";

        //  result is returned.
        // create the list

        List<Holding> holdingList = new ArrayList<Holding>();
        holdingList.add(new Holding("IBM", 200));
        holdingList.add(new Holding("AAPL", 400));
        holdingList.add(new Holding("X", 50));
        holdingList.add(new Holding("CCC", 1000));
        holdingList.add(new Holding("GM", 500));

        return holdingList;
    }

    /**
     * Returns the sum of all the amt in HOLDING table.
     * @return float
     */
    public float returnTotalHolding() {

        // UNUSED
        String sqlQuery = "SELECT SUM(AMT) FROM HOLDING";

        // get the result = 2150;
        setTotalHolding(2150);
        return getTotalHolding();
    }

    /**
     * Method to process the Holding and create ORD values that needs to be inserted to ORD table.
     * @param holdings
     * @param models
     */
    public void createOrd(List<Holding> holdings, Map<String, Float> models) {

        Float totalHoldings = returnTotalHolding();
        List<Ord> ordList = new ArrayList<>();
        List<Holding> miscHoldings = new ArrayList<>();
        Float holdingPercent = 0.0f;

        for (Holding holding : holdings) {
            if (models.containsKey(holding.getSec())) {
                Float expectedPercentage = models.get(holding.getSec());
                ordList.add(calculateAmount(expectedPercentage, totalHoldings, holding.getSec(), (float) holding.getAmt()));
                holdingPercent += expectedPercentage;

            } else {
                miscHoldings.add(holding);
            }
        }

        OrdService ordService = new OrdService();
        ordService.displayTemplate();
        insertOrd(ordList, ordService);
        if (miscHoldings.size() > 0) {
            Float expectedPercentage = holdingPercent / miscHoldings.size();
            for (Holding miscHolding : miscHoldings) {
                ordList.add(calculateAmount(expectedPercentage, totalHoldings, miscHolding.getSec(), (float) miscHolding.getAmt()));
            }
        }
        insertOrd(ordList, ordService);
    }


    private void insertOrd(List<Ord> ordList, OrdService ordService) {

        if (ordList.size() > 0) {
            ordService.insertOrd(ordList);
            ordList.clear();
        }
    }

    /**
     * Method to create the derive the ORD values and create ORD object
     * @param expectedPercentage
     * @param totalHoldings
     * @param sec
     * @param amt
     * @return
     */
    private Ord calculateAmount(Float expectedPercentage, Float totalHoldings, String sec, Float amt) {

        Character transType;
        Float difference;
        Float presentPercentage = (amt * 100) / totalHoldings;

        if (presentPercentage <= expectedPercentage) {
            transType = 'B';
            difference = expectedPercentage - presentPercentage;
        } else {
            transType = 'S';
            difference = presentPercentage - expectedPercentage;
        }

        Float amount = (totalHoldings * difference) / 100;
        return new Ord(sec, transType, amount);
    }

}
