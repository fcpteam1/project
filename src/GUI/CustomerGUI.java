package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
 
public class CustomerGUI {
 
    private JPanel mainPanel;
    private JLabel label;
    // customer gui components
        private JFrame frameCustomerMenu;
        private JPanel frame;
        private JPanel panelCustomers, pnlCustomerMainBtm, pnlCustomerView, pnlCustomerViewEast, pnlCustomerViewWest,
        pnlCustomerViewSouth, pnlCustomerAddMain, pnlCustomerAddNorth, pnlCustomerAddCenter, infoMsgNewCustomerAdded,
        pnlCustomerDeleteMain;
        private JTable tblCustomerView;
        private JScrollPane scrollPanel;
        private JLabel lblCustomersView, lblCustomersMenu;
        private GridLayout gl;
        private JLabel lblId, lblName, lblPhone, lblAddress;
        private JTextField txtId, txtName, txtPhone, txtAddress;
        private JButton btnSubmitNewCustomer, btnCanelNewCustomer, btnViewCustomers, btnAddCustomer, button3, button;
     
    public CustomerGUI(){
         
        /*mainPanel=new JPanel();
        mainPanel.setLayout(new BorderLayout());
         
        label=new JLabel("Customer Panel");
        mainPanel.add(label,BorderLayout.NORTH);*/
         
        //===================CUSTOMERS MENU START============================
         
        //temporary hardcoded customers data
        Object[][] data = {
                {"01", "Andrew Smith", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"02", "Michelle Doe", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"03", "Michael Douglas", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"04", "Joe Smith", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"05", "Janet Jackson", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"01", "Andrew Smith", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"02", "Michelle Doe", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"03", "Michael Douglas","16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"04", "Joe Smith", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"05", "Janet Jackson", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"01", "Andrew Smith", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"02", "Michelle Doe", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"03", "Michael Douglas", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"04", "Joe Smith", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"05", "Janet Jackson", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"01", "Andrew Smith", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"02", "Michelle Doe", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"03", "Michael Douglas", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"04", "Joe Smith", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"05", "Janet Jackson", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"01", "Andrew Smith", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"02", "Michelle Doe", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"03", "Michael Douglas", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"04", "Joe Smith", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"05", "Janet Jackson", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"01", "Andrew Smith", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"02", "Michelle Doe", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"03", "Michael Douglas", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"04", "Joe Smith", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"05", "Janet Jackson", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"01", "Andrew Smith", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"02", "Michelle Doe", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"03", "Michael Douglas", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"04", "Joe Smith", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"05", "Janet Jackson", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"01", "Andrew Smith", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"02", "Michelle Doe", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"03", "Michael Douglas", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"04", "Joe Smith", "16 Hillview, Blessington, Co. Wicklow", "0861234567"},
                {"05", "Janet Jackson", "16 Hillview, Blessington, Co. Wicklow", "0861234567"}                      
        };
         
        String[] columnNames = {"ID",
                "Name",
                "Phone Number",
                "Address",
        };
                 
        //=================================MAIN CUSTOMER MENU START ==========================================
 
        frame=new JPanel();
        frame.setLayout(new BorderLayout());
         
        panelCustomers = new JPanel();
        //main layout of the customer menu
        FlowLayout flowLayout = (FlowLayout) panelCustomers.getLayout();
        flowLayout.setVgap(150);
        panelCustomers.setForeground(Color.GRAY);
        frame.add(panelCustomers, BorderLayout.NORTH);
         
        //south panel in the main customer view
        pnlCustomerMainBtm = new JPanel();
        pnlCustomerMainBtm.setBackground(SystemColor.activeCaption);
        //frameCustomerMenu.getContentPane().add(pnlCustomerMainBtm, BorderLayout.CENTER);
        frame.add(pnlCustomerMainBtm, BorderLayout.CENTER);
        pnlCustomerMainBtm.setLayout(null);
         
        //panel ALL customer view
        pnlCustomerView = new JPanel();
        //add border layout to the pnlCustomerView
        pnlCustomerView.setLayout(new BorderLayout());
        pnlCustomerView.setBackground(SystemColor.activeCaption);
         
        //table with list of customers
        tblCustomerView = new JTable(data, columnNames);
        //create scroll panel and add to list of customers table
        scrollPanel = new JScrollPane(tblCustomerView);
        //add scroll panel to customer view panel
        pnlCustomerView.add(scrollPanel,BorderLayout.CENTER);   
         
        //label north panel - all customer view
        lblCustomersView = new JLabel("List of Customers");
        lblCustomersView.setFont(new Font("Tahoma", Font.PLAIN, 26));
        pnlCustomerView.add(lblCustomersView, BorderLayout.NORTH);
        lblCustomersView.setHorizontalAlignment(JLabel.CENTER);
         
        //east panel in customer view
        pnlCustomerViewEast = new JPanel();
        pnlCustomerViewEast.setBackground(SystemColor.activeCaption);
        pnlCustomerView.add(pnlCustomerViewEast,BorderLayout.EAST);
         
        //east panel in customer view
        pnlCustomerViewWest = new JPanel();
        pnlCustomerViewWest.setBackground(SystemColor.activeCaption);
        pnlCustomerView.add(pnlCustomerViewWest,BorderLayout.WEST);
         
        //south panel in customer view
        pnlCustomerViewSouth = new JPanel();
        pnlCustomerViewSouth.setBackground(SystemColor.activeCaption);
        pnlCustomerView.add(pnlCustomerViewSouth,BorderLayout.SOUTH);
         
         
        //=================================ADD NEW CUSTOMER START ==========================================
         
         
        //panel add new customer main - container for other panels
        pnlCustomerAddMain = new JPanel();
        pnlCustomerAddMain.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
         
        lblId = new JLabel("ID: ");
        lblName = new JLabel("Name: ");
        lblPhone = new JLabel("Phone: ");
        lblAddress = new JLabel("Address: ");
 
        txtId = new JTextField("Enter customer ID", 20);
        txtName = new JTextField("Enter customer name ",20);
        txtPhone = new JTextField("Enter customer phone number",20);
        txtAddress = new JTextField("Enter customer phone address",20);
         
        btnSubmitNewCustomer = new JButton("Submit");           
        btnCanelNewCustomer = new JButton("Cancel");
                         
        /////////////////////FIRST ROW//////////////////////////////////
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,0,5);
        pnlCustomerAddMain.add(lblId, gbc);
         
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets= new Insets(0,0,0,0);
        pnlCustomerAddMain.add(txtId, gbc);
        /////////////////////SECONDE ROW//////////////////////////////////
        gbc.weightx = 1;
        gbc.weighty = 0.1;
         
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets= new Insets(0,0,0,5);
        pnlCustomerAddMain.add(lblName, gbc);
         
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets= new Insets(0,0,0,0);
        pnlCustomerAddMain.add(txtName, gbc);
        /////////////////////third ROW//////////////////////////////////
        gbc.weightx = 1;
        gbc.weighty = 0.1;
         
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets= new Insets(0,0,0,5);
        pnlCustomerAddMain.add(lblPhone, gbc);
         
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets= new Insets(0,0,0,0);
        pnlCustomerAddMain.add(txtPhone, gbc);
        /////////////////////forth ROW//////////////////////////////////
        gbc.weightx = 1;
        gbc.weighty = 0.1;
         
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets= new Insets(0,0,0,5);
        pnlCustomerAddMain.add(lblAddress, gbc);
         
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets= new Insets(0,0,0,0);
        pnlCustomerAddMain.add(txtAddress, gbc);
         
        /////////////////////fifth ROW//////////////////////////////////
        gbc.weightx = 1;
        gbc.weighty = 2;
         
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        gbc.insets= new Insets(0, 0, 0, 0);
        pnlCustomerAddMain.add(btnSubmitNewCustomer, gbc);
         
         
         
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(0, 150, 0, 0);
        pnlCustomerAddMain.add(btnCanelNewCustomer, gbc);
         
        //*******************BUTTONS CUSTOMER MENU***************************
         
        btnViewCustomers = new JButton("View customers");
        btnViewCustomers.setToolTipText("View list of all customers");
        btnViewCustomers.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnViewCustomers.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        btnViewCustomers.setBounds(68, 158, 168, 77);
        pnlCustomerMainBtm.add(btnViewCustomers);
        /*btnViewCustomers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {                
                frame.removeAll();
                frame.add(pnlCustomerView);
                frame.invalidate();
                frame.validate();
            }
        });*/
         
        //button ADD customer
        btnAddCustomer = new JButton("Add customer");
        btnAddCustomer.setToolTipText("Add new customer");
        btnAddCustomer.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnAddCustomer.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        btnAddCustomer.setBounds(288, 158, 168, 77);
        pnlCustomerMainBtm.add(btnAddCustomer);
        /*btnAddCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.removeAll();
                frame.add(pnlCustomerAddMain);
                frame.invalidate();
                frame.validate();
            }
        });*/
         
        //button DELETE customer
        button3 = new JButton("Delete customer");
        button3.setToolTipText("delete customer from list");
        button3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        button3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        button3.setBounds(515, 158, 168, 77);
        pnlCustomerMainBtm.add(button3);
         
        //button EDIT customer
        button = new JButton("Edit customer");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        button.setToolTipText("Edit customer from list");
        button.setFont(new Font("Tahoma", Font.PLAIN, 18));
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        button.setBounds(742, 158, 168, 77);
        pnlCustomerMainBtm.add(button);
         
         
        lblCustomersMenu = new JLabel("Customers Menu");
        lblCustomersMenu.setFont(new Font("Tahoma", Font.PLAIN, 26));
        panelCustomers.add(lblCustomersMenu);       
         
         
        //=================================DELETE CUSTOMER ==========================================
         
        //panel add new customer main - container for other panels
        pnlCustomerDeleteMain = new JPanel();
        pnlCustomerDeleteMain.setLayout(new GridBagLayout());
        GridBagConstraints gbc_delCust = new GridBagConstraints();
        int size = data.length;
        String[] names = new String[size];
         
        //access 2nd column
        for(int i=0; i<size; i++){
            names[i] = data[i][1].toString();
        }
         
        /*JComboBox nameList = new JComboBox(
                 
                for(int i=0; i<data.length; i++){
            names[i] = (String) data[i][1];
            System.out.println(names[i]);
        }*/
         
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    }
    //-----------------------------------GETTERS AND SETTERS--------------------------------------
    public JPanel getPanel(){
        return frame;   
    }
 
    public JButton getBtnSubmitNewCustomer() {
        return btnSubmitNewCustomer;
    }
 
    public void setBtnSubmitNewCustomer(JButton btnSubmitNewCustomer) {
        this.btnSubmitNewCustomer = btnSubmitNewCustomer;
    }
     
    //niall added
 
    public JButton getBtnAddCustomer() {
        return btnAddCustomer;
    }
     
    //
    public JTextField getTxtId() {
        return txtId;
    }
 
    public JTextField getTxtName() {
        return txtName;
    }
 
    public JTextField getTxtPhone() {
        return txtPhone;
    }
 
    public JTextField getTxtAddress() {
        return txtAddress;
    }
 
    public JPanel getFrame() {
        return frame;
    }
 
    public JPanel getPnlCustomerView() {
        return pnlCustomerView;
    }
 
    public void setPnlCustomerView(JPanel pnlCustomerView) {
        this.pnlCustomerView = pnlCustomerView;
    }
     
     
     
    //-----------------------------------------OTHER METHODS-------------------------------------------------
     
    public JButton getBtnViewCustomers() {
        return btnViewCustomers;
    }
 
    //view all customers in the table
    public void changeToViewAllCustomers()
    {
        frame.removeAll();
        frame.add(pnlCustomerView);
        frame.invalidate();
        frame.validate();
    }   
     
    //display menu to add add new customer
    public void changeToAddNewCustomer()
    {
        frame.removeAll();
        frame.add(pnlCustomerAddMain);
        frame.invalidate();
        frame.validate();
    }
}