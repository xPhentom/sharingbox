package sharingbox_CoverageTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sharingbox_webapp.sharingbox_webappApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = sharingbox_webappApplication.class)
@WebAppConfiguration
public class SharingboxWebappApplicationTests {

	@Test
	public void contextLoads() {
	}

}
