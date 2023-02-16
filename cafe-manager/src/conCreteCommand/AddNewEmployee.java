package conCreteCommand;

import command.CommandEmployees;
import controller.ControllerManager;
import model.Person;

public class AddNewEmployee implements CommandEmployees {
    ControllerManager controller;

    public AddNewEmployee(ControllerManager controller) {
        this.controller = controller;
    }

    @Override
    public void execute(Person employee) {
        controller.addNewEmployee(employee);
    }
}
