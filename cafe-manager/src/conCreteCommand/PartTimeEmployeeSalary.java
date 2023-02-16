package conCreteCommand;

import command.CommandStringDataType;
import controller.ControllerManager;

public class PartTimeEmployeeSalary implements CommandStringDataType {
    ControllerManager controllerManager ;

    public PartTimeEmployeeSalary(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public String execute(String id) {
        return controllerManager.salaryPartTime(id);
    }
}
