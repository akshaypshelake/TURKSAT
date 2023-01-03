/**
 * 
 */
package pCRFTestAutomation_Annotations;

import static io.restassured.RestAssured.given;
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
public class USSD_PackFCGIApi 
	{
		String ACCOUNTNO;
		String ALTERNATENO;
		String APIPASSWORD = "ta5h13ell";
		String APIUSER = "TCELL";
		String CREATIONDATE;
		String DATETIME = "211021121501";
		String MSISDN = "97577999037";
		String MSISDN1 = "97577999166";
		String MSPASSWORD = "1234";
		//String RATEPLAN = "10000";
		String RATEPLAN = "1971153396";
		String SCPID = "5";
		String SPID = "5";
		String TRANSACTIONID = "1234567890";
		
		@Test
		public void PCRF_USSD_API_BuyPack() throws IOException
		{
			FileInputStream fileinputstream=new FileInputStream(".\\FcgiAPIFiles\\UssdPackPurchase.xml");
			String body = IOUtils.toString(fileinputstream, "UTF-8");
			body = body.replace("__APIUSER__", APIUSER);
			body = body.replace("__APIPASSWORD__", APIPASSWORD);
			body = body.replace("__MSISDN__", MSISDN);
			body = body.replace("__DATETIME__", DATETIME);
			body = body.replace("__TRANSACTIONID__", TRANSACTIONID);
			RestAssured.baseURI="http://10.70.90.72/fcgi-bin";
			Response response=
					given()
					 .header("Content-Type", "text/xml")
					 .and()
					 .body(body)
					.when()
					 .post("/WDBS_ussdPackProvision.fcgi")
					.then()
					 .statusCode(200)
					 .and()
					 .log().all().extract().response();
			XmlPath xmlpath=new XmlPath(response.asString());
			String pcrfresp=xmlpath.getString("Returncode");
			System.out.println("XML return code is "+pcrfresp);
		}
	}		
		
		
