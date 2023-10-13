
// Util random för att generera slumpmässiga siffror
import java.util.Random;
// Util scanner för att ta inmatning från användaren
import java.util.Scanner;

public class randomgame {

    // Metod randomGame används för att skriva spelkoden
    private static void randomGame() {
        // Inmatning från användaren
        try (Scanner scanner = new Scanner(System.in)) {
            // Genererar slumpmässiga siffror
            Random random = new Random();

            while (true) {
                // Slumpar tal från 1-100
                int randomNumber = random.nextInt(100) + 1;
                // Gissningar
                int guess;
                // Räknar antal gissningar användaren har använt
                int count = 1;
                // Räknar Antal försök
                int attempts = 1;
                // Programmet printar ut spelmeny
                System.out.println("Välkommen till Gissa Numret spelet!");
                System.out.println("Jag har valt ett nummer mellan 1 och 100. Kan du gissa vilket det är?");
                // While loop
                while (true) {
                    System.out.print("Gissning " + count + ": ");
                    // Count ökar med 1 för varje gissning
                    count++;
                    // Scannern tar input från användaren, om heltal angetts returnerar
                    // guess=scanner.nextInt som true och går vidare men om något annat anges än
                    // heltal blir det false och ett felmeddelande kommer upp
                    if (scanner.hasNextInt()) {
                        guess = scanner.nextInt();
                        // Attemps ökar med 1 för varje försök
                        attempts++;
                        // Jämför gissning med slumpmässiga numret
                        // Vid rätt svar avslutas loopen med detta meddelande och hur många gånger man
                        // gissade
                        if (guess == randomNumber) {
                            System.out.println("Grattis! Du gissade rätt på " + attempts + " försök!");
                            break;
                            // Om gissning är mindre än numret skrivs detta ut
                        } else if (guess < randomNumber) {
                            System.out.println("Talet är större.");
                            // Om gissning är större än numret skrivs detta ut
                        } else {
                            System.out.println("Talet är mindre.");
                        }
                        // Felmeddelande som kommer upp om användaren inte anger ett heltal
                    } else {
                        System.out.println("Felaktig input! Var god ange ett heltal.");
                        scanner.next(); // Hanterar input om det är heltal eller ej
                    }
                }

                while (true) {
                    System.out.println("Vill du spela igen? (Ja/Nej): ");
                    String answer = scanner.next().toLowerCase(); // Konverterar inmatning till små bokstäver

                    if (answer.equalsIgnoreCase("ja")) {
                        break; // Avslutar denna loop och går till randomgame metoden för att spela igen
                    } else if (answer.equalsIgnoreCase("nej")) {
                        System.out.println("Tack för den här gången!");
                        return; // Avslutar programmet
                    }
                }
            }
        }
    }

    // Spelet startas i main
    public static void main(String[] args) {
        randomGame();
    }
}
