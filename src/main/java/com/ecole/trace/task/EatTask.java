package com.ecole.trace.task;

import com.ecole.trace.TableStateService;
import io.jenetics.jpx.GPX;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class EatTask implements Callable<GPX> {

    int position;

    public EatTask(int position){
        this.position = position;
    }

    @Override
    public GPX call() throws InterruptedException {
        TableStateService service = TableStateService.getInstance();
        boolean hasEaten = false;

        while (!hasEaten) {
            hasEaten = service.updateState("M", position);
            Thread.sleep(ThreadLocalRandom.current().nextInt(50, 100));
        }

        service.updateState("P", position);

        return null;
    }
}
