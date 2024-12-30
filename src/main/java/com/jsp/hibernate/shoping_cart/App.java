package com.jsp.hibernate.shoping_cart;

import java.util.Scanner;

import com.jsp.hibernate.shoping_cart.repository.ShopingCartRepository;

public class App 

{
	public static void main( String[] args )
	{
		Scanner sc = new Scanner(System.in);
		ShopingCartRepository shop = new ShopingCartRepository();
		System.out.println("DashBoard for Shoping");
		System.out.println("1. To Add a Product\n 2.To Add User along with Cart\n"
				+ "3.To Add product to the User Cart\n 4.Remove product from the User Cart\n 5.To Fetch All products present in a User Cart");
		System.out.println("Enter your choice");

		switch(sc.nextInt()) {

		case 1:shop.addProduct();
		break;

		case 2:shop.addUserWithCart();
		break;

		case 3:shop.addProductToUserCart();
		break;

		case 4:shop.removeProductFromUserCart();
		break;

		case 5:shop.findAllProductsInUser();
		break;

		default: System.out.println("Invalid choice is Entered..\nPlease enter Valid choice ");
		}
		
		sc.close();
	}
}
