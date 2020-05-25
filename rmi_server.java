import java.rmi.*;
import java.net.*;
import java.rmi.registry.*;
import java.util.*;
import java.rmi.server.*;


public class rmi_server extends java.rmi.server.UnicastRemoteObject implements RMIInterface {
  ArrayList<String> CompanyStockPriceList = new ArrayList<>(Arrays.asList("qualcomm $80", "intel $60",
                                                                          "amd $56.51", "juniper $22.57", 
                                                                          "google $1279", "facebook $179", "tesla 751.70","twitter 26.68",  "ford $5.08", "disney $106.56", "microsoft $177.71", "bank of america $23.23", "uber $27.86", "amazon $2366", "netflix $421.80", "nvidia $291.23", "lyft $29.06", "nike $89.90", "nintendo $53.63", "cisco $34.83", "apple $281.96", "snap chat $12.98", "spotify $$1.70", "starbuck $4.88"));

  // @main(): Creates the server object.
  public static void main(String args[]){
    try {
      rmi_server rmi_server = new rmi_server();
    } catch (Exception exep) {
      System.out.println("Error: exception" + exep);
      System.exit(1);
   }
  }

  String AdressServer;
  Registry RMIRegistery;

  /* @ StockPriceOfCompany
     Return value: returns stock price of given company name */
  public String StockPriceOfCompany(String CompanyName) throws Exception {
    String StockPrice = null;
    for (int i = 0; i < CompanyStockPriceList.size(); i++) {
      if(CompanyName.equals(CompanyStockPriceList.get(i).split("\\s+")[0])) {
        StockPrice = CompanyStockPriceList.get(i).split("\\s+")[1];
      }
    }
    return StockPrice;
  }

  /* @Server(): Bind server object with port number and server name.
     - LocateRegistry.createRegistry: create a remote object registry that accepts calls on a
       specific port. 
     - InetAddress getLocalHost(): it returns the instance of InetAdddress containing local host
       name and address*/
  public rmi_server() throws Exception {
    try {
      System.out.println("*** Available Companies ***");
      for (int i = 0; i < CompanyStockPriceList.size(); i++) {
        System.out.println(CompanyStockPriceList.get(i).split("\\s+")[0]);
      }
      AdressServer = (InetAddress.getLocalHost()).toString();
     // Remove unnecessary strings.
      AdressServer = AdressServer.replaceAll("DESKTOP-P8GNDEB/", "");
    } catch(Exception exep) {
      System.out.println("Error: exception" + exep);
    }

    int PortNumber = 5111;
    System.out.println("Server Address = " + AdressServer + ", Server Port Number = " + PortNumber);
    try {
      RMIRegistery = LocateRegistry.createRegistry(PortNumber);
      RMIRegistery.rebind("rmi_server", this);
    } catch(Exception exep) {
      System.out.println("Error: exception" + exep);
    }
  }


}
