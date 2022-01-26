package task1;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        taskOne();
    }
    public static void taskOne() throws FileNotFoundException {
        String filename; //src/task1/hello.txt format
        String language = " ";
        Scanner input = new Scanner(System.in);

        System.out.println("input the filename with src/ at the start: ");
        filename = input.nextLine();

        System.out.println("now choose a programming language");
        System.out.println("1. C");
        System.out.println("2. C++");

        while (language.equals(" ")){
            String langChoice = input.nextLine();
            switch (langChoice){
                case "1":
                    language = "C";
                    break;
                case "2":
                    language = "C++";
                    break;
                default:
                    System.out.println("Bad input, try again.");
            }
        }
        new Task1(language, filename);
        input.close();
    }
}

