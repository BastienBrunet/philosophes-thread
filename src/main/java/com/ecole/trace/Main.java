package com.ecole.trace;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

import com.ecole.trace.task.EatTask;


public class Main {

    public static void main(String[] args) throws InterruptedException {


		int threadAvailableCount = FixedValues.PHILOSOPHER_COUNT / FixedValues.FORK_NEEDED_COUNT;

		ExecutorService executor = Executors.newFixedThreadPool(threadAvailableCount);

		for (int i = 0 ; i < FixedValues.CYCLE_COUNT; i++){
			for (int j = 0; j <= FixedValues.PHILOSOPHER_COUNT / 2; j++){
				executor.submit(new EatTask(j));
				Thread.sleep(ThreadLocalRandom.current().nextInt(50, 100));
				executor.submit(new EatTask(j + 2));
			}
		}
	}
}
