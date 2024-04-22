package Main;

import Controller.LoginController;
import Model.LoginModel;
import View.LoginView;

public class Main {

    public static void main(String[] args) {
        
        LoginView login = new LoginView();
        login.setVisible(true);

        LoginModel loginModel = new LoginModel();
        LoginController logincontroller = new LoginController(login, loginModel);
        logincontroller.initializeController();
        
    }
}
