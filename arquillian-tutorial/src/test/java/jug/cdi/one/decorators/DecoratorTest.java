package jug.cdi.one.decorators;

import java.io.File;

import javax.inject.Inject;

import jug.cdi.one.HelloService;
import jug.cdi.one.qualifierswithmembers.Language;
import jug.cdi.one.qualifierswithmembers.Language.Languages;
import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.FileAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class DecoratorTest {

	@Inject
	@Language(Languages.ENGLISH)
	private HelloService helloService;

	@Test
	public void shouldReturnADecoratedMessage() throws Exception {
		Assert.assertEquals("Hello world-decorated", helloService.hello());
	}

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap
				.create(JavaArchive.class, "test.jar")
				.addClass(HelloDecorator.class)
				.addPackage(HelloService.class.getPackage())
				.addPackage(Language.class.getPackage())
				.addAsManifestResource(
						new FileAsset(new File(
								"src/test/resources/META-INF/beans.xml")),
						"beans.xml");
	}

}
