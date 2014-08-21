package model;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import GUI.OrderFormEvent;
import GUI.UserFormEvent;
import GUI.UserFormPanel;
import GUI.UserTableModel;

public class Shop {
	
	private ArrayList<Order> orders = new ArrayList<Order>();
	private ArrayList<Stock> stocks = new ArrayList<Stock>();
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
	private String username, password, choice,customerName,customerNumber,customerAddress;
	private int customerId,tableIndex;
	private Scanner input = new Scanner(System.in);
	private Scanner input2 = new Scanner(System.in);
	private Scanner input3 = new Scanner(System.in);
	
	private UserFormPanel formPanel ;
	
	boolean loopAuthentication = true;
	boolean adminRunning;
	boolean userRunning;
	boolean loginCorrect;
	boolean createCustomerRun = true;
	
	private String editUserUsername;
	public String getEditUserUsername() {
		return editUserUsername;
	}

	public void setEditUserUsername(String editUserUsername) {
		this.editUserUsername = editUserUsername;
	}

	public String getEditUserPassword() {
		return editUserPassword;
	}

	public void setEditUserPassword(String editUserPassword) {
		this.editUserPassword = editUserPassword;
	}

	private String editUserPassword;

	private static Shop ShopInstance=null;
	
	
	public Shop() throws IOException{
		
		formPanel = new UserFormPanel();
		
		loadCustomers("CustomerList");
		loadUsers("UserList");
		loadSuppliers("SuppliersProductListFiles", "SupplierList");
				
		for (Customer c : customers)
		System.out.println(c.getName() + ", " + c.getAddress() );
		for (User u : users)
		System.out.println((u.getUsername() + ", " + u.getId()));
		for (Supplier s : suppliers)
		System.out.println(s.getName() + " Product list size: " + s.getProducts().size());	
	
			//checkLogin();
			//mainMenu();
	
	}
	
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
			Customer customer = new Customer(name, id, number, address);
			customers.add(customer);
			}
	in.close();
	}
	
	public void checkLogin(){
		while(loopAuthentication == true){
			System.out.println("\nPlease enter your Username: ");
				username = input.nextLine();
				System.out.println("Please enter your Password: ");
				password = input.nextLine(); 
				for(User user: users){
					if((username.equals(user.getUsername())) && (password.equals(user.getPassword()))){
						loginCorrect = true;
						System.out.println("login name and password correct");
						if((loginCorrect == true && (user.isAdmin() == true))){
							System.out.println("Admin Logged in");
							adminRunning = true;
							userRunning = false;
							loopAuthentication = false;
						}
						else if((loginCorrect == true && (user.isAdmin() == false))){
							System.out.println("User Logged in");
							adminRunning = false;
							userRunning = true;
							loopAuthentication = false;
						}
					}
				}
				if (loginCorrect == false){
						System.out.println("Inccorect Login");
						adminRunning = false;
						userRunning = false;
				}
		}
	}
	
	public void mainMenu(){
		while (adminRunning){
			System.out.println("\nMain Menu\n\n(1) Customers\n(2) Suppliers\n(3) Products\n(4) Stock\n(5) Orders\n(6) Sales\n(7) Invoices\n(8) Profit and Loss\n(9) Users\n(0) Logout");
			choice = input.nextLine();
			if(choice.equals("1")){
				System.out.println("Customer Selected\n");
				customerMenu();
				break;
			}else if(choice.equals("2")){
				System.out.println("Suppliers Selected\n");
				supplierMenu();
				break;
			}else if(choice.equals("3")){
				System.out.println("Product Selected\n");
				break;
			}else if(choice.equals("4")){
				System.out.println("Stock Selected\n");
				break;
			}else if(choice.equals("5")){
				System.out.println("Orders Selected\n");
				orderMenu();
				break;
			}else if(choice.equals("6")){
				System.out.println("Sales Selected\n");
				break;
			}else if(choice.equals("7")){
				System.out.println("Invoices Selected\n");
				break;
			}else if(choice.equals("8")){
				System.out.println("Profit and Loss Selected\n");
				break;
			}else if(choice.equals("9")){
				System.out.println("Users Selected\n");
				AdminUserMenu();
				break;
			}else if(choice.equals("0")){
				System.out.println("Logout Selected\n");
				adminRunning = false;
				loopAuthentication = true;
				checkLogin();
			}else {
				System.out.println("\nIncorrect Input!! Please try again");
			}
		}
		while (userRunning){
			System.out.println("\nMain Menu\n\n(1) Customers\n(2) Suppliers\n(3) Products\n(4) Stock\n(5) Sales\n(6) Logout");
			choice = input.nextLine();
			if(choice.equals("1")){
				System.out.println("Customer Selected");
				customerMenu();
				break;
			}else if(choice.equals("2")){
				System.out.println("Suppliers Selected");
				supplierMenu();
				break;
			}else if(choice.equals("3")){
				System.out.println("Product Selected");
				break;
			}else if(choice.equals("4")){
				System.out.println("Stock Selected");
				break;
			}else if(choice.equals("5")){
				System.out.println("Sales Selected");
				break;
			}else if(choice.equals("6")){
				System.out.println("Logout Selected");
				userRunning = false;
				loopAuthentication = true;
				checkLogin();
			}else {
				System.out.println("/nIncorrect Input!! Pleae try again");
			}
		}
	}
	
	
	public void AdminUserMenu(){
		
		boolean stayInUserMenu=true;
		int option=0;
		
		while(stayInUserMenu){
			option=0;
			while( (option!=1) && (option!=2) && (option!=3) && (option!=4) && (option!=5) ){
				System.out.println("\nWhat would you like to do\n(1) Create new User\n(2) Delete User\n(3) Edit User\n(4) List Users\n(5) Exit");
				option=input.nextInt();
				
			}
			
			switch(option){
			
			case(1):
				System.out.println("\nCreate User");
				createUser();
				break;
			case(2):
				System.out.println("\nDelete User");
				deleteUser();
				break;
			case(3):
				System.out.println("\nUpdate User");
				updateUser();
				break;
			case(4):
				System.out.println("\nList Users");
				listUsers();
				break;
			case(5):
				stayInUserMenu=false;
				break;
			
			}
			
		}
		
		
	}
	
	public boolean createUser(){
		
		String username="";
		String password="";
		String password1="";
		
		System.out.println("\nPrint username");
		username=input.next();
		System.out.println("\nPrint password");
		password=input.next();
		
		System.out.println("\nReprint password");
		password1=input.next();
		
		if(password.equals(password1))
		{
			String admin="";
			System.out.println("\nIs user an admin ( Y or N )");
			admin=input.next();
			if(admin.charAt(0)=='y')
				users.add(new User(username,password,true));
			else
				users.add(new User(username,password,false));
		}
		else
			System.out.println("\nPasswords don't match");
		
		
		return true;
	}
		
	public boolean deleteUser(){
		
		String username="";
		boolean foundUser=false;
		int userIndex=0;
		
		System.out.println("\nWhich user would you like to delete (Select by user name)");
		username=input.next();
		
		for(User user : users){
			
			if(user.getUsername().equals(username)){
				foundUser=true;
				break;
			}
			userIndex++;
		}
		
		if(foundUser==true)
			users.remove(userIndex);
		
		else
			System.out.println("\nCould not find user");
		
		
		return true;
	}
	
	public boolean listUsers(){
		
		for(User user : users){
			System.out.println("\n"+user.getUsername()+" "+user.getPassword()+" "+user.getId());
		}
		
		return true;
	}
	
	public boolean updateUser(){
		
		String username="";
		int option=0;
		int userIndex=0;
		boolean userFound=false;
		
		System.out.println("\nWhich user would you like to change");
		username=input.next();
		
		for(User user : users){
			
			if(user.getUsername().equals(username)){
				userFound=true;
				break;
			}
			userIndex++;
		}
		if(userFound){
			
			while( (option!=1) && (option!=2) ){
				System.out.println("\n(1) Edit username\n(2) Edit password");
				option=input.nextInt();
			}
			
			if(option==1){
				String usernameChange="";
				System.out.println("\n Change username to: ");
				usernameChange=input.next();
				users.get(userIndex).setUsername(usernameChange);
				System.out.println("User name changed !!");
				
			}
			
			if(option==2){
				String passwordChange="";
				String passwordChange1="";
				System.out.println("\n Change password to: ");
				passwordChange=input.next();
				System.out.println("\n Change username to: ");
				passwordChange1=input.next();
				
				if(passwordChange.equals(passwordChange1)){
					users.get(userIndex).setPassword(passwordChange);
					System.out.println("\nPassword Updated");
				}
				else
					System.out.println("\nPassword didn't match");
				
				
			}
			
		}
		else
			System.out.println("\nCould Not find User");
		
		return true;
	}
	
	public void customerMenu(){
		while (adminRunning){
			System.out.println("\nCustomer Menu\n\n(1) View Customers\n(2) Create Customers\n(3) Edit Customers\n(4) Delete Customers\n(5) Exit");
			choice = input.nextLine();
			if(choice.equals("1")){
				for (Customer customer: customers){
					System.out.println("\nCustomer: " + customer.getName() + "\nId: " + customer.getId() + "\nNumber: " + customer.getNumber() + "\nAddress: " + customer.getAddress());
				}
				customerMenu();
				break;
		}
			if(choice.equals("2")){
				createNewCustomer();
				break;
			}
			if(choice.equals("3")){
				editCustomer();
				break;
			}
			if(choice.equals("4")){
				deleteCustomer();
				break;
			}
		}
		while (userRunning){
			System.out.println("\nCustomer Menu\n\n(1) View Customers\n(2) Create Customers\n(3) Edit Customers\n(4) Exit");
			choice = input.nextLine();
			if(choice.equals("1")){
				for (Customer customer: customers){
					System.out.println("\nCustomer: " + customer.getName() + "\nId: " + customer.getId() + "\nNumber: " + customer.getNumber() + "\nAddress: " + customer.getAddress());
				}
			customerMenu();
			break;
			}
			if(choice.equals("2")){
				createNewCustomer();
				customerMenu();
				break;
			}
			if(choice.equals("3")){
				editCustomer();
				break;
			}
		}
		}
	
	public void supplierMenu(){
		int option=0;
		boolean stayInMenu=true;
		
		while(stayInMenu){
			
			option=0;
			while( (option!=1) && (option!=2) && (option!=3)){
				System.out.println("\n(1) View Suppliers\n(2) View Supplier Products\n(3) Exit");
				option=input.nextInt();
			}
		
			switch(option){
			case(1):
				System.out.println("\nDisplay Suppliers");
				listSuppliers();
				break;
			case(2):
				System.out.println("\nDisplay supplier products");
				listSupplierProducts();
				break;
			case(3):
				System.out.println("\nExit supplier menu");
				stayInMenu=false;
			
			}
		
		}
		
	}
	
	public boolean listSuppliers(){
		for(Supplier supplier : suppliers){
			System.out.println("\n"+supplier.getName()+ " "+supplier.getNumber()+ "\n"+supplier.getAddress());
			
		}
		return true;
	}
	
	public boolean listSupplierProducts(){
		
		String supName="";
		boolean foundSup=false;
		int index=0;
		
		System.out.println("\nWhich supplier product list would you like");
		supName=input.next();
		
		for(Supplier supplier : suppliers){
			
			if(supplier.getName().equals(supName)){
				foundSup=true;
				break;
			}
			index++;
		}
		
		if(foundSup){
			
			for(Product product : suppliers.get(index).getProducts()){
				System.out.println(""+product.getName()+" "+product.getSupplierPrice());
			}
			
		}
		else
			System.out.println("\nCould not find supplier");
		
		return true;
	}
	
	public void createNewCustomer(){
		System.out.println("Please enter customer name: ");
		customerName = input.nextLine();
		System.out.println("Please enter customer id: ");
		customerId = input.nextInt();
		System.out.println("Please enter Customer number: ");
		customerNumber = input2.nextLine();
		System.out.println("Please enter Customer address: ");
		customerAddress = input3.nextLine();
		
		int customerSize = customers.size();
		int size = 1;
		boolean check = false; 
		while(createCustomerRun == true){
			for(Customer customer  : customers){
				if(customerName.equals(customer.getName()) && (customerAddress.equals(customer.getAddress()))){
					System.out.println("Already a Customer!!");
					customerMenu();
					break;
				}
				else if(customerSize == size){
					check = true;
				}
				size++;
			}
			if(check){
				customers.add(new Customer(customerName,customerId,customerNumber,customerAddress));
				createCustomerRun = false;
				System.out.println("Customer added.");
				createCustomerRun = false;
			}
			
		}
		
	}
	
	public boolean editCustomer(){
		
		String customerName="";
		int option=0;
		int customerIndex=0;
		boolean customerFound=false;
		
		System.out.println("\nWhich customer would you like to change");
		customerName=input.next();
		
		for(Customer customer : customers){
			
			if(customer.getName().equals(customerName)){
				customerFound=true;
				break;
			}
			customerIndex++;
		}
		if(customerFound){
			
			while( (option!=1) && (option!=2) && (option!=3) && (option!=4) ){
				System.out.println("\n(1) Edit name\n(2) Edit id\n(3) Edit Number\n(4) Edit address");
				option=input.nextInt();
			}
			
			if(option==1){
				String nameChange="";
				System.out.println("\nChange name to: ");
				nameChange=input.next();
				customers.get(customerIndex).setName(nameChange);
				System.out.println("Customer name changed !!");
				customerMenu();
			}
			
			if(option==2){
				int idChange;
				System.out.println("\nChange id to: ");
				idChange=input.nextInt();
				customers.get(customerIndex).setId(idChange);
				System.out.println("\nPassword Updated");
				customerMenu();
			}
			
			if(option==3){
				String numberChange="";
				System.out.println("\nChange number to: ");
				numberChange=input.next();
				customers.get(customerIndex).setNumber(numberChange);
				System.out.println("Customer number changed !!");
				customerMenu();
				
			}
			
			if(option==4){
				String addressChange="";
				System.out.println("\nChange address to: ");
				addressChange=input.nextLine();
				customers.get(customerIndex).setAddress(addressChange);
				System.out.println("Customer address changed !!");
				customerMenu();
				
			}	
		}				

		else
			System.out.println("\nCould Not find Customer");
		customerMenu();
		return true;
	}
	
	public boolean deleteCustomer(){
		
		String customerName="";
		boolean foundCustomer=false;
		int customerIndex=0;
		
		System.out.println("\nWhich customer would you like to delete (Select by customer name)");
		customerName=input.next();
		
		for(Customer customer : customers){
			
			if(customer.getName().equals(customerName)){
				foundCustomer=true;
				break;
			}
			customerIndex++;
		}
		
		if(foundCustomer==true)
			customers.remove(customerIndex);
		
		else
			System.out.println("\nCould not find customer");
		customerMenu();
		return true;
	}
	
	public void orderMenu(){
		
	}
	
	public ArrayList<User> getUsers(){
		return users;
	}
	
	public void addUser(UserFormEvent e) {
		String username = e.getUsername();
		String password = e.getPassword();
		String id = e.getId();
		Boolean admin = e.getAdmin();
		
		User user = new User(username, password, admin);
				
		users.add(user);
	}
	
	public void removeUser(int index) {
		users.remove(index);
		int newCount = 0;
		for(User user: users){
			user.setId(newCount++);
			System.out.println("username: " + user.getUsername() + "ID: " + user.getId());
			
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

	
	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	public ArrayList<Stock> getStock() {
		return stocks;
	}


	public void sendEditUsername(){
		formPanel.setEditDataUsername(editUserUsername);
	}
	
	public void sendEditPassword(String editUserPassword){
		formPanel.setEditDataPassword(editUserPassword);
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
	
	public void createOrder(OrderFormEvent e){
		ArrayList<Product> products = e.getProducts();
		Supplier supplier = e.getSupplier();
		Order order = new Order(products, supplier);
		orders.add(order);
	}
	
	public void viewOrders(OrderFormEvent e){
		
	}

	public void editOrder(OrderFormEvent e){
		
	}
	
	public void deleteOrder(OrderFormEvent e){
		
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	
}

