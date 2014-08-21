import java.util.EventListener;

public interface OrderFormListener extends EventListener {
	public void formEventOccurred(OrderFormEvent e);
}
