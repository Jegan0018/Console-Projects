package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.AdminLoginController;
import model.Routes;

public class AdminLogin {
	private Scanner scanner = new Scanner(System.in);
	private AdminLoginController adminLoginController;
	public AdminLogin() {
		adminLoginController=new AdminLoginController(this);
	}
	public void adminLogin() {
		System.out.println("Welcome To Login Page");
		String name,password;
		System.out.println("Enter Admin Name");
		name=scanner.nextLine();
		System.out.println("Enter Password");
		password=scanner.nextLine();
		adminLoginController.adminLogin(name,password);
		
	}
	
}
