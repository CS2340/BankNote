package iView;

import java.util.Date;
import java.util.List;

import com.example.banknote.model.ReportEntry;

public interface iReportView {

	Date getStartDate();

	Date getEndDate();

	void displyMessage(String message);

	void displayListVeiw(List<ReportEntry> list);

}
