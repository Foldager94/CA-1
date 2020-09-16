/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.ClassMember;
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
public class MemberFacadeTest {
    private static  EntityManagerFactory emf;
    private static  MemberFacade facade;
    private ClassMember m1;
    private ClassMember m2;
    private ClassMember m3;
    public MemberFacadeTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = MemberFacade.getMemberFacade(emf);
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        m1 = new ClassMember("id1", "jens", "kiks");
        m2 = new ClassMember("id2", "gert", "gifler");
        m3 = new ClassMember("id3", "kurt", "maregns");
        try {
            em.getTransaction().begin();
            em.createQuery("DELETE from ClassMember").executeUpdate();
            em.persist(m1);
            em.persist(m2);
            em.persist(m3);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testMemberCount() {
        assertEquals(3,facade.getMemberCount(),"Expects three members in the database");
    }
    
}
    /**
     * Test of getMemberFacade method, of class MemberFacade.
     */
    /*
    @Test
    public void testGetMemberFacade() {
        System.out.println("getMemberFacade");
        EntityManagerFactory _emf = null;
        MemberFacade expResult = null;
        MemberFacade result = MemberFacade.getMemberFacade(_emf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
     * Test of getRenameMeCount method, of class MemberFacade.
    
    @Test
    public void testGetRenameMeCount() {
        System.out.println("getRenameMeCount");
        MemberFacade instance = null;
        long expResult = 0L;
        long result = instance.getRenameMeCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

