/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Christoffer
 */
public class MemberFacadeTest {
    
    public MemberFacadeTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
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
}
