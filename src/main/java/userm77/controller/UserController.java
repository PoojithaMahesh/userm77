package userm77.controller;

import java.util.Scanner;

import userm77.dao.UserDao;
import userm77.dto.User;

public class UserController {
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	System.out.println("Welcome to user application");
	System.out.println("ENter 1 to save the data");
	System.out.println("enter 2 to update the data");
	System.out.println("enter 3 to find the data");
	System.out.println("enter 4 to delete the data");
	System.out.println("enter 5 to exit ");
	int choice=scanner.nextInt();
	UserDao dao=new UserDao();
	
	switch (choice) {
	case 1:
	{
		System.out.println("enter id");
		int id=scanner.nextInt();
		System.out.println("ente name");
        String name=scanner.next();
        System.out.println("enter address");
        String address=scanner.next();
        User user=new User();
        user.setId(id);
        user.setName(name);
        user.setAddress(address);
        dao.saveUser(user);
        System.out.println("Thank you user saved successfully");
	}
		break;
	case 2 :{
		System.out.println("enter id to be updated");
		int id=scanner.nextInt();
		System.out.println("ente name");
        String name=scanner.next();
        System.out.println("enter address");
        String address=scanner.next();
        User user=new User();
        user.setName(name);
        user.setAddress(address);
        dao.updateUser(id, user);
        System.out.println("Thank you user data updated successfully");
	}
	break;
	case 3:{
		System.out.println("enter id to be selected");
        int id=scanner.nextInt();
        dao.findUser(id);
        System.out.println("Thank you User data fetched successfully");
	
	}
	break;
	case 4 :{
		System.out.println("Enter id to be deleted");
		int id=scanner.nextInt();
		dao.deleteUser(id);
		System.out.println("Thank you user data deleted successfully");
	}break;
	case 5 :{
		System.out.println("Thank you");
	}
	break;
	}

	
	
}
}
