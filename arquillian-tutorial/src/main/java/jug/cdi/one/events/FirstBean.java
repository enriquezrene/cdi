package jug.cdi.one.events;

import javax.enterprise.event.Event;
import javax.inject.Inject;

public class FirstBean {

	@Inject
	private Event<Post> postEvent;

	public void saveNewPost(Post myPost) {
		System.out.println("Saving post " + myPost.getName());
		postEvent.fire(myPost);
		// For select the implementation in RunTime
		// .select(new AnnotationLiteral<French>() {
		// }).fire(myPost);
	}
}
