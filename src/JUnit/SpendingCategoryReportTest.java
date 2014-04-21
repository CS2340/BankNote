package JUnit;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.example.banknote.model.Account;
import com.example.banknote.model.ReportEntry;
import com.example.banknote.model.SpendingCategoryReport;
import com.example.banknote.model.Transaction;
import com.example.banknote.model.User;
import com.example.banknote.model.UserSingle;

public class SpendingCategoryReportTest {

	
	User user;
	Account a1;
	Account	a2;
	Transaction t1_1;
	Transaction t1_2;
	Transaction t2_1;
	Transaction t2_2;
	String cat1 = "cat1";
	String cat2 = "cat2";
	String cat3 = "cat3";
	
	Date start;
	Date end;
	
	
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception 
	{
		User u = new User();
		u.setName("Bob");
		UserSingle.getInstance().setCurrentUser(u);
		user = u;
		a1 = new Account();
		a2 = new Account();
		t1_1 = new Transaction();
		t1_2 = new Transaction();
		t2_1 = new Transaction();
		t2_2 = new Transaction();
		
		t1_1.setType(cat1);
		t1_2.setType(cat2);
		t2_1.setType(cat3);
		t2_2.setType(cat3);
		
		t1_1.setAmount(1);
		t1_2.setAmount(1);
		t2_1.setAmount(1);
		t2_2.setAmount(1);
		
		
		t1_1.setRecordedTime();
		t1_2.setRecordedTime();
		t2_1.setRecordedTime();
		t2_2.setRecordedTime();
		
		a1.getHistory().addNewTrans(t1_1);
		a1.getHistory().addNewTrans(t1_2);
		a2.getHistory().addNewTrans(t2_1);
		a2.getHistory().addNewTrans(t2_2);
		
		user.addAccount(a1);
		user.addAccount(a2);
		
		start = new Date(00, 01, 01);
		end = new Date(2200, 01, 1);
	}

	@Test
	public void test() 
	{
		SpendingCategoryReport r = new SpendingCategoryReport(start,end);
		ArrayList<ReportEntry> l = r.getCatArray();
		for (ReportEntry e: l)
		{
			System.out.println(e.toString());
		}
	}

}
