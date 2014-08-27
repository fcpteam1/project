package GUI;

public interface OrderTableListener {
	public void rowDeleted(int row);
	public void rowEdited(int row);
	public void rowProcessed(int row);
}
