//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.task8a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaskDAOImpl implements TaskDAO {
    private Connection conn;

    public TaskDAOImpl() {
        try {
            this.conn = DriverManager.getConnection("jdbc:h2:~/test2", "sa", "");
            Statement stmt = this.conn.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS TASK (id INTEGER PRIMARY KEY AUTO_INCREMENT,name VARCHAR(255),time VARCHAR(255),status VARCHAR(255))");
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

    }

    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList();

        try {
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM task");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Task task = new Task(rs.getInt("id"), rs.getString("name"), rs.getString("time"), rs.getString("status"));
                tasks.add(task);
            }
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

        return tasks;
    }

    public Task getTaskById(int id) {
        Task task = null;

        try {
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM task WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                task = new Task(rs.getInt("id"), rs.getString("name"), rs.getString("time"), rs.getString("status"));
            }
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

        return task;
    }

    public void addTask(Task task) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO task (name, time, status) VALUES (?, ?, ?)");
            ps.setString(1, task.getName());
            ps.setString(2, task.getTime());
            ps.setString(3, task.getStatus());
            ps.executeUpdate();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }

    public void updateTask(Task task) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("UPDATE task SET name = ?, time = ?, status = ? WHERE id = ?");
            ps.setString(1, task.getName());
            ps.setString(2, task.getTime());
            ps.setString(3, task.getStatus());
            ps.setInt(4, task.getId());
            ps.executeUpdate();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }

    public void deleteTask(int id) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM task WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }
}
