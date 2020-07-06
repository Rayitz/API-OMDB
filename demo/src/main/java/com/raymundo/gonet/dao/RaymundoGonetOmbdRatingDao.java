package com.raymundo.gonet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.raymundo.gonet.api.RatingRepository;
import com.raymundo.gonet.model.RaymundoGonetOmbdRating;

@Repository
public class RaymundoGonetOmbdRatingDao implements RatingRepository {

	@PersistenceContext
	private EntityManager entityManager;

	protected final Log logger = LogFactory.getLog(getClass());


	@SuppressWarnings("unchecked")
	@Override
	public List<RaymundoGonetOmbdRating> getRatings(int idUser){
	 try {
			String query = "FROM RaymundoGonetOmbdRating r WHERE r.iRatingUser =:idUser";

		Query q = entityManager.createQuery(query);
		q.setParameter("idUser", idUser);
		
		return q.getResultList();
		
	 } catch (RuntimeException ex) {
			logger.error(ex.getMessage());
			throw ex;
	 }
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public RaymundoGonetOmbdRating setRating(RaymundoGonetOmbdRating rating){
	 try {

          entityManager.persist(rating);


		return rating;
	 } catch (RuntimeException ex) {
			logger.error(ex.getMessage());
			throw ex;
	 }
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public RaymundoGonetOmbdRating updateRating(RaymundoGonetOmbdRating rating){
	 try {

          entityManager.merge(rating);


		return rating;
	 } catch (RuntimeException ex) {
			logger.error(ex.getMessage());
			throw ex;
	 }
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public RaymundoGonetOmbdRating getRatingsByUserMovie(int idUser, String idMovie){
	 try {
			String query = "FROM RaymundoGonetOmbdRating r WHERE r.iRatingUser =:idUser AND r.nRatingMovieId =:idMovie";

		Query q = entityManager.createQuery(query);
		q.setParameter("idUser", idUser);
		q.setParameter("idMovie", idMovie);
		
		return (RaymundoGonetOmbdRating) q.getSingleResult();
		
	     } catch (NoResultException ex) {
			return null;
		 } catch (RuntimeException ex) {
			logger.error(ex.getMessage());
			throw ex;
	 }
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void deleteRating(int idUser, String idMovie) {
	 try {
		 RaymundoGonetOmbdRating entity = getRatingsByUserMovie(idUser, idMovie);
		 
          entityManager.remove(entity);
         
	 }catch (RuntimeException ex) {
			logger.error(ex.getMessage());
			throw ex;
	 }
	}
}
