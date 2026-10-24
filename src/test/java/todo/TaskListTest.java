package todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for TaskList.
 */
public class TaskListTest {

    private TaskList list;

    @BeforeEach
    public void setUp() {
        list = new TaskList();
    }

    // EXPECTED: adding a task puts it in the list
    @Test
    public void testAddTask() {
        list.addTask("Study for exam");
        assertEquals(1, list.getTasks().size());
        assertEquals("Study for exam", list.getTasks().get(0).getName());
    }

    // EXPECTED: completing a task marks it done
    @Test
    public void testCompleteTask() {
        list.addTask("Study for exam");
        list.completeTask("Study for exam");
        assertTrue(list.getTasks().get(0).isDone());
    }

    // EDGE: a brand new list has nothing remaining
    @Test
    public void testCountRemainingEmptyList() {
        assertEquals(0, list.countRemaining());
    }

    // ERROR: a blank task name is rejected
    @Test
    public void testAddBlankTaskThrows() {
        assertThrows(IllegalArgumentException.class, () -> list.addTask(""));
    }

    // TODO: add a new test below this line.
}
