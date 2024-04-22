package Controller;

import Model.LoginModel;
import View.LoginView;
import View.ManagerView;
import View.CashierView;
import javax.swing.*;

public class LoginController {

    private final LoginView login;

    //constructor
    public LoginController(LoginView login, LoginModel model) {
        this.login = login;
    }

     //initialize controller
    public void initializeController() {
        this.login.setController(this);
    }

    //method handele login
    public void handleLogin() {
        //getting username and password form login view
        String username = login.getUsername().trim();
        char[] password = login.getPassword();

        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(login, "Username is Empty,\nPlease Enter Username!");
        } else if (password.length == 0) {
            JOptionPane.showMessageDialog(login, "Password is Empty,\nPlease Enter Password!");
        }else {
            try {
                //string userType = model.getUserType(username, new String(password));
                //replaced with class reference and String type converted to var
                var userType = LoginModel.getUserType(username, new String(password));

                if (userType != null) {
                    JOptionPane.showMessageDialog(login, "Login Details Are Entered Correctly,\nYou Will Direct to : " + userType + " Dashboard!");

                    //if else,switch type ->  rule switch for direct to dashboards
                    //usertype = manager -> directs to manager dashboard
                    switch (userType) {
                        case "Manager" -> {
                            ManagerView manager = new ManagerView();
                            manager.setVisible(true);
                            login.dispose();
                        }
                        case "Cashier" -> {
                            CashierView cashier = new CashierView();
                            cashier.setVisible(true);
                            login.dispose();
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(login, "Login Details Are Not Correct!");
                }
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(login, ex.getMessage(), "Error in Login!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
