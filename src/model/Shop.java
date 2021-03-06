package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import GUI.CustomerFormEvent;
import GUI.CustomerFormPanel;
import GUI.FinancialFormEvent;
import GUI.OrderFormEvent;
import GUI.OrderFormPanel;
import GUI.SaleFormEvent;
import GUI.UserFormEvent;
import GUI.UserFormPanel;

public class Shop {

	private ArrayList<Order> financialOrders = new ArrayList<Order>();
	private ArrayList<Order> orders = new ArrayList<Order>();
	private ArrayList<Stock> stocks = new ArrayList<Stock>();
	private ArrayList<Stock> availableStock = new ArrayList<Stock>();
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
	private ArrayList<Sale> financialSales = new ArrayList<Sale>();
	private ArrayList<Sale> sales = new ArrayList<Sale>();
	private ArrayList<Sale> blankSalesTable = new ArrayList<Sale>();
	private ArrayList<Product> totalProducts = new ArrayList<Product>();
	private Model model;

	private String username, password, choice, customerName, customerNumber,
			customerAddress, editUserPassword, editUserUsername,
			editedStockName;
	private double editedStockPrice;
	private String editCustomerName, editCustomerNumber, editCustomerAddress;
	private String saleFile = "sales.ser";
	private String orderFile = "orders.ser";
	private String customerFile = "customers.ser";
	private String userFile = "users.ser";
	private String supplierFile = "suppliers.ser";
	private String stockFile = "stocks.ser";
	private int customerId, tableIndex;
	private FileOutputStream fileOut;
	private ObjectOutputStream out;
	private FileInputStream fileIn;
	private ObjectInputStream in;
	private Scanner input = new Scanner(System.in);
	private Scanner input2 = new Scanner(System.in);
	private Scanner input3 = new Scanner(System.in);

	private UserFormPanel userFormPanel;
	private CustomerFormPanel customerFormPanel;
	private OrderFormPanel orderFormPanel;
	private StockSalesPredictor predictor;

	boolean loopAuthentication = true;
	boolean adminRunning;
	boolean userRunning;
	boolean loginCorrect;

	public Calendar dateToCalender(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	public String getStockFile() {
		return stockFile;
	}

	//The following methods are getters and setters for the editable
	//data for Users and Customers
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
	// Ends Here

	private static Shop ShopInstance = null;

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
		loadTotalProduct();
		loadAvailableStock();

		predictor = new StockSalesPredictor();

		for (Stock stock : stocks)
			System.out.println(stock.getName() + "From Shop Quantity: "
					+ stock.getQuantity());
		for (Product p : totalProducts)
			System.out.println("Total Product list: " + p.getName());
		for (Stock stock : availableStock)
			System.out.println(stock.getName() + " Avaiable Stock: "
					+ stock.getQuantity());

	}

	public static Shop getInstance() throws IOException {

		if (ShopInstance == null) {
			ShopInstance = new Shop();

		}

		return ShopInstance;
	}

	public void loadSales(String inPutFile) {

		try {
			FileInputStream fileIn = new FileInputStream(inPutFile);
			ObjectInputStream in = new ObjectInputStream(fileIn);

			sales = (ArrayList<Sale>) in.readObject();

			in.close();
			fileIn.close();
		}

		catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Sale class not found");
			c.printStackTrace();
		}
	}

	public void loadOrders(String inPutFile) {

		try {
			FileInputStream fileIn = new FileInputStream(inPutFile);
			ObjectInputStream in = new ObjectInputStream(fileIn);

			orders = (ArrayList<Order>) in.readObject();

			in.close();
			fileIn.close();
		}

		catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Order class not found");
			c.printStackTrace();
		}
	}

	public void loadSuppliers(String inPutFile) {

		try {
			FileInputStream fileIn = new FileInputStream(inPutFile);
			ObjectInputStream in = new ObjectInputStream(fileIn);

			suppliers = (ArrayList<Supplier>) in.readObject();

			in.close();
			fileIn.close();
		}

		catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Supplier class not found");
			c.printStackTrace();
		}
	}

	// load in the users from the ser files and store within the users array
	public void loadUsers(String inPutFile) {

		try {
			FileInputStream fileIn = new FileInputStream(inPutFile);
			ObjectInputStream in = new ObjectInputStream(fileIn);

			users = (ArrayList<User>) in.readObject();

			in.close();
			fileIn.close();
		}

		catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("User class not found");
			c.printStackTrace();
		}
	}

	public void loadStock(String inPutFile) {

		try {
			FileInputStream fileIn = new FileInputStream(inPutFile);
			ObjectInputStream in = new ObjectInputStream(fileIn);

			stocks = (ArrayList<Stock>) in.readObject();

			in.close();
			fileIn.close();
		}

		catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Stock class not found");
			c.printStackTrace();
		}
	}
	
	//Loading in the customers
	public void loadCustomers(String inPutFile) {

		try {
			FileInputStream fileIn = new FileInputStream(inPutFile);
			ObjectInputStream in = new ObjectInputStream(fileIn);

			customers = (ArrayList<Customer>) in.readObject();

			in.close();
			fileIn.close();
		}

		catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Customer class not found");
			c.printStackTrace();
		}
	}

	public void loadTotalProduct() {

		for (Supplier s : suppliers) {
			for (Product p : s.getProducts()) {
				totalProducts.add(p);
			}
		}
	}

	public Map<String, Integer> stockLevels() {

		Map<String, Integer> stockLevels = new HashMap<String, Integer>();

		for (int i = 0; i < stocks.size(); i++) {
			int quantity = 0;
			for (int j = i; j < stocks.size(); j++) {
				boolean inMap = stockLevels
						.containsKey(stocks.get(i).getName());
				if (inMap && j == i) {
					j = stocks.size();
				} else if (stocks.get(i).getName()
						.equals(stocks.get(j).getName())) {
					quantity = quantity + stocks.get(j).getQuantity();
					// System.out.println(stocks.get(j).getQuantity());
					stockLevels.put(stocks.get(i).getName(), quantity);
					// System.out.println(quantity);
				}
			}
		}
		return stockLevels;
	}

	public void loadAvailableStock() {
		availableStock.clear();
		for (Product p : totalProducts) {

			if (stockLevels().get(p.getName()) == null) {
				Stock stock = new Stock(p, 0);
				availableStock.add(stock);
			} else {

				Stock stock = new Stock(p, stockLevels().get(p.getName()));
				availableStock.add(stock);
			}
		}
	}

	public ArrayList<Stock> getAvailableStock() {
		return availableStock;
	}

	public void writeSale(String saleFile) {
		try {
			FileOutputStream fileOut = new FileOutputStream(saleFile);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(sales);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public void writeOrder(String orderFile) {
		try {
			FileOutputStream fileOut = new FileOutputStream(orderFile);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(orders);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	//Saving the Customers to file and the end of a session
	public void writeCustomer(String customerFile) {
		try {
			FileOutputStream fileOut = new FileOutputStream(customerFile);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(customers);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public void writeStock(String stockFile) {
		try {
			FileOutputStream fileOut = new FileOutputStream(stockFile);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(stocks);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public void writeSupplier(String supplierFile) {
		try {
			FileOutputStream fileOut = new FileOutputStream(supplierFile);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(suppliers);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	//Saving the users to file
	public void writeUser(String userFile) {
		try {
			FileOutputStream fileOut = new FileOutputStream(userFile);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(users);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	//Returning the users arrayList
	public ArrayList<User> getUsers() {
		return users;
	}

	//Taking in the username,password, id and if they are an admin or not
	public void addUser(UserFormEvent e) {
		String username = e.getUsername();
		String password = e.getPassword();
		String id = e.getId();
		Boolean admin = e.getAdmin();
		
		//creating a new user 
		User newUser = new User(username, password, admin);
		//adding new customer to the arraylist
		users.add(newUser);

		//setting the id to match that of the table rows
		int newCount = 0;
		for (User user : users) {
			user.setId(newCount++);
			writeUser(userFile);
		}
	}

	//removing the user and the selected row within the table
	//index is the row 
	public void removeUser(int index) {
		users.remove(index);
		int newCount = 0;
		for (User user : users) {
			user.setId(newCount++);
		}
		writeUser(userFile);
	}
	
	//Storing in the username and password of the user to be edited
	public void editUser(int index) {
		this.tableIndex = index;
		editUserUsername = users.get(index).getUsername();
		editUserPassword = users.get(index).getPassword();
	}

	//Taking in the new details for the user
	public void NewEditUser(UserFormEvent ee) {
		String username = ee.getUsername();
		String password = ee.getPassword();
		//id is the same as the table index
		int id = tableIndex;
		Boolean admin = ee.getAdmin();

		//changing the details for that user
		for (User user : users) {
			if (user.getId() == (tableIndex)) {
				user.setUsername(username);
				user.setPassword(password);
				user.setId(id);
				user.setAdmin(admin);

				System.out.println(username + password + id + admin);
			}
		}
		int newCount = 0;
		for (User user : users) {
			user.setId(newCount++);
		}
		writeUser(userFile);
	}

	//sending the username to the form panel to be displayed with the appropriate text field
	public void sendEditUsername() {
		userFormPanel.setEditDataUsername(editUserUsername);
	}
	//same for the password
	public void sendEditPassword(String editUserPassword) {
		userFormPanel.setEditDataPassword(editUserPassword);
	}

	//return the orders arraylist
	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	public Order getOrderById(int id) {
		for(Order order: orders){
			if(order.getId()==id){
				return order;
			}
		}
		return null;
	}

	//getting all the orders and putting them
	//into the finacialOrders arrayList
	public ArrayList<Order> getAllOrders() {
		financialOrders.clear();
		for (Order order : orders) {
			financialOrders.add(order);
		}
		return financialOrders;
	}
	//Just todays orders
	public ArrayList<Order> getTodayOrders() {
		//setting the date to today
		Calendar today = Calendar.getInstance();
		//clearing the financialOrders arraylist
		financialOrders.clear();
		for (Order order : orders) {
			//setting the order date to today
			Calendar orderDate = dateToCalender(order.getDate());
			//if the date,month and year match then add them orders to the fincialOrders arrayList
			if ((orderDate.get(Calendar.DATE) == today.get(Calendar.DATE))
					&& (orderDate.get(Calendar.MONTH) == today
							.get(Calendar.MONTH))
					&& (orderDate.get(Calendar.YEAR) == today
							.get(Calendar.YEAR))) {
				financialOrders.add(order);
			}
		}
		return financialOrders;
	}
	//get orders created on any day of any week in any month
	//This is done by taking the the day,week,month chosen from
	//the combo in financailFormPanel and setting the date to that
	//date and then comparing the dates within orders to see which match
	//then adding them to finacialOrders
	public ArrayList<Order> getDailyOrders(FinancialFormEvent e) {
		int day = e.getDay();
		int week = e.getWeek();
		int month = e.getMonth();
		Calendar today = Calendar.getInstance();
		today.set(Calendar.MONTH, month);
		today.set(Calendar.WEEK_OF_MONTH, week);
		today.set(Calendar.DAY_OF_WEEK, day);
		financialOrders.clear();
		for (Order order : orders) {
			Calendar orderDate = dateToCalender(order.getDate());

			if ((orderDate.get(Calendar.DAY_OF_WEEK) == today
					.get(Calendar.DAY_OF_WEEK))
					&& (orderDate.get(Calendar.WEEK_OF_MONTH) == today
							.get(Calendar.WEEK_OF_MONTH))
					&& (orderDate.get(Calendar.MONTH) == today
							.get(Calendar.MONTH))
					&& (orderDate.get(Calendar.YEAR) == today
							.get(Calendar.YEAR))) {
				financialOrders.add(order);
			}
		}
		return financialOrders;
	}
	//Same method as before except just checking is the week and month match
	//storing them that do to the finacialOrders arrayList
	public ArrayList<Order> getWeeklyOrders(FinancialFormEvent e) {
		int week = e.getWeek();
		int month = e.getMonth();
		Calendar today = Calendar.getInstance();
		today.set(Calendar.WEEK_OF_MONTH, week);
		today.set(Calendar.MONTH, month);
		financialOrders.clear();
		for (Order order : orders) {
			Calendar orderDate = dateToCalender(order.getDate());

			if ((orderDate.get(Calendar.WEEK_OF_MONTH) == today
					.get(Calendar.WEEK_OF_MONTH))
					&& (orderDate.get(Calendar.MONTH) == today
							.get(Calendar.MONTH))
					&& (orderDate.get(Calendar.YEAR) == today
							.get(Calendar.YEAR))) {
				financialOrders.add(order);
			}
		}
		return financialOrders;
	}
	//This just checks if the months match
	public ArrayList<Order> getMonthlyOrders(FinancialFormEvent e) {
		int month = e.getMonth();
		Calendar today = Calendar.getInstance();
		today.set(Calendar.MONTH, month);
		financialOrders.clear();
		for (Order order : orders) {
			Calendar orderDate = dateToCalender(order.getDate());

			if ((orderDate.get(Calendar.MONTH) == today.get(Calendar.MONTH))
					&& (orderDate.get(Calendar.YEAR) == today
							.get(Calendar.YEAR))) {
				financialOrders.add(order);
			}
		}
		return financialOrders;
	}
	
	//Same methods used for stock and profit
	public ArrayList<Stock> getStock() {
		return stocks;
	}

	public ArrayList<Product> getAllSupplierProducts() {
		ArrayList<Product> allProducts = new ArrayList<Product>();
		for (Supplier supplier : suppliers) {
			for (Product product : supplier.getProducts()) {
				allProducts.add(product);
			}
		}
		return allProducts;
	}
	
	public ArrayList<Stock> getUniqueStockList() {
		ArrayList<Stock> uniqueStockList = new ArrayList<Stock>();
		ArrayList<Product> allProducts = new ArrayList<Product>();
		// Get all products that we can sell
		allProducts = getAllSupplierProducts();
		// Loop through individual products and add them to a list of stock
		for (Product product : allProducts) {
			Stock stock = new Stock(product, 0);
			uniqueStockList.add(stock);
		}
		// Loop through list of unique products which we stock
		for (Stock stock : uniqueStockList) {
			// Loop through all stock
			for (Stock current : stocks) {
				// if the stock is a certain product, add it's quantity to the
				// uniquelist
				if (current.getName().equals(stock.getName())) {
					stock.setQuantity(stock.getQuantity()
							+ current.getQuantity());
					stock.setCustomerPrice(current.getCustomerPrice());
				}
			}
		}
		return uniqueStockList;
	}

	public void editCustomerPrice() {
		for (Stock stock : stocks) {
			if (stock.getName().equals(editedStockName)) {
				stock.setCustomerPrice(editedStockPrice);
			}
		}
		loadAvailableStock();
		writeStock(stockFile);
	}

	public ArrayList<Sale> getAllSales() {
		financialSales.clear();
		for (Sale sale : sales) {
			financialSales.add(sale);
		}
		return financialSales;
	}

	public ArrayList<Sale> getSales() {
		return sales;
	}

	//Setting up a blank table without any data for initial start up
	public ArrayList<Sale> getBlankSalesTable() {
		return blankSalesTable;
	}
	
	
	public ArrayList<Sale> getTodaySales() {
		Calendar today = Calendar.getInstance();
		financialSales.clear();
		for (Sale sale : sales) {
			Calendar saleDate = dateToCalender(sale.getDate());

			if ((saleDate.get(Calendar.DATE) == today.get(Calendar.DATE))
					&& (saleDate.get(Calendar.MONTH) == today
							.get(Calendar.MONTH))
					&& (saleDate.get(Calendar.YEAR) == today.get(Calendar.YEAR))) {
				financialSales.add(sale);
			}
		}
		return financialSales;
	}

	public ArrayList<Sale> getDailySales(FinancialFormEvent e) {
		int day = e.getDay();
		int week = e.getWeek();
		int month = e.getMonth();

		System.out.println(day + "\n" + month);
		Calendar today = Calendar.getInstance();
		today.set(Calendar.MONTH, month);
		today.set(Calendar.WEEK_OF_MONTH, week);
		today.set(Calendar.DAY_OF_WEEK, day);
		financialSales.clear();
		for (Sale sale : sales) {
			Calendar saleDate = dateToCalender(sale.getDate());

			if ((saleDate.get(Calendar.DAY_OF_WEEK) == today
					.get(Calendar.DAY_OF_WEEK))
					&& (saleDate.get(Calendar.WEEK_OF_MONTH) == today
							.get(Calendar.WEEK_OF_MONTH))
					&& (saleDate.get(Calendar.MONTH) == today
							.get(Calendar.MONTH))
					&& (saleDate.get(Calendar.YEAR) == today.get(Calendar.YEAR))) {
				financialSales.add(sale);
			}
		}
		for (Sale sale : financialSales) {
			System.out.println(sale.getCustomer());
		}
		return financialSales;
	}

	public ArrayList<Sale> getWeeklySales(FinancialFormEvent e) {
		int week = e.getWeek();
		int month = e.getMonth();

		Calendar today = Calendar.getInstance();
		today.set(Calendar.WEEK_OF_MONTH, week);
		today.set(Calendar.MONTH, month);
		financialSales.clear();
		for (Sale sale : sales) {
			Calendar saleDate = dateToCalender(sale.getDate());

			if ((saleDate.get(Calendar.WEEK_OF_MONTH) == today
					.get(Calendar.WEEK_OF_MONTH))
					&& (saleDate.get(Calendar.MONTH) == today
							.get(Calendar.MONTH))
					&& (saleDate.get(Calendar.YEAR) == today.get(Calendar.YEAR))) {
				financialSales.add(sale);
			}
		}
		return financialSales;
	}

	public ArrayList<Sale> getMonthlySales(FinancialFormEvent e) {
		int month = e.getMonth();

		Calendar today = Calendar.getInstance();
		today.set(Calendar.MONTH, month);
		financialSales.clear();
		for (Sale sale : sales) {
			Calendar saleDate = dateToCalender(sale.getDate());

			if ((saleDate.get(Calendar.MONTH) == today.get(Calendar.MONTH))
					&& (saleDate.get(Calendar.YEAR) == today.get(Calendar.YEAR))) {
				financialSales.add(sale);
			}
		}
		for (Sale sale : financialSales) {
			System.out.println(sale.getCustomer());
		}
		return financialSales;
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

	public ArrayList<Product> getTotalProducts() {
		return totalProducts;
	}
	//Same as user
	public void addCustomer(CustomerFormEvent e) {
		String name = e.getName();
		String number = e.getNumber();
		String address = e.getAddress();

		Customer newCustomer = new Customer(name, number, address);
		customers.add(newCustomer);

		int newCount = 0;
		for (Customer customer : customers) {
			customer.setId(newCount++);
			writeCustomer(customerFile);
		}
	}
	//Same as user
	public void removeCustomer(int index) {
		customers.remove(index);
		int newCount = 0;
		for (Customer customer : customers) {
			customer.setId(newCount++);
		}
		writeCustomer(customerFile);
	}
	//Same as user
	public void editCustomer(int index) {
		this.tableIndex = index;
		editCustomerName = customers.get(index).getName();
		editCustomerNumber = customers.get(index).getNumber();
		editCustomerAddress = customers.get(index).getAddress();
	}
	//Same as user
	public void NewEditCustomer(CustomerFormEvent ee) {
		String name = ee.getName();
		String number = ee.getNumber();
		int id = tableIndex;
		String address = ee.getAddress();

		for (Customer customer : customers) {
			if (customer.getId() == (tableIndex)) {
				customer.setName(name);
				customer.setNumber(number);
				customer.setId(id);
				customer.setAddress(address);

				System.out.println(name + number + id + address);
			}
		}
		int newCount = 0;
		for (Customer customer : customers) {
			customer.setId(newCount++);
		}
		writeCustomer(customerFile);
	}

	public void sendCustomerEditName(String editCustomerName) {
		customerFormPanel.setEditDataName(editCustomerName);
		System.out.println("Edit name sent");
	}

	public void sendCustomerEditNumber(String editCustomerNumber) {
		customerFormPanel.setEditDataNumber(editCustomerNumber);
		System.out.println("Edit number sent");
	}

	public void sendCustomerEditAddress(String editCustomerAddress) {
		customerFormPanel.setEditDataAddress(editCustomerAddress);
		System.out.println("Edit address sent");
	}

	public static boolean processSale(Stock saleItem,
			ArrayList<Stock> stockList, int quantity, int stockIndex) {
		boolean inStock = false;

		while (stockIndex < stockList.size()) {
			for (int i = stockIndex; i < stockList.size(); i++) {
				String name = saleItem.getName();

				if (name.equals(stockList.get(i).getName()) && quantity > 0) {

					if (stockList.get(i).getQuantity() > quantity) {
						stockList.get(i).setQuantity(
								stockList.get(i).getQuantity() - quantity);
						inStock = true;
						i = stockList.size();
						// System.out.println("greater: "+ name + quantity);
					} else if (stockList.get(i).getQuantity() == quantity) {
						stockList.remove(stockList.get(i));
						inStock = true;
						i = stockList.size();
						// System.out.println("equal: "+ name + quantity);

					} else if (stockList.get(i).getQuantity() < quantity) {
						quantity -= stockList.get(i).getQuantity();
						// System.out.println("lesser: "+ name + quantity);
						// System.out.println("Num "+i);
						inStock = processSale(saleItem, stockList, quantity,
								i + 1);
						if (inStock) {
							stockList.remove(stockList.get(i));
						}
						// System.out.println("Num "+i);

						i = stockList.size();

					}
				}

			}
			stockIndex = stockList.size();
		}
		return inStock;
	}

	public ArrayList<Stock> checkStock(ArrayList<Stock> saleList,
			ArrayList<Stock> stockList) {

		for (Stock temp : saleList) {
			if (!processSale(temp, stockList, temp.getQuantity(), 0)) {
				if (saleList.get(saleList.size() - 1) == temp) {
					saleList.remove(temp);
					break;
				} else {
					saleList.remove(temp);
				}
			}
		}
		return saleList;
	}

	public void createSale(SaleFormEvent e) {
		try {
			model = new Model();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ArrayList<Stock> inStockList = checkStock(e.getStockList(), model
				.getShop().getStock());

		Sale sale = new Sale(inStockList, e.getCustomer());
		sales.add(sale);
		writeStock(stockFile);

		int newCount = 0;
		for (Sale s : sales) {
			s.setId(newCount++);
		}

		System.out.println("START PRINTING SALES");
		for (Sale temp : sales) {
			System.out.println(temp.getId());
			for (Stock stock : temp.getStocks())
				System.out
						.println(stock.getName() + ": " + stock.getQuantity());
		}

		writeSale(saleFile);
		loadAvailableStock();
	}

	public void removeSale(int index) {
		for (Stock stock : sales.get(index).getStocks()) {
			stocks.add(stock);
		}
		sales.remove(index);
		int newCount = 0;
		for (Sale s : sales) {
			s.setId(newCount++);
		}
		writeStock(stockFile);
		writeSale(saleFile);
		loadAvailableStock();
	}

	public void createOrder(OrderFormEvent e) {
		ArrayList<Product> products = e.getProducts();
		Supplier supplier = e.getSupplier();
		Order order = new Order(products, supplier);
		int last = orders.size() - 1;
		int newId = orders.get(last).getId() + 1;
		order.setId(newId);
		orders.add(order);
//		int newCount = 0;
//		for (Order newOrder : orders) {
//			newOrder.setId(newCount++);
//		}
		writeOrder(orderFile);
	}

	public void viewOrders(OrderFormEvent e) {

	}

	public void editOrder(OrderFormEvent e, int id) {
		for (Order order : orders) {
			if (order.getId() == id) {
				order.setProducts(e.getProducts());
				order.calculatePrice();
				break;
			}
		}
//		int newCount = 0;
//		for (Order newOrder : orders) {
//			newOrder.setId(newCount++);
//		}
		writeOrder(orderFile);
	}

	public void deleteOrder(int id) {
		for(Order order: orders){
			if(order.isCurrent() && order.getId()==id){
				orders.remove(order);
				break;
			}
			writeOrder(orderFile);
		}
	}

	public void processOrder(int id) {
		for(Order order: orders){
			if (order.getId()==id && order.isCurrent()) {
				for (Product product : order.getProducts()) {
					Stock stock = new Stock(product, product.getQuantity());
					stocks.add(stock);
				}
				order.setCurrent(false);
				break;
			}
		}
		loadAvailableStock();
		writeOrder(orderFile);
		writeStock(stockFile);
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	//Getting the total sales for the sales within the financialSales arrayList
	public double totalSales() {
		double totalSum = 0;
		for (Sale sale : financialSales) {
			totalSum = totalSum + sale.getTotalPrice();
		}
		return totalSum;
	}
	//Getting the total orders for the orders within the financialOrders arrayList
	public double totalOrders() {
		double totalSum = 0;
		for (Order order : financialOrders) {
			totalSum = totalSum + order.getTotalPrice();
		}
		return totalSum;
	}

	public double profit(double income, double expenses) {
		double profit = income - expenses;
		profit = round(profit);
		if (profit > 0) {
			return profit;
		} else
			return 0;
	}

	public double loss(double income, double expenses) {
		double loss = expenses - income;
		loss = round(loss);
		if (loss > 0) {
			return loss;
		} else
			return 0;
	}

	public double getAllIncome() {
		double income = 0;
		for (Sale sale : getSales()) {
			income += sale.getTotalPrice();
		}
		income = round(income);
		return income;
	}

	public double getTodaysIncome() {
		double income = 0;
		for (Sale sale : getTodaySales()) {
			income += sale.getTotalPrice();
		}
		income = round(income);
		return income;
	}

	public double getDailyIncome(FinancialFormEvent e) {
		double income = 0;
		int day = e.getDay();
		int week = e.getWeek();
		int month = e.getMonth();

		System.out.println(day + "\n" + month);
		Calendar today = Calendar.getInstance();
		today.set(Calendar.MONTH, month);
		today.set(Calendar.WEEK_OF_MONTH, week);
		today.set(Calendar.DAY_OF_WEEK, day);
		for (Sale sale : sales) {
			Calendar saleDate = dateToCalender(sale.getDate());

			if ((saleDate.get(Calendar.DAY_OF_WEEK) == today
					.get(Calendar.DAY_OF_WEEK))
					&& (saleDate.get(Calendar.WEEK_OF_MONTH) == today
							.get(Calendar.WEEK_OF_MONTH))
					&& (saleDate.get(Calendar.MONTH) == today
							.get(Calendar.MONTH))
					&& (saleDate.get(Calendar.YEAR) == today.get(Calendar.YEAR))) {
				income += sale.getTotalPrice();
			}
		}
		income = round(income);
		return income;
	}

	public double getWeeklyIncome(FinancialFormEvent e) {
		double income = 0;
		int week = e.getWeek();
		int month = e.getMonth();

		Calendar today = Calendar.getInstance();
		today.set(Calendar.WEEK_OF_MONTH, week);
		today.set(Calendar.MONTH, month);
		for (Sale sale : sales) {
			Calendar saleDate = dateToCalender(sale.getDate());

			if ((saleDate.get(Calendar.WEEK_OF_MONTH) == today
					.get(Calendar.WEEK_OF_MONTH))
					&& (saleDate.get(Calendar.MONTH) == today
							.get(Calendar.MONTH))
					&& (saleDate.get(Calendar.YEAR) == today.get(Calendar.YEAR))) {
				income += sale.getTotalPrice();
			}
		}
		income = round(income);
		return income;
	}

	public double getMonthlyIncome(FinancialFormEvent e) {
		double income = 0;
		int month = e.getMonth();
		Calendar today = Calendar.getInstance();
		today.set(Calendar.MONTH, month);
		for (Sale sale : sales) {
			Calendar saleDate = dateToCalender(sale.getDate());

			if ((saleDate.get(Calendar.MONTH) == today.get(Calendar.MONTH))
					&& (saleDate.get(Calendar.YEAR) == today.get(Calendar.YEAR))) {
				income += sale.getTotalPrice();
			}
		}
		income = round(income);
		return income;
	}

	public double getAllExpenses() {
		double expenses = 0;
		for (Order order : getOrders()) {
			expenses += order.getTotalPrice();
		}
		expenses = round(expenses);
		return expenses;
	}

	public double getTodaysExpenses() {
		double expenses = 0;
		for (Order order : getTodayOrders()) {
			expenses += order.getTotalPrice();
		}
		expenses = round(expenses);
		return expenses;
	}

	public double getDailyExpenses(FinancialFormEvent e) {
		double expenses = 0;
		int day = e.getDay();
		int week = e.getWeek();
		int month = e.getMonth();
		Calendar today = Calendar.getInstance();
		today.set(Calendar.MONTH, month);
		today.set(Calendar.WEEK_OF_MONTH, week);
		today.set(Calendar.DAY_OF_WEEK, day);
		for (Order order : orders) {
			Calendar orderDate = dateToCalender(order.getDate());

			if ((orderDate.get(Calendar.DAY_OF_WEEK) == today
					.get(Calendar.DAY_OF_WEEK))
					&& (orderDate.get(Calendar.WEEK_OF_MONTH) == today
							.get(Calendar.WEEK_OF_MONTH))
					&& (orderDate.get(Calendar.MONTH) == today
							.get(Calendar.MONTH))
					&& (orderDate.get(Calendar.YEAR) == today
							.get(Calendar.YEAR))) {
				expenses += order.getTotalPrice();
			}
		}
		expenses = round(expenses);
		return expenses;
	}

	public double getWeeklyExpenses(FinancialFormEvent e) {
		double expenses = 0;
		int week = e.getWeek();
		int month = e.getMonth();
		Calendar today = Calendar.getInstance();
		today.set(Calendar.WEEK_OF_MONTH, week);
		today.set(Calendar.MONTH, month);
		for (Order order : orders) {
			Calendar orderDate = dateToCalender(order.getDate());

			if ((orderDate.get(Calendar.WEEK_OF_MONTH) == today
					.get(Calendar.WEEK_OF_MONTH))
					&& (orderDate.get(Calendar.MONTH) == today
							.get(Calendar.MONTH))
					&& (orderDate.get(Calendar.YEAR) == today
							.get(Calendar.YEAR))) {
				expenses += order.getTotalPrice();
			}
		}
		expenses = round(expenses);
		return expenses;
	}

	public double getMonthlyExpenses(FinancialFormEvent e) {
		double expenses = 0;
		int month = e.getMonth();
		Calendar today = Calendar.getInstance();
		today.set(Calendar.MONTH, month);
		for (Order order : orders) {
			Calendar orderDate = dateToCalender(order.getDate());

			if ((orderDate.get(Calendar.MONTH) == today.get(Calendar.MONTH))
					&& (orderDate.get(Calendar.YEAR) == today
							.get(Calendar.YEAR))) {
				expenses += order.getTotalPrice();
			}
		}
		expenses = round(expenses);
		return expenses;
	}

	public double round(double val) {
		val = Math.round(val * 100) / 100.00;
		return val;
	}

	public StockSalesPredictor getPredictor() {
		return predictor;
	}

	public void setPredictor(StockSalesPredictor predictor) {
		this.predictor = predictor;
	}

	public String getEditedStockName() {
		return editedStockName;
	}

	public void setEditedStockName(String editedStockName) {
		this.editedStockName = editedStockName;
	}

	public double getEditedStockPrice() {
		return editedStockPrice;
	}

	public void setEditedStockPrice(double editedStockPrice) {
		this.editedStockPrice = editedStockPrice;
	}
}

