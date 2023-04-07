package com.ecole.trace.task;

import com.ecole.trace.TableState;
import io.jenetics.jpx.GPX;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class EatTask implements Callable<GPX> {

    int position;

    public EatTask(int position){
        this.position = position;
    }

    @Override
    public GPX call() throws InterruptedException {

        boolean hasEaten = false;

        while (!hasEaten) {
            String[] state = TableState.getInstance();
            if(!isRightPhilosopherEating(state) && !isLeftPhilosopherEating(state)){
                state[position] = "M";
                Thread.sleep(ThreadLocalRandom.current().nextInt(50, 100));
                System.out.println(Arrays.toString(state));
                state[position] = "P";
                System.out.println(Arrays.toString(state));
                hasEaten = true;
            }
            else if (!Objects.equals(state[position], "A")){
                state[position] = "A";
                System.out.println(Arrays.toString(state));
            }
        }

        return null;
    }

    private boolean isRightPhilosopherEating(String[] state){
        int rightPosition = position < state.length - 1 ? position + 1  : 0;
        return Objects.equals(state[rightPosition], "M");
    }

    private boolean isLeftPhilosopherEating(String[] state){
        int leftPosition = position > 0 ? position - 1  : state.length - 1;
        return Objects.equals(state[leftPosition], "M");
    }
}
