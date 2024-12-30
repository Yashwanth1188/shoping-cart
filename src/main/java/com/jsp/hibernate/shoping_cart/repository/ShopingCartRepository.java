package com.jsp.hibernate.shoping_cart.repository;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate.shoping_cart.entity.Cart;
import com.jsp.hibernate.shoping_cart.entity.Product;
import com.jsp.hibernate.shoping_cart.entity.User;

public class ShopingCartRepository {

	SessionFactory sf = new Configuration().configure()
			.addAnnotatedClass(Product.class)
			.addAnnotatedClass(User.class)
			.addAnnotatedClass(Cart.class)
			.buildSessionFactory();

	Scanner scan = new Scanner(System.in);

	public void addProduct() {
		Product product = new Product();
		Session session=sf.openSession();
		Transaction tran = session.beginTransaction();
		System.out.println("Enter the Producid");
		product.setProductId(scan.nextInt());
		System.out.println("Enter the ProductName");
		product.setProductName(scan.next());
		System.out.println("Enter the ProductBrand");
		product.setProductBrand(scan.next());
		System.out.println("Enter the ProductPrice");
		product.setProductPrice(scan.nextInt());

		session.save(product);
		tran.commit();
		session.close();

	}

	public void addUserWithCart() {
		User user = new User();
		System.out.println("Enter the UserId");
		user.setUserId(scan.nextInt());
		System.out.println("Enter the UserName");
		user.setUserName(scan.next());
		System.out.println("Enter the UserEmail");
		user.setUserEmail(scan.next());
		System.out.println("Enter the User Mobile Number");
		user.setMobileNo(scan.nextLong());
		System.out.println("Enter the user Location ");
		user.setLocation(scan.next());

		Cart cart = new Cart();
		System.out.println("Enter the cartId");
		cart.setCartId(scan.nextInt());

		user.setCart(cart);

		Session session=sf.openSession();
		Transaction tran = session.beginTransaction();


		session.save(user);
		session.save(cart);
		tran.commit();
		session.close();
		
	}

	public void addProductToUserCart() {

		Session session=sf.openSession();
		Transaction tran = session.beginTransaction();

		System.out.println("Enter the ProductId need to Add");
		Product product=session.get(Product.class,scan.nextInt());
		if(product!=null) {
			System.out.println("Enter the UserId need to Add the Product");
			User user = session.get(User.class,scan.nextInt());
			if(user!=null) {
				Cart cart=user.getCart();
				System.out.println(cart.getProducts());
				
				session.update(cart);
			}
			else
				System.out.println("User is Not Found");
		}
		else
			System.out.println("Product is Not Found");


		tran.commit();
		session.close();

	}

	public void removeProductFromUserCart() {
		Session session=sf.openSession();
		Transaction tran = session.beginTransaction();

		System.out.println("Enter the ProductId need to Remove");
		Product product=session.get(Product.class,scan.nextInt());
		if(product!=null) {
			System.out.println("Enter the UserId need to remove the Product");
			User user = session.get(User.class,scan.nextInt());
			if(user!=null) {
				Cart cart=user.getCart();
				cart.getProducts().remove(product);
				session.update(cart);
			}
			else
				System.out.println("User is Not Found");
		}
		else
			System.out.println("Product is Not Found");


		tran.commit();
		session.close();

	}

	public void findAllProductsInUser() {

		Session session=sf.openSession();
		Transaction tran = session.beginTransaction();

		System.out.println("Enter the UserId need to Fetch  the Products from It");
		User user = session.get(User.class,scan.nextInt());
		if(user!=null) {
			Cart cart=user.getCart();
			List<Product> products =cart.getProducts();
			
			if(products!=null) {
				for(Product product:products) {
					
					System.out.println(product.getProductId());
					System.out.println(product.getProductName());
					System.out.println(product.getProductBrand());
					System.out.println(product.getProductPrice());
					System.out.println("---------------");
					
				}
				
//				products.forEach(System.out::println);
				
			}
			else
				System.out.println("Cart is Empty");
		}
		else
			System.out.println("User is Not Found");

		tran.commit();
		session.close();
	}

}
