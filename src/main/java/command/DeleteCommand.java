package command;

import datastore.Datastore;

public class DeleteCommand implements Command<String, Void> {

    private Datastore datastore;

    public DeleteCommand(Datastore datastore) {
        this.datastore = datastore;
    }

    @Override
    public Void execute(String s) {
        datastore.delete(s);
        return null;
    }
}
