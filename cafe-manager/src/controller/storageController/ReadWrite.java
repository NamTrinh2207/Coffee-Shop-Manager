package controller.storageController;

import model.classModel.Client;
import model.classModel.Person;
import java.util.List;

public interface ReadWrite {
    void writeToFileClient(List<Client> clients);
    void writeToFileInvoiceHistory(List<Client> clients);
    void writeToFileEmployees(List<Person> employees);
    List<Client> readDataFileClient();
    List<Client> readDataFileInvoiceHistory();
    List<Person> readDataFileEmployees();
}