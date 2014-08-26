package model;
import java.io.File;
import java.io.IOException;
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
	private int customerId,tableIndex;
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
	
	public Shop() throws IOException{
		
		userFormPanel = new UserFormPanel();
		customerFormPanel = new CustomerFormPanel();
		orderFormPanel = new OrderFormPanel();
		
		loadCustomers("CustomerList");
		loadUsers("UserList");
		loadSuppliers("SuppliersProductListFiles", "SupplierList");
		loadStock("StockList");

		for (Customer c : customers)
		System.out.println(c.getName() + ", " + c.getAddress() );
		for (User u : users)
		System.out.println((u.getUsername() + ", " + u.getId()));
		for (Supplier s : suppliers)
		System.out.println(s.getName() + " Product list size: " + s.getProducts().size());	
		}
	
			//checkLogin();
			//mainMenu();
	
	
	
	public static Shop getInstance() throws IOException{
		
		if(ShopInstance==null){
			ShopInstance=new Shop();
		
		}
		
		return ShopInstance;
	}
	
	public void loadSuppliers(String SuppliersProductFiles,String SupplierListFile)throws IOException {
		
	Scanner scan1= new Scanner(new File(SuppliersProductFiles));
	Scanner scan2= new Scanner(new File(SupplierListFile)).useDelimiter("\\,");
	
		while(scan1.hasNext() && scan2.hasNext()){
			
			ArrayList<Product> supplierProducts = new ArrayList<Product>();
			
			String name = scan2.next();
			int id = scan2.nextInt();
			String number = scan2.next();
			String address = scan2.next();
			Supplier supplier = new Supplier(name, id, number, address, supplierProducts);
			
			File file = new File(scan1.next());
			Scanner scan3 = new Scanner(file);
			
				while (scan3.hasNext()) {
					
					String item = scan3.next();
					double supplierPrice = scan3.nextDouble();
					Product product = new Product(item, supplierPrice);
					supplier.getProducts().add(product);	
				}
			scan3.close();
			suppliers.add(supplier);		
		}
		
	scan2.close();
	scan1.close();	
	}
	
	public void loadStock(String fileName) throws IOException {
		
	Scanner in= new Scanner(new File(fileName));
		while(in.hasNext()) {
			String name = in.next();
			double supplierPrice = in.nextDouble();
			int quantity = in.nextInt();
			double customerPrice = in.nextDouble();
			Stock stock = new Stock(name, supplierPrice, quantity, customerPrice);
			stocks.add(stock);
		}
	}
		
	public void loadUsers(String fileName)throws IOException {
			
		Scanner in= new Scanner(new File(fileName));
			while(in.hasNext()){
				int id = in.nextInt();
				String username = in.next();
				String password = in.next();
				boolean admin = in.nextBoolean();
				User user = new User(username, password, admin);
				users.add(user);	
			}
		in.close();
		}
	
	public void loadCustomers(String fileName) throws IOException {
		
	Scanner in= new Scanner(new File(fileName)).useDelimiter("\\,");
		while(in.hasNext()){
			String name = in.next();
			int id = in.nextInt();
			String number = in.next();
			String address = in.next();
			Customer customer = new Customer(name, number, address);
			customers.add(customer);
			}
	in.close();
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
		}
	}
	
	public void removeUser(int index) {
		users.remove(index);
		int newCount = 0;
		for(User user: users){
			user.setId(newCount++);
		}
	}
	
	public void editUser(int index) {
		this.tableIndex = index;
		for (User user: users){
			if(user.getId() == (index)){
				editUserUsername = user.getUsername();
				editUserPassword = user.getPassword();
			}
		}
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
		}
	}
	
	public void removeCustomer(int index) {
		customers.remove(index);
		int newCount = 0;
		for (Customer customer : customers){
			customer.setId(newCount++);
		}
	}
	
	public void editCustomer(int index) {
		this.tableIndex = index;
		for (Customer customer: customers){
			if(customer.getId() == (index)){
				editCustomerName = customer.getName();
				editCustomerNumber = customer.getNumber();
				editCustomerAddress = customer.getAddress();
			}
		}
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
	}
	
	public void createOrder(OrderFormEvent e){
		ArrayList<Product> products = e.getProducts();
		Supplier supplier = e.getSupplier();
		Order order = new Order(products, supplier);
		orders.add(order);
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
	}
	
	public void deleteOrder(int index){
		orders.remove(index);
		int newCount = 0;
		for (Order order : orders){
			order.setId(newCount++);
		}
	}

	public void processOrder(int index){
		orders.get(index).setCurrent(false);
	}
	
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	
	private void stockLevels() {
		// TODO Auto-generated method stub
		
	}
}
	

