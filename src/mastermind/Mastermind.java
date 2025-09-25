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

        int exactGoed = 0;
        for (int i = 0; i < code.length && i < gok.length; i++) {
            if (gok[i].equalsIgnoreCase(code[i])) {
                exactGoed++;
            }

        }
        System.out.println("\nExact goed (kleur + positie): " + exactGoed);

        // (debug) laat geheime code zien
        System.out.println("(debug) Geheime code: " + String.join(" ", code));

        // Kopieën maken zodat de originele variabelen niet aangepast worden
        String[] codeCopy = code.clone();
        String[] gokCopy = gok.clone();

        // de exacte matches uit de vergelijking halen
        for (int i = 0; i < codeCopy.length && i < gokCopy.length; i++) {
            if (gokCopy[i].equalsIgnoreCase(codeCopy[i])) {
                codeCopy[i] = null;
                gokCopy[i] = null;

            }
        }

        int verkeerdePlek = 0;
        for (int i = 0; i < gokCopy.length; i++) {
            // alleen de niet exacte matches
            if (gokCopy[i] != null) {
                for (int j = 0; j < codeCopy.length; j++) {
                    if (codeCopy[j] != null && gokCopy[i].equalsIgnoreCase(codeCopy[j])) {

                        verkeerdePlek++;
                        codeCopy[j] = null;
                        break;
                    }
                }

            }

        }

        System.out.println("Exact goed: " + exactGoed);
        System.out.println("Goede kleur, verkeerde plek: " + verkeerdePlek);

    }

}