package conCreteCommand;

import command.Employees;
import controller.ControllerManager;
import model.Person;

import java.util.List;

public class ListEmployees implements Employees {
    ControllerManager controllerManager;

    public ListEmployees(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }
    @Override
    public List<Person> execute() {
        return controllerManager.getEmployees();
    }
}
