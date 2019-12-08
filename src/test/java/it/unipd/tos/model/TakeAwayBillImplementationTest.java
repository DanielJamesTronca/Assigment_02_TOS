package it.unipd.tos.model;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
import it.unipd.tos.model.*;

public class TakeAwayBillImplementationTest {
private TakeAwayBillImplementation orders= new TakeAwayBillImplementation();

	@Test
	public void VerificaTotparia0Con0elementi() throws TakeAwayBillException{
		List <MenuItem> orderList= new ArrayList<MenuItem>();
		assertEquals(orders.getOrderPrice(orderList),0, 0);
	}

	@Test
	public void CalcolaTotpiudi5panini() throws TakeAwayBillException {
		List <MenuItem> orderList= new ArrayList<MenuItem>();
		for (int i=0; i<6; i++) {
			MenuItem m= new MenuItem();
			m.setPrice(5);
			orderList.add(m);
		}
		assertEquals(orders.getOrderPrice(orderList),27.5, 0);
	}

   @Test
   public void ApplicaSconto10seTotalepiudi50euro() throws TakeAwayBillException{
	   List <MenuItem> orderList= new ArrayList<MenuItem>();
		for (int i=0; i<6; i++) {
			MenuItem m= new MenuItem();
			m.setType(MenuItem.ItemType.FRITTO);
			orderList.add(m);
		}
		assertEquals(orders.getOrderPrice(orderList),54, 0);
   }
 
   @Test
   public void AggiungiCommissioneDi50centesimisottoi10euroDitotale() throws TakeAwayBillException{
	   List <MenuItem> orderList= new ArrayList<MenuItem>();
		for (int i=0; i<5; i++) {
			MenuItem m= new MenuItem();
		    m.setPrice(1);
			orderList.add(m);
		}
		assertEquals(orders.getOrderPrice(orderList),5.5, 0);
   }
   
   @Test(expected = TakeAwayBillException.class)
   public void lanciaeccezioneConpiudi30elementiOrdinati() throws TakeAwayBillException {
	   List <MenuItem> orderList= new ArrayList<MenuItem>();
		for (int i=0; i<31; i++) {
			MenuItem m= new MenuItem();
			orderList.add(m);
		}
		System.out.println(orders.getOrderPrice(orderList));
   }

}
