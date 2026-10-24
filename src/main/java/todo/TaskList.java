package todo;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple to-do list. This is the backend of our app.
 */
public class TaskList {

    private final List<Task> tasks = new ArrayList<>();

    /**
     * Adds a new task to the list.
     *
     * @param name the task name
     * @throws IllegalArgumentException if the name is null or blank
     */
    public void addTask(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Task name cannot be blank");
        }
        tasks.add(new Task(name));
    }

    /**
     * Marks the task with the given name as done.
     *
     * @param name the name of the task to complete
     * @throws IllegalArgumentException if no task has that name
     */
    public void completeTask(String name) {
        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                task.markDone();
                return;
            }
        }
    }

    /**
     * Returns how many tasks are not done yet.
     */
    public int countRemaining() {
        int count = 0;
        for (Task task : tasks) {
            if (!task.isDone()) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns all tasks.
     */
    public List<Task> getTasks() {
        return tasks;
    }
}
