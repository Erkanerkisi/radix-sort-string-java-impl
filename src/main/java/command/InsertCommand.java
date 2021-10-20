package command;

import datastore.Datastore;
import util.Util;

public class InsertCommand implements Command<String, Void> {

    private Datastore datastore;

    public InsertCommand(Datastore datastore) {
        this.datastore = datastore;
    }

    @Override
    public Void execute(String s) {
        validateArrayAndWordLen(s, datastore.actualData.size() + 1);
        datastore.insert(s);
        return null;
    }

    private void validateArrayAndWordLen(String word, int mapSize) {
        Util.validateStringArr(mapSize);
        Util.validateString(word);
    }
}
