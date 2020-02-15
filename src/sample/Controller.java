package sample;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ListView<Worker> employeeListView;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private CheckBox isActiveCheckBox;
    @FXML
    private Button deleteButton;
    @FXML
    private Button addButton;
    @FXML
    private Button clearButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        //The purpose of these code is to get the items from the employeeListView and fill in the selected information into the textfields and textbox
        employeeListView.getSelectionModel().selectedItemProperty().addListener((
                ObservableValue<? extends Worker> ov, Worker old_val, Worker new_val) ->
                {
                    Worker selectedItem = employeeListView.getSelectionModel().getSelectedItem();
                    firstNameTextField.setText(((Employee)selectedItem).firstName);
                    lastNameTextField.setText(((Employee)selectedItem).lastName);
                    isActiveCheckBox.setSelected(((Employee)selectedItem).isActive);
                }
                );

            //We created a observableList using the Workers interface with the variable name items and made it equal to the employeeListView from the sample.fxml file
            ObservableList<Worker> items = employeeListView.getItems();

            //We created an Employee object with the variable name employee1 from the Employee.java to store first and last name for employee 1
            Employee employee1 = new Employee();
            employee1.firstName = "Robert";
            employee1.lastName = "Smith";

            //We created an Employee object with the variable name employee1 from the Employee.java to store first and last name for employee 1
            Employee employee2 = new Employee();
            employee2.firstName = "Osman";
            employee2.lastName = "Adam";

            //Now that the 2 employees have been created we add them to the list created using item variable name we created in line 47 with add and employee in paranthesis.
            items.add(employee1);
            items.add(employee2);

            //The purpose of this look is to simply write employees into the employeeListView in a for loop 10 times
            for(int i = 0; i < 10; i++)
            {
                Employee employee = new Employee();
                employee.firstName = "Generic";
                employee.lastName = "Employee" + " " + i;
                employee.hire();
                items.add(employee);

            }

            //We created a new object with the variable name staff1 that is from the Staff.java
            Staff staff1 = new Staff();
            staff1.firstName = "StaffPerson";
            staff1.lastName = "GoodWorker";

            //We created a new object with the variable name faculty1 that is from the Faculty.java
            Faculty faculty1 = new Faculty();
            faculty1.firstName = "FacultyPerson";
            faculty1.lastName = "TerribleWorker";

            //This lines of code job is to add the created staff1/faculty1 and get the first and last name to add it into the list items.
            items.add(staff1);
            items.add(faculty1);

            //Set action for the deleteButton that was created in the sample.fxml file
            deleteButton.setOnAction(e -> deleteFunction());
            //Set action for the addButton that was created in the sample.fxml file
            addButton.setOnAction(e -> addFunction());
            //Set action for the clearButton that was created in the sample.fxml file
            clearButton.setOnAction(e -> clearFunction());



    }

    /* When the delete button with the id deleteButton is clicked this function will run
       In the function I got typed down the observable list we made in class and made objects.
       employeeList is supposed to equal all the employees in the list that was created and selectedEmployee
       get the selected employee from the employeeListView. The last line of code is the making sure that
       the each item selected will be removed and not the whole list that was brought by the employeeListView.
       Used this video to understand delete and add function: https://www.youtube.com/watch?v=uz2sWCnTq6E&t=429s */
    @FXML
    public void deleteFunction(){
        ObservableList<Worker> employeeList, selectedEmployee;
        employeeList = employeeListView.getItems();
        selectedEmployee = employeeListView.getSelectionModel().getSelectedItems();

        selectedEmployee.forEach(employeeList:: remove);

    }

    @FXML
    public void addFunction()
    {
        // Created a new employee so I get access to the set name functions I made in the employee class
       Employee employee = new Employee();
       // This gets the information of what the user input in the text field
       employee.setFName(firstNameTextField.getText());
       employee.setLName(lastNameTextField.getText());
       employee.hire();
       //Now that we got the employee fname and lname we can get the list of items in the employeelistview and add that new employee from the employee object we created here
       employeeListView.getItems().add(employee);
       // All this does is clear the fields where the user typed in the information and uncheck the box if the user checked it
       firstNameTextField.clear();
       lastNameTextField.clear();
       isActiveCheckBox.setSelected(false);
    }
    public void clearFunction()
    {
        Employee clear = new Employee();
        //I learned that through this website that you can add . after the text field clear it clears the values in there: https://stackoverflow.com/questions/28516654/javafx-how-to-clear-textfield-when-mouse-is-clicked-on-it
        firstNameTextField.clear();
        lastNameTextField.clear();
        // Used this page to know how to uncheck a checkbox: https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/CheckBox.html
        isActiveCheckBox.setSelected(false);
    }





}
