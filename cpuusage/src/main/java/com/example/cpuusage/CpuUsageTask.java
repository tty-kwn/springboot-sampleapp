package com.example.cpuusage;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CpuUsageTask {

    private static final int TARGET_USAGE = 10;
    private static final int DURATION = 100;

    public void createCpuLoad() {
        Random random = new Random();
        int randomDuration = 1000 + random.nextInt(2000); // 1秒から3秒のランダムな時間

        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < randomDuration) {
            long busyTime = DURATION * TARGET_USAGE / 100;
            long idleTime = DURATION - busyTime;

            long cycleStartTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - cycleStartTime < busyTime) {
                // CPUを忙しくする
            }

            try {
                Thread.sleep(idleTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

