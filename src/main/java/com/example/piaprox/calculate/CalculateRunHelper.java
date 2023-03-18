package com.example.piaprox.calculate;

public class CalculateRunHelper implements Runnable {
    static Thread calculateThread = new Thread(new CalculateRunHelper());
    public static RunningState getRunningState()   {
        RunningState runningState;
        if(calculateThread.isAlive() != Calculate.running) {
            return RunningState.THREAD_LOOPSTATE_MISMATCH;
        }
        if (Calculate.running)
            return RunningState.RUNNING;
        return RunningState.STOPPED;
    }


    public static void start() {
        //calculateThread = new Thread(new CalculateRunHelper());
        Calculate.running = true;
        calculateThread.start();
    }
    public static void stop() {
        System.out.println("gsdfgsdfgfgsdfgsfgsdf");
        Calculate.running = false;
        try {
            calculateThread.join(1000000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        calculateThread = new Thread(new CalculateRunHelper());

        //calculateThread.interrupt();
    }
    @Override
    public void run() {
        try {
            Calculate.main(Calculate.args);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
