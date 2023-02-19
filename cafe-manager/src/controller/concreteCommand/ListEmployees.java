package controller.concreteCommand;

import controller.command.CommandListEmployees;
import controller.managerController.Manager;
import model.classModel.Person;

import java.util.List;

public class ListEmployees implements CommandListEmployees {
    Manager controllerManager;

    public ListEmployees(Manager controllerManager) {
        this.controllerManager = controllerManager;
    }
    @Override
    public List<Person> execute() {
        return controllerManager.getEmployees();
    }
}
