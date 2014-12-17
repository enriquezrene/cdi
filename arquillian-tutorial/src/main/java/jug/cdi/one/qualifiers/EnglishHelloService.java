package jug.cdi.one.qualifiers;

import jug.cdi.one.HelloService;

@English
public class EnglishHelloService implements HelloService {

	@Override
	public String hello() {
		return "Hello world";
	}

}
