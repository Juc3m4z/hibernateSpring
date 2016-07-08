package com.anncode.transporteshibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anncode.transporteshibernate.camion.Camion;
import com.anncode.transporteshibernate.camionero.Camionero;

public class Principal3 {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory;
		Configuration configuration = new Configuration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Camion camion1 = new Camion("1234WEH", 3.0, "FORD","Y4");
		Camion camion2 = new Camion("TR2341", 3.0, "RENAULT","F7");

		Camionero camionero1 = new Camionero("123ABC", "MIGUEL", "555666", "DIRECCION 1", 300.40, "poblacion 1");
		Camionero camionero2 = new Camionero("456FGH", "PEDRO", "555537", "DIRECCION 2", 300.50, "poblacion 2");
		Camionero camionero3 = new Camionero("890AQS", "JUAN", "555784", "DIRECCION 3", 300.60, "poblacion 3");

		camion1.getCamioneros().add(camionero1);
		camion1.getCamioneros().add(camionero2);
		camion2.getCamioneros().add(camionero3);

		camionero1.getCamion().add(camion1);
		camionero2.getCamion().add(camion1);
		camionero3.getCamion().add(camion2);
		
		session.beginTransaction();
		
		session.save(camion1);
		session.save(camion2);

		session.getTransaction().commit();
		session.close();

	}

}
