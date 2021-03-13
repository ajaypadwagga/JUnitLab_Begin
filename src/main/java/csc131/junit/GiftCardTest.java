package csc131.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
//import org.junit.rules.ExpectedException;


public class GiftCardTest {

	@Test
	public void getIssuingStore()
	{
		double       balance;
		GiftCard     card; 
		int          issuingStore;
		
		issuingStore = 1337; 
		balance      = 100.00;
		card = new GiftCard(issuingStore, balance); 
		
		assertEquals("getIssuingStore()", issuingStore, card.getIssuingStore());
		
	}
	
	@Test
	public void getBalance()
	{
		double       balance;
		GiftCard     card; 
		int          issuingStore;
		
		issuingStore = 1337; 
		balance      = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getBalance()", balance, card.getBalance(), 0.001);
		
	}
	
	@Test
	public void deduct_RemainingBalance()
	{
		double       balance;
		GiftCard     card; 
		int          issuingStore;
		String		 s;
		
		issuingStore = 1337; 
		balance      = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		s = "Remaining Balance: " + String.format("%6.2f", 90.00);
		System.out.println(s);
		assertEquals("deduct(10.00)", s, card.deduct(10.0));
		
	}
	
	@Test
	public void deduct_AmountDue()
	{
		double       balance;
		GiftCard     card; 
		int          issuingStore;
		String		 s;
		
		issuingStore = 1337; 
		balance      = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		s = "Amount Due: " + String.format("%6.2f", 10.00);
		System.out.println(s);
		assertEquals("deduct 110.00 from 100.00", s, card.deduct(110.0));
	}
	
	@Test
	public void deduct_InvalidTransaction()
	{
		double       balance;
		GiftCard     card; 
		int          issuingStore;
		String		 s;
		
		issuingStore = 1337; 
		balance      = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		s = "Invalid Transaction";
		assertEquals("deduct -10.00 from 100.00", s, card.deduct(-10.0));
	}
	
	@Test
	public void testExc()
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.00);});
	}
	
	//(expected = IllegalArgumentException.class)
	//public void constructor_IncorrectBalance() throws IllegalArgumentException
	//{
	//	new GiftCard(1, -100.00);
	//}
	//assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.00);});
	
	
	@Test
	public void constructor_IncorrectID_Low()
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(-1,100.00);});
		//new GiftCard(-1, 100.00);
	}
	
	@Test
	public void constructor_IncorrectID_High()
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(100000000,100.00);});
		//new GiftCard(100000, 100.00);
	}
	
	
}
