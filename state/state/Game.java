package state;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your character's name: ");
        String name = scanner.nextLine();

        GameCharacter character = new GameCharacter(name);

        while (!character.isMaster()) {
            character.displayStatus();

            System.out.println("\nActions:");
            System.out.println("1. Train");
            System.out.println("2. Meditate");
            System.out.println("3. Fight");

            System.out.print("Choose an action: ");
            int choice = 0;
            try{
                choice = scanner.nextInt();
            }catch(InputMismatchException error){
                scanner.nextLine();
            }
            System.out.println("");
            switch (choice) {
                case 1:
                    character.train();
                    break;
                case 2:
                    character.meditate();
                    break;
                case 3:
                    character.fight();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        System.out.println("\nCongratulations! " + character.getName() + " has reached Master level!");
        scanner.close();
    }
}
