package jug.cdi.one.interceptor;

import javax.inject.Inject;

import jug.cdi.one.HelloService;
import jug.cdi.one.qualifierswithmembers.Language;
import jug.cdi.one.qualifierswithmembers.Language.Languages;

public class MyBean {

	@Inject
	@Language(Languages.ENGLISH)
	private HelloService helloService;

	@Loggable
	public String sayHello() {
		return helloService.hello();
	}
}
