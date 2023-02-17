package conCreteCommand;

import command.CommandEditEmployees;
import controller.ControllerManager;
import model.Person;

public class EditEmployee implements CommandEditEmployees {
    ControllerManager controllerManager;

    public EditEmployee(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public void execute(Person employee, String id) {
        controllerManager.editEmployee(employee,id);
    }
}
