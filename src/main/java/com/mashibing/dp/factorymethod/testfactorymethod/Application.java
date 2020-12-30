package com.mashibing.dp.factorymethod.testfactorymethod;

import java.util.ArrayList;

public class Application {
    private static  String applicationName;
    private static float averageRate;
    private static ArrayList<NewFeature> newFeatureItems = new ArrayList<NewFeature>();

    public static void main(String[] args) {
        Createable c1 = new AppleStoreFactory().create();
        Createable c2 = new CoogleStoreFactory().create();
       description(c1);
    }
    static String description(Createable platform){
        StringBuffer result = new StringBuffer();
        result.append("This is"+applicationName+"for"+"platform\n");

        for (int i = 0; i < newFeatureItems.size(); i++) {
            result.append(newFeatureItems.get(i).getDescription());
        }
        result.append("AverageRate from "+"商店");
        result.append(String.valueOf(averageRate));
        return result.toString();
    };

}
