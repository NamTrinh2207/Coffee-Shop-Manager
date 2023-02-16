package conCreteCommand;

import command.CommandString;
import controller.ControllerManager;

public class SalaryPartTime implements CommandString {
    ControllerManager controllerManager ;

    public SalaryPartTime(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public String execute(String id) {
        return controllerManager.salaryPartTime(id);
    }
}
