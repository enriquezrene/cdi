package jug.cdi.one.lazyinjection.any;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import jug.cdi.one.HelloService;
import jug.cdi.one.qualifierswithmembers.Language;
import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class AnyTest {

	@Inject
	@Any
	private Instance<HelloService> helloServices;

	@Test
	public void shouldCallTwoTimeToTheMethod() {
		int times = 0;
		for (HelloService helloService : helloServices) {
			helloService.hello();
			times++;
		}
		Assert.assertEquals(2, times);
	}

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class, "test.jar")
				.addClass(HelloService.class)
				.addPackage(Language.class.getPackage())
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
}
