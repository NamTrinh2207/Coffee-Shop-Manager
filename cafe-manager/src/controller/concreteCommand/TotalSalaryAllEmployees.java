package controller.concreteCommand;
import controller.command.CommandTotalEmployeeSalary;
import controller.managerController.Manager;

public class TotalSalaryAllEmployees implements CommandTotalEmployeeSalary {
    Manager controllerManager ;

    public TotalSalaryAllEmployees(Manager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public String execute() {
        return controllerManager.totalSalaryAllEmployees();
    }
}