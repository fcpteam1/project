import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ShopNoGUI {
	
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
	private String username, password, choice;
	private Scanner input = new Scanner(System.in);
	
	boolean loopAuthentication = true;
	boolean adminRunning;
	boolean userRunning;
	boolean loginCorrect;

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
			System.out.println("Please enter your Username: ");
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
				break;
			}else if(choice.equals("6")){
				System.out.println("Invoices Selected\n");
				break;
			}else if(choice.equals("7")){
				System.out.println("Profit and Loss Selected\n");
				break;
			}else if(choice.equals("8")){
				System.out.println("Users Selected\n");
				AdminUserMenu();
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
				supplierMenu();
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
				users.add(new User(username,password,123,true));
			else
				users.add(new User(username,password,123,false));
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
			System.out.println("\nCustomer Menu\n\n1: View Customers\n2: Create Customers\n3: Edit Customers\n4: Delete Customers\n5: Exit");
			choice = input.nextLine();
			if(choice.equals("1")){
				for (Customer customer: customers){
					System.out.println("\nCustomer: " + customer.getName() + "\nId: " + customer.getId() + "\nNumber: " + customer.getNumber() + "\nAddress: " + customer.getAddress());
				}
				customerMenu();
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
		}
		}
	
	
	public void supplierMenu(){
		int option=0;
		boolean stayInMenu=true;
		
		while(stayInMenu){
			
			option=0;
			while( (option!=1) && (option!=2)){
				System.out.println("\n(1) View Suppliers\n(2) Exit");
				option=input.nextInt();
			}
		
			switch(option){
			case(1):
				System.out.println("\nDisplay Suppliers");
				listSuppliers();
				break;
			case(2):
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
	
	public static void main(String[] args) throws IOException {
		new ShopNoGUI();
	}

}
