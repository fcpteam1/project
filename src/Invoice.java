import java.text.DateFormat;
import java.util.Date;


public class Invoice {

	private Date date = new Date();
	private DateFormat format = DateFormat.getDateInstance();
	private double totalPrice;
	
	public Invoice(){
		this.totalPrice = 0;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public DateFormat getFormat() {
		return format;
	}

	public void setFormat(DateFormat format) {
		this.format = format;
	}
}
