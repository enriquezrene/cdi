package jug.cdi.one.qualifierswithmembers;

import jug.cdi.one.HelloService;
import jug.cdi.one.qualifierswithmembers.Language.Languages;

@Language(Languages.ENGLISH)
public class EnglishHelloService implements HelloService {

	@Override
	public String hello() {
		return "Hello world";
	}

}
