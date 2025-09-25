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

        int maxBeurten = 10;
        boolean gewonnen = false;
        Scanner scanner = new Scanner(System.in);

        // laat speler raden
        for (int beurt = 1; beurt <= maxBeurten; beurt++) {
            System.out.println("\nBeurt " + beurt + " van " + maxBeurten);
            System.out.println("Voer 4 kleuren in, gescheiden door spaties\n"
                    + "(keuze: rood, blauw, groen, geel, oranje, paars):");
            String invoer = scanner.nextLine();

            // zorg ervoor dat de invoer gesplitst wordt op één of meer spaties
            String[] gok = invoer.trim().split("\\s+");

            // feedback voorbereiden in de vorm van strings
            StringBuilder exactGoedKleuren = new StringBuilder();
            StringBuilder verkeerdePlekKleuren = new StringBuilder();

            String[] codeCopy = code.clone();
            String[] gokCopy = gok.clone();

            // Stap 1: exacte matches
            int exactGoed = 0;
            for (int i = 0; i < codeCopy.length && i < gokCopy.length; i++) {
                if (gokCopy[i].equalsIgnoreCase(codeCopy[i])) {
                    exactGoed++;
                    exactGoedKleuren.append(gokCopy[i]).append(" ");
                    codeCopy[i] = null;
                    gokCopy[i] = null;
                }
            }

            // Stap 2: verkeerde plek
            int verkeerdePlek = 0;
            for (int i = 0; i < gokCopy.length; i++) {
                if (gokCopy[i] != null) {
                    for (int j = 0; j < codeCopy.length; j++) {
                        if (codeCopy[j] != null && gokCopy[i].equalsIgnoreCase(codeCopy[j])) {
                            verkeerdePlek++;
                            verkeerdePlekKleuren.append(gokCopy[i]).append(" ");
                            codeCopy[j] = null;
                            break;
                        }
                    }
                }
            }

            // Feedback printen
            System.out.println("(debug) Geheime code: " + String.join(" ", code));
            System.out.println("Exact goed: " + exactGoed + " -> " + exactGoedKleuren);
            System.out.println("Goede kleur, verkeerde plek: " + verkeerdePlek + " -> " + verkeerdePlekKleuren);

            if (exactGoed == code.length) {
                System.out.println("gefeliciteerd! Je hebt de code gekraakt!");
                gewonnen = true;
                break;
            }

        }

        if (!gewonnen) {
            System.out.println("Helaas, je hebt de code niet kunne kraken\n"
                    + "De geheime code was: " + String.join(" ", code));
        }
    }

}