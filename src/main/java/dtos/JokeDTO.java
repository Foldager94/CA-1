/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Joke;

/**
 *
 * @author Christoffer
 */
public class JokeDTO {

    private long id;
    private String joke;

    public JokeDTO(Joke joke) {
        this.id = joke.getId();
        this.joke = joke.getJoke();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    
}
