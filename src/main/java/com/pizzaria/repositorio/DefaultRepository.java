package com.pizzaria.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

@NoRepositoryBean
public class DefaultRepository<T, PK extends Serializable> {

	protected static Logger log = Logger.getLogger("Pizzaria - DAO");
	
	@PersistenceContext
    protected EntityManager entityManager;

	@Transactional
	protected List<T> listar(Class<T> classe) {
		log.info("Início DefaultRepository.listar(" + classe.getName() + ")");	
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteria = (CriteriaQuery<T>) cb.createQuery(classe);
		Root<T> lista = (Root<T>) criteria.from(classe);
		criteria.select(lista);

		log.info("Fim DefaultRepository.listar(" + classe.getName() + ")");	
		return entityManager.createQuery(criteria).getResultList();
	}

	@Transactional
	protected T getById(Class<T> classe, PK id) {
		log.info("Início DefaultRepository.getById(" + classe.getName() + ", " + id + ")");	
		T o;
		try {
			o = entityManager.find(classe, id);
			
			log.info("Fim DefaultRepository.getById(" + classe.getName() + ", " + id + ")");	
			return o;
		} catch (NoResultException e) {
			
			log.error("Exception DefaultRepository.getById(" + classe.getName() + ", " + id + ")");	
			return null;
		} finally {
            if (entityManager != null) {
            	entityManager.close();
            }
		}		
	}

	@Transactional()
	protected boolean save(T object) {
		log.info("Início DefaultRepository.save(" + object + ")");	
		
		try {
			entityManager.merge(object);
			
			log.info("Fim DefaultRepository.save(" + object + ")");	
			return true;
		} catch (Exception e) {
			
			log.error("Exception DefaultRepository.save(" + object + ")");	
			e.printStackTrace();
			return false;
		} finally {
            if (entityManager != null) {
            	entityManager.close();
            }
		}
		
	}	
}
