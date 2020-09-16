/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.ClassMember;

/**
 *
 * @author Christoffer
 */
public class ClassMemberDTO {
   private String id; 
   private String navn; 
   private String favSlik; 

    public ClassMemberDTO(ClassMember member) {
        this.id = member.getId();
        this.navn = member.getNavn();
        this.favSlik = member.getFavSlik();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getFavSlik() {
        return favSlik;
    }

    public void setFavSlik(String favSlik) {
        this.favSlik = favSlik;
    }
   
   
}
