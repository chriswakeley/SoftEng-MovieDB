/*
 * Created by Osman Balci on 2016.05.23  * 
 * Copyright © 2016 Osman Balci. All rights reserved. * 
 */
package com.mycompany.sessionbeans;

import com.mycompany.entityclasses.Movie;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Balci
 */
// @Stateless annotation implies that the conversational state with the client shall NOT be maintained.
@Stateless
public class MovieFacade extends AbstractFacade<Movie> {

    /*
    ----------------------------------------------------------------------------------------------------
    Annotating 'private EntityManager em;' with '@PersistenceContext(unitName = "PizzaHut-BalciPU")' 
    implies that the EntityManager instance pointed to by 'em' is associated with the 'PizzaHut-BalciPU'
    persistence context. The persistence context is a set of entity (Customer) instances in which for
    any persistent entity (Customer) identity, there is a unique entity (Customer) instance.
    Within the persistence context, the entity (Customer) instances and their life cycle are managed.
    The EntityManager API is used to create and remove persistent entity (Customer) instances,
    to find entities by their primary key, and to query over entities (Customers).
    ----------------------------------------------------------------------------------------------------
     */
    @PersistenceContext(unitName = "Movies-WakeleyPU")
    private EntityManager em;

    // @Override annotation indicates that the super class AbstractFacade's getEntityManager() method is overridden.
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /* 
    This constructor method invokes the parent abstract class AbstractFacade.java's
    constructor method AbstractFacade, which in turn initializes its entityClass instance
    variable with the Movie class object reference returned by the Movie.class.
     */
    public MovieFacade() {
        super(Movie.class);
    }
    
}
