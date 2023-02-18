package controller.conCreteCommand;

import controller.command.CommandAddEmployee;
import controller.manager.ControllerManager;
import model.Person;

public class AddNewEmployee implements CommandAddEmployee {
    ControllerManager controller;

    public AddNewEmployee(ControllerManager controller) {
        this.controller = controller;
    }

    @Override
    public void execute(Person employee) {
        controller.addNewEmployee(employee);
    }
}
