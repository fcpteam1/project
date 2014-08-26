package model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;


public class Controller {

	private View view;
	private Model model;
	private ActionListener loginListener,logoutListener,createUserListener,backToUserMenu,deleteUserListener;
	private ActionListener viewSupplier,viewProducts,nextSupplier,prevSupplier,searchSupplier;
	private ActionListener btnSubmitNewCustomer, btnViewCustomers, btnAddCustomer;
	
	private MouseAdapter supplierTableListener;
	private ActionListener menuViewSupplier,menuEditSupplier,menuAddProduct;
	private ActionListener exitProductPanel;
	
	public Controller() throws IOException {
		// TODO Auto-generated constructor stub
		
		view=new View();
		model=new Model();
		addListeners();
		addListenersToButtons();
	
	}
	
	
	public void addListeners(){
		
		loginListener=new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				String username=view.getLogin().getLoginUsername().getText();
				char[] password = view.getLogin().getLoginPassword().getPassword();
				
				
				String pass="";
				for(int i=0;i<password.length;i++){
					pass+=password[i];
				}
				
				System.out.println("Username "+username+",password "+pass);
				boolean correctUser=false;
				boolean admin=false;
				for(User user : model.getShop().getUsers()){
					if(username.equals(user.getUsername()) && pass.equals(user.getPassword())){
						correctUser=true;
						admin=user.isAdmin();
						break;
					}	
				}
				if(correctUser){
					view.changeToMaineMenu();
					view.getMainmenu().addTabs(admin);
				}
				else
					System.out.println("Not a valid user");
				
				
				view.getLogin().getLoginUsername().setText("");
				view.getLogin().getLoginPassword().setText("");
				viewSuppliers();
			}
		
		};
		
		
		logoutListener=new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				view.logout();
				view.getMainmenu().removeTabs();
			}
			
		};
		
		
		
		viewSupplier=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				viewSuppliers();
				
			}
		};
		
		viewProducts=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				viewProducts();
			}
		};
		
		
		nextSupplier=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				if(view.getMainmenu().getSupplierTab().isSupplier()==false){
					
					view.getMainmenu().getSupplierTab().setCurrent((view.getMainmenu().getSupplierTab().getCurrent()+1) % model.getShop().getSuppliers().size());
					
					int current=view.getMainmenu().getSupplierTab().getCurrent();
					
					Object data[][]=fillProductsForSupplier(current);
					view.getMainmenu().getSupplierTab().getSupplierText().setText(model.getShop().getSuppliers().get(current).getName());
					view.getMainmenu().getSupplierTab().setProductData(data);
					view.getMainmenu().getSupplierTab().focusViewProducts();
				}
				
			}
		};
		
		
		prevSupplier=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				if(view.getMainmenu().getSupplierTab().isSupplier()==false){
					
					view.getMainmenu().getSupplierTab().setCurrent((view.getMainmenu().getSupplierTab().getCurrent()-1) );
					
					
					
					int current=view.getMainmenu().getSupplierTab().getCurrent();
					
					if(current<0){
						view.getMainmenu().getSupplierTab().setCurrent(model.getShop().getSuppliers().size()-1);
						current=view.getMainmenu().getSupplierTab().getCurrent();
					}
					
					Object data[][]=fillProductsForSupplier(current);
					view.getMainmenu().getSupplierTab().getSupplierText().setText(model.getShop().getSuppliers().get(current).getName());
					view.getMainmenu().getSupplierTab().setProductData(data);
					view.getMainmenu().getSupplierTab().focusViewProducts();
				}
				
			}
		};
		
		
		searchSupplier=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				String supplierName=view.getMainmenu().getSupplierTab().getSearchText().getText();
				int index=0;
				boolean foundSupp=false;
				
				for(Supplier supplier : model.getShop().getSuppliers()){
					
					if(supplier.getName().equals(supplierName)){
						foundSupp=true;
						System.out.println("Found");
						break;
					}
					
					index++;
				}
				
				
				if(foundSupp){
					System.out.println("Filling");
					Object data[][]=fillProductsForSupplier(index);
					view.getMainmenu().getSupplierTab().getSupplierText().setText(model.getShop().getSuppliers().get(index).getName());
					view.getMainmenu().getSupplierTab().setProductData(data);
					view.getMainmenu().getSupplierTab().focusViewProducts();
					
				}
			}
		};
		
		
		
		
		supplierTableListener=new MouseAdapter(){
				public void mousePressed(MouseEvent e) {
				
				int row = view.getMainmenu().getSupplierTab().getViewSupplierTabel().rowAtPoint(e.getPoint());
				
				System.out.println("Row "+row);
				
				view.getMainmenu().getSupplierTab().getViewSupplierTabel().getSelectionModel().setSelectionInterval(row, row);
				
				if(e.getButton() == MouseEvent.BUTTON3){
					view.getMainmenu().getSupplierTab().getViewProductsPopup().show(view.getMainmenu().getSupplierTab().getViewSupplierTabel(), e.getX(),e.getY());
					System.out.println("MOUSE event 3");
				}
			}
			
		};
		
		menuViewSupplier=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				int index=view.getMainmenu().getSupplierTab().getViewSupplierTabel().getSelectedRow();
				view.getMainmenu().getSupplierTab().setCurrent(index);
				viewProducts();
				
			}
			
		};
		
		menuEditSupplier=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				view.getMainmenu().getSupplierTab().showEditPanel();
				
			}
			
		};
		
		menuAddProduct=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				view.getMainmenu().getSupplierTab().showAddProductPanel();
				
			}
			
		};
		
		exitProductPanel=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				view.getMainmenu().getSupplierTab().removeAddProductsPanel();
				
			}
			
		};
	}

		
		
public Object[][] fillProductsForSupplier(int current){
		
		
		Object data[][]=new Object[model.getShop().getSuppliers().get(current).getProducts().size()][3];
		
		for(int i=0;i<model.getShop().getSuppliers().get(current).getProducts().size();i++){
			System.out.println(i);
			data[i][0]=model.getShop().getSuppliers().get(current).getProducts().get(i).getName();
			System.out.println(i);
			data[i][1]=model.getShop().getSuppliers().get(current).getProducts().get(i).getId();
			System.out.println(i);
			data[i][2]=model.getShop().getSuppliers().get(current).getProducts().get(i).getSupplierPrice();
			
		}
		
		return data;
	}
		
	public void addListenersToButtons(){
		
		view.getLogin().getSubmit().addActionListener(loginListener);
		view.getMainmenu().getLogoutButton().addActionListener(logoutListener);
		
		view.getMainmenu().getSupplierTab().getSupplierButton().addActionListener(viewSupplier);
		view.getMainmenu().getSupplierTab().getProductButton().addActionListener(viewProducts);
		view.getMainmenu().getSupplierTab().getNext().addActionListener(nextSupplier);
		view.getMainmenu().getSupplierTab().getPrevious().addActionListener(prevSupplier);
		view.getMainmenu().getSupplierTab().getSearch().addActionListener(searchSupplier);
		view.getMainmenu().getSupplierTab().getViewSupplierTabel().addMouseListener(supplierTableListener);
		view.getMainmenu().getSupplierTab().getViewProducts().addActionListener(menuViewSupplier);
		view.getMainmenu().getSupplierTab().getEditSupplier().addActionListener(menuEditSupplier);
		view.getMainmenu().getSupplierTab().getAddProducts().addActionListener(menuAddProduct);
		view.getMainmenu().getSupplierTab().getExitProductPanel().addActionListener(exitProductPanel);
		
		
	}
	
	
	public void viewSuppliers(){
		
		Object data[][]=new Object[model.getShop().getSuppliers().size()][4];
		
		for(int i=0;i<model.getShop().getSuppliers().size();i++){
			data[i][0]=model.getShop().getSuppliers().get(i).getName();
			data[i][1]=model.getShop().getSuppliers().get(i).getId();
			data[i][2]=model.getShop().getSuppliers().get(i).getNumber();
			data[i][3]=model.getShop().getSuppliers().get(i).getAddress();
		}
		view.getMainmenu().getSupplierTab().setSupplierData(data);
		view.getMainmenu().getSupplierTab().focusViewSuppliers();
		view.getMainmenu().getSupplierTab().getViewSupplierTabel().addMouseListener(supplierTableListener);
		view.getMainmenu().getSupplierTab().getNext().setEnabled(false);
		view.getMainmenu().getSupplierTab().getPrevious().setEnabled(false);
		view.getMainmenu().getSupplierTab().getSearch().setEnabled(false);
	}
	
	
	public void viewProducts(){
		int current=view.getMainmenu().getSupplierTab().getCurrent();
		
		Object data[][]=fillProductsForSupplier(current);
		view.getMainmenu().getSupplierTab().getSupplierText().setText(model.getShop().getSuppliers().get(current).getName());
		view.getMainmenu().getSupplierTab().setProductData(data);
		view.getMainmenu().getSupplierTab().focusViewProducts();
		
		view.getMainmenu().getSupplierTab().getNext().setEnabled(true);
		view.getMainmenu().getSupplierTab().getPrevious().setEnabled(true);
		view.getMainmenu().getSupplierTab().getSearch().setEnabled(true);
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		new Controller();
		
	}

}
