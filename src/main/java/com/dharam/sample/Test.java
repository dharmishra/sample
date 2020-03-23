package com.dharam.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Test {

    /**
     * Method to return the max from array
     * @param data
     * @return
     */
    private static  int getMax(int [] data) {
        return Arrays.stream(data)
                .max()
                .getAsInt();
    }

    /**
     * Given String array function convert the array to integer array
     * @param data
     * @return
     */
    private static int[] getIntegerArray(String [] data) {
        return Arrays.stream(data)
                .map( d -> d.trim())
                .mapToInt(Integer::parseInt)
                .toArray();
    }
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            if (line != null && !line.isEmpty()) {
                String [] data = line.split(",");
                if (data != null && data.length > 0) {
                    int [] intArray = getIntegerArray(data);
                    int M = getMax(intArray);
                    double D = (100.0 / (double) M);
                    String [] finalArray = new String[intArray.length];
                    for (int i=0; i<intArray.length; i++) {
                        double b = intArray[i] * D;
                        finalArray[i] = String.valueOf(Math.round(b));
                    }
                    System.out.println(String.join(",", finalArray));
                }
            }

        }


    }
}