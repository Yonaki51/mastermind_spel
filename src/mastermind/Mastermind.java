package mastermind;

import java.util.*;

public class Mastermind {
    private static final int code_length = 4;
        private static final Set<String> colors = Set.of(
            "red", "blue", "yellow", "purple", "green", "orange"
    );

    public static void main(String[] args) {
        System.out.println("mastermind!");
        System.out.println("Toegestane kleuren: " + String.join(", ", colors));
        

  
    }


}
