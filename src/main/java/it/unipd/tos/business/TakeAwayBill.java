//Daniel James Tronca 1168535
package it.unipd.tos.business;
import java.util.List; 
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.TakeAwayBillException;
public interface TakeAwayBill {
double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException;
}
