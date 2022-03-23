package com.niko.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateless
public class EntityManagerProvider {

	@PersistenceContext(unitName = "primary", type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
