//Same set up as Customer Form Listener

package GUI;

import java.util.EventListener;

public interface UserFormListener extends EventListener {
	public void formEventOccurred(UserFormEvent e);

	public void editFormEventOccurred(UserFormEvent ee);
}
