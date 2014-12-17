package jug.cdi.one.events;

import javax.enterprise.event.Observes;

public class SecondBean {

	public void listenPost(@Observes Post post) {
		System.out.println("listening..." + post.getName());
	}
}
