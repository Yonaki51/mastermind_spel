package mastermind;

import java.util.Random;
import java.util.*;

public class Mastermind {

    public static void main(String[] args) {
        String[] colours = {"red", "blue", "yellow", "purple", "green", "orange"};
        Random rng = new Random();

        System.out.println("geheime code: ");
        for (int clr_combo = 0; clr_combo <4; clr_combo++) {
            int index = rng.nextInt(colours.length);
            String chosen =  colours[index];
            System.out.print(chosen + " ");

        }


    }

}
