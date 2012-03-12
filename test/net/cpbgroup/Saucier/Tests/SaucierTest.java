package net.cpbgroup.Saucier.Tests;

import static org.testng.AssertJUnit.assertEquals;
import net.cpbgroup.Saucier.Saucier;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SaucierTest {
	
	Saucier saucier;
	String username = "bwigginton";
	String secretKey = "fcebbbc9-8c70-403d-a85e-a893b678d1c3";
	
	@BeforeSuite
	public void setupSaucier() {
		saucier = Saucier.getInstance(username, secretKey);
	}

	@Test
	public void TestGetConnectionURL() {
		assertEquals(saucier.getConnectionURL().toString(),
					"http://" + username + ":" + secretKey + "@ondemand.saucelabs.com:80/wd/hub");
	} 

}
