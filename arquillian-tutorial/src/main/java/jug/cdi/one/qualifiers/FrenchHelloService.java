package jug.cdi.one.qualifiers;

import jug.cdi.one.HelloService;

@French
public class FrenchHelloService implements HelloService {

	@Override
	public String hello() {
		return "Bonjour tout le monde!";
	}

}
