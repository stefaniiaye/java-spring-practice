package pl.edu.pja.s27591.tpo03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Controller
public class FlashcardsController {
    private final SpringDataEntryRepoInterface entryRepoInterface;
    private DisplayInterface displayInterface;
    private final Scanner scanner;

    @Autowired
    public FlashcardsController(SpringDataEntryRepoInterface entryRepoInterface, DisplayInterface displayInterface, Scanner scanner) {
        this.entryRepoInterface = entryRepoInterface;
        this.displayInterface = displayInterface;
        this.scanner = scanner;
    }

    public void runMenu() throws IOException {
        System.out.println("Welcome to the language flashcards application!\n" +
                "What would you like to do?");
        while (true) {
            System.out.println("1. Add a new word to the dictionary");
            System.out.println("2. Display all words from the dictionary");
            System.out.println("3. Search for a word");
            System.out.println("4. Test yourself");
            System.out.println("5. Modify existing record");
            System.out.println("6. Delete a record");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            if(scanner.hasNextInt()) {
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        addWord();
                        break;
                    case 2:
                        displayDictMenu();
                        break;
                    case 3:
                        System.out.print("Enter the word to search for: ");
                        String searchTerm = scanner.nextLine();
                        List<Entry> searchResults = entryRepoInterface.searchEntries(searchTerm);
                        if(!searchResults.isEmpty()) {
                            System.out.println("Here is what was found");
                            displayInterface.displayDict(searchResults);
                        }else System.out.println("No results.");
                        break;
                    case 4:
                        System.out.print("Here is your word: ");
                        test();
                        break;
                    case 5:
                       // modifyRecord();
                        break;
                    case 6:
                        deleteRecord();
                        break;
                    case 7:
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
        entryRepoInterface.save(new Entry(eng, de, pl));
        System.out.println("New word has been added to the dictionary!");
    }

    private void test() {
        int word = (int)(Math.random()*entryRepoInterface.findAll().size()-1);
        int lang = (int)(Math.random()*2);
        String input;
        switch (lang){
            case 0 -> {
                System.out.println("(Eng) " +
                        displayInterface.displayWord(entryRepoInterface.findAll().get(word).getEng()));
                System.out.println("Now enter this word in german: ");
                input = scanner.nextLine();
                while (!input.equalsIgnoreCase(entryRepoInterface.findAll().get(word).getDe())){
                    System.out.println("Oops, that is incorrect, try again: ");
                    input = scanner.nextLine();
                }
                System.out.println("Well done!\nNow enter polish translation: ");
                input = scanner.nextLine();
                while (!input.equalsIgnoreCase(entryRepoInterface.findAll().get(word).getPl())){
                    System.out.println("Oops, that is incorrect, try again: ");
                    input = scanner.nextLine();
                }
                System.out.println("Good job! Everything is correct!");
            }
            case 1 -> {
                System.out.println("(De) " +
                        displayInterface.displayWord(entryRepoInterface.findAll().get(word).getDe()));
                System.out.println("Now enter this word in english: ");
                input = scanner.nextLine();
                while (!input.equalsIgnoreCase(entryRepoInterface.findAll().get(word).getEng())){
                    System.out.println("Oops, that is incorrect, try again: ");
                    input = scanner.nextLine();
                }
                System.out.println("Well done!\nNow enter polish translation: ");
                input = scanner.nextLine();
                while (!input.equalsIgnoreCase(entryRepoInterface.findAll().get(word).getPl())){
                    System.out.println("Oops, that is incorrect, try again: ");
                    input = scanner.nextLine();
                }
                System.out.println("Good job! Everything is correct!");
            }
            case 2 -> {
                System.out.println("(Pl) " +
                        displayInterface.displayWord(entryRepoInterface.findAll().get(word).getPl()));
                System.out.println("Now enter this word in english: ");
                input = scanner.nextLine();
                while (!input.equalsIgnoreCase(entryRepoInterface.findAll().get(word).getEng())){
                    System.out.println("Oops, that is incorrect, try again: ");
                    input = scanner.nextLine();
                }
                System.out.println("Well done!\nNow enter german translation: ");
                input = scanner.nextLine();
                while (!input.equalsIgnoreCase(entryRepoInterface.findAll().get(word).getDe())){
                    System.out.println("Oops, that is incorrect, try again: ");
                    input = scanner.nextLine();
                }
                System.out.println("Good job! Everything is correct!");
            }
        }
    }

    private void displayDictMenu() {
        System.out.println("Do you want to sort the words?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Choose an option: ");
        int sortOption = scanner.nextInt();
        scanner.nextLine();

        if (sortOption == 1) {
            System.out.println("Sort options:");
            System.out.println("1. Sort by English (ASC)");
            System.out.println("2. Sort by English (DESC)");
            System.out.println("3. Sort by German (ASC)");
            System.out.println("4. Sort by German (DESC)");
            System.out.println("5. Sort by Polish (ASC)");
            System.out.println("6. Sort by Polish (DESC)");
            System.out.println("7. Return to main menu");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                /*case 1:
                    displaySortedDict("eng", true);
                    break;
                case 2:
                    displaySortedDict("eng", false);
                    break;
                case 3:
                    displaySortedDict("de", true);
                    break;
                case 4:
                    displaySortedDict("de", false);
                    break;
                case 5:
                    displaySortedDict("pl", true);
                    break;
                case 6:
                    displaySortedDict("pl", false);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid option. Returning to main menu.");*/

        }
        } else if (sortOption == 2) {
            displayInterface.displayDict(entryRepoInterface.findAll());
        } else {
            System.out.println("Invalid option. Returning to main menu.");
        }
    }

    /*private void displaySortedDict(String lang, boolean asc) {
        displayInterface.displayDict(entryRepoInterface.sortEntriesByLanguage(lang, asc));
    }*/

    private void deleteRecord() {
        System.out.print("Enter a keyword to search for the word you want to delete: ");
        String searchKeyword = scanner.nextLine();

        List<Entry> searchResults = entryRepoInterface.searchEntries(searchKeyword);
        if (searchResults.isEmpty()) {
            System.out.println("No matching words found.");
            return;
        }

        System.out.println("Matching words:");
        int i = 1;
        for (Entry entry : searchResults) {
            System.out.println(i + ". " + entry.toString());
            i++;
        }

        System.out.print("Enter the number of the word you want to delete: ");
        int selectedNumber = scanner.nextInt();
        scanner.nextLine();

        if (selectedNumber < 1 || selectedNumber > searchResults.size()) {
            System.out.println("Invalid selection. Deletion canceled.");
            return;
        }

        Entry wordToDelete = searchResults.get(selectedNumber - 1);


        System.out.print("Are you sure you want to delete this word? (yes/no): ");
        String confirmation = scanner.nextLine().trim().toLowerCase();
        if (!confirmation.equals("yes")) {
            System.out.println("Deletion canceled.");
            return;
        }

        entryRepoInterface.deleteById(wordToDelete.getId());
        System.out.println("Word deleted successfully.");
    }

    /*private void modifyRecord() {
        System.out.print("Enter a keyword to search for the word you want to modify: ");
        String searchKeyword = scanner.nextLine();

        List<Entry> searchResults = entryRepoInterface.searchEntries(searchKeyword);
        if (searchResults.isEmpty()) {
            System.out.println("No matching words found.");
            return;
        }

        System.out.println("Matching words:");
        int i = 1;
        for (Entry entry : searchResults) {
            System.out.println(i + ". " + entry.toString());
            i++;
        }

        System.out.print("Enter the number of the word you want to modify: ");
        int selectedNumber = scanner.nextInt();
        scanner.nextLine();

        if (selectedNumber < 1 || selectedNumber > searchResults.size()) {
            System.out.println("Invalid selection. Modification canceled.");
            return;
        }

        Entry wordToModify = searchResults.get(selectedNumber - 1);

        System.out.println("Select the language to modify:");
        System.out.println("1. English");
        System.out.println("2. German");
        System.out.println("3. Polish");
        System.out.print("Enter the option: ");
        int languageOption = scanner.nextInt();
        scanner.nextLine();

        String modifiedWord = null;
        switch (languageOption) {
            case 1:
                System.out.print("Enter the new English word: ");
                modifiedWord = scanner.nextLine();
                wordToModify.setEng(modifiedWord);
                break;
            case 2:
                System.out.print("Enter the new German word: ");
                modifiedWord = scanner.nextLine();
                wordToModify.setDe(modifiedWord);
                break;
            case 3:
                System.out.print("Enter the new Polish word: ");
                modifiedWord = scanner.nextLine();
                wordToModify.setPl(modifiedWord);
                break;
            default:
                System.out.println("Invalid option. Modification canceled.");
                return;
        }

        System.out.println("Modified word:");
        System.out.println(wordToModify.toString());

        System.out.print("Are you sure you want to save this modification? (yes/no): ");
        String confirmation = scanner.nextLine().trim().toLowerCase();
        if (!confirmation.equals("yes")) {
            System.out.println("Modification canceled.");
            return;
        }

        entryRepoInterface.(wordToModify);
        System.out.println("Word modified successfully.");
    }*/
}
