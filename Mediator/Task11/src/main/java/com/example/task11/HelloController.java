package com.example.task11;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class HelloController implements Initializable, Mediator {

    public ScrollPane viewpane;

    public TextField login;
    private HashMap<String, Colleague> id=new HashMap<>();
    private Colleague currentcolleague;
    private BaseTest basetest=new BaseTest();

    public void onStart(ActionEvent actionEvent) {
        currentcolleague =id.get(login.getText());
        if(currentcolleague==null) currentcolleague =id.get("1");
        currentcolleague.receive(basetest.getTest());
        currentcolleague.notifyColleague(currentcolleague.getReceivedMessage());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.put("Студент", new Worker(this));
        id.put("Преподаватель", new Editor(this));
        id.put("Посетитель", new Viewer(this));
    }
    @Override
    public void setView(Node control) {
        Group root = new Group();
        ScrollBar sc = new ScrollBar();
        sc.setLayoutX(control.getLayoutX());
        control.setLayoutX(control.getLayoutX()+sc.getWidth());
        sc.setMin(0);
        sc.setValue(50);
        sc.setMax(100);
        sc.setOrientation(Orientation.VERTICAL);
        root.getChildren().addAll(control,sc);
        viewpane.setContent(control);
    }
}