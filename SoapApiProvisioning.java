/**
 * 
 */
package pCRFTestAutomation_Annotations;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;


/**
 * @author TssUser
 *
 */
public class SoapApiProvisioning 
	{
		String ACCOUNTNO;
		String ALTERNATENO;
		String APIPASSWORD = "ta5h13ell";
		String APIUSER = "TCELL";
		String CREATIONDATE;
		String DATETIME = "211021121501";
		String MSISDN = "97577999039";
		String MSISDN1 = "97577999166";
		String CHILD = MSISDN1; 
		String MSPASSWORD = "1234";
		//String RATEPLAN = "10000";
		String RATEPLAN = "1971153396";
		String SCPID = "5";
		String SPID = "5";
		String TRANSACTIONID;
		String SOAPURI = "http://10.70.90.72/fcgi-bin/services";
		
		@Test
		public void PCRF_SOAP_API_RetrieveSubscriber() throws IOException
		{
			FileInputStream fileinputstream=new FileInputStream(".\\SoapAPIFiles\\PCRF_SOAP_API_RetrieveSubscriber.xml");
			String body = IOUtils.toString(fileinputstream, "UTF-8");
			String resultCodePath = "Envelope.Body.retriveSubscriberResponse.return.resultCode";
			body = body.replace("__APIUSER__", APIUSER);
			body = body.replace("__APIPASSWORD__", APIPASSWORD);
			body = body.replace("__MSISDN__", MSISDN);
			body = body.replace("__DATETIME__", DATETIME);
			RestAssured.baseURI=SOAPURI;
			Response response=
					given()
					 .header("Content-Type", "text/xml")
					 .and()
					 .body(body)
					.when()
					 .post("/SubscriberProv")
					.then()
					 .statusCode(200)
					 .and()
					 .log().all().extract().response();
			XmlPath xmlpath=new XmlPath(response.asString());
			String pcrfresp = xmlpath.get(resultCodePath).toString();
			System.out.println("XML return code is "+pcrfresp);
			Assert.assertEquals(pcrfresp, "0", "INVALID RESULT-CODE");
		}
		
		@Test
		public void PCRF_SOAP_API_RemoveSubscriber() throws IOException
		{
			FileInputStream fileinputstream=new FileInputStream(".\\SoapAPIFiles\\PCRF_SOAP_API_RemoveSubscriber.xml");
			String body = IOUtils.toString(fileinputstream, "UTF-8");
			String resultCodePath = "Envelope.Body.removeSubscriberResponse.return.resultCode";
			body = body.replace("__APIUSER__", APIUSER);
			body = body.replace("__APIPASSWORD__", APIPASSWORD);
			body = body.replace("__MSISDN__", MSISDN);
			body = body.replace("__DATETIME__", DATETIME);
			RestAssured.baseURI=SOAPURI;
			Response response=
					given()
					 .header("Content-Type", "text/xml")
					 .and()
					 .body(body)
					.when()
					 .post("/SubscriberProv")
					.then()
					 .statusCode(200)
					 .and()
					 .log().all().extract().response();
			XmlPath xmlpath=new XmlPath(response.asString());
			String pcrfresp = xmlpath.get(resultCodePath).toString();
			System.out.println("XML return code is "+pcrfresp);
			Assert.assertEquals(pcrfresp, "0", "INVALID RESULT-CODE");
		}
		
		@Test
		public void PCRF_SOAP_API_AddSubscriber() throws IOException
		{
			FileInputStream fileinputstream=new FileInputStream(".\\SoapAPIFiles\\PCRF_SOAP_API_AddSubscriber.xml");
			String body = IOUtils.toString(fileinputstream, "UTF-8");
			String resultCodePath = "Envelope.Body.addSubscriberResponse.return.resultCode";
			body = body.replace("__APIUSER__", APIUSER);
			body = body.replace("__APIPASSWORD__", APIPASSWORD);
			body = body.replace("__MSISDN__", MSISDN);
			body = body.replace("__DATETIME__", DATETIME);
			body = body.replace("__RATEPLAN__", RATEPLAN);
			body = body.replace("__SCPID__", SCPID);
			body = body.replace("__SPID__", SPID);
			RestAssured.baseURI=SOAPURI;
			Response response=
					given()
					 .header("Content-Type", "text/xml")
					 .and()
					 .body(body)
					.when()
					 .post("/SubscriberProv")
					.then()
					 .statusCode(200)
					 .and()
					 .log().all().extract().response();
			XmlPath xmlpath=new XmlPath(response.asString());
			String pcrfresp = xmlpath.get(resultCodePath).toString();
			System.out.println("XML return code is "+pcrfresp);
			Assert.assertEquals(pcrfresp, "0", "INVALID RESULT-CODE");
		}	
		
		@Test (priority = 10, description = "Pack purchase Status Check from PCRF DB")
		public void PCRF_PackStatusQuery(){
		   given().when().get("http://10.70.90.72/cgi-bin/ssSystemApi?command=QUERY&message=packsubstatus," + MSISDN + "," + RATEPLAN).then().log()
		  .all();
		}
		
		@Test
		public void PCRF_SOAP_API_AddUpdateSubscriber() throws IOException
		{
			FileInputStream fileinputstream=new FileInputStream(".\\SoapAPIFiles\\PCRF_SOAP_API_AddUpdateSubscriber.xml");
			String body = IOUtils.toString(fileinputstream, "UTF-8");
			String resultCodePath = "Envelope.Body.addUpdateSubscriberResponse.return.resultCode";
			RATEPLAN = "310481551";
			body = body.replace("__APIUSER__", APIUSER);
			body = body.replace("__APIPASSWORD__", APIPASSWORD);
			body = body.replace("__MSISDN__", MSISDN);
			body = body.replace("__DATETIME__", DATETIME);
			body = body.replace("__RATEPLAN__", RATEPLAN);
			body = body.replace("__SCPID__", SCPID);
			body = body.replace("__SPID__", SPID);
			RestAssured.baseURI=SOAPURI;
			Response response=
					given()
					 .header("Content-Type", "text/xml")
					 .and()
					 .body(body)
					.when()
					 .post("/SubscriberProv")
					.then()
					 .statusCode(200)
					 .and()
					 .log().all().extract().response();
			XmlPath xmlpath=new XmlPath(response.asString());
			String pcrfresp = xmlpath.get(resultCodePath).toString();
			System.out.println("XML return code is "+pcrfresp);
			Assert.assertEquals(pcrfresp, "0", "INVALID RESULT-CODE");
		}

		@Test
		public void PCRF_SOAP_API_AddUpdateSubs() throws IOException
		{
			FileInputStream fileinputstream=new FileInputStream(".\\SoapAPIFiles\\PCRF_SOAP_API_AddUpdateSubscriber.xml");
			String body = IOUtils.toString(fileinputstream, "UTF-8");
			String resultCodePath = "Envelope.Body.addUpdateSubscriberResponse.return.resultCode";
			RATEPLAN = "310481551";
			body = body.replace("__APIUSER__", APIUSER);
			body = body.replace("__APIPASSWORD__", APIPASSWORD);
			body = body.replace("__MSISDN__", MSISDN);
			body = body.replace("__DATETIME__", DATETIME);
			body = body.replace("__RATEPLAN__", RATEPLAN);
			body = body.replace("__SCPID__", SCPID);
			body = body.replace("__SPID__", SPID);
			RestAssured.baseURI=SOAPURI;
			Response response=
					given()
					 .header("Content-Type", "text/xml")
					 .and()
					 .body(body)
					.when()
					 .post("/SubscriberProv")
					.then()
					 .statusCode(200)
					 .and()
					 .log().all().extract().response();
			XmlPath xmlpath=new XmlPath(response.asString());
			String pcrfresp = xmlpath.get(resultCodePath).toString();
			System.out.println("XML return code is "+pcrfresp);
			Assert.assertEquals(pcrfresp, "0", "INVALID RESULT-CODE");
		}
		
		@Test
		public void PCRF_SOAP_API_SharePacks() throws IOException
		{
			FileInputStream fileinputstream=new FileInputStream(".\\SoapAPIFiles\\PCRF_SOAP_API_SharePackage.xml");
			String body = IOUtils.toString(fileinputstream, "UTF-8");
			String resultCodePath = "Envelope.Body.shareSubscriberResponse.return.resultCode";
			body = body.replace("__APIUSER__", APIUSER);
			body = body.replace("__APIPASSWORD__", APIPASSWORD);
			body = body.replace("__MSISDN__", MSISDN);
			body = body.replace("__CHILD__", CHILD);
			body = body.replace("__RATEPLAN__", RATEPLAN);
			RestAssured.baseURI=SOAPURI;
			Response response=
					given()
					 .header("Content-Type", "text/xml")
					 .and()
					 .body(body)
					.when()
					 .post("/SubscriberProv")
					.then()
					 .statusCode(200)
					 .and()
					 .log().all().extract().response();
			XmlPath xmlpath=new XmlPath(response.asString());
			String pcrfresp = xmlpath.get(resultCodePath).toString();
			System.out.println("XML return code is "+pcrfresp);
			Assert.assertEquals(pcrfresp, "0", "INVALID RESULT-CODE");
		}

	}
