package GUI;

import model.Order;

public interface OrderTableListener {
	public void rowDeleted(int id);

	public void rowEdited(int id);

	public void rowProcessed(int id);
}
