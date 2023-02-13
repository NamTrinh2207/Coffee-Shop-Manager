package controller;

import model.*;
import storage.ReadWriteToFile;

import java.util.*;

public class ControllerManager {
    //Display saving---------------------------------------------------------------------------------
    private static ControllerManager instance;
    private static List<Client> clients;
    private static List<Person> employees;

    private ControllerManager() {
        clients = ReadWriteToFile.getInstance().readDataFileClient();
        employees = ReadWriteToFile.getInstance().readDataFileEmployees();
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
        ReadWriteToFile.getInstance().writeToFileClient(clients);
    }

    public void addNewEmployee(Person employee) {
        employees.add(employee);
        ReadWriteToFile.getInstance().writeToFileEmployees(employees);
    }

    public void display() {
        for (Client o : clients) {
            System.out.println(o);
        }
    }

    public void displayEmployees() {
        for (Person employee : employees) {
            System.out.println(employee);
        }
    }

    public void deleteByEmploy(String id) {
        for (Person o : employees) {
            if (id.equals(o.getId())) {
                employees.remove(o);
                break;
            }
        }
        ReadWriteToFile.getInstance().writeToFileEmployees(employees);
    }

    public Object totalMoney(String id) {
        StringBuilder sb = new StringBuilder();
        double sum = 0;
        for (Client p : clients) {
            if (id.equals(p.getId())) {
                for (Product o : p.getProduct()) {
                    sum += o.getPrice() * o.getQuantity();
                }
                sb.append("Khách hàng: ").append(p.getName()).append("\nTổng tiền : ").append(sum);
                if (clients.size() > 0) {
                    clients.remove(p);
                }
            }else {
                return "Không tìm thấy thông tin khách hàng";
            }
        }
        if (clients != null) {
            ReadWriteToFile.getInstance().writeToFileClient(clients);
        }
        return sb;
    }

    public void sortClient() {
        clients.sort(new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        ReadWriteToFile.getInstance().writeToFileClient(clients);
    }

    public void editEmployee(Scanner input) {
        String newId;
        String newName;
        int newAge;
        String address;
        String newPhone;
        String newEmail;
        double newHardSalary;
        double newWorkingDays;
        System.out.println("Mời bạn nhập vào id nhân viên: ");
        String id = input.nextLine();
        for (Person e : employees) {
            if (id.equals(e.getId())) {
                if (e instanceof FullTimeEmployee) {
                    System.out.print("Mời bạn nhập mã nhân viên  : ");
                    newId = input.nextLine();
                    System.out.print("Mời bạn nhập tên nhân viên : ");
                    newName = input.nextLine();
                    System.out.print("Mời bạn nhập tuổi nhân viên : ");
                    newAge = Integer.parseInt(input.nextLine());
                    System.out.print("Mời bạn nhập địa chỉ nhân viên : ");
                    address = input.nextLine();
                    System.out.print("Mời bạn nhập sđt nhân viên : ");
                    newPhone = input.nextLine();
                    System.out.print("Mời bạn nhập email nhân viên : ");
                    newEmail = input.nextLine();
                    System.out.print("Mời bạn nhập lương cứng nhân viên : ");
                    newHardSalary = Double.parseDouble(input.nextLine());
                    System.out.print("Mời bạn nhập số ngày làm việc nhân viên : ");
                    newWorkingDays = Integer.parseInt(input.nextLine());
                    e.setId(newId);
                    e.setName(newName);
                    e.setAge(newAge);
                    e.setAddress(address);
                    e.setPhoneNumber(newPhone);
                    ((FullTimeEmployee) e).setEmail(newEmail);
                    ((FullTimeEmployee) e).setWorkingDays(newWorkingDays);
                    ((FullTimeEmployee) e).setHardSalary(newHardSalary);
                } else if (e instanceof PartTimeEmployee) {
                    System.out.print("Mời bạn nhập mã nhân viên  : ");
                    newId = input.nextLine();
                    System.out.print("Mời bạn nhập tên nhân viên : ");
                    newName = input.nextLine();
                    System.out.print("Mời bạn nhập tuổi nhân viên : ");
                    newAge = Integer.parseInt(input.nextLine());
                    System.out.print("Mời bạn nhập địa chỉ nhân viên : ");
                    address = input.nextLine();
                    System.out.print("Mời bạn nhập sđt nhân viên : ");
                    newPhone = input.nextLine();
                    System.out.print("Mời bạn nhập số giờ làm việc : ");
                    double newWorkTime = Integer.parseInt(input.nextLine());
                    e.setId(newId);
                    e.setName(newName);
                    e.setAge(newAge);
                    e.setAddress(address);
                    e.setPhoneNumber(newPhone);
                    ((PartTimeEmployee) e).setWorkingTimes(newWorkTime);
                }
            }
        }
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
        total.append("Tổng lương của tất cả nhân viên: ").append(totalSalary);
        return total.toString();
    }

    public String salaryEmployee(String id, double unpaidLeave, int late) {
        StringBuilder salaryEmployee = new StringBuilder();
        double total;
        for (Person nv : employees) {
            if (id.equals(nv.getId())) {
                if (nv instanceof FullTimeEmployee) {
                    total = ((FullTimeEmployee) nv).realFieldEmployee(unpaidLeave, late);
                    salaryEmployee.append("Nhân viên: ").append(nv.getFullName()).append("; Nghỉ không lương: ").
                            append(unpaidLeave).append(" Ngày").append("; Đi muộn: ").append(late).
                            append("; Thực lĩnh: ").append(total);
                    break;
                } else if (nv instanceof PartTimeEmployee) {
                    total = ((PartTimeEmployee) nv).calculateTheAmount();
                    salaryEmployee.append("Nhân viên: ").append(nv.getFullName()).append("; Thực lĩnh: ").append(total);
                    break;
                }
            }
        }
        return salaryEmployee.toString();
    }

    public void sortEmployees() {
        employees.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        ReadWriteToFile.getInstance().writeToFileClient(clients);
    }

}
