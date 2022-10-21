package runner;

import org.junit.Test;

import testClasses.Customer_BookingAPI;

import javax.naming.ConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;


public class TestRunner {

    //***************TestNG****************

  Customer_BookingAPI booker = new Customer_BookingAPI();

  public TestRunner() throws FileNotFoundException {
  }

    @Test @org.testng.annotations.Test(priority = 1)
    public void doLoginApi() throws ConfigurationException, IOException, org.apache.commons.configuration.ConfigurationException {
      booker.LoginApi();
  }

    @Test  @org.testng.annotations.Test(priority = 2)
  public void doBooking() throws IOException {
      booker.GETBookingIDs();

  }

    @Test  @org.testng.annotations.Test(priority = 3)
  public void doBookingByID() throws IOException {
      booker.GETBooking();

  }

    @Test @org.testng.annotations.Test(priority = 4)
  public void doCreteBooking() throws IOException {
      booker.CreateBooking();

  }
    @Test @org.testng.annotations.Test(priority = 5)
    public void update() throws IOException {
        booker.UpdateCustomer();
    }
    @Test @org.testng.annotations.Test(priority = 6)
    public void partialUpdate(){
        booker.PartialUpdate();
    }

    @Test @org.testng.annotations.Test(priority = 7)
    public void delete(){
        booker.Delete();
    }
  @org.testng.annotations.Test(priority = 8)
  public  void doPing() throws IOException {
      booker.Ping();
  }

}
// ***************************JUNIT****************************************
//    CustomerApi booker=new CustomerApi();
//@Test
//    public  void login() throws ConfigurationException, IOException {
//        booker.LoginApi();
//
//    }
//@Test
//    public void getAllIds(){
//    booker.GetBookingIds();
//    }
//@Test
//    public void getONEid(){
//    booker.GETBooking();
//    }
//
//@Test
//    public void create(){
//    booker.CreateBooking();
//    }
//
//@Test
//    public void update() throws IOException {
//    booker.UpdateCustomer();
//    }
//@Test
//    public void partialUpdate(){
//    booker.PartialUpdate();
//    }
//
//@Test
//    public void delete(){
//    booker.Delete();
//    }
//
//@Test
//    public void ping(){
//    booker.Ping();
//
//    }
//}
