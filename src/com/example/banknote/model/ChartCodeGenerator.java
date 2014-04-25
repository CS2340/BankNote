package com.example.banknote.model;

import java.util.ArrayList;
import java.util.List;

public class ChartCodeGenerator {
	
	static String content;
	static String datacontent = "";
	static String headcontent = "";
	static String footcontent = "";
	
	static public String updateColumnsChart(){
		headcontent = "<html>"
				+ "  <head>"
				+ "    <script type=\"text/javascript\" src=\"jsapi.js\"></script>"
				+ "    <script type=\"text/javascript\">"
				+ "      google.load(\"visualization\", \"1\", {packages:[\"corechart\"]});"
				+ "      google.setOnLoadCallback(drawChart);"
				+ "      function drawChart() {"
				+ "        var data = google.visualization.arrayToDataTable(["
				+ "          ['Accounts', 'Balance'],";
		datacontent="";
		List<ReportEntry> list = ReportSingle.getCurrentReport().getReportList();
		for (ReportEntry r : list)
		{
			if (!r.getCategory().equals("Total"))
			{
			datacontent = datacontent + "          ['" + r.getCategory() + " ',  " + r.getAmount() + "],";
			}
			
		}
		footcontent=
				  "        ]);"
				+ "        var options = {"
				+ "          title: 'Financial Accounts Overview',"
				+ "          hAxis: {title: 'Financial Accounts', titleTextStyle: {color: 'red'}}"
				+ "        };"
				+ "        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));"
				+ "        chart.draw(data, options);"
				+ "      }"
				+ "    </script>"
				+ "  </head>"
				+ "  <body>"
				+ "    <div id=\"chart_div\" style=\"width: 600px; height: 500px;\"></div>"
				+ "	   <img style=\"padding: 0; margin: 0 0 0 330px; display: block;\" src=\"truiton.png\"/>"
				+ "  </body>" + "</html>";
		
		content = headcontent + datacontent + footcontent;
		return content;
		
	}
	
	static public String updateDonutChart(){
		
		headcontent = "<html>"
 		  +"<head>"
 		  +"  <script type=\"text/javascript\" src=\"https://www.google.com/jsapi\"></script>"
 		  +" <script type=\"text/javascript\">"
 		  +"    google.load(\"visualization\", \"1\", {packages:[\"corechart\"]});"
 		  +"    google.setOnLoadCallback(drawChart);"
 		  +"    function drawChart() {"
 		  +"      var data = google.visualization.arrayToDataTable(["
 		  +"        ['Categories', 'Amount'],";
 		datacontent=""; 
		ArrayList<ReportEntry> list = (ArrayList<ReportEntry>) ReportSingle.getCurrentReport().getReportList();
 		 for (ReportEntry r : list)
 			{
 				if (!r.getCategory().equals("Total"))
 				{
 				datacontent = datacontent + "          ['" + r.getCategory() + " ',  " + r.getAmount() + "],";
 				}
 				
 			}
 		footcontent="      ]);"
 		  +"    var options = {"
 		  +"       title: 'Financial Report by Category',"
 		  +"        pieHole: 0.4,"
 		  +"      };"
 		  +"     var chart = new google.visualization.PieChart(document.getElementById('donutchart'));"
 		  +"      chart.draw(data, options);"
 		  +"   }"
 		  +"  </script>"
 		  +"</head>"
 		  +"<body>"
 		  +"  <div id=\"donutchart\" style=\"width: 400px; height: 500px;\"></div>"
 		  +"</body>"
 		  + "</html>";
 		content = headcontent + datacontent + footcontent;
		return content;
	}
	
	static public String updateAreaChart(List<ReportEntry> inList, List<ReportEntry> outList){
		headcontent = "<html>"
		  +"<head>"
		  +"  <script type=\"text/javascript\" src=\"https://www.google.com/jsapi\"></script>"
		  +"  <script type=\"text/javascript\">"
		  +"    google.load(\"visualization\", \"1\", {packages:[\"corechart\"]});"
		  +"    google.setOnLoadCallback(drawChart);"
		  +"    function drawChart() {"
		  +"      var data = google.visualization.arrayToDataTable(["
		  +"        ['Year', 'Income', 'Outcome'],";
		
		int i = 0;	
		for (  i = 0 ; i < inList.size(); i++ )
			{	
			datacontent = datacontent + "          ['"+ (String)(inList.get(i).getCategory()) + " ', 5.0 , 5.0 ],";
			}
		
	  footcontent = "      ]);"
		  +"      var options = {"
		  +"        title: 'Company Performance',"
		  +"        hAxis: {title: 'Month',  titleTextStyle: {color: '#333'}},"
		  +"        vAxis: {minValue: 0}"
		  +"      };"
		  +"      var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));"
		  +"      chart.draw(data, options);"
		  +"    }"
		  +"  </script>"
		  +"</head>"
		  +"<body>"
		  +"  <div id=\"chart_div\" style=\"width: 600px; height: 500px;\"></div>\""
		  +"</body>"
		  +"</html>";
		content = headcontent + datacontent + footcontent;
		return content;
	}

}
