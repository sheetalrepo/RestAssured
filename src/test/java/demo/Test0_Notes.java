package demo;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class Test0_Notes {

    //@Test
    public void testGetMultipleWay1() {
        System.out.println("******************Basic Has Item: Test 2****************************");

        Response response=
        given()
                .header("Authorization", "Bearer <token>")
                .contentType(ContentType.JSON).
        when()        
                .get("http://services.groupkt.com/country/get/all").
        then()
                .statusCode(200).log().all()
                .assertThat().body(matchesJsonSchemaInClasspath("test3_geo_schema123.json"))
                .body("RestResponse.result.name", is("Italy"))
                .body("RestResponse.result.name",hasItems("Afghanistan","Argentina","Australia"))
                .time(lessThan(4000L)).  //performance check
        extract().
                response();

        //Extract Headers:
        String singleHeader = response.getHeader("CF-RAY");
        Headers headers = response.getHeaders();   //All Headers
    }

    public void testGetMultipleWay2() {
        String responseString = get("http://services.groupkt.com/country/search?text=lands").asString();

        JsonPath jsonPath = new JsonPath(responseString);
        jsonPath.get("name");
    }


    /**
     * API GET https://example.com/api/users?name=John
     *  
     * Query Parameters: 
     *          Passed in the URL itself.
     *          Typically used for filtering, searching, or pagination.
     *          e.g. ?name=John
     *          In Rest Assured its denoted by   .param("A", "B")
     * 
     * Path Parameters:
     *          Embedded in the URL path.
     *          Used to identify specific resources.
     *          e.g. /api/users
     *          
     * Form Parameters:
     *          Used mainly in POST requests.
     *          Sent in the request body, not the URL.
     *          Works like query params but is hidden inside the request body.
     *          In case of POST Req: both formParam() and param() will be treated same
     *          
     * Header Parameters:    
     *          Authorization, Content-Type
     *     
     *     
     * Request Body:
     *          Contains structured data (JSON/XML).
     *          Used for sending complex data in POST/PUT requests
     */
    public void testPOSTMultipleWay1(){
        Cookie cookie = new Cookie.Builder("").build();  //can be passed as well
        
        given()
            .header("Authorization", "Bearer <token>")
            .cookie("__utmt", "1")
            .contentType(ContentType.JSON)
            .pathParam("type", "json")
            .param("color", "red")               //Not sensitive   
            .formParam("username", "My Name").   //sensitive info
        when().
                post("http://api.fonts.com/rest/{type}/").
        then().
                statusCode(201);
    }


    public void testPOSTMultipleWay2(){
        List<String> list = new ArrayList<String>();
        list.add("one");

        //For Smaller body
        Map<String,String> inputJson = new HashMap<>();
        inputJson.put("firstName", "A");

        //For bigger complex body structure
        ZebraRequestClassNew obj = new ZebraRequestClassNew();
        obj.setAge(10);

        //Request Body
        File jsonFile = new File("src/test/resources/user.json");

        //Uploading Files
        File imageFile = new File("src/test/resources/image.jpg");
        
        given()
                .param("bodydata", list)
                .contentType("application/json")
                .body(inputJson)  // Pass Map
                .body(obj)        // Pass Java Obj      
                .body(jsonFile)  // Pass JSON from file
                .multiPart("file", imageFile).  // Upload a file
        when().
                post("https://api.fonts.com/rest/json/Accounts/").
        then().
                statusCode(200);
    }


    
    
    
    /**
     * best to Use RequestSpecBuilder and Response Spec Builder
     */
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    
    @BeforeClass
    public void setup(){
        RestAssured.baseURI = "http://services.groupkt.com";
        RestAssured.basePath = "/country";
        RestAssured.useRelaxedHTTPSValidation();   //To bypass HTTPs certificate validations in QA env
        RestAssured.useRelaxedHTTPSValidation("TLS");
        
        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.addParam("parameter1", "parameterValue");
        reqBuilder.addHeader("header1", "headerValue");
        requestSpec = reqBuilder.build();

        ResponseSpecBuilder respBuilder = new ResponseSpecBuilder();
        respBuilder.expectStatusCode(200);
        respBuilder.expectHeader("Content-Type", "application/json;charset=UTF-8");
        respBuilder.expectHeader("Cache-Control", "no-cache, no-store, max-age=0, must-revalidate");
        responseSpec = respBuilder.build();
    }
    
    @Test
    public void testRequestResponseBuilder(){
        given()
                .spec(requestSpec).
        when()
                .get("/search?text=united").   //only endpoint
        then()
                .spec(responseSpec);
                
    }



    /**
     * Use Java POJOs for complex response
     */
    public void testSerializationDeSerialization(){
        //Serialization: Java Obj to JSON
        ZebraRequestClassNew reqObj = new ZebraRequestClassNew();
        reqObj.setAge(5);

        //De serialization using .as() method
        ZebraResponseClass respObj =
                given()
                        .body(reqObj).
                when()
                        .post("http://www.thomas-bayer.com/restnames/countries.groovy")
                        .as(ZebraResponseClass.class);  // DeSerialization: Json -> Java Obj

        //Verification
        Assert.assertTrue(respObj.getRegId() > 0); 
    }

    
    
    
    
    
    
    
    

    /**
     * Authentications:
     *  1. Basic authentication = simple username:password
     *  2. Digest authentication = Secure variation of Basic Auth
     *  3. API Key Authentication
     *  4. JWT (JSON Web Token) Authentication: Works similar to Bearer Token but includes claims and expiration checks.
     *  5. Bearer tokens = OAuth 2.0 authentication
     *  
     *  
     *  JWT vs OAuth 2.0
     *  #JWT (JSON Web Token)
     *      Purpose: Used for stateless authentication, meaning the server doesn’t need to track sessions.
     *      Structure: JWT contains three parts—Header, Payload, Signature.
     *      Usage: Typically used for API authentication without needing OAuth.
     *      Usually longer lived
     *      
     *  #OAuth 2.0 Authentication    
     *      Purpose: More advanced and secure, mainly for authorization rather than authentication.
     *      Flow: Uses access tokens that are issued via OAuth providers (e.g., Google, Facebook).
     *      Scope-based Access: Can restrict what a user is allowed to do.
     *      Short-lived, requires refresh
     *      Works with OAuth servers
     *     
     */
    public void testAuthentications(){
        given()
                .auth().basic("user", "password")            // Basic authentication
                .auth().digest("user", "password")           // Digest authentication
                .header("API-Key", "your-api-key")       // API Key Authentication   
                .header("Authorization", "Bearer jwt_base64token")  //JWT
                .header("Authorization", "Bearer jwt_base64token"). //OAuth 2.0
        when()
                .get("https://api.example.com/protected-resource").
        then()
                .statusCode(200);
    }


   





}
