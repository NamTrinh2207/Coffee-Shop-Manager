package views;

import controller.ControllerManager;
import controller.LoginController;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Menu {
    public static ControllerManager controllerManager = ControllerManager.getInstance();
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
    //Client----------------------------------------------------------------------

    public void menuClient() {
        while (true) {
            showMessage("""
                    +--------------- QUẢN LÝ HÓA ĐƠN ---------------+
                    |    1. Thêm khách hàng                         |
                    |    2. Danh sách khách mua hàng                |
                    |    3. Tính tiền theo id khách hàng            |
                    |    4. Sắp xếp theo tên khách hàng             |
                    |    5. Đăng xuất                               |
                    |    0. Thoát                                   |
                    +-----------------------------------------------+
                    """);
            showMessage("Lựa chọn: ");
            checkInput = checkInt();
            switch (checkInput) {
                case 1 -> controllerManager.addNewClient(addClient());
                case 2 -> controllerManager.display();
                case 3 -> prepareInvoice();
                case 4 -> {
                    controllerManager.sortClient();
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
        System.out.println(controllerManager.totalMoney(checkId));
    }

    public Client addClient() {
        String id = checkCustomerId();
        showMessage("Nhập tên khách hàng:");
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

    public String checkCustomerId() {
        showMessage("Nhập mã khách hàng:");
        String id = string();
        for (Client o : ControllerManager.getInstance().getClients()) {
            while (true) {
                if (o.getId().equals(id)) {
                    showMessageErr("Trùng id ! Vui lòng nhập lại");
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
                    |   7. Tính lương nhân viên                     |
                    |   8. Đăng xuất                                |
                    |   0. Thoát                                    |
                    +-----------------------------------------------+
                    """);
            showMessage("Lựa chọn: ");
            checkInput = checkInt();
            switch (checkInput) {
                case 1 -> controllerManager.addNewEmployee(addEmployee());
                case 2 -> {
                    controllerManager.sortEmployees();
                    showMessage("successful arrangement");
                }
                case 3 -> controllerManager.displayEmployees();
                case 4 -> controllerManager.editEmployee(input);
                case 5 -> deleteEmployee();
                case 6 -> System.out.println(controllerManager.totalSalaryAllEmployees());
                case 7 -> salaryEmployee();
                case 8 -> {
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
                Thêm nhân viên mới :
                1. nhân viên full time
                2. nhân viên part time
                0. Quay lại""");
        showMessage("Lựa chọn: ");
        checkInput = Integer.parseInt(input.nextLine());
        switch (checkInput) {
            case 1 -> {
                showMessage("Mời bạn nhập mã nhân viên  : ");
                String id = checkEmployeeId();
                showMessage("Mời bạn nhập tên nhân viên : ");
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
                showMessage("Mời bạn nhập tên nhân viên : ");
                String name = string();
                showMessage("Mời bạn nhập tuổi nhân viên : ");
                int age = checkInt();
                showMessage("Mời bạn nhập địa chỉ nhân viên : ");
                String address = string();
                showMessage("Mời bạn nhập sđt nhân viên : ");
                String phone = string();
                showMessage("Mời bạn nhập số giờ làm việc : ");
                double workingTimes = checkInt();
                return new PartTimeEmployee(id, name, age, address, phone, workingTimes);
            }
            case 0 -> menuEmployee();
            default -> showMessageErr("Nhập dữ liệu không đúng !!");
        }
        return null;
    }

    public void deleteEmployee() {
        if (controllerManager.getEmployees().isEmpty()) {
            showMessageErr("Danh sách trống!");
        } else {
            showMessage("Nhập id nhân viên muốn xóa: ");
            checkId = string();
            controllerManager.deleteByEmploy(checkId);
        }
    }

    public void salaryEmployee() {
        if (controllerManager.getEmployees().isEmpty()) {
            showMessage("Danh sách trống!");
        } else {
            showMessage("Nhập id nhân viên muốn tính lương:  ");
            checkId = string();
            for (Person o : controllerManager.getEmployees()
            ) {
                if (!checkId.equals(o.getId())) {
                    showMessageErr("Không tìm thấy id nhân viên tương ứng");
                    break;
                }
            }
            showMessage("Số ngày nghỉ (Ngày):  ");
            double unpaidLeave = checkInt();
            showMessage("Đi muộn (ngày/tháng):  ");
            int late = checkInt();
            System.out.println(controllerManager.salaryEmployee(checkId, unpaidLeave, late));
        }
    }

    public String checkEmployeeId() {
        String id = string();
        for (Person o : ControllerManager.getInstance().getEmployees()) {
            while (true) {
                if (o.getId().equals(id)) {
                    showMessageErr("Trùng id ! Vui lòng nhập lại");
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
    public String checkInputEmail(){
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

