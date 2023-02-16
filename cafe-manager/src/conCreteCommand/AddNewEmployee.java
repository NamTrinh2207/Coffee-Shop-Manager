package conCreteCommand;

import command.CommandAddEmployee;
import controller.ControllerManager;
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
