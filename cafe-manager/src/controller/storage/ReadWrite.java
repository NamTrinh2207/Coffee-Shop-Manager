package controller.storage;

import model.Client;
import model.Person;
import java.util.List;

public interface ReadWrite {
    void writeToFileClient(List<Client> clients);
    void writeToFileEmployees(List<Person> employees);
    List<Client> readDataFileClient();
    List<Person> readDataFileEmployees();
}