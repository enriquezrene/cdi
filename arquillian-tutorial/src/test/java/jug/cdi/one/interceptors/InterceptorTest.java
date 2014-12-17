package jug.cdi.one.interceptors;

import java.io.File;

import javax.inject.Inject;

import jug.cdi.one.HelloService;
import jug.cdi.one.interceptor.MyBean;
import jug.cdi.one.qualifierswithmembers.Language;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.FileAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class InterceptorTest {

	@Inject
	private MyBean myBean;

	@Test
	public void enteringAndExitingMessagesShouldAppearInTheConsole()
			throws Exception {
		myBean.sayHello();
	}

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap
				.create(JavaArchive.class, "test.jar")
				.addPackage(HelloService.class.getPackage())
				.addPackage(Language.class.getPackage())
				.addPackage(MyBean.class.getPackage())
				.addAsManifestResource(
						new FileAsset(
								new File(
										"src/test/resources/META-INF/interceptor-beans.xml")),
						"beans.xml");
	}
}
