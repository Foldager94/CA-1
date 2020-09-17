/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.JokeDTO;
import entities.Joke;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class JokeFacade {

    private static JokeFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private JokeFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static JokeFacade getJokeFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new JokeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<JokeDTO> getAllJokes() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Joke> query = em.createQuery("SELECT j FROM Joke j", Joke.class);

        List<Joke> jokes = query.getResultList();
        List<JokeDTO> JokeDTOs = new ArrayList();

        jokes.forEach((Joke joke) -> {
            JokeDTOs.add(new JokeDTO(joke));
        });
        return JokeDTOs;
    }

    public JokeDTO getJokeByID(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Joke jokeOBJ = em.find(Joke.class, id);
            return new JokeDTO(jokeOBJ);
        } finally {
            em.close();
        }
    }

    public List<JokeDTO> getAllJokesByType(String type) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Joke> query = em.createQuery("SELECT j FROM Joke j WHERE j.type LIKE :type", Joke.class);
        query.setParameter("type", "%" + type + "%");

        List<Joke> jokes = query.getResultList();
        List<JokeDTO> JokeDTOs = new ArrayList();

        jokes.forEach((Joke joke) -> {
            JokeDTOs.add(new JokeDTO(joke));
        });
        return JokeDTOs;
    }

    public long getJokeCount() {
        EntityManager em = emf.createEntityManager();
        try {
            long jokeCount = (long) em.createQuery("SELECT COUNT(r) FROM Joke r").getSingleResult();
            return jokeCount;
        } finally {
            em.close();
        }
    }

    public Joke getRandomQuestion() {
        EntityManager em = emf.createEntityManager();
        Random random = new Random();
        int number = random.nextInt((int) getJokeCount());
        TypedQuery<Joke> query = em.createQuery("SELECT j FROM Joke j", Joke.class);
        query.setFirstResult(number);
        query.setMaxResults(1);
        return (Joke) query.getSingleResult();
    }

}
