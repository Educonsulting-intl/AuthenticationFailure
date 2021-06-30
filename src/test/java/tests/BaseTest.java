package tests;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import pageobjects.MainPage;



public class BaseTest {
	
	protected WebDriver driver;
	private DesiredCapabilities capabilities;
	private String log;
	
	@Parameters({"log"})
	@BeforeSuite
	public void setup(String log)
			throws Exception {
		capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("chrome");
		capabilities.setVersion("85.0");
		capabilities.setCapability("enableVNC", true);
		capabilities.setCapability("enableVideo", false);
		if(log.equals("LvivVpn"))
			Thread.sleep(700);
		else if(log.equals("IsraelVpn"))
			Thread.sleep(5000);
		else if(log.equals("FileDelete"))
			Thread.sleep(5000);
		else if(log.equals("GTs"))
			Thread.sleep(9000);
		else if(log.equals("RedTS"))
			Thread.sleep(14000);
		else if(log.equals("GreyTS"))
			Thread.sleep(18000);
		else if(log.equals("FileCopy"))
			Thread.sleep(18000);
		else if(log.equals("ManagementTS"))
			Thread.sleep(23000);
		else if(log.equals("FakeRedTS"))
			Thread.sleep(27000);
		else if(log.equals("FileWrite"))
			Thread.sleep(27000);
		else if(log.equals("KievVpn"))
			Thread.sleep(32000);
		else if(log.equals("EndPointBlock"))
			Thread.sleep(36000);
			
		driver = new RemoteWebDriver(
		    URI.create("http://192.168.18.22:4444/wd/hub").toURL(), 
		    capabilities
		);
		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		driver.manage().window().maximize();
		if(log.equals("IsraelVpn"))
			driver.get("http://192.168.20.162:5601/app/discover#/?_g=(filters:!(),refreshInterval:(pause:!t,value:0),time:(from:now-10m,to:now))&_a=(columns:!(_source),filters:!(),index:'filebeat-*',interval:auto,query:(language:kuery,query:'observer.name%20:%22FORTI-600E-EDU-IL%22%20AND%20rule.description:%20%22SSL%20VPN%20login%20fail%22'),sort:!())");
		else if(log.equals("GTs"))
			driver.get("http://192.168.20.162:5601/app/discover#/?_g=(filters:!(),refreshInterval:(pause:!t,value:0),time:(from:now-10m,to:now))&_a=(columns:!(_source),filters:!(),index:'auditbeat-*',interval:auto,query:(language:kuery,query:'auditd.message_type%20:%22user_login%22%20AND%20auditd.result%20:%20%22fail%22%20%20%20%20'),sort:!())");
		else if(log.equals("RedTS"))
			driver.get("http://192.168.20.162:5601/app/discover#/?_g=(filters:!(),refreshInterval:(pause:!t,value:0),time:(from:now-10m,to:now))&_a=(columns:!(_source),filters:!(),index:'5cdaac10-5425-11eb-935b-0bb49ce79efe',interval:auto,query:(language:kuery,query:'event.outcome%20:%20%22failure%22%20%20AND%20winlog.event_data.LogonProcessName:%20%22User32%20%22%20AND%20host.name%20:%20%22TS01.inter.local%22%20%20'),sort:!())");
		else if(log.equals("GreyTS"))
			driver.get("http://192.168.20.162:5601/app/discover#/?_g=(filters:!(),refreshInterval:(pause:!t,value:0),time:(from:now-10m,to:now))&_a=(columns:!(_source),filters:!(),index:'5cdaac10-5425-11eb-935b-0bb49ce79efe',interval:auto,query:(language:kuery,query:'event.outcome%20:%20%22failure%22%20%20AND%20winlog.event_data.LogonProcessName:%20%22User32%20%22%20AND%20host.name%20:%20%22TS01%22%20'),sort:!())");
		else if(log.equals("ManagementTS"))
			driver.get("http://192.168.20.162:5601/app/discover#/?_g=(filters:!(),refreshInterval:(pause:!t,value:0),time:(from:now-15m,to:now))&_a=(columns:!(_source),filters:!(),index:'5cdaac10-5425-11eb-935b-0bb49ce79efe',interval:auto,query:(language:kuery,query:'event.outcome%20:%20%22failure%22%20AND%20host.name%20:%20%22edu-ad01.extr.local%22%20AND%20event.category%20:%20%22authentication%22%20'),sort:!())");
		else if(log.equals("LvivVpn"))
			driver.get("http://192.168.20.162:5601/app/discover#/?_g=(filters:!(),refreshInterval:(pause:!t,value:0),time:(from:now-10m,to:now))&_a=(columns:!(_source),filters:!(),index:'filebeat-*',interval:auto,query:(language:kuery,query:'observer.name%20:%22FG100FT19013741%22%20AND%20fortinet.firewall.status:%20%22failure%22%20AND%20fortinet.firewall.result:%20%22XAUTH%20authentication%20failed%22%20'),sort:!())");
		else if(log.equals("KievVpn"))
			driver.get("http://192.168.20.162:5601/app/discover#/?_g=(filters:!(),refreshInterval:(pause:!t,value:0),time:(from:now-10m,to:now))&_a=(columns:!(_source),filters:!(),index:'filebeat-*',interval:auto,query:(language:kuery,query:'observer.name%20:%22FG100ETK18029390%22%20AND%20fortinet.firewall.status:%20%22failure%22%20AND%20fortinet.firewall.result:%20%22XAUTH%20authentication%20failed%22%20'),sort:!())");
		else if(log.equals("EndPointBlock"))
			driver.get("http://192.168.20.162:5601/app/discover#/?_g=(filters:!(),query:(language:kuery,query:''),refreshInterval:(pause:!t,value:0),time:(from:now-5m,to:now))&_a=(columns:!(_source),filters:!(),index:aac2d300-8263-11eb-982f-c9a5e769f212,interval:auto,query:(language:kuery,query:'Event%20Name%20:%20%22Blocked%22'),sort:!())");
		else if(log.equals("FakeRedTS"))
			driver.get("http://192.168.20.162:5601/app/discover#/?_g=(filters:!(),query:(language:kuery,query:''),refreshInterval:(pause:!t,value:0),time:(from:now-5m,to:now))&_a=(columns:!(_source),filters:!(),index:'5cdaac10-5425-11eb-935b-0bb49ce79efe',interval:auto,query:(language:kuery,query:'event.action%20:%20%22logged-in%22%20AND%20event.outcome%20:%20%22success%22%20AND%20winlog.event_data.LogonProcessName:%20%22User32%20%22%20AND%20host.name:%20%22Red-TS26%22%20'),sort:!())");
		else if(log.equals("FileDelete"))
			driver.get("http://192.168.20.162:5601/app/discover#/?_g=(filters:!(),refreshInterval:(pause:!t,value:0),time:(from:now-1h,to:now))&_a=(columns:!(_source),filters:!(),index:aac2d300-8263-11eb-982f-c9a5e769f212,interval:auto,query:(language:kuery,query:'Event%20Name%20:%20%22File%20Delete%22'),sort:!())");
		else if(log.equals("FileCopy"))
			driver.get("http://192.168.20.162:5601/app/discover#/?_g=(filters:!(),refreshInterval:(pause:!t,value:0),time:(from:now-1h,to:now))&_a=(columns:!(_source),filters:!(),index:aac2d300-8263-11eb-982f-c9a5e769f212,interval:auto,query:(language:kuery,query:'Event%20Name%20:%20%22File%20Copy%22'),sort:!())");
		else if(log.equals("FileWrite"))
			driver.get("http://192.168.20.162:5601/app/discover#/?_g=(filters:!(),refreshInterval:(pause:!t,value:0),time:(from:now-1h,to:now))&_a=(columns:!(_source),filters:!(),index:aac2d300-8263-11eb-982f-c9a5e769f212,interval:auto,query:(language:kuery,query:'Event%20Name%20:%20%22File%20Write%22'),sort:!())");
		this.log = log;

	}
	
	@Test
	public void getHits() {
		int hits = 0;
		String flag = "false";
		MainPage mainPage = new MainPage(driver);
		if(log.equals("KievVpn") || log.equals("LvivVpn")) {
			
			try {
				hits = Integer.parseInt(mainPage.getHits());
			}catch (Exception e) {}
			
			if(hits > 5)
				flag = "true";
			AssertJUnit.assertEquals("false", flag);
			
		}else if(log.equals("FileDelete") || log.equals("FileCopy") || log.equals("FileWrite")) {
			try {
				String getHits = mainPage.getHits().replace(",", "");
				hits = Integer.parseInt(getHits);
			}catch (Exception e) {}
			System.out.println("HITS:"+hits);
			if(hits > 1000)
				flag = "true";
			AssertJUnit.assertEquals("false", flag);
			
		}else if(log.equals("EndPointBlock")) {
			
			try {
				hits = Integer.parseInt(mainPage.getHits());
			}catch (Exception e) {}
			
			if(hits > 0) {
				mainPage.clickOnDetailsExpand();
				mainPage.getClientUser();
				mainPage.getDeviceType();
				AssertJUnit.assertEquals(0, 1);

			}
			
		}else {

			mainPage.noResults();
		}

	}
	
	@AfterSuite
	public void quit() {
		driver.quit();
	}
}
