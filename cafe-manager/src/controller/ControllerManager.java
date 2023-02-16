package controller;

import model.*;
import storage.ReadWrite;
import storage.ReadWriteToFile;

import java.util.*;


public class ControllerManager {
    //Display saving---------------------------------------------------------------------------------
    private static ControllerManager instance;
    private final ReadWrite readWrite = ReadWriteToFile.getInstance();
    private final List<Client> clients;
    private final List<Person> employees;

    private ControllerManager() {
        this.clients = readWrite.readDataFileClient();
        this.employees = readWrite.readDataFileEmployees();
    }

    public static ControllerManager getInstance() {
        if (instance == null) {
            instance = new ControllerManager();
        }
        return instance;
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<Person> getEmployees() {
        return employees;
    }

    //CRUD Client------------------------------------------------------------------------------------
    public void addNewClient(Client client) {
        clients.add(client);
        readWrite.writeToFileClient(clients);
    }

    public void addNewEmployee(Person employee) {
        employees.add(employee);
        readWrite.writeToFileEmployees(employees);
    }

    public void displayClients() {
        for (Client o : clients) {
            System.out.println(o);
        }
    }

    public void displayEmployees() {
        for (Person employee : employees) {
            System.out.println(employee);
        }
    }

    public String deleteByEmploy(String id) {
        for (Person o : employees) {
            if (id.equals(o.getId())) {
                employees.remove(o);
                System.out.println("successful delete by " + o.getFullName());
                break;
            }
        }
        readWrite.writeToFileEmployees(employees);
        return "ib bạn nhập không có trong dánh sách";
    }

    public Object totalMoney(String id) {
        StringBuilder sb = new StringBuilder();
        double sum;
        for (Client p : clients) {
            if (id.trim().equals(p.getId())) {
                sum = p.calculateTheAmount();
                sb.append("Khách hàng: ").append(p.getName()).append("\nTổng tiền : ").append((long) sum).append(" VNĐ");
                if (clients != null) {
                    clients.remove(p);
                    readWrite.writeToFileClient(clients);
                }
                return sb;
            }
        }
        return "Không tìm thấy id khách hàng";
    }

    public void sortClient() {
        clients.sort(new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        readWrite.writeToFileClient(clients);
    }

    public String totalSalaryAllEmployees() {
        StringBuilder total = new StringBuilder();
        double totalSalary;
        double FullTimeSalary = 0;
        double PartTimeSalary = 0;
        for (Person nv : employees) {
            if (nv instanceof FullTimeEmployee) {
                FullTimeSalary += ((FullTimeEmployee) nv).calculateTheAmount();
            }
            if (nv instanceof PartTimeEmployee) {
                PartTimeSalary += ((PartTimeEmployee) nv).calculateTheAmount();
            }
        }
        totalSalary = FullTimeSalary + PartTimeSalary;
        total.append("Tổng lương của tất cả nhân viên: ").append((long) totalSalary).append(" VNĐ");
        return total.toString();
    }

    public String salaryFullTime(String id) {
        StringBuilder salaryEmployee = new StringBuilder();
        double total;
        for (Person nv : employees) {
            if (id.equals(nv.getId())) {
                if (nv instanceof FullTimeEmployee) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Số ngày nghỉ (Ngày):  ");
                    double unpaidLeave = Double.parseDouble(scanner.nextLine());
                    System.out.println("Đi muộn (ngày/tháng):  ");
                    int late = Integer.parseInt(scanner.nextLine());
                    total = ((FullTimeEmployee) nv).realFieldEmployee(unpaidLeave, late);
                    salaryEmployee.append("Nhân viên full time: ").append(nv.getName()).append("; Nghỉ không lương: ").
                            append(unpaidLeave).append(" Ngày").append("; Đi muộn: ").append(late).append(" Ngày").
                            append("; Thực lĩnh: ").append((long) total).append(" VNĐ");
                    return salaryEmployee.toString();
                }
            }
        }
        return "id bạn nhập không có hoặc trùng id với nhân viên part time";
    }

    public String salaryPartTime(String id) {
        StringBuilder salaryEmployee = new StringBuilder();
        double total;
        for (Person nv : employees) {
            if (nv.getId().equalsIgnoreCase(id)) {
                if (nv instanceof PartTimeEmployee) {
                    total = ((PartTimeEmployee) nv).calculateTheAmount();
                    salaryEmployee.append("Nhân viên part time: ").append(nv.getName()).append("; Thực lĩnh: ").
                            append((long) total);
                    return salaryEmployee.toString();
                }
            }
        }
        return "id bạn nhập không có hoặc trùng id với nhân viên full time";
    }

    public void sortNameEmployees() {
        employees.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        readWrite.writeToFileEmployees(employees);
    }
}
