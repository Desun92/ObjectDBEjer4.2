package es.iestetuan.acv.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import es.iestetuan.acv.dao.vo.Linea;
import es.iestetuan.acv.dao.IBaseDeDatos;
import es.iestetuan.acv.utilidades.GestorEntityManagerJPA;

public class LineaJPA implements IBaseDeDatos<Linea> {
	
	private EntityManager entityManager;

	public void crear(Linea entidad) {
		EntityTransaction transaccion=null;
		try {
			entityManager=GestorEntityManagerJPA.getEntityManager();
			transaccion=entityManager.getTransaction();
			transaccion.begin();
			
			entityManager.persist(entidad);
            
            transaccion.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			entityManager.close();
		}
	}

	public void modificar(Linea entidad) {
		EntityTransaction transaccion=null;
		try {
			entityManager=GestorEntityManagerJPA.getEntityManager();
			transaccion=entityManager.getTransaction();
			transaccion.begin();
			
			if(!entityManager.contains(entidad))
				entidad=entityManager.merge(entidad);
            
            transaccion.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			entityManager.close();
		}
	}

	public void borrar(Linea entidad) {
		EntityTransaction transaccion=null;
		try {
			entityManager=GestorEntityManagerJPA.getEntityManager();
			transaccion=entityManager.getTransaction();
			transaccion.begin();
			
			if(!entityManager.contains(entidad))
				entidad=entityManager.merge(entidad);
			
			entityManager.remove(entidad);
            
            transaccion.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			entityManager.close();
		}
	}

	public Linea consultarPorID(int codEntidad, Class<Linea> clase) {
		
		Linea linea = new Linea();
		
		try {
			entityManager=GestorEntityManagerJPA.getEntityManager();
			
			linea = entityManager.find(Linea.class, codEntidad);
		}
		catch (NoResultException e) {
        	linea =null;            
        }
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			entityManager.close();
		}
		return linea;
	}

	public List<Linea> consultarLista() {
		
		List<Linea> listaLineas = null;
		
		try {
			entityManager=GestorEntityManagerJPA.getEntityManager();
			
			String sentenciaJPQL="Select linea FROM Linea linea";
			
			TypedQuery<Linea> query =entityManager.createQuery(sentenciaJPQL, Linea.class);
			
			listaLineas=query.getResultList();
		}
		catch (NoResultException e) {
        	listaLineas =null;            
        }
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			entityManager.close();
		}
		return listaLineas;
	}



}
