import command.BulkInsertCommand;
import command.DeleteCommand;
import command.InsertCommand;
import command.SortCommand;
import datastore.Datastore;
import menu.Menu;
import sorting.algorithms.Radix;
import util.FileUtil;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        Datastore datastore = new Datastore(new Radix());
        readFileValuesAndBulkInsert("Names.txt", datastore);
        boolean active = true;
        while (active) {
            menu.printMainMenu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    LinkedList<String> res = new SortCommand(datastore).execute(datastore.getActualDataKeyAsArray());
                    res.forEach(e -> System.out.println(datastore.getValueFromKey(e)));
                    break;
                case 2:
                    String insertedData = menu.askValue("Insert Data");
                    new InsertCommand(datastore).execute(insertedData);
                    break;
                case 3:
                    String deletedData = menu.askValue("Delete Data");
                    new DeleteCommand(datastore).execute(deletedData);
                    break;
                case 4:
                    // Exit
                    active = false;
                    break;
                default:
                    System.out.println("Please choose available options.");
            }
            if (!active) {
                break;
            }
        }
    }

    private static void readFileValuesAndBulkInsert(String fileName, Datastore datastore) throws IOException {
        String[] input = FileUtil.getDataFromFile(fileName);
        new BulkInsertCommand(datastore).execute(input);
    }
}
