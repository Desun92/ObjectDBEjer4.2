package es.iestetuan.acv.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import es.iestetuan.acv.dao.vo.Color;
import es.iestetuan.acv.dao.IBaseDeDatos;
import es.iestetuan.acv.utilidades.GestorEntityManagerJPA;

public class ColorJPA implements IBaseDeDatos<Color>{

	private EntityManager entityManager;
	
	public void crear(Color entidad) {
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
	}

	public void modificar(Color entidad) {
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
	}

	public void borrar(Color entidad) {
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
	}

	public Color consultarPorID(int codEntidad, Class<Color> clase) {

		Color color = new Color();
		
		try {
			entityManager=GestorEntityManagerJPA.getEntityManager();
			
			color = entityManager.find(Color.class, codEntidad);
		}
		catch (NoResultException e) {
        	color =null;            
        }
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return color;
	}

	public List<Color> consultarLista() {
		
		List<Color> listaColores = null;
		
		try {
			entityManager=GestorEntityManagerJPA.getEntityManager();
			
			String sentenciaJPQL="SELECT color FROM Color color";
			
			TypedQuery<Color> query =entityManager.createQuery(sentenciaJPQL, Color.class);
			
			listaColores=query.getResultList();
		}
		catch (NoResultException e) {
        	listaColores =null;            
        }
		catch(Exception e) {
			e.printStackTrace();
		}
		return listaColores;
	}

}
