//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.task8a;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController implements Initializable {
    @FXML
    public TextField name;
    @FXML
    public TextField time;

    @FXML
    public TextField status;

    public RadioButton radioh2;
    public RadioButton radiofile;
    @FXML
    TaskDAOImpl taskdao;
    TaskFabrica taskFabrica = new TaskFabrica();
    TaskDAO taskDAO;
    public TableView table;
    private ObservableList<Task> fxlist;

    public HelloController() {
    }

    private void createtable() {
        TableColumn Col0 = new TableColumn("Номер");
        Col0.setMinWidth(15.0);
        Col0.setCellValueFactory(new PropertyValueFactory("id"));
        TableColumn Col1 = new TableColumn("Название");
        Col1.setMinWidth(100.0);
        Col1.setCellValueFactory(new PropertyValueFactory("name"));
        TableColumn Col2 = new TableColumn("Время");
        Col2.setMinWidth(50.0);
        Col2.setCellValueFactory(new PropertyValueFactory("time"));
        TableColumn Col3 = new TableColumn("Статус");
        Col3.setMinWidth(50.0);
        Col3.setCellValueFactory(new PropertyValueFactory("status"));
        this.table.getColumns().clear();
        this.table.getColumns().addAll(new Object[]{Col0, Col1, Col2, Col3});
        this.table.setItems(this.fxlist);
        Col0.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Task, Integer>>() {
            public void handle(TableColumn.CellEditEvent<Task, Integer> t) {
                ((Task)t.getTableView().getItems().get(t.getTablePosition().getRow())).setId((Integer)t.getNewValue());
            }
        });
        Col1.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Task, Integer>>() {
            public void handle(TableColumn.CellEditEvent<Task, Integer> t) {
                ((Task)t.getTableView().getItems().get(t.getTablePosition().getRow())).setId((Integer)t.getNewValue());
            }
        });
        Col2.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Task, Integer>>() {
            public void handle(TableColumn.CellEditEvent<Task, Integer> t) {
                ((Task)t.getTableView().getItems().get(t.getTablePosition().getRow())).setId((Integer)t.getNewValue());
            }
        });
        Col3.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Task, Integer>>() {
            public void handle(TableColumn.CellEditEvent<Task, Integer> t) {
                ((Task)t.getTableView().getItems().get(t.getTablePosition().getRow())).setId((Integer)t.getNewValue());
            }
        });
    }

    @FXML
    protected void onButtonClick() {
        try {
            String name2 = this.name.getText();
            String time2 = this.time.getText();
            String status2 = this.status.getText();
            if (this.radioh2.isSelected()) {
                this.taskDAO = this.taskFabrica.getFabDAO("H2");
            } else if (this.radiofile.isSelected()) {
                this.taskDAO = this.taskFabrica.getFabDAO("File");
            }

            this.taskDAO.addTask(new Task(0, name2, time2, status2));
            this.table.setItems(FXCollections.observableList(this.taskDAO.getAllTasks()));
        } catch (Exception var4) {
            var4.getMessage();
        }

    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.createtable();
        this.taskdao = new TaskDAOImpl();
        this.table.setItems(FXCollections.observableList(this.taskdao.getAllTasks()));
    }

    public void getBD(ActionEvent actionEvent) {
        if (this.radioh2.isSelected()) {
            this.taskFabrica.getFabDAO("H2");
        } else if (this.radiofile.isSelected()) {
            this.taskFabrica.getFabDAO("File");
        }

    }
}
