package net.cpbgroup.Saucier.Tests;

import java.util.ArrayList;

import net.cpbgroup.Saucier.Request;
import net.cpbgroup.Saucier.RequestBuffer;

import org.testng.annotations.*;
import static org.testng.AssertJUnit.*;

public class RequestBufferTest {

	RequestBuffer requests;
	
	@BeforeTest
	public void BeforeMethod() {
		requests = new RequestBuffer();
		
		// prime a few requests
		requests.add(new Request("2012-02-29 15:48:34,012 - GET http://www.openforum.com/ -> 200 (176ms)"));
		requests.add(new Request("2012-02-29 15:48:41,960 - GET http://omn.americanexpress.com/b/ss/amexopenforumprod/1/H.22.1/s91263642331485?AQB=1&ndh=1&t=29%2F1%2F2012%2014%3A48%3A40%203%20480&ce=UTF-8&ns=1americanexpress&pageName=US%7COPENForum%7CHome%7CHome&g=http%3A%2F%2Fwww.openforum.com%2F&cc=USD&server=www.openforum.com&h1=US%7COPENForum%7CHome&c3=en&c4=US&v13=D%3Dblueboxpublic&v27=US&c34=D%3Dblueboxpublic&c48=D%3Dgctrac&c49=OpenF%20r13.2&c52=D%3DUser-Agent&c75=npn&s=1024x768&c=24&j=1.7&v=Y&k=Y&bw=1016&bh=638&p=Google%20Update%3BShockwave%20Flash%3BShockwave%20for%20Director%3BJava(TM)%20Platform%20SE%206%20U30%3BJava%20Deployment%20Toolkit%206.0.300.12%3B&AQE=1 -> 302 (386ms)"));
		requests.add(new Request("2012-02-29 15:48:42,062 - GET http://keywords.fmpub.net/?t=js&s=431&u=http%3A%2F%2Fwww.openforum.com%2F -> 200 (137ms)"));
		requests.add(new Request("2012-02-29 15:48:40,039 - GET http://connect.facebook.net/en_US/all.js -> 200 (360ms)"));
		requests.add(new Request("2012-02-29 15:48:42,069 - GET http://omn.americanexpress.com/b/ss/amexopenforumprod/1/H.22.1/s91263642331485?AQB=1&pccr=true&vidn=27A755A4851D38A9-6000014160019476&&ndh=1&t=29%2F1%2F2012%2014%3A48%3A40%203%20480&ce=UTF-8&ns=1americanexpress&pageName=US%7COPENForum%7CHome%7CHome&g=http%3A%2F%2Fwww.openforum.com%2F&cc=USD&server=www.openforum.com&h1=US%7COPENForum%7CHome&c3=en&c4=US&v13=D%3Dblueboxpublic&v27=US&c34=D%3Dblueboxpublic&c48=D%3Dgctrac&c49=OpenF%20r13.2&c52=D%3DUser-Agent&c75=npn&s=1024x768&c=24&j=1.7&v=Y&k=Y&bw=1016&bh=638&p=Google%20Update%3BShockwave%20Flash%3BShockwave%20for%20Director%3BJava(TM)%20Platform%20SE%206%20U30%3BJava%20Deployment%20Toolkit%206.0.300.12%3B&AQE=1 -> 200 (33ms)"));
		requests.add(new Request("2012-02-29 15:48:42,150 - GET https://omns.americanexpress.com/b/ss/amexopenforumprod/1/H.22.1/s74794308182518?AQB=1&ndh=1&t=1%2F2%2F2012%2014%3A37%3A2%204%20480&ce=UTF-8&ns=1americanexpress&pageName=US%7COPENForum%7CHome%7CHome&g=https%3A%2F%2Fwww.openforum.com%2F&cc=USD&server=www.openforum.com&h1=US%7COPENForum%7CHome&c3=en&c4=US&v13=D%3Dblueboxpublic&v27=US&c34=D%3Dblueboxpublic&c48=D%3Dgctrac&c49=OpenF%20r13.2&c52=D%3DUser-Agent&c75=npn&s=1024x768&c=24&j=1.7&v=Y&k=Y&bw=1016&bh=638&p=Google%20Update%3BShockwave%20Flash%3BShockwave%20for%20Director%3BJava(TM)%20Platform%20SE%206%20U30%3BJava%20Deployment%20Toolkit%206.0.300.12%3B&AQE=1 -> 302 (472ms)"));
		requests.add(new Request("2012-02-29 15:48:42,282 - GET http://ad.doubleclick.net/adj/fmpub.openforum/OF_Default;sz=300x250;fmzid=5949;;fmcls=ATF;tile=1;ord=6384942138553543;u=_fmnu90f9f9379ed8f9539fdb90650a858cf1; -> 200 (118ms)"));
	}
	
	@Test
	public void filterByStatus() {
		int statusCode = 302;
		RequestBuffer rb = requests.filterByHttpStatusCode(statusCode);
		assertEquals(2, rb.size());
	}
	
	@Test
	public void filterByHost() {
		String hostname = "omn.americanexpress.com";
		RequestBuffer rb = requests.filterByHost(hostname);
		assertEquals(2, rb.size());
	}
	
	@Test
	public void filterByHosts() {
		
		ArrayList<String> hostnames = new ArrayList<String>();
		hostnames.add("omn.americanexpress.com");
		hostnames.add("omns.americanexpress.com");
		
		RequestBuffer rb = requests.filterByHostnames(hostnames);
		
		assertEquals(3, rb.size());
		
	}

}
