package controller;

import java.util.ArrayList;

import model.Routes;
import view.AdminLogin;
import view.AdminView;

public class AdminLoginController {
	private AdminLogin adminLogin;

	public AdminLoginController(AdminLogin adminLogin) {
		this.adminLogin=adminLogin;
	}

	public void adminLogin(String name, String password) {
		if(name.equals("1") && password.equals("1")) {
			System.out.println("Logged In Successfully");
			new AdminView().adminDisplay();
		} else {
			System.out.println("Invalid ID");
		}
		
	}
}
