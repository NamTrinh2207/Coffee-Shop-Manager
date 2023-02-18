package controller.loginController;

import controller.managerController.Manager;
import model.modelClass.LoginModel;
import model.modelClass.Person;

public class Login {
    private views.Login view;

    public Login(views.Login view) {
        this.view = view;
    }

    private boolean check(LoginModel user) {
        if (checkAdmin(user)) {
            return true;
        }
        for (Person o : Manager.getInstance().getEmployees()) {
            if (o.getId().equals(user.getUser()) && o.getPhoneNumber().
                    equals(user.getPass())) {
                return true;
            }
        }
        return false;
    }

    private boolean checkAdmin(LoginModel user) {
        return (user.getUser().equals("admin")) && (user.getPass().equals("123"));
    }

    public views.Login getView() {
        return view;
    }

    public void setView(views.Login view) {
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