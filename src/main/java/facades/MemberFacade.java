/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.MemberDTO;
import entities.Member;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Christoffer
 */
public class MemberFacade {
    
    private static MemberFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private MemberFacade() {}
    
    public List<MemberDTO> getAllMembers() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Member> query =  em.createQuery("SELECT m FROM members m",Member.class);
        List<Member> members = query.getResultList();
        List<MemberDTO> memberDTOs = new ArrayList();
        members.forEach((Member member) -> {
            memberDTOs.add(new MemberDTO(member));
        });
        return memberDTOs;     
    }
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static MemberFacade getMemberFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MemberFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //TODO Remove/Change this before use
    public long getMemberCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long memberCount = (long)em.createQuery("SELECT COUNT(r) FROM member r").getSingleResult();
            return memberCount;
        }finally{  
            em.close();
        }
        
    }

}
