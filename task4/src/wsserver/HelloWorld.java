package wsserver;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
 
//Service Endpoint Interface
@WebService(targetNamespace="http://localhost:9999/ws/hello")
@SOAPBinding(style = Style.RPC)
public interface HelloWorld{
 
	@WebMethod 
	String getHelloWorld(String name);
	
	@WebMethod 
	int add(int a, int b);

}