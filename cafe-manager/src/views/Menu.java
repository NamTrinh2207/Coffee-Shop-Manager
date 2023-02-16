package views;
import command.*;
import command.CommandListClients;
import conCreteCommand.*;
import controller.ControllerManager;
import controller.LoginController;
import invoker.CoffeeApp;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Menu {
    CommandListClients clients = new conCreteCommand.ListClients(ControllerManager.getInstance());
    CommandListEmployees employees = new ListEmployees(ControllerManager.getInstance());
    CommandAddClients addNewClient = new AddNewClient(ControllerManager.getInstance());
    CommandAddEmployee addNewEmployee = new AddNewEmployee(ControllerManager.getInstance());
    CommandStringDataType deleteByEmploy = new DeleteByEmploy(ControllerManager.getInstance());
    CommandStringDataType salaryPartTime = new PartTimeEmployeeSalary(ControllerManager.getInstance());
    CommandStringDataType totalMoney = new TotalBillAmount(ControllerManager.getInstance());
    CommandStringDataType salaryFullTime = new FullTimeEmployeeSalary(ControllerManager.getInstance());
    CommandVoidDataType displayClients = new DisplayClients(ControllerManager.getInstance());
    CommandVoidDataType deleteByEmploys = new DisplayEmployees(ControllerManager.getInstance());
    CommandVoidDataType sortClient = new SortListClients(ControllerManager.getInstance());
    CommandVoidDataType sortNameEmployees = new SortListEmployees(ControllerManager.getInstance());
    TotalSalaryAllEmployees totalSalaryAllEmployees = new TotalSalaryAllEmployees(ControllerManager.getInstance());
    CoffeeApp menu = new CoffeeApp(clients,employees,addNewClient,addNewEmployee,deleteByEmploy,displayClients,
            deleteByEmploys, salaryFullTime,salaryPartTime,sortClient,sortNameEmployees,totalMoney,
            totalSalaryAllEmployees);
    public Scanner input = new Scanner(System.in);
    public int checkInput;
    public String checkId;

    //Login--------------------------------------------------------------------------------------------------
    public void clubCoffee() {
        while (true) {
            showMessage("""
                    +----------LOGIN-----------+
                    |      1. Đăng nhập        |
                    |      0. Thoát            |
                    +--------------------------+
                    """);
            showMessage("Lựa chọn: ");
            checkInput = checkInt();
            switch (checkInput) {
                case 1 -> {
                    userLogin();
                    menu();
                }
                case 0 -> {
                    showMessageErr("Goodbye");
                    System.exit(checkInput);
                }
            }
        }

    }

    public void menu() {
        while (true) {
            showMessage("""
                    +--------------- CLUB COFFEE -------------+
                    |        1. Quản lý nhân viên             |
                    |        2. Quản lý khách hàng            |
                    |        3. Đăng xuất                     |
                    |        0. Thoát                         |
                    +-----------------------------------------+
                    """);
            showMessage("Lựa chọn: ");
            checkInput = checkInt();
            if (checkInput == 1) {
                adminLogin();
                menuEmployee();
            } else if (checkInput == 2) {
                menuClient();
            } else if (checkInput == 3) {
                showMessage("successful logout");
                clubCoffee();
            } else if (checkInput == 0) {
                showMessage("Goodbye");
                System.exit(checkInput);
            }
        }
    }

    public void userLogin() {
        LoginView view = new LoginView();
        LoginController control = new LoginController(view);
        control.userLogin();
    }

    public void adminLogin() {
        LoginView view = new LoginView();
        LoginController control = new LoginController(view);
        control.AdminLogin();
    }
    //Client--------------------------------------------------------------------------------------------

    public void menuClient() {
        while (true) {
            showMessage("""
                    +--------------- QUẢN LÝ HÓA ĐƠN ---------------+
                    |    1. Thêm hóa đơn mới                        |
                    |    2. Danh sách hóa đơn                       |
                    |    3. Tính tiền theo id khách hàng            |
                    |    4. Sắp xếp hóa đơn theo tên khách hàng     |
                    |    5. Đăng xuất                               |
                    |    0. Thoát                                   |
                    +-----------------------------------------------+
                    """);
            showMessage("Lựa chọn: ");
            checkInput = checkInt();
            switch (checkInput) {
                case 1 -> {
                    showMessage("Thêm hóa đơn mới :");
                    menu.addClients(addClient());
                }
                case 2 -> {
                    showMessage("Danh sách hóa đơn :");
                    checkEmptyClients();
                }
                case 3 -> prepareInvoice();
                case 4 -> {
                    menu.sortByClients();
                    showMessage("successful arrangement");
                }
                case 5 -> {
                    showMessage("successful logout");
                    menu();
                }
                case 0 -> {
                    showMessage("Goodbye");
                    System.exit(checkInput);
                }
                default -> showMessageErr("Vui lòng chọn theo đúng menu");
            }
        }
    }

    public void prepareInvoice() {
        showMessage("Nhập id khách hàng muốn tính tiền: ");
        checkId = string();
        menu.totalMoney(checkId);
    }

    public Client addClient() {
        String id = checkCustomerId();
        showMessage("Mời bạn nhập tên khách hàng : ");
        String name = string();
        showMessage("Nhập tuổi khách hàng :");
        int age = checkInt();
        showMessage("Nhập địa chỉ:");
        String address = string();
        String phone = checkInputPhoneNumber();
        showMessage("Nhập số lượng cà phê khách hàng mua:");
        int sp = checkInt();
        List<Product> products = new ArrayList<>();
        for (int i = 1; i <= sp; i++) {
            showMessage("thêm sản phẩm thứ " + i + ":");
            showMessage("Tên cà phê: ");
            String nameSP = string();
            showMessage("Giá : ");
            double price = checkDouble();
            showMessage("Số lượng: ");
            double quantity = checkDouble();
            products.add(new Product(nameSP, price, quantity));
        }
        return new Client(id, name, age, address, phone, products);
    }

    public void checkEmptyClients() {
        if (menu.listClients().size() == 0) {
            showMessageErr("Danh sách hiện tại đang trống!");
        } else {
            menu.displayClient();
        }
    }

    public String checkCustomerId() {
        showMessage("Nhập mã khách hàng:");
        String id = string();
        for (Client o : ControllerManager.getInstance().getClients()) {
            while (true) {
                if (o.getId().equals(id)) {
                    showMessageErr("id bạn nhập đã có trong danh sách ! Vui lòng nhập lại");
                    id = input.nextLine();
                } else {
                    break;
                }
            }
        }
        return id;
    }

    //Display Employee--------------------------------------------------------------------------------------------------
    public void menuEmployee() {
        while (true) {
            showMessage("""
                    +---------------QUẢN LÝ NHÂN VIÊN---------------+
                    |   1. Thêm nhân viên                           |
                    |   2. Sắp xếp danh sách nhân viên theo tên     |
                    |   3. Danh sách nhân viên                      |
                    |   4. Sửa thông tin nhân viên                  |
                    |   5. Xóa nhân viên                            |
                    |   6. Tổng lương của tất cả nhân viên          |
                    |   7. Tính lương thực lĩnh nhân viên full time |
                    |   8. Tính lương thực lĩnh nhân viên part time |
                    |   9. Đăng xuất                                |
                    |   0. Thoát                                    |
                    +-----------------------------------------------+
                    """);
            showMessage("Lựa chọn: ");
            checkInput = checkInt();
            switch (checkInput) {
                case 1 -> {
                    showMessage("Thêm nhân viên:");
                    menu.addEmployees(addEmployee());
                }
                case 2 -> {
                    menu.sortByEmployees();
                    showMessage("successful arrangement");
                }
                case 3 -> {
                    showMessage("Danh sách nhân viên :");
                    checkEmptyEmployee();
                }
                case 4 -> {
                    showMessage("Sửa thông tin nhân viên:");
                    editEmployee();
                }
                case 5 -> deleteEmployee();
                case 6 -> menu.totalSalaryAllEmployees();
                case 7 -> salaryEmployeeFullTime();
                case 8 -> salaryEmployeePartTime();
                case 9 -> {
                    showMessage("successful logout");
                    menu();
                }
                case 0 -> {
                    showMessage("Goodbye");
                    System.exit(checkInput);
                }
                default -> showMessageErr("Vui lòng nhập lại!!!");
            }
        }
    }

    public Person addEmployee() {
        showMessage("""
                +--------THÊM NHÂN VIÊN MỚI--------+
                |      1. nhân viên full time      |
                |      2. nhân viên part time      |
                |      0. Quay lại                 |
                +----------------------------------+
                """);
        showMessage("Lựa chọn: ");
        checkInput = Integer.parseInt(input.nextLine());
        switch (checkInput) {
            case 1 -> {
                showMessage("Mời bạn nhập mã nhân viên  : ");
                String id = checkEmployeeId();
                showMessage("Mời bạn nhập tên nhân viên  : ");
                String name = string();
                showMessage("Mời bạn nhập tuổi nhân viên : ");
                int age = checkInt();
                showMessage("Mời bạn nhập địa chỉ nhân viên : ");
                String address = string();
                String phone = checkInputPhoneNumber();
                String email = checkInputEmail();
                showMessage("Mời bạn nhập lương của nhân viên : ");
                double hardSalary = checkDouble();
                return new FullTimeEmployee(id, name, age, address, phone, email, hardSalary);
            }
            case 2 -> {
                showMessage("Mời bạn nhập mã nhân viên  : ");
                String id = checkEmployeeId();
                showMessage("Mời bạn nhập tên nhân viên  : ");
                String name = string();
                showMessage("Mời bạn nhập tuổi nhân viên : ");
                int age = checkInt();
                showMessage("Mời bạn nhập địa chỉ nhân viên : ");
                String address = string();
                String phone = checkInputPhoneNumber();
                showMessage("Mời bạn nhập số giờ làm việc : ");
                double workingTimes = checkInt();
                return new PartTimeEmployee(id, name, age, address, phone, workingTimes);
            }
            case 0 -> menuEmployee();
            default -> showMessageErr("Nhập dữ liệu không đúng !!");
        }
        return null;
    }

    public void editEmployee() {
        String newName;
        int newAge;
        String address;
        String newPhone;
        String newEmail;
        double newHardSalary;
        showMessage("Mời bạn nhập vào id nhân viên: ");
        String id = string();
        for (Person e : menu.listEmployees()) {
            if (id.equals(e.getId())) {
                if (e instanceof FullTimeEmployee) {
                    showMessage("Mời bạn nhập tên nhân viên : ");
                    newName = string();
                    showMessage("Mời bạn nhập tuổi nhân viên : ");
                    newAge = checkInt();
                    showMessage("Mời bạn nhập địa chỉ nhân viên : ");
                    address = string();
                    newPhone = checkInputPhoneNumber();
                    newEmail = checkInputEmail();
                    showMessage("Mời bạn nhập lương cứng nhân viên : ");
                    newHardSalary = checkDouble();
                    e.setName(newName);
                    e.setAge(newAge);
                    e.setAddress(address);
                    e.setPhoneNumber(newPhone);
                    ((FullTimeEmployee) e).setEmail(newEmail);
                    ((FullTimeEmployee) e).setHardSalary(newHardSalary);
                } else if (e instanceof PartTimeEmployee) {
                    showMessage("Mời bạn nhập tên nhân viên : ");
                    newName = string();
                    showMessage("Mời bạn nhập tuổi nhân viên : ");
                    newAge = checkInt();
                    showMessage("Mời bạn nhập địa chỉ nhân viên : ");
                    address = string();
                    newPhone = checkInputPhoneNumber();
                    showMessage("Mời bạn nhập số giờ làm việc : ");
                    double newWorkTime = checkInt();
                    e.setName(newName);
                    e.setAge(newAge);
                    e.setAddress(address);
                    e.setPhoneNumber(newPhone);
                    ((PartTimeEmployee) e).setWorkingTimes(newWorkTime);
                }
            }
        }
    }

    public void checkEmptyEmployee() {
        if (menu.listEmployees().size() == 0) {
            showMessageErr("Danh sách hiện tại đang trống!");
        } else {
            menu.displayEmployee();
        }
    }

    public void deleteEmployee() {
        if (menu.listEmployees().isEmpty()) {
            showMessageErr("Danh sách trống!");
        } else {
            showMessage("Nhập id nhân viên muốn xóa: ");
            checkId = string();
            menu.deleteByEmployee(checkId);
        }
    }

    public void salaryEmployeeFullTime() {
        if (menu.listEmployees().isEmpty()) {
            showMessageErr("Danh sách trống!");
        } else {
            showMessage("Nhập id nhân viên full time:  ");
            checkId = string();
            menu.salaryFullTime(checkId);
        }
    }

    public void salaryEmployeePartTime() {
        if (menu.listEmployees().isEmpty()) {
            showMessageErr("Danh sách trống!");
        } else {
            showMessage("Nhập id nhân viên part time:  ");
            checkId = string();
            menu.salaryPartTime(checkId);
        }
    }

    public String checkEmployeeId() {
        String id = string();
        for (Person o : ControllerManager.getInstance().getEmployees()) {
            while (true) {
                if (o.getId().equals(id)) {
                    showMessageErr("id này đã có trong danh sách ! Vui lòng nhập lại");
                    id = input.nextLine();
                } else {
                    break;
                }
            }
        }
        return id;
    }

    //check input-------------------------------------------------------------------------------------------------
    public String string() {
        try {
            return input.nextLine();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public int checkInt() {
        try {
            return Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return -1;
        }
    }

    public double checkDouble() {
        try {
            return Double.parseDouble(input.nextLine());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return -1;
        }
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }

    public void showMessageErr(String msg) {
        System.err.println(msg);
    }

    //regex-------------------------------------------------------------------------------------------------
    public String checkInputPhoneNumber() {
        while (true) {
            showMessage("Nhập sđt: ");
            String phone = string();
            Pattern checkPhone = Pattern.compile("^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$");
            if (checkPhone.matcher(phone).find()) {
                System.out.println("phone is ok");
                return phone;
            } else {
                System.err.println("phone is not ok");
            }
        }
    }

    public String checkInputEmail() {
        while (true) {
            showMessage("Nhập email: ");
            String email = string();
            Pattern checkPhone = Pattern.compile("^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$");
            if (checkPhone.matcher(email).find()) {
                System.out.println("email is ok");
                return email;
            } else {
                System.err.println("email is not ok");
            }
        }
    }
}

