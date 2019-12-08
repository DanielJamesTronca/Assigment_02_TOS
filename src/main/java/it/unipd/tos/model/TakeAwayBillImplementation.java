//Daniel James Tronca 1168535
package it.unipd.tos.model;
import java.util.List;
import it.unipd.tos.business.TakeAwayBill;
import it.unipd.tos.model.MenuItem;
public class TakeAwayBillImplementation implements TakeAwayBill {
public double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException{
double total=0.0;
double cheapest=-1;
int paniniCount=0;
double paniniFrittiCount=0.0;
if (itemsOrdered.size() > 30) {
throw new TakeAwayBillException("Sono stati fatti troppi ordini.");
}
for(MenuItem item: itemsOrdered) {
total += item.getPrice();
if(item.getType() == "PANINO") {
paniniCount++;
double paninoPrice = item.getPrice();
paniniFrittiCount += paninoPrice;
if(paninoPrice < cheapest || cheapest < 0.0) {
cheapest = paninoPrice;
}
}
else if(item.getType() == "FRITTO") {
paniniFrittiCount += item.getPrice();
}
}
if(paniniFrittiCount > 50) {
total *= 0.9; 
}
if(paniniCount > 5) {
total -= cheapest / 2;
}
if (total < 10) {
total += 0.5;
}
return total;
}
}
