package com.ecole.trace;

public class TableState {


    public static String[] states;

    public synchronized static String[] getInstance() {
        if (states == null) {
            states = new String[FixedValues.PHILOSOPHER_COUNT];
            for (int i = 0; i < FixedValues.PHILOSOPHER_COUNT; i++){
                states[i] = "P";
            }
        }
        return states;
    }
}
