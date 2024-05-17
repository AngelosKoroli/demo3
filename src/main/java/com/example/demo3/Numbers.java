package com.example.demo3;

public class Numbers {
    Object[] numbers = new Object[100];

    int x = 0;
    int y = 0;

    int dataUsed = 0;

    public synchronized boolean put(Object obj) {
        if (dataUsed < 100) {
            dataUsed = dataUsed + 1;
            numbers[x] = obj;
            if (x < 99) {
                x = x + 1;
            } else {
                x = 0;
            }
            return true;
        } else {
            return false;
        }
    }
    public synchronized Object get () {
        if (dataUsed > 0) {
            Object value = numbers[y];
            dataUsed = dataUsed - 1;
            if (y < 99) {
                y = y + 1;
            } else {
                y = 0;
            }
            return value;
        } else {
            return null;
        }
    }
}

