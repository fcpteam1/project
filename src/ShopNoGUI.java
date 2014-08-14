import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ShopNoGUI {
	
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
	private String username, password, choice,customerName,customerNumber,customerAddress;
	private int customerId;
	private Scanner input = new Scanner(System.in);
	private Scanner input2 = new Scanner(System.in);
	private Scanner input3 = new Scanner(System.in);
	
	boolean loopAuthentication = true;
	boolean adminRunning;
	boolean userRunning;
	boolean loginCorrect;
	boolean createCustomerRun = true;

	public ShopNoGUI() throws IOException{
		
			
			loadCustomers("CustomerList");
			loadUsers("UserList");
			loadSuppliers("SuppliersProductListFiles", "SupplierList");
			
		
		for (Customer c : customers)
		System.out.println(c.getName() + ", " + c.getAddress() );
		for (User u : users)
		System.out.println((u.getUsername() + ", " + u.getId()));
		for (Supplier s : suppliers)
		System.out.println(s.getName() + " Product list size: " + s.getProducts().size());	
	
			checkLogin();
			mainMenu();
	
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
				User user = new User(username, password, id, admin);
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
			System.out.println("\nMain Menu\n\n1: Customers\n2: Suppliers\n3: Products\n4: Stock\n5: Orders\n6: Invoices\n7: Profit and Loss\n8: Users\n9: Logout");
			choice = input.nextLine();
			if(choice.equals("1")){
				System.out.println("Customer Selected\n");
				customerMenu();
				break;
			}else if(choice.equals("2")){
				System.out.println("Suppliers Selected\n");
				break;
			}else if(choice.equals("3")){
				System.out.println("Product Selected\n");
				break;
			}else if(choice.equals("4")){
				System.out.println("Stock Selected\n");
				break;
			}else if(choice.equals("5")){
				System.out.println("Orders Selected\n");
				break;
			}else if(choice.equals("6")){
				System.out.println("Invoices Selected\n");
				break;
			}else if(choice.equals("7")){
				System.out.println("Profit and Loss Selected\n");
				break;
			}else if(choice.equals("8")){
				System.out.println("Users Selected\n");
				break;
			}else if(choice.equals("9")){
				System.out.println("Logout Selected\n");
				adminRunning = false;
				loopAuthentication = true;
				checkLogin();
				break;
			}else {
				System.out.println("/nIncorrect Input!! Please try again");
			}
		}
		while (userRunning){
			System.out.println("\nMain Menu\n\n1: Customers\n2: Suppliers\n3: Products\n4: Stock\n5: Orders\n6: Logout");
			choice = input.nextLine();
			if(choice.equals("1")){
				System.out.println("Customer Selected");
				customerMenu();
				break;
			}else if(choice.equals("2")){
				System.out.println("Suppliers Selected");
				break;
			}else if(choice.equals("3")){
				System.out.println("Product Selected");
				break;
			}else if(choice.equals("4")){
				System.out.println("Stock Selected");
				break;
			}else if(choice.equals("5")){
				System.out.println("Orders Selected");
				break;
			}else if(choice.equals("6")){
				System.out.println("Logout Selected");
				userRunning = false;
				loopAuthentication = true;
				checkLogin();
				break;
			}else {
				System.out.println("/nIncorrect Input!! Pleae try again");
			}
		}
	}
	
	public void customerMenu(){
		while (adminRunning){
			System.out.println("\nCustomer Menu\n\n1: View Customers\n2: Create Customers\n3: Edit Customers\n4: Delete Customers\n5: Exit");
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
		}
		while (userRunning){
			System.out.println("\nCustomer Menu\n\n1: View Customers\n2: Create Customers\n3: Edit Customers\n4: Exit");
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
		}
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
	
	public static void main(String[] args) throws IOException {
		new ShopNoGUI();
	}

}
