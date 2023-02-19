package controller.concreteCommand;

import controller.command.CommandVoidDataType;
import controller.managerController.Manager;

public class DisplayInvoiceHistory implements CommandVoidDataType {
    Manager manager;

    public DisplayInvoiceHistory(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void execute() {
        manager.displayInvoiceHistory();
    }
}
