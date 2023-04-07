package com.ecole.trace;

import java.util.Arrays;
import java.util.Objects;

public class TableStateService {

    public static TableStateService instance;
    public final String[] states;

    TableStateService(){
        states = new String[FixedValues.PHILOSOPHER_COUNT];
        for (int i = 0; i < FixedValues.PHILOSOPHER_COUNT; i++){
            states[i] = "P";
        }
    }

    public static TableStateService getInstance() {
        if (instance == null) {
            instance = new TableStateService();
        }
        return instance;
    }

    public boolean updateState(String newState, int position){
        synchronized (states) {
            if (Objects.equals(newState, "M")) {
                if (!isRightPhilosopherEating(position) && !isLeftPhilosopherEating(position)){
                    this.states[position] = newState;
                    System.out.println(Arrays.toString(states));
                } else {
                    this.states[position] = "A";
                    System.out.println(Arrays.toString(states));
                    return false;
                }
            } else if (!Objects.equals(this.states[position], newState)){
                this.states[position] = newState;
                System.out.println(Arrays.toString(states));
            }
            return true;
        }
    }

    private boolean isRightPhilosopherEating(int position){
        int rightPosition = position < states.length - 1 ? position + 1  : 0;
        return Objects.equals(states[rightPosition], "M");
    }

    private boolean isLeftPhilosopherEating(int position){
        int leftPosition = position > 0 ? position - 1  : states.length - 1;
        return Objects.equals(states[leftPosition], "M");
    }
}
