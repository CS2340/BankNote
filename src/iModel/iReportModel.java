package iModel;

import java.util.Date;
import java.util.List;

import com.example.banknote.model.ReportEntry;

public interface iReportModel 
{

	void setDates(Date start, Date end);

	List<ReportEntry> getCatArray();

}
