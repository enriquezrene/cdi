package jug.cdi.one.lazyinjection;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import jug.cdi.one.HelloService;
import jug.cdi.one.qualifierswithmembers.Language;
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
public class LazyTest {

	@Inject
	@Language(Languages.ENGLISH)
	private Instance<HelloService> helloService;

	@Test
	public void shouldGreetInEnglish() throws Exception {
		Assert.assertFalse(helloService.isUnsatisfied());
		Assert.assertEquals("Hello world", helloService.get().hello());
	}

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class, "test.jar")
				.addClass(HelloService.class)
				.addPackage(Language.class.getPackage())
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
}
