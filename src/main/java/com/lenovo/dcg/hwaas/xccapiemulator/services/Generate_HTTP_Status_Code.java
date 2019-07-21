package com.lenovo.dcg.hwaas.xccapiemulator.services;

import java.util.Random;
// TODO: This Feature is a Work In Progress
public class Generate_HTTP_Status_Code {

    private int HTTP_200 = 200;
    private int HTTP_307 = 307;
    private int HTTP_308 = 308;
    private int HTTP_400 = 400;
    private int HTTP_401 = 401;
    private int HTTP_403 = 403;
    private int HTTP_408 = 408;
    private int HTTP_500 = 500;
    private int HTTP_503 = 503;
    private int[] successCodes;
    private int[] failureCodes;

    public static int getRandomNumberInts(int min, int max) {
        Random random = new Random();
        return random.ints(min,(max+1)).findFirst().getAsInt();
    }

    public boolean determineOutcome() {
        int outcome = getRandomNumberInts(0, 100);
        boolean success = outcome <= 95;
        return success;
    };
}
