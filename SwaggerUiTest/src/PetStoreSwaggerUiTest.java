import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

class PetStoreSwaggerUiTest {

	Logger logger = Logger.getLogger( "PetStoreSwaggerUiTest" );
	@Test
	void findByStatusTest()  {
		HttpURLConnection conn = null;
		try {
			URL url = new URL("https://petstore.swagger.io/v2/pet/findByStatus?status=available&status=pending&status=sold");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			int responseCode = conn.getResponseCode();
			if (responseCode != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output = br.readLine();
			logger.info( "Output for findByStatus .... \n" );
			logger.info(output);
			
			assertTrue(responseCode == 200);
			assertTrue( output.length() > 0 );
		} catch( Exception e ) {
			fail("test fail " + e.getMessage());
		} finally {
			if( conn != null ) {
				conn.disconnect();
			}
		}
	}
	
	@Test
	void findPetByIdTest()  {
		HttpURLConnection conn = null;
		try {
			URL url = new URL("https://petstore.swagger.io/v2/pet/10");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			int responseCode = conn.getResponseCode();

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output = br.readLine();
			logger.info( "Output for findPetByIdTest .... \n" );
			logger.info(output);
			assertTrue(responseCode == 200);
			assertTrue( output.length() > 0 );
		} catch( Exception e ) {
			fail("test fail " + e.getMessage());
		} finally {
			if( conn != null ) {
				conn.disconnect();
			}
		}
	}
	
	@Test
	void findPurchaseOrderByIdTest()  {
		HttpURLConnection conn = null;
		try {
			URL url = new URL("https://petstore.swagger.io/v2/store/order/1");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			int responseCode = conn.getResponseCode();

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output = br.readLine();
			logger.info( "Output for findPurchaseOrderByIdTest .... \n" );
			logger.info(output);
			assertTrue(responseCode == 200);
			assertTrue( output.length() > 0 );
		} catch( Exception e ) {
			fail("test fail " + e.getMessage());
		} finally {
			if( conn != null ) {
				conn.disconnect();
			}
		}
	}
	
	@Test
	void getPetInventoryTest()  {
		HttpURLConnection conn = null;
		try {
			URL url = new URL("https://petstore.swagger.io/v2/store/inventory");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			int responseCode = conn.getResponseCode();

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output = br.readLine();
			logger.info( "Output for getPetInventoryTest .... \n" );
			logger.info(output);
			assertTrue(responseCode == 200);
			assertTrue( output.length() > 0 );
		} catch( Exception e ) {
			fail("test fail " + e.getMessage());
		} finally {
			if( conn != null ) {
				conn.disconnect();
			}
		}
	}
}
