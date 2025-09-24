package mastermind;

import java.util.Random;
import java.util.Scanner;

public class Mastermind {
    public static void main(String[] args) {
        String[] kleuren = { "rood", "blauw", "groen", "geel", "oranje", "paars" };
        // geheimde code
        String[] code = new String[4];

        Random random = new Random();
        // willekeurige code genereren
        for (int i = 0; i < code.length; i++) {
            int index = random.nextInt(kleuren.length);
            code[i] = kleuren[index];

        }
        for (String kleur : code) {
            System.out.print(kleur + " ");
        }

        // laat speler raden
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voer 4 kleuren in, gescheiden door spaties\n"
                + "(keuze: rood, blauw, groen, geel, oranje, paars):");
        String invoer = scanner.nextLine();

        // zorg ervoor dat de invoer gesplitst wordt op één of meer spaties
        String[] gok = invoer.split("\\s+");

        int exactgoed = 0;
        for (int i = 0; i < code.length && i < gok.length; i++) {
            if (gok[i].equalsIgnoreCase(code[i])) {
                exactgoed++;
            }

        }
        System.out.println("\nExact goed (kleur + positie): " + exactgoed);

        // (debug) laat geheime code zien
        System.out.println("(debug) Geheime code: " + String.join(" ", code));

    }

}