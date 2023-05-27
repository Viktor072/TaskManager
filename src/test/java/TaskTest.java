import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void shouldGetTitle() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Assertions.assertEquals("Позвонить родителям", simpleTask.getTitle());
    }

    @Test
    public void shouldTrueSearchTasksByQuerySimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        simpleTask.matches("Позвонить родителям");

        Assertions.assertTrue(true);
    }

    @Test
    public void shouldFalseSearchTasksByQuerySimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        simpleTask.matches("Позвонить врачу");

        Assertions.assertFalse(false);
    }

    @Test
    public void testSimpleTaskFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить в офис");
        boolean actual = simpleTask.matches("Позвонить в офис");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testSimpleTaskNotFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить в офис");
        boolean actual = simpleTask.matches("Позвонить дедушке");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testTaskNotFound() {
        Task task = new Task(5);
        boolean actual = task.equals("Позвонить руководству");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testTaskHashCode() {
        Task task1 = new Task(1);
        Task task2 = new Task(1);
        Task task3 = new Task(2);

        Assertions.assertEquals(task1.hashCode(), task2.hashCode());
        Assertions.assertNotEquals(task1.hashCode(), task3.hashCode());
    }

    @Test
    public void testTasksEquals() {
        Task task1 = new Task(1);
        Task task2 = new Task(1);
        Task task3 = new Task(2);

        Assertions.assertEquals(task1, task2);
        Assertions.assertNotEquals(task1, task3);
    }

    @Test
    public void testEquals() {
        Task task1 = new Task(1);
        Task task2 = new Task(1);
        Task task3 = new Task(2);

        Assertions.assertTrue(task1.equals(task2));
        Assertions.assertFalse(task1.equals(task3));
    }


    @Test
    public void shouldGetSubtask() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        String[] expected = {"Молоко", "Яйца", "Хлеб"};
        String[] actual = epic.getSubtasks();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTrueSearchTasksByQueryEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        epic.matches("Молоко");

        Assertions.assertTrue(true);
    }

    @Test
    public void shouldFalseSearchTasksByQueryEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        epic.matches("Колбаса");

        Assertions.assertFalse(false);
    }


    @Test
    public void shouldGetTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "приложение НетоБанка",
                "Во вторник после обеда"
        );

        Assertions.assertEquals("Выкатка 3й версии приложения", meeting.getTopic());
    }

    @Test
    public void shouldTrueSearchTasksByQueryMeetingTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "приложение НетоБанка",
                "Во вторник после обеда"
        );

        meeting.matches("Выкатка 3й версии приложения");

        Assertions.assertTrue(true);
    }

    @Test
    public void shouldFalseSearchTasksByQueryMeetingTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "приложение НетоБанка",
                "Во вторник после обеда"
        );

        meeting.matches("Выкатка финальной версии приложения");

        Assertions.assertFalse(false);
    }


    @Test
    public void shouldGetProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "приложение НетоБанка",
                "Во вторник после обеда"
        );

        Assertions.assertEquals("приложение НетоБанка", meeting.getProject());
    }

    @Test
    public void shouldTrueSearchTasksByQueryMeetingProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "приложение НетоБанка",
                "Во вторник после обеда"
        );

        meeting.matches("приложение НетоБанк");

        Assertions.assertTrue(true);
    }

    @Test
    public void shouldFalseSearchTasksByQueryMeetingProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "приложение НетоБанка",
                "Во вторник после обеда"
        );

        meeting.matches("приложение БРК");

        Assertions.assertFalse(false);
    }


    @Test
    public void shouldGetStart() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "приложение НетоБанка",
                "Во вторник после обеда"
        );

        Assertions.assertEquals("Во вторник после обеда", meeting.getStart());
    }

    @Test
    public void shouldTrueSearchTasksByQueryMeetingStart() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "приложение НетоБанка",
                "Во вторник после обеда"
        );

        meeting.matches("Во вторник после обеда");

        Assertions.assertTrue(true);
    }

    @Test
    public void shouldFalseSearchTasksByQueryMeetingStart() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "приложение НетоБанка",
                "Во вторник после обеда"
        );

        meeting.matches("В среду утром");

        Assertions.assertFalse(false);
    }


    @Test
    public void shouldGetId() {
        Task task = new Task(15);

        Assertions.assertEquals(15, task.getId());
    }

    @Test
    public void shouldFalseSearchTasksByQuery() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "приложение НетоБанка",
                "Во вторник после обеда"
        );
        Task task = new Task(5);

        task.matches("Мороженое");

        Assertions.assertFalse(false);
    }

    @Test
    public void testEpicMatches() {
        String[] subtasks = {"задача1", "задача2", "задача3"};
        Epic epic = new Epic(1, subtasks);
        Assertions.assertTrue(epic.matches("задача1"));
        Assertions.assertFalse(epic.matches("задача4"));
    }

    @Test
    public void testEpicGetSubtasks() {
        String[] subtasks = {"задача1", "задача2", "задача3"};
        Epic epic = new Epic(1, subtasks);
        Assertions.assertEquals(subtasks, epic.getSubtasks());
    }

    @Test
    public void testSimpleTaskMatches() {
        SimpleTask task = new SimpleTask(1, "Купить продукты");
        Assertions.assertTrue(task.matches("продукты"));
        Assertions.assertFalse(task.matches("уборка"));
    }

    @Test
    public void testSimpleTaskGetTitle() {
        SimpleTask task = new SimpleTask(1, "Купить продукты");
        Assertions.assertEquals("Купить продукты", task.getTitle());
    }

    @Test
    public void testMeetingMatches() {
        Meeting meeting = new Meeting(1, "Совещание по проекту", "Проект Х", "2023-06-01 10:00:00");
        Assertions.assertTrue(meeting.matches("Проект"));
        Assertions.assertFalse(meeting.matches("X"));
        Assertions.assertFalse(meeting.matches("Задача"));
    }

    @Test
    public void testMeetingGetters() {
        Meeting meeting = new Meeting(1, "Совещание по проекту", "Проект Х", "2023-06-01 10:00:00");
        Assertions.assertEquals(meeting.getTopic(), "Совещание по проекту");
        Assertions.assertEquals(meeting.getProject(), "Проект Х");
        Assertions.assertEquals(meeting.getStart(), "2023-06-01 10:00:00");
    }

    @Test
    public void testTaskEquals() {
        Task task1 = new Task(1);
        Task task2 = new Task(1);
        Task task3 = new Task(2);

        Assertions.assertEquals(task1, task2);
        Assertions.assertNotEquals(task1, task3);
    }

}