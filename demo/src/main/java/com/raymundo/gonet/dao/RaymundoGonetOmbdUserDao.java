package com.raymundo.gonet.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.raymundo.gonet.api.UserRepository;
import com.raymundo.gonet.model.RaymundoGonetOmbdUser;

@Repository
public class RaymundoGonetOmbdUserDao implements UserRepository {

	@PersistenceContext
	private EntityManager entityManager;

	protected final Log logger = LogFactory.getLog(getClass());


	@SuppressWarnings("unchecked")
	@Override
	public RaymundoGonetOmbdUser findByUsername(String idUser){
	 try {
			String query = "FROM RaymundoGonetOmbdUser r WHERE r.username =:idUser";

		Query q = entityManager.createQuery(query);
		q.setParameter("idUser", idUser);
		
		return (RaymundoGonetOmbdUser) q.getSingleResult();
		
	 } catch (RuntimeException ex) {
			logger.error(ex.getMessage());
			throw ex;
	 }
	}

}
