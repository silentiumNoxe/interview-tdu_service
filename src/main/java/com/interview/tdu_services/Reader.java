package com.interview.tdu_services;

import java.io.IOException;

public class Reader extends Thread {
    private String name;
    private SynchronizedCircularListStringBuffer buffer;

    public Reader(String name, SynchronizedCircularListStringBuffer buffer){
        this.buffer = buffer;
        this.name = name;
    }

    @Override
    public void run() {

        while (true){
            try {
                int index = buffer.removeAndGetIndex();
                if (index < 0){
                    Thread.sleep(50);
                    continue;
                }

                MyLogger.log("Thread-reader "+name+" read data from cell "+index);
            }catch (IOException | InterruptedException e){
                System.err.println(e.getMessage());
                break;
            }
        }
    }
}
