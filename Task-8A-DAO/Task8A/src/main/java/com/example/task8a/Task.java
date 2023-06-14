//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.task8a;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Task {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty time;
    private SimpleStringProperty status;

    public Task(int id, String name, String time, String status) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.time = new SimpleStringProperty(time);
        this.status = new SimpleStringProperty(status);
    }

    public int getId() {
        return this.id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return this.id;
    }

    public String getName() {
        return this.name.get();
    }

    public SimpleStringProperty nameProperty() {
        return this.name;
    }

    public String getTime() {
        return this.time.get();
    }

    public SimpleStringProperty timeProperty() {
        return this.time;
    }

    public String getStatus() {
        return this.status.get();
    }

    public SimpleStringProperty statusProperty() {
        return this.status;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
}
