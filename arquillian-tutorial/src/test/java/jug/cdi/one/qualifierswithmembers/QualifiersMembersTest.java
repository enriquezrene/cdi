package jug.cdi.one.qualifierswithmembers;

import javax.inject.Inject;

import jug.cdi.one.HelloService;
import jug.cdi.one.qualifierswithmembers.Language.Languages;
import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class QualifiersMembersTest {

	@Inject
	@Language(Languages.ENGLISH)
	private HelloService helloServiceIngles;

	@Inject
	@Language(Languages.FRENCH)
	private HelloService helloServiceFrances;

	@Test
	public void shouldGreetInEnglish() throws Exception {
		Assert.assertEquals("Hello world", helloServiceIngles.hello());
	}

	@Test
	public void shouldGreetInFrench() throws Exception {
		Assert.assertEquals("Bonjour tout le monde!",
				helloServiceFrances.hello());
	}

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class, "test.jar")
				.addClass(HelloService.class)
				.addPackage(Language.class.getPackage())
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
}
