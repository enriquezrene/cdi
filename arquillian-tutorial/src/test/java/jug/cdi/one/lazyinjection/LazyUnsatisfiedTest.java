package jug.cdi.one.lazyinjection;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import jug.cdi.one.HelloService;
import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class LazyUnsatisfiedTest {

	@Inject
	private Instance<HelloService> helloService;

	@Test
	public void theInjectionIsNotSatisfied() throws Exception {
		Assert.assertTrue(helloService.isUnsatisfied());
	}

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class, "test.jar")
				.addClass(HelloService.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
}
