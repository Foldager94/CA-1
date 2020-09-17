package rest;

import entities.Joke;
import utils.EMF_Creator;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import java.net.URI;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.util.HttpStatus;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//@Disabled
public class JokeResourceTest{

    private static final int SERVER_PORT = 7777;
    private static final String SERVER_URL = "http://localhost/api";
    static final URI BASE_URI = UriBuilder.fromUri(SERVER_URL).port(SERVER_PORT).build();
    private static HttpServer httpServer;
    private static EntityManagerFactory emf;
    
    private Joke j1;
    private Joke j2;
    private Joke j3;

    static HttpServer startServer() {
        ResourceConfig rc = ResourceConfig.forApplication(new ApplicationConfig());
        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
    }


    @BeforeAll
    public static void setUpClass() {
        //First Drop and Rebuild the test database 
        emf = EMF_Creator.createEntityManagerFactoryForTest();

        //Set System property so the project executed by the Grizly-server wil use this same database
        EMF_Creator.startREST_TestWithDB();
        
        httpServer = startServer();

        //Setup RestAssured
        RestAssured.baseURI = SERVER_URL;
        RestAssured.port = SERVER_PORT;

        RestAssured.defaultParser = Parser.JSON;
    }

    @AfterAll
    public static void closeTestServer()  {
       
       // System.in.read();
       
        httpServer.shutdownNow();
        //Don't forget this, if you called its counterpart in @BeforeAll
        EMF_Creator.endREST_TestWithDB();
    }

    // Setup the DataBase (used by the test-server and this test) in a known state BEFORE EACH TEST
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        j1 = new Joke(1,"dårlig joke 1", "type1");
        j2 = new Joke(2,"dårlig joke 2", "type2");
        j3 = new Joke(3,"dårlig joke 3", "type2");
        try {
            em.getTransaction().begin();
            em.createQuery("DELETE from Joke").executeUpdate();
            em.persist(j1);
            em.persist(j2);
            em.persist(j3);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Test
    public void serverIsRunning() {
        System.out.println("Testing is server UP");
        //Gherkin Syntax
        given().when().get("/joke/all").then().statusCode(200);
        //Hamcrest matcher
        given().when().get("/joke/all").then().assertThat().statusCode(200);
    }
    @Test
    public void contentType() {
        //Gherkin Syntax
        given().when().get("/joke/all").then().contentType(ContentType.JSON);
        //Hamcrest matcher
        given().when().get("/joke/all").then().assertThat().contentType(ContentType.JSON);
    }
    
    @Test
    public void demonStrateLogging() {
        
        given().log().all().when().get("/joke/all").then().log().body();
       
    }

    @Test
    public void testJokeCount() {
        given().
                get("/joke/count")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK_200.getStatusCode())
                .body("count", equalTo(3));
    }

    @Test
    public void testGetAll() {
         given()
                .when().
                get("/joke/all").
                then().assertThat().body("joke", hasItems("dårlig joke 1","dårlig joke 2", "dårlig joke 3"));
    }
 @Test
    public void testGetAll1() {
        given().
        get("/joke/all").then().assertThat()
      .body("size()", is(3));
                
    }
    
    @Test
    public void testFindById() {
        int value = (int) j1.getId();
        given().get("/joke/"+ j1.getId()).then().assertThat().body("id", equalTo(value)).log().body();
    
    }
}


 