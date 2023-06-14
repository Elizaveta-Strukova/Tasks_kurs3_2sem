//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.task8a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

class ListTask implements TaskDAO {
    private List<Task> tasks = new ArrayList();

    public ListTask(int size) {
        Random random = new Random();

        for(int i = 0; i < size; ++i) {
            Task task = new Task(i + 1, "Task " + (i + 1), this.randomTime(random), "Context for task " + (i + 1));
            this.tasks.add(task);
        }

    }

    private String randomTime(Random random) {
        int hours = random.nextInt(24);
        int minutes = random.nextInt(60);
        return String.format("%02d:%02d", hours, minutes);
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    public List<Task> getAllTasks() {
        return this.tasks;
    }

    public Task getTaskById(int id) {
        Iterator var2 = this.tasks.iterator();

        Task task;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            task = (Task)var2.next();
        } while(task.getId() != id);

        return task;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void updateTask(Task task) {
        for(int i = 0; i < this.tasks.size(); ++i) {
            if (((Task)this.tasks.get(i)).getId() == task.getId()) {
                this.tasks.set(i, task);
                return;
            }
        }

    }

    public void deleteTask(int id) {
        for(int i = 0; i < this.tasks.size(); ++i) {
            if (((Task)this.tasks.get(i)).getId() == id) {
                this.tasks.remove(i);
                return;
            }
        }

    }
}
