
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SupplierGUI  {

	private JPanel showPanel,holder,viewSupplierPanel,viewProductsPanel;
	private JButton viewSuppliers,viewProducts,returnFromSuppliers,returnFromProducts;
	private JLabel viewingSuppliers,viewingProducts;
	private ActionListener returnListener;
	
	
	public SupplierGUI() {
		// TODO Auto-generated constructor stub
		
		showPanel=new JPanel();
		holder=new JPanel();
		holder.setLayout(new BorderLayout());
		
		viewSupplierPanel=new JPanel();
		viewProductsPanel=new JPanel();
		
		viewSupplierPanel.setLayout(new BorderLayout());
		viewProductsPanel.setLayout(new BorderLayout());
		
		
		viewSuppliers=new JButton("View All");
		viewProducts=new JButton("View Products");
		
		viewingSuppliers=new JLabel("Viewing Suppliers");
		viewingProducts=new JLabel("Viewing Products");
		
		returnListener=new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				backToMainPanel();
			}
		};
		
		viewSuppliers.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				focusViewSuppliers();
			}
		});
		
		viewProducts.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				focusViewProducts();
			}
		});
		
		viewSupplierPanel.add(viewingSuppliers,BorderLayout.CENTER);
		viewProductsPanel.add(viewingProducts,BorderLayout.CENTER);
		holder.add(viewSuppliers,BorderLayout.EAST);
		holder.add(viewProducts,BorderLayout.CENTER);
		
		returnFromSuppliers=new JButton("Return");
		returnFromProducts=new JButton("Return");
		
		returnFromSuppliers.addActionListener(returnListener);
		returnFromProducts.addActionListener(returnListener);
		
		viewSupplierPanel.add(returnFromSuppliers, BorderLayout.SOUTH);
		viewProductsPanel.add(returnFromProducts, BorderLayout.SOUTH);
		
		showPanel.add(holder);
		
	}
	
	
	public JPanel getPanel(){
		
		
		return showPanel;
	}

	public void backToMainPanel(){
		
		showPanel.removeAll();
		showPanel.add(holder);
		
		showPanel.validate();
		showPanel.repaint();
		
	}
	
	public void focusViewSuppliers(){
		showPanel.removeAll();
		showPanel.add(viewSupplierPanel);
		
		showPanel.validate();
		showPanel.repaint();
	}
	
	
	public void focusViewProducts(){
		
		showPanel.removeAll();
		showPanel.add(viewProductsPanel);
		
		showPanel.validate();
		showPanel.repaint();
		
	}
}
