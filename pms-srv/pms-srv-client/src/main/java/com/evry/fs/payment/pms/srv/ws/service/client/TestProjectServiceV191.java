package com.evry.fs.payment.pms.srv.ws.service.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class TestProjectServiceV191 {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("Please enter the following option ");
			System.out.println("1 -> Add Project");
			System.out.println("2 -> Delete Project");
			System.out.println("3 -> Get All Projects");
			System.out.println("4 -> Get Project Info");
			System.out.println("5 -> Update Project");
			System.out.println("6 -> Exit");
			String strXml;
			String projectId;
			String projectName;
			int token = 0;
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:

				System.out.println("Please enter project id");
				projectId = scanner.next();
				System.out.println("Please enter project Name");
				projectName = scanner.next();
				System.out.println("Please enter project Status");
				String projectStatus = scanner.next();
				System.out.println("Please enter estimated hrs");
				int estimatedHr = scanner.nextInt();
				System.out.println("Please enter Logged hrs");
				int loggedHr = scanner.nextInt();
				System.out.println("Please enter remaining hrs");
				int remainingHr = scanner.nextInt();
				strXml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pms=\"http://evry.com/fs/payment/pms\">"
						+ "<soapenv:Header/>" + "<soapenv:Body>" + "<pms:addProjectRequestType>"
						+ "<pms:ProjectDetailsType><pms:projectId>" + projectId + "</pms:projectId><pms:projectName>"
						+ projectName + "</pms:projectName><pms:projectStatus>" + projectStatus + "</pms:projectStatus>"
						+ "<pms:estimatedHrs>" + estimatedHr + "</pms:estimatedHrs><pms:loggedHrs>" + loggedHr
						+ "</pms:loggedHrs> <pms:remainingHrs>" + remainingHr
						+ "</pms:remainingHrs></pms:ProjectDetailsType>"
						+ "</pms:addProjectRequestType></soapenv:Body></soapenv:Envelope>";
				sendRequest(strXml, token);
				break;
			case 2:
				System.out.println("Please enter deleted project id");
				projectId = scanner.next();
				strXml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pms=\"http://evry.com/fs/payment/pms\">"
						+ "<soapenv:Header/>" + "<soapenv:Body>" + " <pms:deleteProjectRequestType>"
						+ "         <pms:projectId>" + projectId + "</pms:projectId>"
						+ "</pms:deleteProjectRequestType>" + "   </soapenv:Body>" + "</soapenv:Envelope>";
				sendRequest(strXml, token);
				break;
			case 3:
				strXml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pms=\"http://evry.com/fs/payment/pms\">"
						+ "<soapenv:Header/>" + "<soapenv:Body>" + "<pms:getAllProjectsRequestType/>"
						+ "</soapenv:Body>" + "</soapenv:Envelope>";
				token = 1;
				sendRequest(strXml, token);
				break;
			case 4:
				System.out.println("Please enter project id");
				projectId = scanner.next();
				strXml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pms=\"http://evry.com/fs/payment/pms\">"
						+ "<soapenv:Header/>" + "<soapenv:Body>" + "<pms:getProjectInfoRequestType> <pms:projectId>"
						+ projectId
						+ "</pms:projectId></pms:getProjectInfoRequestType></soapenv:Body></soapenv:Envelope>";
				token = 1;
				sendRequest(strXml, token);
				break;
			case 5:
				System.out.println("Please enter updated project id");
				projectId = scanner.next();
				System.out.println("Please enter updated project name");
				projectName = scanner.next();
				strXml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pms=\"http://evry.com/fs/payment/pms\">"
						+ "<soapenv:Header/>" + "<soapenv:Body>  <pms:updateProjectRequestType>" + "<pms:projectId>"
						+ projectId + "</pms:projectId>" + "<pms:projectName>" + projectName + "</pms:projectName>"
						+ "</pms:updateProjectRequestType>" + "</soapenv:Body>" + "</soapenv:Envelope>";
				sendRequest(strXml, token);
				break;

			case 6:
				flag = false;
				break;
			default:
				System.out.println("Please choose proper option.");
				break;
			}
		}
	}

	public static void sendRequest(String request, int token) throws Exception {

		String httpRequestURL = "http://localhost:3456/pms-srv-ws/services/wsservice/projectServiceV191?wsdl";
		String soapRequestParam = request;
		String responseString = testProjectService(httpRequestURL, soapRequestParam, token);
		System.out.println("Response String : " + responseString);
	}

	/**
	 * This method uses HttpURLConnection to invoke exposed SOAP web service and
	 * returns the response string to the calling client
	 * 
	 * @param httpRequestURL
	 * @param requestXmlParam
	 * @return responseXML
	 * @throws IOException
	 */
	public static String testProjectService(String httpRequestURL, String requestXmlParam, int token) throws Exception {

		// local variables
		URL url = null;
		HttpURLConnection httpURLConnection = null;
		OutputStreamWriter outputStreamWriter = null;
		String responseMessageFromServer = null;
		String responseXML = null;

		try {
			// set basic request parameters
			url = new URL(httpRequestURL);
			httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setRequestMethod("GET");
			// httpURLConnection.setRequestProperty("SOAPAction", "");
			httpURLConnection.setRequestProperty("Content-Type", "text/xml");
			httpURLConnection.setRequestProperty("Accept", "text/xml");

			// write request XML to the HTTP request
			outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
			outputStreamWriter.write(requestXmlParam);
			outputStreamWriter.flush();

			System.out.println("Response code: " + httpURLConnection.getResponseCode());
			if (httpURLConnection.getResponseCode() == 200) {

				responseMessageFromServer = httpURLConnection.getResponseMessage();
				System.out.println("ResponseMessageFromServer: " + responseMessageFromServer);
				if (token == 0) {
					responseXML = getResponseXML(httpURLConnection);
				} else {
					getData(httpURLConnection);
				}
			}
		} catch (IOException ioex) {
			ioex.printStackTrace();
			throw ioex;
		} finally {
			// finally close all operations
			outputStreamWriter.close();
			httpURLConnection.disconnect();
		}
		return responseXML;
	}

	private static void getData(HttpURLConnection httpURLConnection) throws Exception {

		// local variables
		StringBuffer stringBuffer = new StringBuffer();
		BufferedReader bufferedReader = null;
		InputStreamReader inputStreamReader = null;
		String readSingleLine = null;

		try {
			// read the response stream AND buffer the result into a StringBuffer
			inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
			bufferedReader = new BufferedReader(inputStreamReader);

			// reading the XML response content line BY line
			while ((readSingleLine = bufferedReader.readLine()) != null) {
				stringBuffer.append(readSingleLine);
			}
			String xmlString = stringBuffer.toString();
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource src = new InputSource();
			src.setCharacterStream(new StringReader(xmlString));

			Document doc = builder.parse(src);
			NodeList nodeList = doc.getChildNodes().item(0).getChildNodes().item(0).getChildNodes().item(0).getChildNodes();
			int length = nodeList.getLength();
			System.out.println("Project Id\tProject Name\tprojectStatus\testimatedHrs\tloggedHrs\tremainingHrs");
			String projectId;
			String projectName;
			String projectStatus;
			String estimatedHrs;
			String loggedHrs;
			String remainingHrs;
			for (int i = 0; i < length; i++) {
				projectId = doc.getElementsByTagName("projectId").item(i).getTextContent();
				projectName = doc.getElementsByTagName("projectName").item(i).getTextContent();
				projectStatus = doc.getElementsByTagName("projectStatus").item(i).getTextContent();
				estimatedHrs = doc.getElementsByTagName("estimatedHrs").item(i).getTextContent();
				loggedHrs = doc.getElementsByTagName("loggedHrs").item(i).getTextContent();
				remainingHrs = doc.getElementsByTagName("remainingHrs").item(i).getTextContent();
				System.out.println(projectId + "\t\t" + projectName + "\t\t\t" + projectStatus + "\t\t" + estimatedHrs
						+ "\t\t" + loggedHrs + "\t\t" + remainingHrs);
			}

		} catch (IOException ioex) {
			ioex.printStackTrace();
			throw ioex;
		} finally {
			// finally close all operations
			bufferedReader.close();
			httpURLConnection.disconnect();
		}
	}

	/**
	 * This method is used to get response XML from the HTTP POST request
	 * 
	 * @param httpURLConnection
	 * @return stringBuffer.toString()
	 * @throws IOException
	 */
	private static String getResponseXML(HttpURLConnection httpURLConnection) throws Exception {

		// local variables
		StringBuffer stringBuffer = new StringBuffer();
		BufferedReader bufferedReader = null;
		InputStreamReader inputStreamReader = null;
		String readSingleLine = null;

		try {
			// read the response stream AND buffer the result into a StringBuffer
			inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
			bufferedReader = new BufferedReader(inputStreamReader);

			// reading the XML response content line BY line
			while ((readSingleLine = bufferedReader.readLine()) != null) {
				stringBuffer.append(readSingleLine);
			}
		} catch (IOException ioex) {
			ioex.printStackTrace();
			throw ioex;
		} finally {
			// finally close all operations
			bufferedReader.close();
			httpURLConnection.disconnect();
		}
		return stringBuffer.toString();
	}

}
