package pl.edu.pja.s27591.tpo03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Scanner;

@Controller
public class FlashcardsController {
    private final EntryRepoInterface entryRepoInterface;
    //private final FileService fileService;
    private DisplayInterface displayInterface;
    private final Scanner scanner;

    @Autowired
    public FlashcardsController(EntryRepoInterface entryRepoInterface, DisplayInterface displayInterface, Scanner scanner) {
        this.entryRepoInterface = entryRepoInterface;
        //this.fileService = fileService;
        this.displayInterface = displayInterface;
        this.scanner = scanner;
    }

    public void runMenu() throws IOException {
        System.out.println("Welcome to the language flashcards application!\n" +
                "What would you like to do?");
        while (true) {
            System.out.println("1. Add a new word to the dictionary");
            System.out.println("2. Display all words from the dictionary");
            System.out.println("3. Test yourself");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            if(scanner.hasNextInt()) {
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        addWord();
                        break;
                    case 2:
                        System.out.println("Here are all the words you have in a dictionary so far: ");
                        displayInterface.displayDict(entryRepoInterface.getEntries());
                        break;
                    case 3:
                        System.out.print("Here is your word: ");
                        test();
                        break;
                    case 4:
                        System.out.println("Bye-bye...");
                        return;
                    default:
                        System.out.println("Oops, there is no such option. Please try again.");
                }
            }else {
                System.out.println("Oops, there is no such option. Please try again.");
                scanner.next();
            }
        }
    }

    private void addWord() throws IOException {
        System.out.print("Enter english word: ");
        String eng = scanner.nextLine();
        System.out.print("Now enter german translation: ");
        String de = scanner.nextLine();
        System.out.print("Finally, enter polish translation: ");
        String pl = scanner.nextLine();
        entryRepoInterface.addEntry(new Entry(eng, de, pl));
        System.out.println("New word has been added to the dictionary!");
    }

    private void test() {
        int word = (int)(Math.random()*entryRepoInterface.getEntries().size()-1);
        int lang = (int)(Math.random()*2);
        String input;
        switch (lang){
            case 0 -> {
                System.out.println("(Eng) " +
                        displayInterface.displayWord(entryRepoInterface.getEntries().get(word).getEng()));
                System.out.println("Now enter this word in german: ");
                input = scanner.nextLine();
                while (!input.equalsIgnoreCase(entryRepoInterface.getEntries().get(word).getDe())){
                    System.out.println("Oops, that is incorrect, try again: ");
                    input = scanner.nextLine();
                }
                System.out.println("Well done!\nNow enter polish translation: ");
                input = scanner.nextLine();
                while (!input.equalsIgnoreCase(entryRepoInterface.getEntries().get(word).getPl())){
                    System.out.println("Oops, that is incorrect, try again: ");
                    input = scanner.nextLine();
                }
                System.out.println("Good job! Everything is correct!");
            }
            case 1 -> {
                System.out.println("(De) " +
                        displayInterface.displayWord(entryRepoInterface.getEntries().get(word).getDe()));
                System.out.println("Now enter this word in english: ");
                input = scanner.nextLine();
                while (!input.equalsIgnoreCase(entryRepoInterface.getEntries().get(word).getEng())){
                    System.out.println("Oops, that is incorrect, try again: ");
                    input = scanner.nextLine();
                }
                System.out.println("Well done!\nNow enter polish translation: ");
                input = scanner.nextLine();
                while (!input.equalsIgnoreCase(entryRepoInterface.getEntries().get(word).getPl())){
                    System.out.println("Oops, that is incorrect, try again: ");
                    input = scanner.nextLine();
                }
                System.out.println("Good job! Everything is correct!");
            }
            case 2 -> {
                System.out.println("(Pl) " +
                        displayInterface.displayWord(entryRepoInterface.getEntries().get(word).getPl()));
                System.out.println("Now enter this word in english: ");
                input = scanner.nextLine();
                while (!input.equalsIgnoreCase(entryRepoInterface.getEntries().get(word).getEng())){
                    System.out.println("Oops, that is incorrect, try again: ");
                    input = scanner.nextLine();
                }
                System.out.println("Well done!\nNow enter german translation: ");
                input = scanner.nextLine();
                while (!input.equalsIgnoreCase(entryRepoInterface.getEntries().get(word).getDe())){
                    System.out.println("Oops, that is incorrect, try again: ");
                    input = scanner.nextLine();
                }
                System.out.println("Good job! Everything is correct!");
            }
        }
    }
}
