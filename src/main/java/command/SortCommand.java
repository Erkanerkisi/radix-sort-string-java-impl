package command;

import datastore.Datastore;

import java.util.LinkedList;

public class SortCommand implements Command<String[], LinkedList<String>> {

    private Datastore datastore;

    public SortCommand(Datastore datastore) {
        this.datastore = datastore;
    }

    @Override
    public LinkedList<String> execute(String[] strings) {
        return datastore.sort(strings);
    }
}
