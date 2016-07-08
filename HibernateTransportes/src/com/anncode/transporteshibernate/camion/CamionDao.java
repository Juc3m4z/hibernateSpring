package com.anncode.transporteshibernate.camion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class CamionDao {

	public void insertar(Camion camion, Session session){
		try {
			session.beginTransaction();
			session.save(camion);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			System.err.println("****ERROR AL INSERTAR CAMION****");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	public Camion obtenerRegistroPorID(int id, Session session){ 
		Camion camion = null;
		try {
			camion = (Camion) session.get(Camion.class, 2);
		}  catch (HibernateException e) {
			// TODO: handle exception
			System.err.println("****ERROR AL OBTENER EL CAMION POR ID****");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return camion;
	}
	
	
	public List<Camion> obtenerTodosRegistros(Session session){
		List<Camion> camiones = null;
		try {
			camiones = (List<Camion>) session.createCriteria(Camion.class).list();
			
		}  catch (HibernateException e) {
			// TODO: handle exception
			System.err.println("****ERROR AL OBTENER TODOS LOS REGISTROS DE CAMION****");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return camiones;
	}
	
	public List<Camion> obtenerRegistrosParametros(HashMap<String, Object> parametros, Session session){
		String hql = "FROM Camion WHERE ";
		List<Camion> camiones = null;
		try {
			String parametrosQuery = "";
			int i = 1;
			for (Map.Entry<String, Object> parametro: parametros.entrySet()){
				parametrosQuery += parametro.getKey() + "= :" + parametro.getKey();
				if(i> parametros.size()){
					parametrosQuery += " AND ";
				}
				i++;
			}
			Query query = session.createQuery(hql + parametrosQuery);
			for (Map.Entry<String, Object> parametro: parametros.entrySet()){
				query.setParameter(parametro.getKey(), parametro.getValue());
			}
			
			session.beginTransaction();
			camiones = query.list();
			session.getTransaction().commit();
				
		} catch (HibernateException e) {
			// TODO: handle exception
			System.err.println("****ERROR AL OBTENER REGISTROS DE PARAMETRO****");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return camiones;
	}
	
	public void actualizar(Camion camion, Session session){
		
		try {
			Camion camion2 = (Camion) session.get(Camion.class, camion.getId());
			camion2.setMatricula(camion.getMatricula());
			camion2.setModelo(camion.getModelo());
			camion2.setPotencia(camion.getPotencia());
			session.beginTransaction();
			session.update(camion2);
			session.getTransaction().commit();
			
		}  catch (HibernateException e) {
			// TODO: handle exception
			System.err.println("****ERROR AL OBTENER REGISTROS POR PARAMETRO****");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public int actualizarParametros(HashMap<String, Object> parametros, HashMap<String, Object> filtros, Session session){
		int row_afectados = 0;
		
		String hql = "UPDATE Camion SET";
		try {
			String parametrosQuerySET = "";
			int i = 1;
			for (Map.Entry<String, Object> parametro: parametros.entrySet()){
				parametrosQuerySET += parametro.getKey() + "= :" + parametro.getKey();
				if(i> parametros.size()){
					parametrosQuerySET += ", ";
				}
				i++;
			}
			
			String parametrosQueryWHERE = " WHERE ";
			int j = 1;
			for (Map.Entry<String, Object> filtro: filtros.entrySet()){
				parametrosQueryWHERE += filtro.getKey() + "= :" + filtro.getKey();
				if(j < filtros.size()){
					parametrosQueryWHERE += " AND ";
				}
				j++;
			}
			
			Query query = session.createQuery(hql + parametrosQuerySET + parametrosQueryWHERE);
			for (Map.Entry<String, Object> parametro: parametros.entrySet()){
				query.setParameter(parametro.getKey(), parametro.getValue());
			}
			for (Map.Entry<String, Object> filtro: filtros.entrySet()){
				query.setParameter(filtro.getKey(), filtro.getValue());
			}
			
			session.beginTransaction();
			row_afectados = query.executeUpdate();
			session.getTransaction().commit();
				
		} catch (HibernateException e) {
			// TODO: handle exception
			System.err.println("****ERROR AL ACTUALIZAR LOS REGISTROS POR PARAMETRO****");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return row_afectados;
	}
	
	public void eliminar(Camion camion, Session session){
		try {
			Camion camion2 = (Camion) session.get(Camion.class, camion.getId());
			session.beginTransaction();
			session.delete(camion2);
			session.getTransaction().commit();
			
		}  catch (HibernateException e) {
			// TODO: handle exception
			System.err.println("****ERROR AL ELIMINAR REGISTROS POR OBJETO****");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	public int eliminarParametros(HashMap<Object, Object> parametros){
		int row_afectados = 0;
		return row_afectados;
	}
	
}
