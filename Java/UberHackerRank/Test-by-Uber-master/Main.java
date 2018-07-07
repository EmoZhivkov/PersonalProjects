# Test-by-Uber

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String command = new String();
        Scanner user_input = new Scanner(System.in);
        System.out.println("Enter a command");
        command = user_input.nextLine();
        if(command.compareTo("Team selection")==0)
        {
            int arraySize;
            System.out.println("Enter the size of the array : ");
            arraySize = user_input.nextInt();
            int[] array = new int[arraySize];
            for (int i = 0; i < arraySize; i++) {
                array[i] = user_input.nextInt();
            }
            System.out.println("Enter the size of the team : ");
            int teamSize = user_input.nextInt();
            System.out.println("Enter the group size selection : ");
            int groupSize = user_input.nextInt();
            int score = TeamSelection.teamFormation(array, teamSize, groupSize, 0);
            System.out.println("Finale team score : " + score);
        }
        if(command.compareTo("Tokyo rumble")==0)
        {
            int arraySize;
            System.out.println("Enter the size of the array : ");
            arraySize = user_input.nextInt();
            int[] array = new int[arraySize];
            for (int i = 0; i < arraySize; i++) {
                array[i] = user_input.nextInt();
            }
            int score = TokyoRumble.getMinimumBlows(array,0);
            System.out.println("Minimum blows : " + score);
        }
        if(command.compareTo("Programmer string")==0)
        {
            String programmerString;
            System.out.println("Enter your programmer string");
            programmerString = user_input.nextLine();
            int score = ProgrammerString.programmerStrings(programmerString);
            System.out.println("Number of indices in-between : " + score);
        }
    }
}
