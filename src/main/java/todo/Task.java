package todo;

/**
 * One item on a to-do list.
 */
public class Task {

    private final String name;
    private boolean done;

    public Task(String name) {
        this.name = name;
        this.done = false;
    }

    public String getName() {
        return name;
    }

    public boolean isDone() {
        return done;
    }

    public void markDone() {
        this.done = true;
    }
}
