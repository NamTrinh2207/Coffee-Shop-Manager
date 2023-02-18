package controller.conCreteCommand;

import controller.command.CommandListEmployees;
import controller.manager.ControllerManager;
import model.Person;

import java.util.List;

public class ListEmployees implements CommandListEmployees {
    ControllerManager controllerManager;

    public ListEmployees(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }
    @Override
    public List<Person> execute() {
        return controllerManager.getEmployees();
    }
}
