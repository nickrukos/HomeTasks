package Curs3;

import java.util.function.Function;

public class Task {
    private final String name;
    private final String description;
    private long executed;
    private final Function<ServerApp, Message> executor;

    public Task(String name, String description, Function<ServerApp, Message> executor) {
        this.name = name;
        this.description = description;
        this.executor = executor;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public long getExecuted() {
        return executed;
    }

    public Message execute(ServerApp serverApp){
        executed++;
        return executor.apply(serverApp);
    }
}
