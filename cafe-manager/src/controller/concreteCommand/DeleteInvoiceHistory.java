package controller.concreteCommand;

import controller.command.CommandVoidDataType;
import controller.managerController.Manager;

public class DeleteInvoiceHistory implements CommandVoidDataType {
    Manager manager;

    public DeleteInvoiceHistory(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void execute() {
        manager.deleteInvoiceHistory();
    }
}
