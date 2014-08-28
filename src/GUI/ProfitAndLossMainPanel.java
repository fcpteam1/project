//package GUI;
//
//import javax.swing.JPanel;
//
//import javafx.application.Application;
//import javafx.embed.swing.JFXPanel;
//import javafx.scene.Scene;
//import javafx.scene.chart.BarChart;
//import javafx.scene.chart.CategoryAxis;
//import javafx.scene.chart.NumberAxis;
//import javafx.scene.chart.XYChart;
//import javafx.stage.Stage;
//import model.Model;
//
//
//public class ProfitAndLossMainPanel extends Application {
//	private Model model;
//	JFXPanel mainPanel = new JFXPanel();
//	
//	@Override public void start(Stage stage) {
//    	mainPanel.setName("Bar Chart Sample");
//    	final CategoryAxis xAxis = new CategoryAxis();
//    	final NumberAxis yAxis = new NumberAxis();
//    	final BarChart<String,Number> bc = 
//    			new BarChart<String,Number>(xAxis,yAxis);
//    	bc.setTitle("Supplier Summary");
//    	xAxis.setLabel("Supplier");       
//    	yAxis.setLabel("Products");
//    
//    	XYChart.Series series1 = new XYChart.Series();
//    	series1.setName("2003");       
//    	series1.getData().add(new XYChart.Data(model.getShop().getSuppliers().get(0).getName(), model.getShop().getSuppliers().get(0).getProducts().size()));
//    	series1.getData().add(new XYChart.Data(model.getShop().getSuppliers().get(1).getName(), model.getShop().getSuppliers().get(1).getProducts().size()));
//    	series1.getData().add(new XYChart.Data(model.getShop().getSuppliers().get(2).getName(), model.getShop().getSuppliers().get(2).getProducts().size()));
//        
//    
//    	/*XYChart.Series series2 = new XYChart.Series();
//    	series2.setName("2004");
//    	series2.getData().add(new XYChart.Data(suppliers.get(0).getName(), suppliers.get(0).getProducts()));
//    	series2.getData().add(new XYChart.Data(suppliers.get(1).getName(), suppliers.get(1).getProducts()));
//    
//    	XYChart.Series series3 = new XYChart.Series();
//    	series3.setName("2005");
//    	series3.getData().add(new XYChart.Data(suppliers.get(0).getName(), suppliers.get(0).getProducts()));
//    	series3.getData().add(new XYChart.Data(suppliers.get(1).getName(), suppliers.get(1).getProducts()));
//    	*/
//    	Scene scene  = new Scene(bc,800,600);
//    	bc.getData().addAll(series1);
//    	mainPanel.setScene(scene);
//    	mainPanel.show();
//}
//
//	public JFXPanel getPanel(){
//		return mainPanel;
//		
//	}
//}
