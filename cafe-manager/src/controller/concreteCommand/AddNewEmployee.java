package controller.concreteCommand;

import controller.command.CommandAddEmployee;
import controller.managerController.Manager;
import model.modelClass.Person;

public class AddNewEmployee implements CommandAddEmployee {
    Manager controller;

    public AddNewEmployee(Manager controller) {
        this.controller = controller;
    }

    @Override
    public void execute(Person employee) {
        controller.addNewEmployee(employee);
    }
}
