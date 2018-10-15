package players_and_monsters;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player tim = new Player("Tim", 10, 15);
        System.out.println(tim.toString());
        saveObject(tim);

        tim.setHitPoints(8);
        System.out.println(tim);
        tim.setPlayerWeapon("Stormbringer");
        saveObject(tim);
        loadObject(tim);
        System.out.println(tim);

        Savable werewolf = new Monster("Werewolf", 20, 40);
        System.out.println(werewolf);
        System.out.println(((Monster) werewolf).getStrength());
        saveObject(werewolf);
    }

    private static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<>();

        Scanner scanner = new Scanner(System.in, "UTF-8");
        boolean quit = false;
        int index = 0;
        System.out.println("Choose:\n" +
                "1 to enter the string\n" +
                "0 to quit"
        );
        while (!quit) {
            int choice = Integer.MAX_VALUE;
            System.out.print("Choose an option: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("You press wrong number!");
                scanner = new Scanner(System.in);
            }
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
                default:
                    System.out.println("WARNING. Press numbers: 1 or 0 only! Try again ...");
            }
        }
        scanner.close();
        return values;
    }

    private static void saveObject(Savable objectToSave) {
        for (int i = 0; i < objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
        }
    }

    private static void loadObject(Savable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }
}
