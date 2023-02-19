package views.invoker;

import controller.command.*;
import model.classModel.Client;
import model.classModel.Person;

import java.util.List;

public class CoffeeApp {
    private CommandListClients clients;
    private CommandListClients listInvoiceHistory;
    private CommandListEmployees employees;
    private CommandAddClients addClients;
    private CommandAddEmployee addEmployees;
    private CommandStringDataType deleteByEmployee;
    private CommandVoidDataType displayClient;
    private CommandVoidDataType displayEmployee;
    private CommandStringDataType salaryFullTime;
    private CommandStringDataType salaryPartTime;
    private CommandVoidDataType sortClient;
    private CommandVoidDataType displayInvoiceHistory;
    private CommandVoidDataType sortNameEmployees;
    private CommandStringDataType totalMoney;
    private CommandTotalEmployeeSalary totalSalaryAllEmployees;
    private CommandEditEmployees editEmployees;
    private CommandVoidDataType deleteInvoiceHistory;

    public CoffeeApp() {
    }

    public CoffeeApp(CommandListClients clients, CommandListClients listInvoiceHistory, CommandListEmployees employees,
                     CommandAddClients addClients, CommandAddEmployee addEmployees, CommandStringDataType deleteByEmployee,
                     CommandVoidDataType displayClient, CommandVoidDataType displayEmployee,
                     CommandStringDataType salaryFullTime, CommandStringDataType salaryPartTime, CommandVoidDataType sortClient,
                     CommandVoidDataType sortNameEmployees, CommandStringDataType totalMoney, CommandTotalEmployeeSalary
                             totalSalaryAllEmployees, CommandEditEmployees editEmployees,
                     CommandVoidDataType displayInvoiceHistory, CommandVoidDataType deleteInvoiceHistory) {
        this.clients = clients;
        this.listInvoiceHistory = listInvoiceHistory;
        this.employees = employees;
        this.addClients = addClients;
        this.addEmployees = addEmployees;
        this.deleteByEmployee = deleteByEmployee;
        this.displayClient = displayClient;
        this.displayEmployee = displayEmployee;
        this.salaryFullTime = salaryFullTime;
        this.salaryPartTime = salaryPartTime;
        this.sortClient = sortClient;
        this.sortNameEmployees = sortNameEmployees;
        this.totalMoney = totalMoney;
        this.totalSalaryAllEmployees = totalSalaryAllEmployees;
        this.editEmployees = editEmployees;
        this.displayInvoiceHistory = displayInvoiceHistory;
        this.deleteInvoiceHistory = deleteInvoiceHistory;
    }

    public List<Client> listClients() {
        return clients.execute();
    }

    public List<Client> listInvoiceHistory() {
        return listInvoiceHistory.execute();
    }

    public List<Person> listEmployees() {
        return employees.execute();
    }

    public void addClients(Client client) {
        addClients.execute(client);
    }

    public void addEmployees(Person employees) {
        addEmployees.execute(employees);
    }

    public void totalSalaryAllEmployees() {
        System.out.println(totalSalaryAllEmployees.execute());
    }

    public void displayClient() {
        displayClient.execute();
    }

    public void displayInvoiceHistory() {
        displayInvoiceHistory.execute();
    }

    public void displayEmployee() {
        displayEmployee.execute();
    }

    public void sortByClients() {
        sortClient.execute();
    }

    public void sortByEmployees() {
        sortNameEmployees.execute();
    }

    public void deleteByEmployee(String id) {
        System.out.println(deleteByEmployee.execute(id));
    }

    public void totalMoney(String id) {
        System.out.println(totalMoney.execute(id));
    }

    public void salaryFullTime(String id) {
        System.out.println(salaryFullTime.execute(id));
    }

    public void salaryPartTime(String id) {
        System.out.println(salaryPartTime.execute(id));
    }

    public void editEmployee(Person employee, String id) {
        editEmployees.execute(employee, id);
    }
    public void deleteInvoiceHistory(){
        deleteInvoiceHistory.execute();
    }


}
