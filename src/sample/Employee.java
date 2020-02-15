package sample;

import java.util.UUID;

public class Employee implements Worker {
    public String firstName;
    public String lastName;
    public boolean isActive;
    public UUID id;

    // I created an employee in the employee class so that when I create a employee object on another class that defaults to those values below
    public Employee()
    {
        this.firstName = "";
        this.lastName = "";
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString()
    {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public void hire() {
        isActive = true;
    }

    @Override
    public void fire() {
        isActive = false;
    }

    @Override
    public void leave() {

    }

    // Created a getter for first name
    public String getFirstName()
    {
        return firstName;
    }
    // Created a getter for the last name also
    public String getLastName()
    {
        return  lastName;
    }

    // I created this so I am able to set the first name of the employee
    public void setFName(String firstName)
    {
        this.firstName = firstName;
    }

    //I created this so I am able to set the last name of the employee
    public void setLName( String lastName)
    {
        this.lastName = lastName;
    }
}
