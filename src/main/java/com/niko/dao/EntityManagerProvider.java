package com.niko.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

//Czy to jest odpowiedni rodzaj???
@Stateless
public class EntityManagerProvider {
	
	//Czy nie powinienem skorzystac z czegos takiego??

	@PersistenceContext(unitName = "primary", type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
