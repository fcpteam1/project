package GUI;
import java.util.EventListener;

public interface OrderFormListener extends EventListener {
	public void createOrderOccurred(OrderFormEvent e);
}
