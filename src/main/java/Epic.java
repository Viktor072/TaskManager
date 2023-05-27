public class Epic extends Task {

    protected int id;
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id); // вызов родительского конструктора
        this.id = id;
        this.subtasks = subtasks; // заполнение своих полей
    }

    @Override
    public boolean matches(String query) {
        for (String subtasks : subtasks) {
            if (subtasks.contains(query)) {
                return true;
            }
        }
        return false;
    }

    public String[] getSubtasks () {
        return subtasks;
    }
}


