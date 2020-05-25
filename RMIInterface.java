import java.rmi.*;
import java.util.*;

/* @RMIInterface: It is an interface that declares a set of methods that may be invoked from a
   remote Java virtual machine. */
public interface RMIInterface extends Remote{
	public String StockPriceOfCompany(String CompanyName) throws Exception;
}
