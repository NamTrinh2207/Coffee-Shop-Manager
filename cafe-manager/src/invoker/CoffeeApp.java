package invoker;

import command.*;
import model.Client;
import model.Person;

import java.util.List;

public class CoffeeApp {
    private Clients clients;
    private Employees employees;
    private CommandClients addClients;
    private CommandEmployees addEmployees;
    private CommandString deleteByEmployee;
    private CommandVoid displayClient;
    private CommandVoid displayEmployee;
    private CommandString salaryFullTime;
    private CommandString salaryPartTime;
    private CommandVoid sortClient;
    private CommandVoid sortNameEmployees;
    private CommandString totalMoney;
    private TotalSalaryEmployees totalSalaryAllEmployees;

    public CoffeeApp() {
    }

    public CoffeeApp(Clients clients, Employees employees, CommandClients addClients, CommandEmployees addEmployees,
                     CommandString deleteByEmployee, CommandVoid displayClient, CommandVoid displayEmployee,
                     CommandString salaryFullTime, CommandString salaryPartTime, CommandVoid sortClient,
                     CommandVoid sortNameEmployees, CommandString totalMoney, TotalSalaryEmployees
                           totalSalaryAllEmployees) {
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


}
