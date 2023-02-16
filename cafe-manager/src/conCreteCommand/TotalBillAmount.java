package conCreteCommand;

import command.CommandStringDataType;
import controller.ControllerManager;

public class TotalBillAmount implements CommandStringDataType {
    ControllerManager controllerManager;

    public TotalBillAmount(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public String execute(String id) {
        return controllerManager.totalBillAmount(id);
    }
}
