package jug.cdi.one.producers;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class LogProducerTest {

	@Inject
	private Logger LOG;

	@Test
	public void theLoggerNameMustContainsTheClassName() throws Exception {
		Assert.assertTrue(LOG.getName().contains("LogProducerTest"));
	}

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class, "test.jar")
				.addClass(LogProducer.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
}
