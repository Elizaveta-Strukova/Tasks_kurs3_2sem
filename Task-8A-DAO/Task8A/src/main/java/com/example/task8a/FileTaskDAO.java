package com.example.task8a;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileTaskDAO implements TaskDAO {
    private String fileName;

    public FileTaskDAO(String fileName) {
        this.fileName = fileName;
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.fileName));

            String line;
            try {
                while((line = reader.readLine()) != null) {
                    Task task = this.parseTaskFromLine(line);
                    tasks.add(task);
                }
            } catch (Throwable var6) {
                try {
                    reader.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }

                throw var6;
            }

            reader.close();
        } catch (IOException var7) {
            var7.printStackTrace();
        }

        return tasks;
    }

    public Task getTaskById(int id) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.fileName));

            Task var5;
            label49: {
                String line;
                try {
                    while((line = reader.readLine()) != null) {
                        Task task = this.parseTaskFromLine(line);
                        if (task.getId() == id) {
                            var5 = task;
                            break label49;
                        }
                    }
                } catch (Throwable var7) {
                    try {
                        reader.close();
                    } catch (Throwable var6) {
                        var7.addSuppressed(var6);
                    }

                    throw var7;
                }

                reader.close();
                return null;
            }

            reader.close();
            return var5;
        } catch (IOException var8) {
            var8.printStackTrace();
            return null;
        }
    }

    public void addTask(Task task) {
        List<Task> tasks = this.getAllTasks();
        int maxId = tasks.stream().mapToInt(Task::getId).max().orElse(0);
        task.setId(maxId + 1);
        tasks.add(task);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileName));

            try {
                Iterator var5 = tasks.iterator();

                while(var5.hasNext()) {
                    Task t = (Task)var5.next();
                    String line = this.taskToString(t);
                    writer.write(line);
                    writer.newLine();
                }
            } catch (Throwable var9) {
                try {
                    writer.close();
                } catch (Throwable var8) {
                    var9.addSuppressed(var8);
                }

                throw var9;
            }

            writer.close();
        } catch (IOException var10) {
            var10.printStackTrace();
        }

    }

    public void updateTask(Task task) {
        List<Task> tasks = this.getAllTasks();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileName));

            try {
                Iterator var4 = tasks.iterator();

                while(var4.hasNext()) {
                    Task t = (Task)var4.next();
                    if (t.getId() == task.getId()) {
                        t.setName(task.getName());
                        t.setTime(task.getTime());
                        t.setStatus(task.getStatus());
                    }

                    String line = this.taskToString(t);
                    writer.write(line);
                    writer.newLine();
                }
            } catch (Throwable var8) {
                try {
                    writer.close();
                } catch (Throwable var7) {
                    var8.addSuppressed(var7);
                }

                throw var8;
            }

            writer.close();
        } catch (IOException var9) {
            var9.printStackTrace();
        }

    }

    public void deleteTask(int id) {
        List<Task> tasks = this.getAllTasks();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileName));

            try {
                Iterator var4 = tasks.iterator();

                while(var4.hasNext()) {
                    Task t = (Task)var4.next();
                    if (t.getId() != id) {
                        String line = this.taskToString(t);
                        writer.write(line);
                        writer.newLine();
                    }
                }
            } catch (Throwable var8) {
                try {
                    writer.close();
                } catch (Throwable var7) {
                    var8.addSuppressed(var7);
                }

                throw var8;
            }

            writer.close();
        } catch (IOException var9) {
            var9.printStackTrace();
        }

    }

    private Task parseTaskFromLine(String line) {
        String[] parts = line.split(",");
        int id = Integer.parseInt(parts[0]);
        String name = parts[1];
        String time = parts[2];
        String status = parts[3];
        return new Task(id, name, time, status);
    }

    private String taskToString(Task task) {
        StringBuilder sb = new StringBuilder();
        sb.append(task.getId()).append(",");
        sb.append(task.getName()).append(",");
        sb.append(task.getTime()).append(",");
        sb.append(task.getStatus());
        return sb.toString();
    }
}
