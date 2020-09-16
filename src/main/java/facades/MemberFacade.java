/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.ClassMemberDTO;
import entities.ClassMember;
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
    
    public List<ClassMemberDTO> getAllMembers() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<ClassMember> query =  em.createQuery("SELECT m FROM ClassMembers m",ClassMember.class);
        List<ClassMember> members = query.getResultList();
        List<ClassMemberDTO> memberDTOs = new ArrayList();
        members.forEach((ClassMember member) -> {
            memberDTOs.add(new ClassMemberDTO(member));
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
            long memberCount = (long)em.createQuery("SELECT COUNT(r) FROM ClassMember r").getSingleResult();
            return memberCount;
        }finally{  
            em.close();
        }
        
    }

}
