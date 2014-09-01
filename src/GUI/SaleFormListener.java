package GUI;

import java.util.EventListener;

public interface SaleFormListener extends EventListener {

	public void createSaleOccurred(SaleFormEvent e);

	public void editSaleOccurred(SaleFormEvent e, int id);
}
