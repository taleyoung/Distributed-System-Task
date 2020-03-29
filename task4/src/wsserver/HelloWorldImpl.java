package wsserver;

import javax.jws.WebService;
 
//Service Implementation
@WebService(endpointInterface = "wsserver.HelloWorld")
public class HelloWorldImpl implements HelloWorld{
 
	@Override
	public String getHelloWorld(String name) {
		return "Hello World to " + name;
	}
	
	@Override
	public int add(int a, int b) {
		return a + b;
	}
}