package command;

import datastore.Datastore;
import util.Util;

public class BulkInsertCommand implements Command<String[], Void> {

    private Datastore datastore;

    public BulkInsertCommand(Datastore datastore) {
        this.datastore = datastore;
    }

    @Override
    public Void execute(String[] strings) {
        validateArrayAndWordLen(strings);
        datastore.bulkInsert(strings);
        return null;
    }

    private static void validateArrayAndWordLen(String[] arr) {
        Util.validateStringArr(arr.length);
        for (String s : arr) {
            Util.validateString(s);
        }
    }
}
