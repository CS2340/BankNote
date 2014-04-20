package presenter;

import iModel.iReportModel;
import iView.iReportView;

import java.util.Date;
import java.util.List;

import com.example.banknote.model.ReportEntry;
import com.example.banknote.model.SpendingCategoryReport;
import com.example.banknote.view.ReportActivity;

public class ReportPresenter 
{
	iReportView view;
	iReportModel model;
	
	public ReportPresenter(ReportActivity reportActivity) 
	{
		view = reportActivity;
		model = new SpendingCategoryReport();
	}

	public void reportButtonClicked() 
	{
    	Date start = view.getStartDate();
    	Date end = view.getEndDate();
		if (start == null || end == null) 
		{
            String message = "Must select dates";
            view.displyMessage(message);
        } 
    	else // (dates are set)
        {
    		model.setDates(start, end);
            List<ReportEntry> list = model.getCatArray();
            view.displayListVeiw(list);
        }		
	}
}
