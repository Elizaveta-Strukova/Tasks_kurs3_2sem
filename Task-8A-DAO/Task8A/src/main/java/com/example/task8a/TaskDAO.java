//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.task8a;

import java.util.List;

public interface TaskDAO {
    List<Task> getAllTasks();

    Task getTaskById(int var1);

    void addTask(Task var1);

    void updateTask(Task var1);

    void deleteTask(int var1);
}
