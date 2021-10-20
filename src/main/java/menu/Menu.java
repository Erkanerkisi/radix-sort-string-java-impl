package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public final class Menu {

    private final String title;
    private final List<MenuItem> optionList;

    public Menu() {
        title = "Welcome to the Radix Sort";
        optionList = new ArrayList<>();
        optionList.add(new MenuItem("Sort data"));
        optionList.add(new MenuItem("Insert data"));
        optionList.add(new MenuItem("Delete data"));
        optionList.add(new MenuItem("Exit data"));
    }

    public void printMainMenu() {
        System.out.println("***************** " + title + " **********************");
        IntStream.range(1, optionList.size() + 1)
                .forEach(idx ->
                        System.out.println(idx + ". " + optionList.get(idx - 1).getTitle())
                );
        System.out.println("***************************************");
    }

    public void printRequiredInputName(String requiredInputName) {
        System.out.println("Enter " + requiredInputName);
    }

    public String askValue(String sentence) {
        printRequiredInputName(sentence);
        Scanner scannerInput = new Scanner(System.in);
        return scannerInput.next();
    }
}

class MenuItem {
    public MenuItem(String title) {
        this.title = title;
    }

    private final String title;

    public String getTitle() {
        return title;
    }
}
