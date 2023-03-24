package com.example.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class EntityManagerProducer {

  @PersistenceContext(unitName = "myDB")
  private EntityManager mEntityManager;

  @Produces
  @Default
  public EntityManager getEntityManager() {
    return mEntityManager;
  }

  public void dispose(@Disposes @Default EntityManager entityManager) {
    if (entityManager.isOpen()) {
      entityManager.close();
    }
  }
}
