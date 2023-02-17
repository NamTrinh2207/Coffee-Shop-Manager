package invoker;

import command.*;
import model.Client;
import model.Person;

import java.util.List;

public class CoffeeApp {
    private CommandListClients clients;
    private CommandListEmployees employees;
    private CommandAddClients addClients;
    private CommandAddEmployee addEmployees;
    private CommandStringDataType deleteByEmployee;
    private CommandVoidDataType displayClient;
    private CommandVoidDataType displayEmployee;
    private CommandStringDataType salaryFullTime;
    private CommandStringDataType salaryPartTime;
    private CommandVoidDataType sortClient;
    private CommandVoidDataType sortNameEmployees;
    private CommandStringDataType totalMoney;
    private CommandTotalEmployeeSalary totalSalaryAllEmployees;
    private CommandEditEmployees editEmployees;

    public CoffeeApp() {
    }

    public CoffeeApp(CommandListClients clients, CommandListEmployees employees, CommandAddClients addClients, CommandAddEmployee addEmployees,
                     CommandStringDataType deleteByEmployee, CommandVoidDataType displayClient, CommandVoidDataType displayEmployee,
                     CommandStringDataType salaryFullTime, CommandStringDataType salaryPartTime, CommandVoidDataType sortClient,
                     CommandVoidDataType sortNameEmployees, CommandStringDataType totalMoney, CommandTotalEmployeeSalary
                           totalSalaryAllEmployees,CommandEditEmployees editEmployees) {
        this.clients = clients;
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

    }

    public List<Client> listClients() {
        return clients.execute();
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
        editEmployees.execute(employee,id);
    }


}
