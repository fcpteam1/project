import java.util.ArrayList;
import java.util.Scanner;


public class ShopNoGUI {
	private ArrayList<User> users = new ArrayList<User>();
	private String username, password, choice;
	private Scanner input = new Scanner(System.in);
	
	boolean loopAuthentication = true;
	boolean adminRunning;
	boolean userRunning;
	boolean loginCorrect;
	
	public ShopNoGUI(){
		createUsers();
		checkLogin();
		mainMenu();
	}
	
	public void createUsers(){
		User user1 = new User("ShaneFlynn88","Password11",123,true);
		User user2 = new User("NiallSull21","Password11",123,true);
		User user3 = new User("DarenKane21","Password11",123,false);
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
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
				System.out.println("/nIncorrect Input!! Please try again");
			}
		}
	}
		
	
	public static void main(String[] args) {
		new ShopNoGUI();

	}

}
