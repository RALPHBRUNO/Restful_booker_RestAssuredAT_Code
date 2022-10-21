package testClasses;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import javax.naming.ConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

    public class Customer_BookingAPI {
        Properties props = new Properties();
        FileInputStream file;
        {
            try {
                file = new FileInputStream("./src/main/java/properties/config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public String token;

        public void LoginApi() throws ConfigurationException, IOException, org.apache.commons.configuration.ConfigurationException {


            props.load(file);
            RestAssured.baseURI = props.getProperty("baseURL");
            Response response =
                    given()
                            .contentType("application/json")
                            .body("{\n" +
                                    "    \"username\" : \"admin\",\n" +
                                    "    \"password\" : \"password123\"\n" +
                                    "}")
                            .when()
                            .post("/auth")
                            .then()
                            .assertThat().statusCode(200).extract().response();

            System.out.println(response.asString());
            JsonPath jsonPath = response.jsonPath();
            token = jsonPath.get("token");
            Utils.setEnvVariable("token", token);

        }

        public void GETBookingIDs() throws IOException {

            RestAssured
                    .given()
                    .log().all()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("booking")
                    .when()
                    .get()
                    .then()
                    .log().all()
                    .assertThat().statusCode(200);
        }

        public void GETBooking() throws IOException {

            RestAssured
                    .given()
                    .log().all()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("booking/5000")
                    .when()
                    .get()
                    .then()
                    .log().all()
                    .assertThat().statusCode(200);
        }

        public void CreateBooking(){
            RestAssured
                    .given()
                    .log().all()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("booking")
                    .header("Content-Type", "application/json")
                    .body("{\n" +
                            "    \"firstname\" : \"Jim\",\n" +
                            "    \"lastname\" : \"Brown\",\n" +
                            "    \"totalprice\" : 111,\n" +
                            "    \"depositpaid\" : true,\n" +
                            "    \"bookingdates\" : {\n" +
                            "        \"checkin\" : \"2018-01-01\",\n" +
                            "        \"checkout\" : \"2019-01-01\"\n" +
                            "    },\n" +
                            "    \"additionalneeds\" : \"Breakfast\"\n" +
                            "}")
                    .header("Accept", "application/json")
                    // .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                    .when()
                    .post()
                    .then()
                    .log().all()
                    .assertThat().statusCode(200);

        }

        public void UpdateCustomer() throws IOException {
            RestAssured
                    .given()
                    .log().all()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("booking/7157")
                    .header("Content-Type", "application/json")
                    .body("{\n" +
                            "    \"firstname\" : \"Jim\",\n" +
                            "    \"lastname\" : \"Brown\",\n" +
                            "    \"totalprice\" : 111,\n" +
                            "    \"depositpaid\" : true,\n" +
                            "    \"bookingdates\" : {\n" +
                            "        \"checkin\" : \"2018-01-01\",\n" +
                            "        \"checkout\" : \"2019-01-01\"\n" +
                            "    },\n" +
                            "    \"additionalneeds\" : \"Breakfast\"\n" +
                            "}")
                    .header("Accept", "application/json")
                    .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                    .when()
                    .put()
                    .then()
                    .log().all()
                    .assertThat().statusCode(200);

        }

        public void PartialUpdate(){
            RestAssured
                    .given()
                    .log().all()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("booking/7157")
                    .header("Content-Type", "application/json")
                    .body("{\n" +
                            "    \"firstname\" : \"James\",\n" +
                            "    \"lastname\" : \"Brown\"\n" +
                            "}")
                    .header("Accept", "application/json")
                    .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                    .when()
                    .patch()

                    .then()
                    .log().all()
                    .assertThat().statusCode(200);

        }

        public void Delete(){
            RestAssured
                    .given()
                    .log().all()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("booking/7465")
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                    .when()
                    .delete()
                    .then()
                    .log().all()
                    .assertThat().statusCode(201);

        }

        public  void Ping(){
            RestAssured
                    .given()
                    .log().all()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("ping")
                    // .header("Content-Type", "application/json")
                    //.header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                    .when()
                    .get()
                    .then()
                    .log().all()
                    .assertThat().statusCode(201);

        }
    }

