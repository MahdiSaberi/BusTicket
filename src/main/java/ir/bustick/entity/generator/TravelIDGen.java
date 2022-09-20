package ir.bustick.entity.generator;

import java.util.Random;

public class TravelIDGen {

    public static String generate() {

        Random random = new Random();
        Integer x;
            x = random.nextInt(900) + 100;



        String y = String.valueOf(x);

        return y;
    }
}