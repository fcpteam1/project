package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import model.ErrorChecker;

public class Controller {

	private View view;
	private Model model;
	private ActionListener loginListener, logoutListener, createUserListener,
			backToUserMenu, deleteUserListener;
	private ActionListener viewSupplier, viewProducts, nextSupplier,
			prevSupplier, searchSupplier;
	private ActionListener btnSubmitNewCustomer, btnViewCustomers,
			btnAddCustomer;

	private MouseAdapter supplierTableListener;
	private ActionListener menuViewSupplier, menuEditSupplier, menuAddProduct,
			menuEditSupplierFromProduct, addProductFromProducts;
	private ActionListener exitProductPanel, exitSupplierPanel,
			exitCreatePanel;
	private ActionListener updateSupName, updateSupPhone, updateSupAddress,
			addProduct;
	private ActionListener createSupButton, deleteSupButton, editSupButton,
			addSupButton;
	private ActionListener createSupplier;

	private ActionListener stockBack, weekPredict, monthPredict, predict;
	private ActionListener switchToLogin,exit,loginDelay;

	public Controller() throws IOException {
		// TODO Auto-generated constructor stub

		view = new View();
		model = new Model();
		addListeners();
		addListenersToButtons();
		viewSuppliers();
	}

	public void addListeners() {

		loginListener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				view.getLogin().settStart(System.currentTimeMillis());
				view.getLogin().setTend(view.getLogin().gettStart());
				view.getLogin().getDelayTimer().restart();
				String username = view.getLogin().getLoginUsername().getText();
				char[] password = view.getLogin().getLoginPassword()
						.getPassword();

				String pass = "";
				for (int i = 0; i < password.length; i++) {
					pass += password[i];
				}

				System.out
						.println("Username " + username + ",password " + pass);
				boolean correctUser = false;
				boolean admin = false;
				for (User user : model.getShop().getUsers()) {
					if (username.equals(user.getUsername())
							&& pass.equals(user.getPassword())) {
						correctUser = true;
						admin = user.isAdmin();
						break;
					}
				}
				if (correctUser) {
					view.getMainmenu().addTabs(admin);
					view.changeToMaineMenu();
					view.getLogin().settStart(System.currentTimeMillis());
					view.getLogin().setTend(view.getLogin().gettStart());
					view.getLogin().stopTimer();
					
				} else
					System.out.println("Not a valid user");

				view.getLogin().getLoginUsername().setText("");
				view.getLogin().getLoginPassword().setText("");
				viewSuppliers();
			}

		};

		logoutListener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				view.getLogin().settStart(System.currentTimeMillis());
				view.getLogin().setTend(view.getLogin().gettStart());
				view.logout();
				view.getMainmenu().removeTabs();
				
			}

		};

		viewSupplier = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				viewSuppliers();

			}
		};

		viewProducts = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				viewProducts();
			}
		};

		nextSupplier = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (view.getMainmenu().getSupplierTab().isSupplier() == false) {

					view.getMainmenu()
							.getSupplierTab()
							.setCurrent(
									(view.getMainmenu().getSupplierTab()
											.getCurrent() + 1)
											% model.getShop().getSuppliers()
													.size());

					int current = view.getMainmenu().getSupplierTab()
							.getCurrent();

					Object data[][] = fillProductsForSupplier(current);
					view.getMainmenu()
							.getSupplierTab()
							.getSupplierText()
							.setText(
									model.getShop().getSuppliers().get(current)
											.getName());
					view.getMainmenu().getSupplierTab().setProductData(data);
					view.getMainmenu().getSupplierTab().focusViewProducts();
				}

			}
		};

		prevSupplier = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (view.getMainmenu().getSupplierTab().isSupplier() == false) {

					view.getMainmenu()
							.getSupplierTab()
							.setCurrent(
									(view.getMainmenu().getSupplierTab()
											.getCurrent() - 1));

					int current = view.getMainmenu().getSupplierTab()
							.getCurrent();

					if (current < 0) {
						view.getMainmenu()
								.getSupplierTab()
								.setCurrent(
										model.getShop().getSuppliers().size() - 1);
						current = view.getMainmenu().getSupplierTab()
								.getCurrent();
					}

					Object data[][] = fillProductsForSupplier(current);
					view.getMainmenu()
							.getSupplierTab()
							.getSupplierText()
							.setText(
									model.getShop().getSuppliers().get(current)
											.getName());
					view.getMainmenu().getSupplierTab().setProductData(data);
					view.getMainmenu().getSupplierTab().focusViewProducts();
				}

			}
		};

		searchSupplier = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String supplierName = view.getMainmenu().getSupplierTab()
						.getSearchText().getText();
				int index = 0;
				boolean foundSupp = false;

				for (Supplier supplier : model.getShop().getSuppliers()) {

					if (supplier.getName().equals(supplierName)) {
						foundSupp = true;
						System.out.println("Found");
						break;
					}

					index++;
				}

				if (foundSupp) {
					System.out.println("Filling");
					Object data[][] = fillProductsForSupplier(index);
					view.getMainmenu()
							.getSupplierTab()
							.getSupplierText()
							.setText(
									model.getShop().getSuppliers().get(index)
											.getName());
					view.getMainmenu().getSupplierTab().setProductData(data);
					view.getMainmenu().getSupplierTab().focusViewProducts();

				}
			}
		};

		supplierTableListener = new MouseAdapter() {
			public void mousePressed(MouseEvent e) {

				int row = view.getMainmenu().getSupplierTab()
						.getViewSupplierTabel().rowAtPoint(e.getPoint());
				view.getMainmenu().getSupplierTab().getViewSupplierTabel()
						.getSelectionModel().setSelectionInterval(row, row);

				if (e.getButton() == MouseEvent.BUTTON3) {
					view.getMainmenu()
							.getSupplierTab()
							.getViewProductsPopup()
							.show(view.getMainmenu().getSupplierTab()
									.getViewSupplierTabel(), e.getX(), e.getY());

				}
			}

		};

		menuViewSupplier = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int index = view.getMainmenu().getSupplierTab()
						.getViewSupplierTabel().getSelectedRow();
				view.getMainmenu().getSupplierTab().setCurrent(index);
				viewProducts();

			}

		};

		menuEditSupplier = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = view.getMainmenu().getSupplierTab()
						.getViewSupplierTabel().getSelectedRow();
				view.getMainmenu().getSupplierTab().setCurrent(index);
				view.getMainmenu().getSupplierTab().showEditPanel();
				view.getMainmenu()
						.getSupplierTab()
						.getSupplierName()
						.setText(
								model.getShop().getSuppliers().get(index)
										.getName());
				view.getMainmenu()
						.getSupplierTab()
						.getSupplierPhone()
						.setText(
								model.getShop().getSuppliers().get(index)
										.getNumber());
				view.getMainmenu()
						.getSupplierTab()
						.getSupplierAddress()
						.setText(
								model.getShop().getSuppliers().get(index)
										.getAddress());

			}

		};

		menuAddProduct = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = view.getMainmenu().getSupplierTab()
						.getViewSupplierTabel().getSelectedRow();
				view.getMainmenu().getSupplierTab().setCurrent(index);
				viewProducts();
				view.getMainmenu().getSupplierTab().showAddProductPanel();

			}

		};

		exitProductPanel = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getMainmenu().getSupplierTab().removeAddProductsPanel();

			}

		};

		exitSupplierPanel = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getMainmenu().getSupplierTab().removeEditPanel();

			}

		};

		exitCreatePanel = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getMainmenu().getSupplierTab().removeCreateSupplierPanel();

			}

		};

		menuEditSupplierFromProduct = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = view.getMainmenu().getSupplierTab().getCurrent();
				view.getMainmenu().getSupplierTab().showEditPanel();
				view.getMainmenu()
						.getSupplierTab()
						.getSupplierName()
						.setText(
								model.getShop().getSuppliers().get(index)
										.getName());
				view.getMainmenu()
						.getSupplierTab()
						.getSupplierPhone()
						.setText(
								model.getShop().getSuppliers().get(index)
										.getNumber());
				view.getMainmenu()
						.getSupplierTab()
						.getSupplierAddress()
						.setText(
								model.getShop().getSuppliers().get(index)
										.getAddress());

			}

		};

		addProductFromProducts = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				view.getMainmenu().getSupplierTab().showAddProductPanel();

			}

		};

		updateSupName = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				model.getShop()
						.getSuppliers()
						.get(view.getMainmenu().getSupplierTab().getCurrent())
						.setName(
								view.getMainmenu().getSupplierTab()
										.getSupplierName().getText());

				view.getMainmenu().getSupplierTab()
						.refreshSupplier(fillSupplierTable());

			}

		};

		updateSupPhone = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				if(ErrorChecker.isPhoneNumber(view.getMainmenu().getSupplierTab()
											.getSupplierPhone().getText())){
					
						model.getShop()
								.getSuppliers()
								.get(view.getMainmenu().getSupplierTab().getCurrent())
								.setNumber(
										view.getMainmenu().getSupplierTab()
												.getSupplierPhone().getText());
						
						
						view.getMainmenu().getSupplierTab()
								.refreshSupplier(fillSupplierTable());
					
				}
				else{
					JOptionPane.showMessageDialog(ErrorChecker.getFrame(), "Phone number can only contain numbers and ' - '");
				}
			
			}
		};

		updateSupAddress = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				model.getShop()
						.getSuppliers()
						.get(view.getMainmenu().getSupplierTab().getCurrent())
						.setAddress(
								view.getMainmenu().getSupplierTab()
										.getSupplierAddress().getText());
				view.getMainmenu().getSupplierTab()
						.refreshSupplier(fillSupplierTable());
			}

		};

		addProduct = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int current = view.getMainmenu().getSupplierTab().getCurrent();

				String name = view.getMainmenu().getSupplierTab()
						.getProductName().getText();
				String price = view.getMainmenu().getSupplierTab()
						.getSupplierPrice().getText();

				
				
				if(ErrorChecker.isOnlyLetters(name)==false){
					JOptionPane.showMessageDialog(ErrorChecker.getFrame(), "Product name must only conatain letters");
				}
				else if(ErrorChecker.isFloat(price)==false){
					JOptionPane.showMessageDialog(ErrorChecker.getFrame(), "Supplier Price must be of the format e.cc.");
					
				}
				else{
					name= name.toLowerCase();
					
					char[] cName=name.toCharArray();
					name=name.toUpperCase();
					char one=name.charAt(0);
					
					String newName="";
					newName+=one;
					for(int i=1;i<name.length();i++){
						newName+=cName[i];
					}
					
					model.getShop().getSuppliers().get(current).getProducts()
							.add(new Product(newName, Double.parseDouble(price)));

					
					Object data[][] = fillProductsForSupplier(current);

					view.getMainmenu().getSupplierTab().refreshProducts(data);
					}
			}

		};

		createSupButton = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getMainmenu().getSupplierTab().showCreateSupplierPanel();
			}
		};

		deleteSupButton = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (view.getMainmenu().getSupplierTab().getViewSupplierTabel()
						.getSelectedRow() > -1) {
					int index = view.getMainmenu().getSupplierTab()
							.getViewSupplierTabel().getSelectedRow();

					String warning = "";
					warning = "Are you sure you want to delete supplier"
							+ model.getShop().getSuppliers().get(index)
									.toString();

					int n = JOptionPane.showConfirmDialog(view.getMainmenu()
							.getSupplierTab().getDeleteFrame(), warning,
							"An Inane Question", JOptionPane.YES_NO_OPTION);

					if (n == JOptionPane.YES_OPTION) {
						model.getShop().getSuppliers().remove(index);
					}
				}

			}
		};

		editSupButton = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (view.getMainmenu().getSupplierTab().getViewSupplierTabel()
						.getSelectedRow() > -1) {
					view.getMainmenu()
							.getSupplierTab()
							.setCurrent(
									view.getMainmenu().getSupplierTab()
											.getViewSupplierTabel()
											.getSelectedRow());
				}
				int index = view.getMainmenu().getSupplierTab().getCurrent();
				view.getMainmenu().getSupplierTab().showEditPanel();
				view.getMainmenu()
						.getSupplierTab()
						.getSupplierName()
						.setText(
								model.getShop().getSuppliers().get(index)
										.getName());
				view.getMainmenu()
						.getSupplierTab()
						.getSupplierPhone()
						.setText(
								model.getShop().getSuppliers().get(index)
										.getNumber());
				view.getMainmenu()
						.getSupplierTab()
						.getSupplierAddress()
						.setText(
								model.getShop().getSuppliers().get(index)
										.getAddress());
			}
		};

		addSupButton = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getMainmenu().getSupplierTab().showAddProductPanel();
			}
		};

		createSupplier = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Supplier supplier = new Supplier();
				supplier.setName(view.getMainmenu().getSupplierTab()
						.getCreateName().getText());
				supplier.setNumber(view.getMainmenu().getSupplierTab()
						.getCreatePhone().getText());
				supplier.setAddress(view.getMainmenu().getSupplierTab()
						.getCreateAddress().getText());
				model.getShop().getSuppliers().add(supplier);
			}
		};

		predict = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getMainmenu().getStockTab().switchToStockPredict();
			}
		};

		weekPredict = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object data[][];
				int count = 0;
				int[] result = new int[5];
				data = new Object[model.getShop().getStock().size()][6];
				for (Stock stock : model.getShop().getStock()) {
					result = model
							.getShop()
							.getPredictor()
							.stockPredictor(model.getShop().getSales(), stock,
									true);
					data[count][0] = stock.getName();
					data[count][1] = result[0];
					data[count][2] = result[1];
					data[count][3] = result[2];
					data[count][4] = result[3];
					data[count][5] = result[4];
					System.out.println(count);
					count++;
				}
				view.getMainmenu().getStockTab().setPredictData(data);
				view.getMainmenu().getStockTab().fillWeekPrediction(data);
			}
		};

		monthPredict = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object data[][];
				int count = 0;
				int[] result = new int[5];
				data = new Object[model.getShop().getStock().size()][6];
				for (Stock stock : model.getShop().getStock()) {
					result = model
							.getShop()
							.getPredictor()
							.stockPredictor(model.getShop().getSales(), stock,
									false);
					data[count][0] = stock.getName();
					data[count][1] = result[0];
					data[count][2] = result[1];
					data[count][3] = result[2];
					data[count][4] = result[3];
					data[count][5] = result[4];
					count++;
				}

				view.getMainmenu().getStockTab().setPredictData(data);
				view.getMainmenu().getStockTab().fillMonthPrediction(data);
			}
		};

		stockBack = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getMainmenu().getStockTab().switchToMain();
			}
		};
		
		switchToLogin=new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				
				
				view.getLogin().getPanel().setVisible(true);
				new Timer(1, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						view.getWelcomeScreen().getWelcomePanel().setLocation(view.getWelcomeScreen().getWelcomePanel().getX() - 5, 0);
						
						if (view.getWelcomeScreen().getWelcomePanel().getX()+view.getWelcomeScreen().getWelcomePanel().getWidth() <= 0) {
							((Timer) e.getSource()).stop();
							
							view.getLogin().getSubmit().setEnabled(true);
							view.getLogin().getPanel().setVisible(true);
							//view.getCurrentPanel().setVisible(true);
							view.getWelcomeScreen().getWelcomePanel().setVisible(false);
							view.getLogin().startTimer();
							view.getLogin().settStart(System.currentTimeMillis());
							view.getLogin().setTend(view.getLogin().gettStart());
						}
					}
				}).start();
			}
		};
		
		exit=new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		};
		
		loginDelay=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				view.getLogin().setTend(System.currentTimeMillis());
				
				if((view.getLogin().getTend() - view.getLogin().gettStart()) >60000){
					view.getLogin().stopTimer();
					view.idle();
					view.getLogin().getPanel().setVisible(false);
					
				}
				
			}
		};
		
	}

	public Object[][] fillProductsForSupplier(int current) {

		Object data[][] = new Object[model.getShop().getSuppliers()
				.get(current).getProducts().size()][3];

		for (int i = 0; i < model.getShop().getSuppliers().get(current)
				.getProducts().size(); i++) {

			data[i][0] = model.getShop().getSuppliers().get(current)
					.getProducts().get(i).getName();

			data[i][1] = model.getShop().getSuppliers().get(current)
					.getProducts().get(i).getId();

			data[i][2] = model.getShop().getSuppliers().get(current)
					.getProducts().get(i).getSupplierPrice();

		}

		return data;
	}

	public void addListenersToButtons() {

		view.getLogin().getSubmit().addActionListener(loginListener);
		view.getMainmenu().getLogoutButton().addActionListener(logoutListener);

		view.getMainmenu().getSupplierTab().getSupplierButton()
				.addActionListener(viewSupplier);
		view.getMainmenu().getSupplierTab().getProductButton()
				.addActionListener(viewProducts);
		view.getMainmenu().getSupplierTab().getNext()
				.addActionListener(nextSupplier);
		view.getMainmenu().getSupplierTab().getPrevious()
				.addActionListener(prevSupplier);
		view.getMainmenu().getSupplierTab().getSearch()
				.addActionListener(searchSupplier);
		view.getMainmenu().getSupplierTab().getViewProducts()
				.addActionListener(menuViewSupplier);
		view.getMainmenu().getSupplierTab().getEditSupplier()
				.addActionListener(menuEditSupplier);
		view.getMainmenu().getSupplierTab().getAddProducts()
				.addActionListener(menuAddProduct);
		view.getMainmenu().getSupplierTab().getExitProductPanel()
				.addActionListener(exitProductPanel);
		view.getMainmenu().getSupplierTab().getExitEditPanel()
				.addActionListener(exitSupplierPanel);
		view.getMainmenu().getSupplierTab().getAddProductFromProducts()
				.addActionListener(addProductFromProducts);
		view.getMainmenu().getSupplierTab().getEditSupplierFromProducts()
				.addActionListener(menuEditSupplierFromProduct);

		view.getMainmenu().getSupplierTab().getEditSupName()
				.addActionListener(updateSupName);
		view.getMainmenu().getSupplierTab().getEditSupPhone()
				.addActionListener(updateSupPhone);
		view.getMainmenu().getSupplierTab().getEditSupAddress()
				.addActionListener(updateSupAddress);
		view.getMainmenu().getSupplierTab().getCreate()
				.addActionListener(createSupButton);
		view.getMainmenu().getSupplierTab().getCreateSupplierButton()
				.addActionListener(createSupplier);
		view.getMainmenu().getSupplierTab().getDelete()
				.addActionListener(deleteSupButton);
		view.getMainmenu().getSupplierTab().getDeleteSupplier()
				.addActionListener(deleteSupButton);
		view.getMainmenu().getSupplierTab().getEdit()
				.addActionListener(editSupButton);
		view.getMainmenu().getSupplierTab().getAdd()
				.addActionListener(addSupButton);
		view.getMainmenu().getSupplierTab().getAddProduct()
				.addActionListener(addProduct);
		view.getMainmenu().getSupplierTab().getExitCreatePanelButton()
				.addActionListener(exitCreatePanel);

		view.getMainmenu().getStockTab().getBackTo()
				.addActionListener(stockBack);
		view.getMainmenu().getStockTab().getPredictNextWeek()
				.addActionListener(weekPredict);
		view.getMainmenu().getStockTab().getPredictNextMonth()
				.addActionListener(monthPredict);
		view.getMainmenu().getStockTab().getPredictStock()
				.addActionListener(predict);
		
		
		view.getWelcomeScreen().getswitchToLoginPanelButton().addActionListener(switchToLogin);
		view.getWelcomeScreen().getExit().addActionListener(exit);
		view.getLogin().setDelayTimer(loginDelay);
		
		
		
	}

	public Object[][] fillSupplierTable() {
		Object data[][] = new Object[model.getShop().getSuppliers().size()][4];

		for (int i = 0; i < model.getShop().getSuppliers().size(); i++) {
			data[i][0] = model.getShop().getSuppliers().get(i).getName();
			data[i][1] = model.getShop().getSuppliers().get(i).getId();
			data[i][2] = model.getShop().getSuppliers().get(i).getNumber();
			data[i][3] = model.getShop().getSuppliers().get(i).getAddress();
		}

		return data;
	}

	public void viewSuppliers() {

		Object data[][] = fillSupplierTable();
		view.getMainmenu().getSupplierTab().setSupplierData(data);
		view.getMainmenu().getSupplierTab().focusViewSuppliers();
		view.getMainmenu().getSupplierTab().getViewSupplierTabel()
				.addMouseListener(supplierTableListener);

	}

	public void viewProducts() {

		if (view.getMainmenu().getSupplierTab().getViewSupplierTabel()
				.getSelectedRow() > -1) {
			view.getMainmenu()
					.getSupplierTab()
					.setCurrent(
							view.getMainmenu().getSupplierTab()
									.getViewSupplierTabel().getSelectedRow());
		}
		int current = view.getMainmenu().getSupplierTab().getCurrent();

		Object data[][] = fillProductsForSupplier(current);
		view.getMainmenu().getSupplierTab().getSupplierText()
				.setText(model.getShop().getSuppliers().get(current).getName());
		view.getMainmenu().getSupplierTab().setProductData(data);
		// view.getMainmenu().getSupplierTab().refreshProducts(data);
		view.getMainmenu().getSupplierTab().focusViewProducts();
		view.getMainmenu().getSupplierTab().getViewSupplierTabel()
				.addMouseListener(supplierTableListener);

	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		new Controller();

	}

}
