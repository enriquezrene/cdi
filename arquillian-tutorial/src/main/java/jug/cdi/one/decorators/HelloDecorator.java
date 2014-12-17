package jug.cdi.one.decorators;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

import jug.cdi.one.HelloService;
import jug.cdi.one.qualifierswithmembers.Language;
import jug.cdi.one.qualifierswithmembers.Language.Languages;

@Decorator
public class HelloDecorator implements HelloService {

	// si quiero puedo quitar el qualifier del Language
	@Inject
	@Delegate
	@Language(Languages.ENGLISH)
	private HelloService helloService;

	@Override
	public String hello() {
		return helloService.hello() + "-decorated";
	}

}
