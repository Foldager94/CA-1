/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Joke;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

/**
 *
 * @author Christoffer
 */
public class JokeFacadeTest {
    private static EntityManagerFactory emf;
    private static JokeFacade facade;
    private Joke j1;
    private Joke j2;
    private Joke j3;
    public JokeFacadeTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = JokeFacade.getJokeFacade(emf);
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
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
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testJokeCount() {
        assertEquals(3,facade.getJokeCount(),"Expects three jokes in the database");
    }
    
    @Test
    public void testGetRandomJoke(){
        assertEquals(true,(facade.getRandomJoke().getId() <= facade.getJokeCount()));
    }
    @Test
    public void testNegativeGetRandomJoke(){
        assertEquals(false,(facade.getRandomJoke().getId() > facade.getJokeCount()));
    }
    @Test
    public void testGetJokeById(){
     assertEquals(j1.getId(), facade.getJokeByID(j1.getId()).getId());
    
    }
    
    
}
