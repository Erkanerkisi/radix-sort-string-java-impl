package command;

public interface Command<T, R> {
    R execute(T t);
}
