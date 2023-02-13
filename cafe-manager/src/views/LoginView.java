package views;

import model.LoginModel;

import java.util.Scanner;

public class LoginView {
    public static Scanner input = new Scanner(System.in);
    public void showMessageOK(String msg) {
        System.out.println(msg);
    }
    public void showMessageErr(String msg) {
        System.err.println(msg);
    }

    public LoginModel getInfo() {
        System.out.println("--------------------CLUB COFFEE LOGIN--------------------");
        LoginModel user = new LoginModel();
        System.out.print("Employee id: ");
        user.setUser(input.nextLine());
        System.out.print("Password: ");
        user.setPass(input.nextLine());
        return user;
    }

    public LoginModel getInfoAdmin() {
        System.out.println("--------------------EMPLOYEE MANAGER--------------------");
        LoginModel user = new LoginModel();
        System.out.print("Admin: ");
        user.setUser(input.nextLine());
        System.out.print("Password: ");
        user.setPass(input.nextLine());
        return user;
    }
}