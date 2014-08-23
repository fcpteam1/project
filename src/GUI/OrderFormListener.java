package GUI;
import java.util.EventListener;

public interface OrderFormListener extends EventListener {
	public void createOrderOccurred(OrderFormEvent e);
	public void editOrderOccurred(OrderFormEvent e);
	public void deleteOrderOccurred(OrderFormEvent e);
	public void processOrderOccurred(OrderFormEvent e);
}
