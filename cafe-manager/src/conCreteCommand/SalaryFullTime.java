package conCreteCommand;

import command.CommandString;
import controller.ControllerManager;

public class SalaryFullTime implements CommandString {
    ControllerManager controllerManager;

    public SalaryFullTime(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public String execute(String id) {
        return controllerManager.salaryFullTime(id);
    }
}
