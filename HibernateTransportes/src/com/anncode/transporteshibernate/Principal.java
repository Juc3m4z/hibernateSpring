package com.anncode.transporteshibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anncode.transporteshibernate.camion.Camion;
import com.anncode.transporteshibernate.camion.CamionDao;



public class Principal {

	public static void main(String[] args) {
		
		///generar una sesion en nuestra base de datos
		
		CamionDao camionDao = new CamionDao();
		
		
		SessionFactory sessionFactory;
		Configuration configuration = new Configuration();
		configuration.configure(); ///archivo de configuracion
		sessionFactory = configuration.buildSessionFactory();///comienza a construir la sesion
		
		//Insertar un registro a la bd 
		Camion camion = new Camion("56QWER2", 3.0, "NISSAN","R4"); //Instaciamos el objeto camion
		Session session = sessionFactory.openSession(); //abrimos la sesion
		
		/*session.beginTransaction();
		session.save(camion); //Insertamos el registro
		session.getTransaction().commit();//Hace el commit para insertar*/
		
		//Obtener datos en la bd
		
		/*Camion camion2 = (Camion) session.get(Camion.class, 1);//especificamos a que tabla hacemos la consulta
		System.out.println("ID: " + camion2.getId());
		System.out.println("Matricula: " + camion2.getMatricula());
		System.out.println("Potencia: " + camion2.getPotencia());*/
		
		/*List<Camion> camiones = (List<Camion>) 
				session.createCriteria(Camion.class).setMaxResults(2).list();
		
		int i = 0;
		
		for (Camion camion3 : camiones){
			i++;
			System.out.println(i + ". ID " + camion3.getId());
			System.out.println(i + ". Matricula " + camion3.getMatricula());
			
		}*/
		
		//Actualizar los datos en la bd con HQL 
		/*session.beginTransaction(); //sentencias mas elavoradas
		String hql = "UPDATE Camion set matricula = :matricula WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("matricula", "TYU987");
		query.setParameter("id", 2);
		query.executeUpdate();
		session.getTransaction().commit();*/
		
		//Actualizar los datos en la bd con Objeto
		/*session.beginTransaction(); //sentencias mas sencillas pero tarda un poco mas las consultas
		Camion camion4 = (Camion) session.get(Camion.class, 2);
		camion4.setMatricula("POIU123");
		session.getTransaction().commit();*/
		
		//Eliminar un dato en la bd con objeto
		/*session.beginTransaction();
		Camion camion5 = (Camion) session.get(Camion.class, 1);
		session.delete(camion5);
		session.getTransaction().commit();*/
		
		//Eliminar un dato en la bd con HQL
		session.beginTransaction();
		String hql = "DELETE FROM Camion WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", 4);
		query.executeUpdate();	
		session.getTransaction().commit();
		//Cerrar sesiones
		
		session.close();
		sessionFactory.close();

	}

}
