package GUI;
import java.io.IOException;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SaleGui {


	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				try {
					new SaleMainPanel();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
