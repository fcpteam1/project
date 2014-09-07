package GUI;

import model.Order;

public interface OrderTableListener {
	public void rowDeleted(int row);

	public void rowEdited(Order order);

	public void rowProcessed(Order order);
}
