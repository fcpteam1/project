import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Controller {

	private View view;
	private Model model;
	private ActionListener loginListener,logoutListener,createUserListener,backToUserMenu,deleteUserListener;
	private ActionListener goToCreateUser,goToViewUser,goToEditUser;
	private ActionListener deleteNext,deletePrevious,deleteUser,deleteSearch;
	private ActionListener editNext,editPrevious,editUser,editSearch;
	
	
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
				for(User user : model.getShop().getUsers()){
					if(username.equals(user.getUsername()) && pass.equals(user.getPassword())){
						correctUser=true;
						break;
					}	
				}
				if(correctUser){
					view.changeToMaineMenu();
				}
				else
					System.out.println("Not a valid user");
				
				
				view.getLogin().getLoginUsername().setText("");
				view.getLogin().getLoginPassword().setText("");
			}
		
		};
		
		
		logoutListener=new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				view.logout();
			}
			
		};
		
		
		createUserListener=new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				String username=view.getMainmenu().getUserTab().getNameField().getText();
				char[] password=view.getMainmenu().getUserTab().getPasswordField().getPassword();
				String pass="";
				for(int i=0;i<password.length;i++){
					pass+=password[i];
				}
				
				boolean admin=view.getMainmenu().getUserTab().getIsAdmin().isSelected();
				
				model.getShop().getUsers().add(new User(username,pass,model.getShop().getUsers().size()+1,admin));
				
				view.getMainmenu().getUserTab().getErrorField().setText("User "+username+" created");
				
				view.getMainmenu().getUserTab().getNameField().setText("");
				view.getMainmenu().getUserTab().getPasswordField().setText("");
			}
		};
		
		
		goToCreateUser =new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				view.getMainmenu().getUserTab().switchToCreateUser();
				
			}
		};
		
		backToUserMenu=new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				view.getMainmenu().getUserTab().swithToMain();
			}
		};
		
		goToViewUser=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				Object[][] userData;
				userData=new Object[model.getShop().getUsers().size()][4];
				
				for(int i=0;i<model.getShop().getUsers().size();i++){
					
					userData[i][0]=model.getShop().getUsers().get(i).getUsername();
					userData[i][1]=model.getShop().getUsers().get(i).getPassword();
					userData[i][2]=model.getShop().getUsers().get(i).getId();
					userData[i][3]=model.getShop().getUsers().get(i).isAdmin();
				}
				
				view.getMainmenu().getUserTab().setViewUserData(userData);
				view.getMainmenu().getUserTab().switchToViewPanel();
				
			}
		};
		
		
		deleteUserListener=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				view.getMainmenu().getUserTab().swithToDeleteUser();
				fillDeleteUserPage();
			}
		};
		
		
		deleteNext=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				
				
				view.getMainmenu().getUserTab().setCurrentDeleteUser((view.getMainmenu().getUserTab().getCurrentDeleteUser()+1)%model.getShop().getUsers().size());
				
				
				fillDeleteUserPage();
			}
		};
		
		deletePrevious=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				view.getMainmenu().getUserTab().setCurrentDeleteUser((view.getMainmenu().getUserTab().getCurrentDeleteUser()-1)%model.getShop().getUsers().size());
				if(view.getMainmenu().getUserTab().getCurrentDeleteUser()<0)
					view.getMainmenu().getUserTab().setCurrentDeleteUser(model.getShop().getUsers().size()-1);
				
				fillDeleteUserPage();
			}
		};
		
		
		deleteUser=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				model.getShop().getUsers().remove(view.getMainmenu().getUserTab().getCurrentDeleteUser());
				
				view.getMainmenu().getUserTab().setCurrentDeleteUser((view.getMainmenu().getUserTab().getCurrentDeleteUser()-1)%model.getShop().getUsers().size());
				if(view.getMainmenu().getUserTab().getCurrentDeleteUser()<0)
					view.getMainmenu().getUserTab().setCurrentDeleteUser(model.getShop().getUsers().size()-1);
				fillDeleteUserPage();
			}
		};
		
		deleteSearch=new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				String deleteUsername=view.getMainmenu().getUserTab().getDeleteSearchUsernameText().getText();
				int index=0;
				boolean userExist=false;
				
				
				for(User user : model.getShop().getUsers()){
					
					if(user.getUsername().equals(deleteUsername)){
						userExist=true;
						break;
					}
					index++;
				}
				
				if(userExist){
					view.getMainmenu().getUserTab().setCurrentDeleteUser(index);
					fillDeleteUserPage();
				}
			}
		};
		
		goToEditUser=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				view.getMainmenu().getUserTab().switchToEditUser();
				fillEditUserPage();
			}
			
		};
		
		editSearch=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				String editUsername=view.getMainmenu().getUserTab().getEditSearchUsernameText().getText();
				int index=0;
				boolean userExist=false;
				
				for(User user : model.getShop().getUsers()){
					
					if(user.getUsername().equals(editUsername)){
						userExist=true;
						break;
					}
					index++;
				}
				
				if(userExist){
					view.getMainmenu().getUserTab().setCurrentEditUser(index);
					fillEditUserPage();
				}
				
				
			}
		};
		
		editNext=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				view.getMainmenu().getUserTab().setCurrentEditUser((view.getMainmenu().getUserTab().getCurrentEditUser()+1)%model.getShop().getUsers().size());
				
				
				fillEditUserPage();
				
			}
		};
		
		editPrevious=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				view.getMainmenu().getUserTab().setCurrentEditUser((view.getMainmenu().getUserTab().getCurrentEditUser()-1)%model.getShop().getUsers().size());
				if(view.getMainmenu().getUserTab().getCurrentEditUser()<0)
					view.getMainmenu().getUserTab().setCurrentEditUser(model.getShop().getUsers().size()-1);
				
				fillEditUserPage();
			}
		};
		
		editUser=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				int userIndex=view.getMainmenu().getUserTab().getCurrentEditUser();
				
				String newUsername=view.getMainmenu().getUserTab().getEditNewUsernameText().getText();
				String newPassword=view.getMainmenu().getUserTab().getEditNewPasswordText().getText();
				String newId=view.getMainmenu().getUserTab().getEditNewIdText().getText();
				boolean newAdmin=view.getMainmenu().getUserTab().getEditNewAdminText().isSelected();
				
				
				if(!(newUsername.equals(""))){
					model.getShop().getUsers().get(userIndex).setUsername(newUsername);
				}
				
				if(!(newPassword.equals(""))){
					model.getShop().getUsers().get(userIndex).setPassword(newPassword);
				}
				
				model.getShop().getUsers().get(userIndex).setAdmin(newAdmin);
				
				fillEditUserPage();
				
			}
		};
		
	}

	
	public void fillDeleteUserPage(){
		int current=view.getMainmenu().getUserTab().getCurrentDeleteUser();
		view.getMainmenu().getUserTab().getDeleteUsernameText().setText(model.getShop().getUsers().get(current).getUsername());
		view.getMainmenu().getUserTab().getDeletePasswordText().setText(model.getShop().getUsers().get(current).getPassword());
		view.getMainmenu().getUserTab().getDeleteIdText().setText(""+model.getShop().getUsers().get(current).getId());
		view.getMainmenu().getUserTab().getDeleteAdminText().setText(""+model.getShop().getUsers().get(current).isAdmin());
		
	}
	
	public void fillEditUserPage(){
		int current=view.getMainmenu().getUserTab().getCurrentEditUser();
		view.getMainmenu().getUserTab().getEditUsernameText().setText(model.getShop().getUsers().get(current).getUsername());
		view.getMainmenu().getUserTab().getEditPasswordText().setText(model.getShop().getUsers().get(current).getPassword());
		view.getMainmenu().getUserTab().getEditIdText().setText(""+model.getShop().getUsers().get(current).getId());
		view.getMainmenu().getUserTab().getEditAdminText().setText(""+model.getShop().getUsers().get(current).isAdmin());
		
		
	}
	
	public void addListenersToButtons(){
		
		view.getLogin().getSubmit().addActionListener(loginListener);
		view.getMainmenu().getLogoutButton().addActionListener(logoutListener);
		
		view.getMainmenu().getUserTab().getCreateUserButton().addActionListener(goToCreateUser);
		view.getMainmenu().getUserTab().getCreateUser().addActionListener(createUserListener);
		view.getMainmenu().getUserTab().getCreateBack().addActionListener(backToUserMenu);
		
		
		view.getMainmenu().getUserTab().getViewUserButton().addActionListener(goToViewUser);
		view.getMainmenu().getUserTab().getBackToUserFromView().addActionListener(backToUserMenu);
		
		view.getMainmenu().getUserTab().getDeleteUserButton().addActionListener(deleteUserListener);
		view.getMainmenu().getUserTab().getDeleteBackButton().addActionListener(backToUserMenu);
		view.getMainmenu().getUserTab().getDeleteNextSearchButton().addActionListener(deleteNext);
		view.getMainmenu().getUserTab().getDeletePreviousSearchButton().addActionListener(deletePrevious);
		view.getMainmenu().getUserTab().getDeleteButton().addActionListener(deleteUser);
		view.getMainmenu().getUserTab().getDeleteSearchButton().addActionListener(deleteSearch);
		
		view.getMainmenu().getUserTab().getEditBackButton().addActionListener(backToUserMenu);
		view.getMainmenu().getUserTab().getEditUserButton().addActionListener(goToEditUser);
		view.getMainmenu().getUserTab().getEditNextSearchButton().addActionListener(editNext);
		view.getMainmenu().getUserTab().getEditPreviousSearchButton().addActionListener(editPrevious);
		view.getMainmenu().getUserTab().getEditButton().addActionListener(editUser);
		view.getMainmenu().getUserTab().getEditSearchButton().addActionListener(editSearch);
		
		view.getMainmenu().getStockTab();
		view.getMainmenu().getStockTab().getPanel();
		
		
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		new Controller();
		
	}

}
