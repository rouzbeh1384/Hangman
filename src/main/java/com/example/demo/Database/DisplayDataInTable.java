package com.example.demo.Database;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DisplayDataInTable extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create the data
        Person person1 = new Person("John", "Doe", 30);
        Person person2 = new Person("Jane", "Doe", 25);
        ObservableList<Person> data = FXCollections.observableArrayList(person1, person2);

        // Create the table
        TableView<Person> tableView = new TableView<>();
        TableColumn<Person, String> firstNameColumn = new TableColumn<>("First Name");
        TableColumn<Person, String> lastNameColumn = new TableColumn<>("Last Name");
        TableColumn<Person, Integer> ageColumn = new TableColumn<>("Age");

        // Set up the table columns
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        // Add the columns to the table
        tableView.getColumns().addAll(firstNameColumn, lastNameColumn, ageColumn);

        // Add the data to the table
        tableView.setItems(data);

        // Create the scene
        VBox root = new VBox(tableView);
        Scene scene = new Scene(root, 300, 250);

        // Show the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}