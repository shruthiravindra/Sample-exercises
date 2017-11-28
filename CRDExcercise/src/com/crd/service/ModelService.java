package com.crd.service;

import com.crd.account.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelService {

      /**
     * Queries Model table and retuns the list of Model.
     *
     * @return
     */
    public Map<String, Float> getAllModels() {

        // query all the models. -- Unused
        String sqlQquery = "SELECT T.SEC, T.PERCENTAGE FROM MODEL";

        // GET THE RESULT.
        Map<String, Float> models = new HashMap<String, Float>();
        models.put("GM", (float) 20);
        models.put("AAPL", (float) 20);
        models.put("X", (float) 10);
        models.put("Y", (float) 50);

        return models;
    }

}
