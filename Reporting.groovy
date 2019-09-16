package customReports

import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Formatter
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory

public class Reporting {
	static DateFormat dateFormat = new SimpleDateFormat("hhmmss");
	static Date date = new Date();
	private static Formatter file;
	private static FileWriter f;
	private static String fileName = "Report_" + dateFormat.format(date);
	private static String csvFileName = fileName + ".csv";
	private static String htmlFileName = fileName + ".html";
	private static String htmlHeader = "<html>" +
	"<body>" +
	"<h1 align='center'>"+ fileName +"</h1>" +
	"<table border = '1' align='center'>" +
	"<tr>" +
	"<th>Test Summary</th>" +
	"<th>Test Status</th>" +
	"</tr>";
	private static String htmlFooter = "</table>" +
	"</body>" +
	"</html>";
	private static String htmlTableRows = "";
	private static String cellColorGreen = "#32CD32";
	private static String cellColorRed = "#FF0000";

	@Keyword
	def setTestCasePass(String reportsDirectory, String testSummary) {
		String csvFilePath = reportsDirectory + "/" + csvFileName;

		try {
			f = new FileWriter(csvFilePath, true);
			file = new Formatter(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		file.format("\"%s\",PASS\n", testSummary);
		htmlTableRows = htmlTableRows + "<tr><td>"+testSummary+"</td><td bgcolor='"+cellColorGreen+"'>PASS</td></tr>";
		file.close();
	}

	@Keyword
	def setTestCaseFail(String reportsDirectory, String testSummary) {
		String csvFilePath = reportsDirectory + "/" + csvFileName;

		try {
			f = new FileWriter(csvFilePath, true);
			file = new Formatter(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		file.format("\"%s\",FAIL\n", testSummary);
		htmlTableRows = htmlTableRows + "<tr><td>"+testSummary+"</td><td bgcolor='"+cellColorRed+"'>FAIL</td></tr>";
		file.close();
	}

	@Keyword
	def setTestCaseBlocked(String reportsDirectory, String testSummary) {
		String csvFilePath = reportsDirectory + "/" + csvFileName;

		try {
			f = new FileWriter(csvFilePath, true);
			file = new Formatter(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		file.format("\"%s\",BLOCKED\n", testSummary);
		htmlTableRows = htmlTableRows + "<tr><td>"+testSummary+"</td><td>BLOCKED</td></tr>";
		file.close();
	}

	@Keyword
	def validateCondition(boolean condition, String reportsDirectory, String testSummary) {
		String csvFilePath = reportsDirectory + "/" + csvFileName;
		try {
			f = new FileWriter(csvFilePath, true);
			file = new Formatter(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (condition == true) {
			file.format("\"%s\",PASS\n", testSummary);
			htmlTableRows = htmlTableRows + "<tr><td>"+testSummary+"</td><td bgcolor='"+cellColorGreen+"'>PASS</td></tr>";
		}
		else {
			file.format("\"%s\",FAIL\n", testSummary);
			htmlTableRows = htmlTableRows + "<tr><td>"+testSummary+"</td><td bgcolor='"+cellColorRed+"'>FAIL</td></tr>";
		}
		file.close();
	}

	@Keyword
	def generateHTMLReport(String reportsDirectory) {
		String htmlFilePath = reportsDirectory + "/" + htmlFileName;
		try {
			f = new FileWriter(htmlFilePath, false);
			file = new Formatter(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		file.format("%s%s%s", htmlHeader, htmlTableRows, htmlFooter);
		file.close();
	}
}
