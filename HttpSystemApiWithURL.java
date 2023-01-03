package pCRFTestAutomation_Annotations;
import static io.restassured.RestAssured.given;
import java.util.UUID;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class HttpSystemApiWithURL {
		String MSISDN = "97577999037";
		//String SESSIONID = "00b39673edfcb6338b57";
		String SESSIONID = UUID.randomUUID().toString();
		String RATEPLAN = "1971153396";
		//String TestURL = "http://10.70.90.72/cgi-bin/ssSystemApi";
		String TestURL = "http://10.0.0.208/cgi-bin/ssSystemApi";
		
		@Test (priority = -2, description = "Subs Status Check from PCRF DB")
		public void PCRF_SubStatusQuery(){
			Response response=
		   given()
		   .when()
		   .get(TestURL + "?command=QUERY&message=substatus," + MSISDN)
		   .then()
		   .statusCode(200)
		   .and()
		   .log()
		   .all().extract().response();
		   XmlPath xmlpath=new XmlPath(response.asString());
		   String pcrfresp=xmlpath.getString("returncode");
		   System.out.println("XML return code is "+pcrfresp);
		   Assert.assertEquals(pcrfresp, 0);
		}
		
		@Test (priority = -1, description = "Account Status Check for the given pack from PCRF DB")
		public void PCRF_PackBalanceQuery(){
			Response response=
		   given()
		   .when()
		   .get(TestURL + "?command=QUERY&message=packbalance," + MSISDN + "," + RATEPLAN)
		   .then()
		   .statusCode(200)
		   .and()
		   .log()
		   .all().extract().response();
		   XmlPath xmlpath=new XmlPath(response.asString());
		   String pcrfresp=xmlpath.getString("returncode");
		   System.out.println("XML return code is "+pcrfresp);
		   Assert.assertEquals(pcrfresp, 0);
		}
		
		@Test (priority = 0, description = "Account Status Check for the given pack from PCRF DB")
		public void PCRF_PackUsageQuery(){
			Response response =
		     given()
		    .when()
		    .get(TestURL + "?command=QUERY&message=packusage," + MSISDN + "," + RATEPLAN)
		    .then()
		    .statusCode(200)
		    .and()
			.log()
			.all().extract().response();
			 XmlPath xmlpath=new XmlPath(response.asString());
			 String pcrfresp=xmlpath.getString("returncode");
			 System.out.println("XML return code is "+pcrfresp);
			 Assert.assertEquals(pcrfresp, 0);
		}
		
		@Test (priority = 1, description = "PGW CCR-I")
		public void PCRF_gy_ccrInitial(){
			Response response =
		   given()
		   .when()
		   .get(TestURL + "?command=CCRGY&message=PCRF_gy_ccr,initial," + MSISDN + "," + SESSIONID)
		   .then()
		   .statusCode(200)
		   .and()
		   .log()
		   .all().extract().response();
		   XmlPath xmlpath=new XmlPath(response.asString());
		   String pcrfresp=xmlpath.getString("returncode");
		   System.out.println("XML return code is "+pcrfresp);
		   Assert.assertEquals(pcrfresp, 0);
		}
		
		@Test (priority = 2, description = "PGW CCR-U")
		public void PCRF_gy_ccrUpdate(){
			Response response =
		   given()
		   .when()
		   .get(TestURL + "?command=CCRGY&message=PCRF_gy_ccr,update," + MSISDN + "," + SESSIONID)
		   .then()
		   .statusCode(200)
		   .and()
		   .log()
		   .all().extract().response();
		   XmlPath xmlpath=new XmlPath(response.asString());
		   String pcrfresp=xmlpath.getString("returncode");
		   System.out.println("XML return code is "+pcrfresp);
		   Assert.assertEquals(pcrfresp, 0);
		}
		
		@Test (priority = 3, description = "SMP CCR-I")
		public void PCRF_gx_ccrInitial(){
			Response response =
		   given()
		   .when()
		   .get(TestURL + "?command=CCRGX&message=PCRF_gx_ccr,initial," + MSISDN + "," + SESSIONID)
		   .then()
		   .statusCode(200)
		   .and()
		   .log()
		   .all().extract().response();
		   XmlPath xmlpath=new XmlPath(response.asString());
		   String pcrfresp=xmlpath.getString("returncode");
		   System.out.println("XML return code is "+pcrfresp);
		   Assert.assertEquals(pcrfresp, 0);
		}
		
		@Test (priority = 4, description = "SMP CCR-U")
		public void PCRF_gx_ccrUpdate(){
			Response response =
		   given()
		   .when()
		   .get(TestURL + "?command=CCRGX&message=PCRF_gx_ccr,update," + MSISDN + "," + SESSIONID)
		   .then()
		   .statusCode(200)
		   .and()
		   .log()
		   .all().extract().response();
		   XmlPath xmlpath=new XmlPath(response.asString());
		   String pcrfresp=xmlpath.getString("returncode");
		   System.out.println("XML return code is "+pcrfresp);
		   Assert.assertEquals(pcrfresp, 0);
		}
		
		@Test (priority = 5, description = "PGW CCR-T")
		public void PCRF_gy_ccrTerminate(){
			Response response =
		   given()
		   .when()
		   .get(TestURL + "?command=CCRGY&message=PCRF_gy_ccr,terminate," + MSISDN + "," + SESSIONID)
		   .then()
		   .statusCode(200)
		   .and()
		   .log()
		   .all().extract().response();
		   XmlPath xmlpath=new XmlPath(response.asString());
		   String pcrfresp=xmlpath.getString("returncode");
		   System.out.println("XML return code is "+pcrfresp);
		   Assert.assertEquals(pcrfresp, 0);
		}
		
		@Test (priority = 6, description = "SMP CCR-T")
		public void PCRF_gx_ccrTerminate(){
			Response response =
		   given()
		   .when()
		   .get(TestURL + "?command=CCRGX&message=PCRF_gx_ccr,terminate," + MSISDN + "," + SESSIONID)
		   .then()
		   .statusCode(200)
		   .and()
		   .log()
		   .all().extract().response();
		   XmlPath xmlpath=new XmlPath(response.asString());
		   String pcrfresp=xmlpath.getString("returncode");
		   System.out.println("XML return code is "+pcrfresp);
		   Assert.assertEquals(pcrfresp, 0);
		}

}
