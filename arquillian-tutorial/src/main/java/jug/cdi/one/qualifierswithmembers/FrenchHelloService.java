package jug.cdi.one.qualifierswithmembers;

import jug.cdi.one.HelloService;
import jug.cdi.one.qualifierswithmembers.Language.Languages;

@Language(Languages.FRENCH)
public class FrenchHelloService implements HelloService {

	@Override
	public String hello() {
		return "Bonjour tout le monde!";
	}

}
