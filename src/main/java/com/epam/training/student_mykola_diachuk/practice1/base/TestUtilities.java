package com.epam.training.student_mykola_diachuk.practice1.base;

public class TestUtilities {
    // STATIC SLEEP
    protected void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
