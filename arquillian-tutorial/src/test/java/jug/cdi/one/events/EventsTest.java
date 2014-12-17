package jug.cdi.one.events;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class EventsTest {

	@Inject
	private FirstBean firstBean;

	@Test
	public void twoMessagesShouldAppearInTheConsole() throws Exception {
		firstBean.saveNewPost(new Post("Post name"));
	}

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class, "test.jar")
				.addPackage(Post.class.getPackage())
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
}
