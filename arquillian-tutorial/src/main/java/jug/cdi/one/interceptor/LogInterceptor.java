package jug.cdi.one.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Loggable
public class LogInterceptor {

	@AroundInvoke
	public Object intercepInvocation(InvocationContext ic) throws Exception {
		System.out.println("++++++++++++++++++++++++++++++++++++++++Entering");
		try {
			return ic.proceed();
		} finally {
			System.out
					.println("++++++++++++++++++++++++++++++++++++++++Exiting");
		}
	}
}
