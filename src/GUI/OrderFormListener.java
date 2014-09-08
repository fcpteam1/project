package GUI;

import java.util.EventListener;

//the two listener events needed to create and edit orders
//these take in required data for the particular event
public interface OrderFormListener extends EventListener {
	public void createOrderOccurred(OrderFormEvent e);

	public void editOrderOccurred(OrderFormEvent e, int id);
}
