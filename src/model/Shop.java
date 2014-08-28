package model;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import GUI.CustomerFormEvent;
import GUI.CustomerFormPanel;
import GUI.OrderFormEvent;
import GUI.OrderFormPanel;
import GUI.SaleFormEvent;
import GUI.UserFormEvent;
import GUI.UserFormPanel;

public class Shop {
	
	private ArrayList<Order> orders = new ArrayList<Order>();
	private ArrayList<Stock> stocks = new ArrayList<Stock>();
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
	private ArrayList<Sale> sales = new ArrayList<Sale>();
	private String username, password, choice,customerName,customerNumber,customerAddress,editUserPassword,editUserUsername;
	private String editCustomerName, editCustomerNumber, editCustomerAddress;
	private String saleFile = "sales.ser";
	private String orderFile = "orders.ser";
	private String customerFile = "customers.ser";
	private String userFile = "users.ser";
	private String supplierFile = "suppliers.ser";
	private String stockFile = "stocks.ser";
	private int customerId,tableIndex;
	private FileOutputStream fileOut;
	private ObjectOutputStream out; 
	private FileInputStream fileIn;
	private ObjectInputStream in;
	private Scanner input = new Scanner(System.in);
	private Scanner input2 = new Scanner(System.in);
	private Scanner input3 = new Scanner(System.in);
	
	private UserFormPanel userFormPanel ;
	private CustomerFormPanel customerFormPanel;
	private OrderFormPanel orderFormPanel;
	
	boolean loopAuthentication = true;
	boolean adminRunning;
	boolean userRunning;
	boolean loginCorrect;
	
	public void setEditUserUsername(String editUserUsername) {
		this.editUserUsername = editUserUsername;
	}
	
	public String getEditUserUsername() {
		return editUserUsername;
	}

	public String getEditUserPassword() {
		return editUserPassword;
	}

	public void setEditUserPassword(String editUserPassword) {
		this.editUserPassword = editUserPassword;
	}
	
	public String getEditCustomerName() {
		return editCustomerName;
	}

	public void setEditCustomerName(String editCustomerName) {
		this.editCustomerName = editCustomerName;
	}

	public String getEditCustomerNumber() {
		return editCustomerNumber;
	}

	public void setEditCustomerNumber(String editCustomerNumber) {
		this.editCustomerNumber = editCustomerNumber;
	}

	public String getEditCustomerAddress() {
		return editCustomerAddress;
	}

	public void setEditCustomerAddress(String editCustomerAddress) {
		this.editCustomerAddress = editCustomerAddress;
	}

	private static Shop ShopInstance=null;
	
	public Shop() {
		
		userFormPanel = new UserFormPanel();
		customerFormPanel = new CustomerFormPanel();
		orderFormPanel = new OrderFormPanel();
		
		loadCustomers(customerFile);
		loadUsers(userFile);
		loadSuppliers(supplierFile);
		loadStock(stockFile);
		loadSales(saleFile);
		loadOrders(orderFile);
	
		/*for (Sale s : sales)
			System.out.println(s.getCustomer() + " : From sales.ser");
		for (Order o : orders)
			System.out.println(o.getSupplier() + " : From orders.ser");
		for (Customer c : customers)
			System.out.println(c.getName() + ", " + c.getAddress() );
		for (User u : users)
			System.out.println((u.getUsername() + ", " + u.getId()));
		for (Supplier s : suppliers)
			System.out.println(s.getName() + " Product list size: " + s.getProducts().size());	
		for (Stock stock : stocks)
			System.out.println(stock.getName() + " Quantity: " + stock.getQuantity());*/
	
			//checkLogin();
			//mainMenu();
	}
	
	
	public static Shop getInstance() throws IOException{
		
		if(ShopInstance==null){
			ShopInstance=new Shop();
		
		}
		
		return ShopInstance;
	}
	
	public void loadSales(String inPutFile) {
		
		try {
			FileInputStream fileIn = new FileInputStream(inPutFile);
			ObjectInputStream in = new ObjectInputStream(fileIn);
				
					sales = (ArrayList<Sale>)in.readObject();
					
					in.close();
					fileIn.close();
			}
		
		catch(IOException i) {
			i.printStackTrace();
		}
		catch(ClassNotFoundException c){
			System.out.println("Sale class not found");
			c.printStackTrace();
		}
	}
	
public void loadOrders(String inPutFile) {
		
		try {
			FileInputStream fileIn = new FileInputStream(inPutFile);
			ObjectInputStream in = new ObjectInputStream(fileIn);
				
					orders = (ArrayList<Order>)in.readObject();
					
					in.close();
					fileIn.close();
			}
		
		catch(IOException i) {
			i.printStackTrace();
		}
		catch(ClassNotFoundException c){
			System.out.println("Order class not found");
			c.printStackTrace();
		}
	}

public void loadSuppliers(String inPutFile) {
	
	try {
		FileInputStream fileIn = new FileInputStream(inPutFile);
		ObjectInputStream in = new ObjectInputStream(fileIn);
			
				suppliers = (ArrayList<Supplier>)in.readObject();
				
				in.close();
				fileIn.close();
		}
	
	catch(IOException i) {
		i.printStackTrace();
	}
	catch(ClassNotFoundException c){
		System.out.println("Supplier class not found");
		c.printStackTrace();
	}
}

public void loadUsers(String inPutFile) {
	
	try {
		FileInputStream fileIn = new FileInputStream(inPutFile);
		ObjectInputStream in = new ObjectInputStream(fileIn);
			
				users = (ArrayList<User>)in.readObject();
				
				in.close();
				fileIn.close();
		}
	
	catch(IOException i) {
		i.printStackTrace();
	}
	catch(ClassNotFoundException c){
		System.out.println("User class not found");
		c.printStackTrace();
	}
}
	

	public void loadStock(String inPutFile) {
		
		try {
			FileInputStream fileIn = new FileInputStream(inPutFile);
			ObjectInputStream in = new ObjectInputStream(fileIn);
				
					stocks = (ArrayList<Stock>)in.readObject();
					
					in.close();
					fileIn.close();
			}
		
		catch(IOException i) {
			i.printStackTrace();
		}
		catch(ClassNotFoundException c){
			System.out.println("Stock class not found");
			c.printStackTrace();
		}
	}
		
	

public void loadCustomers(String inPutFile) {
	
	try {
		FileInputStream fileIn = new FileInputStream(inPutFile);
		ObjectInputStream in = new ObjectInputStream(fileIn);
			
				customers = (ArrayList<Customer>)in.readObject();
				
				in.close();
				fileIn.close();
		}
	
	catch(IOException i) {
		i.printStackTrace();
	}
	catch(ClassNotFoundException c){
		System.out.println("Customer class not found");
		c.printStackTrace();
	}
}
	
	public void writeSale(String saleFile){
		try {
			FileOutputStream fileOut = new FileOutputStream(saleFile);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(sales);
			out.close();
			fileOut.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
	}
	
	public void writeOrder(String orderFile){
		try {
			FileOutputStream fileOut = new FileOutputStream(orderFile);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(orders);
			out.close();
			fileOut.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
	}

	public void writeCustomer(String customerFile){
		try {
			FileOutputStream fileOut = new FileOutputStream(customerFile);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(customers);
			out.close();
			fileOut.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
	}
	
	public void writeStock(String stockFile){
		try {
			FileOutputStream fileOut = new FileOutputStream(stockFile);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(stocks);
			out.close();
			fileOut.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
	}
	
	public void writeSupplier(String supplierFile){
		try {
			FileOutputStream fileOut = new FileOutputStream(supplierFile);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(suppliers);
			out.close();
			fileOut.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
	}
	
	public void writeUser(String userFile){
		try {
			FileOutputStream fileOut = new FileOutputStream(userFile);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(users);
			out.close();
			fileOut.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
	}
	
	public ArrayList<User> getUsers(){
		return users;
	}
	
	public void addUser(UserFormEvent e) {
		String username = e.getUsername();
		String password = e.getPassword();
		String id = e.getId();
		Boolean admin = e.getAdmin();
		
		User newUser = new User(username, password, admin);
				
		users.add(newUser);
		
		int newCount = 0;
		for(User user: users){
			user.setId(newCount++);
		writeUser(userFile);
		}
	}
	
	public void removeUser(int index) {
		users.remove(index);
		writeUser(userFile);
	}
	
	public void editUser(int index) {
		this.tableIndex = index;
				editUserUsername = users.get(index).getUsername();
				editUserPassword = users.get(index).getPassword();
				}
		
	public void NewEditUser(UserFormEvent ee) {
		String username = ee.getUsername();
		String password = ee.getPassword();
		int id = tableIndex;
		Boolean admin = ee.getAdmin();
		
		for (User user: users){
			if(user.getId() == (tableIndex)){
				user.setUsername(username);
				user.setPassword(password);
				user.setId(id);
				user.setAdmin(admin);
				
				System.out.println(username + password + id + admin);
			}
		}
		writeUser(userFile);
	}
	
	public void sendEditUsername(){
		userFormPanel.setEditDataUsername(editUserUsername);
	}
	
	public void sendEditPassword(String editUserPassword){
		userFormPanel.setEditDataPassword(editUserPassword);
	}
	

	
	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	public ArrayList<Stock> getStock() {
			
		return stocks;
	}
	public ArrayList<Sale> getSales() {
		return sales;
	}
	


	public ArrayList<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(ArrayList<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	

	public void addCustomer(CustomerFormEvent e) {
		String name = e.getName();
		String number = e.getNumber();
		String address = e.getAddress();
		
		Customer newCustomer = new Customer(name, number, address);
		customers.add(newCustomer);
		
		int newCount = 0;
		for (Customer customer : customers){
			customer.setId(newCount++);
		writeCustomer(customerFile);
		}
	}
	
	public void removeCustomer(int index) {
		customers.remove(index);
		writeCustomer(customerFile);
	}
	
	public void editCustomer(int index) {
		this.tableIndex = index;
				editCustomerName = customers.get(index).getName();
				editCustomerNumber = customers.get(index).getNumber();
				editCustomerAddress = customers.get(index).getAddress();
			}
	
	public void NewEditCustomer(CustomerFormEvent ee) {
		String name = ee.getName();
		String number = ee.getNumber();
		int id = tableIndex;
		String address = ee.getAddress();
		
		for (Customer customer: customers){
			if(customer.getId() == (tableIndex)){
				customer.setName(name);
				customer.setNumber(number);
				customer.setId(id);
				customer.setAddress(address);
				
				System.out.println(name + number + id + address);
			}
		}
		writeCustomer(customerFile);
	}

	public void sendCustomerEditName(String editCustomerName){
		customerFormPanel.setEditDataName(editCustomerName);
		System.out.println("Edit name sent");
	}
	
	public void sendCustomerEditNumber(String editCustomerNumber){
		customerFormPanel.setEditDataNumber(editCustomerNumber);
		System.out.println("Edit number sent");
	}
	public void sendCustomerEditAddress(String editCustomerAddress){
		customerFormPanel.setEditDataAddress(editCustomerAddress);
		System.out.println("Edit address sent");
	}	
	
	public void createSale(SaleFormEvent e) {
		
		ArrayList<Stock> stocks = e.getStockList();
		Customer customer = e.getCustomer();
		Sale sale = new Sale(stocks, customer);
		sales.add(sale);
		
		int newCount = 0;
			for (Sale s : sales){
				s.setId(newCount++);
			}
		writeSale(saleFile);
	}
	
	public void createOrder(OrderFormEvent e){
		ArrayList<Product> products = e.getProducts();
		Supplier supplier = e.getSupplier();
		Order order = new Order(products, supplier);
		orders.add(order);
		
		writeOrder(orderFile);
	}
	
	public void viewOrders(OrderFormEvent e){
		
	}

	public void editOrder(OrderFormEvent e, int id){
		for(Order order: orders){
			if(order.getId() == id){
				order.setProducts(e.getProducts());
				order.calculatePrice();
			}
		}

		writeOrder(orderFile);
	}
	
	public void deleteOrder(int index){
		orders.remove(index);
		int newCount = 0;
		for (Order order : orders){
			order.setId(newCount++);
		}

		writeOrder(orderFile);
	}

	public void processOrder(int index){
		orders.get(index).setCurrent(false);
		for(Product product: orders.get(index).getProducts()){
			Stock stock = new Stock(product, product.getQuantity());
			stocks.add(stock);
		}
		writeOrder(orderFile);
	}
	
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	
	private void stockLevels() {
		// TODO Auto-generated method stub
		
	}
}
	

