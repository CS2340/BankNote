package JUnit;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.example.banknote.model.Reports;
import com.example.banknote.model.Transaction;

/**
 * JUnit to test the detDateRange method of reports.
 * 
 * @author Brian Cann
 *
 */
public class getDateRangeTest {

	Reports reports;
	List<Transaction> transactions;
	Date beforeDate;
	
	@Before
	public void setup() {
		beforeDate = new Date();
		transactions = new ArrayList<Transaction>();
		for (int i = 0; i < 10; i++) {
            transactions.add(new Transaction("other", "groceries", false, 200.00d));
		}
		transactions.add(null);
		for (int i = 0; i < 10; i++) {
            transactions.add(new Transaction("job", "work", true, 200.00d));
		}
	}
	
	@Test
	public void testBeforeDates() {
	    reports.storeDate(new Date(), new Date());
	    setup();
	    List<Transaction> fullList = reports.getDateRange(transactions);
	    assertTrue(fullList.isEmpty());
	}
	
	@Test
	public void testNormalDates() {
		reports.storeDate(beforeDate, new Date());
		List<Transaction> fullList = reports.getDateRange(transactions);
		int counter = 0;
		for (Transaction t: fullList) {
			counter++;
		}
		assertEquals(counter, 20);
	}
	
	@Test
	public void testAfterDates() {
		reports.storeDate(new Date(), new Date());
		List<Transaction> fullList = reports.getDateRange(transactions);
		assertTrue(fullList.isEmpty());
	}
	
	@Test(expected=NullPointerException.class)
	public void testNullDates() throws NullPointerException {
		reports.storeDate(null, new Date());
		List<Transaction> fullList = reports.getDateRange(transactions);
	}
	
	@Test(expected=NullPointerException.class)
	public void testNullList() throws NullPointerException {
		reports.storeDate(beforeDate, new Date());
		reports.getDateRange(null);
	}
}
