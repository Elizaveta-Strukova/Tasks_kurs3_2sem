
package com.example.task8a;

public class TaskFabrica {
    public static String H2 = "H2";
    public static String FILE = "File";
    private TaskDAO FabDAO = null;

    public TaskFabrica() {
    }

    public TaskDAO getFabDAO(String shapeType) {
        if (shapeType.equalsIgnoreCase(H2)) {
            this.FabDAO = new TaskDAOImpl();
        } else if (shapeType.equalsIgnoreCase(FILE)) {
            this.FabDAO = new FileTaskDAO("E:\\Университет\\3 курс\\2 семестр\\Программная инженерия\\Task8A\\src\\main\\java\\com\\example\\task8a\\BD.txt");
        }

        return this.FabDAO;
    }
}
