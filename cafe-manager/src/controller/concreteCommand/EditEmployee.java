package controller.concreteCommand;

import controller.command.CommandEditEmployees;
import controller.managerController.Manager;
import model.classModel.Person;

public class EditEmployee implements CommandEditEmployees {
    Manager controllerManager;

    public EditEmployee(Manager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public void execute(Person employee, String id) {
        controllerManager.editEmployee(employee,id);
    }
}
