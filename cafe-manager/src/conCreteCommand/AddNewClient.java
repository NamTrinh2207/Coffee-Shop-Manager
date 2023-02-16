package conCreteCommand;

import command.CommandClients;
import controller.ControllerManager;
import model.Client;

public class AddNewClient implements CommandClients {
    ControllerManager controllerManager;

    public AddNewClient(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }

    @Override
    public void execute(Client client) {
        controllerManager.addNewClient(client);
    }
}
