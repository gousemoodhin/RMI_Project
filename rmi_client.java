import java.rmi.registry.*;
import java.net.*;
import java.rmi.*;

public class rmi_client {
  public static void main(String args[]){
    String ServerAddress = args[0];
    String ServerPort    = args[1];
    String CompanyName   = args[2];
    CompanyName          = CompanyName.toLowerCase();
    Registry RMIregistry;
    RMIInterface ServerInterface;
    System.out.println("Transmitting company name " + CompanyName.toUpperCase() + " to " + ServerAddress + ":" + ServerPort);

    try {
      /* @LocateRegistry.getRegistry() is used to obtain the local registry reference.
         Return value: returns a reference to the the remote object Registry for the local host on
         the default registry port of 1099. */
      RMIregistry = LocateRegistry.getRegistry(ServerAddress, (new Integer(ServerPort)).intValue());
      ServerInterface = (RMIInterface) (RMIregistry.lookup("rmi_server"));
      String ResultStockPrice = ServerInterface.StockPriceOfCompany(CompanyName);
      if (ResultStockPrice != null) {
        System.out.println("Stock price of company " + CompanyName.toUpperCase() + " = " + ResultStockPrice);
      } else {
        System.out.println("Error: " + CompanyName + " Company name is not in the list");
     }
    } catch(Exception exep) {
      System.out.println("Error: exception" + exep);
    }
  }
}
