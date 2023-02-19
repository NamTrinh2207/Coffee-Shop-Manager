package controller.concreteCommand;

import controller.command.CommandListClients;
import controller.managerController.Manager;
import model.classModel.Client;

import java.util.List;

public class ListInvoiceHistory implements CommandListClients {
    Manager manager;

    public ListInvoiceHistory(Manager manager) {
        this.manager = manager;
    }

    @Override
    public List<Client> execute() {
        return manager.getInvoiceHistory();
    }
}
