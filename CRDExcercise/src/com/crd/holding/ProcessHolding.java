package com.crd.holding;

import com.crd.account.Holding;
import com.crd.service.HoldingService;
import com.crd.service.ModelService;

import java.util.List;
import java.util.Map;

public class ProcessHolding {

    // Main Method
    public static void main(String[] args) {

        // query all the values from Holding.
        HoldingService holdingService =  new HoldingService();
        List<Holding> allHolding = holdingService.getAllHolding();

        // query all the values from Model
        ModelService modelService = new ModelService();
        Map<String, Float> allModels = modelService.getAllModels();

        // Check and create ORD values.
        holdingService.createOrd(allHolding,allModels);
    }
}
