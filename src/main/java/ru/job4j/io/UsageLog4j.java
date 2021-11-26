package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte age = 24;
        short waist = 63;
        int hips = 92;
        long money = 1000;
        float weight = 54;
        double length = 168;
        char symbol = 'v';
        boolean happy = true;
        LOG.debug("Output variables to the console age : {}, waist : {}, hips : {}, money : {}, weight : {}, length : {}, symbol : {}, happy : {}",
                age, waist, hips, money, weight, length, symbol, happy);
    }
}
