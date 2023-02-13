package controller;

import model.LoginModel;
import model.Person;
import views.LoginView;

public class LoginController {
    private LoginView view;

    public LoginController(LoginView view) {
        this.view = view;
    }

    private boolean check(LoginModel user) {
        for (Person o : ControllerManager.getInstance().getEmployees()) {
            if (o.getId().equals(user.getUser()) && o.getPhoneNumber().
                    equals(user.getPass()) || user.getUser().equals("admin") &&
                    user.getPass().equals("123")) {
                return true;
            }
        }
        return false;
    }

    private boolean checkAdmin(LoginModel user) {
        return (user.getUser().equals("admin")) && (user.getPass().equals("123"));
    }

    public LoginView getView() {
        return view;
    }

    public void setView(LoginView view) {
        this.view = view;
    }

    public void userLogin() {
        while (true) {
            LoginModel user = view.getInfo();
            if (check(user)) {
                view.showMessageOK("Login successfully");
                break;
            } else {
                view.showMessageErr("Wrong username or password");
            }
        }
    }

    public void AdminLogin() {
        while (true) {
            LoginModel user = view.getInfoAdmin();
            if (checkAdmin(user)) {
                view.showMessageOK("Login successfully");
                break;
            } else {
                view.showMessageErr("Wrong username or password");
            }
        }
    }
}