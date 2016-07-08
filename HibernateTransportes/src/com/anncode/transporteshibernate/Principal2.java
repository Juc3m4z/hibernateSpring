package com.anncode.transporteshibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anncode.transporteshibernate.camionero.Camionero;
import com.anncode.transporteshibernate.paquete.Paquete;
import com.anncode.transporteshibernate.provincia.Provincia;

public class Principal2 {

	public static void main(String[] args) {

		/// UNO A MUCHOS
		SessionFactory sessionFactory;
		Configuration configuration = new Configuration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Provincia provincia = new Provincia("QR", "Queretaro");
		Camionero camionero = new Camionero("123ABC", "MIGUEL", "555666", "DIRECCION 1", 300.40, "poblacion 1");
		List<Paquete> paquetes = new ArrayList<>();
		paquetes.add(new Paquete("A001", "Laptop Acer", "Julio Lopez", "direccion de julio", provincia, camionero));
		paquetes.add(new Paquete("B001", "Gafas de sol", "Karla Martinez", "direccion de karla", provincia, camionero));
		paquetes.add(
				new Paquete("C001", "Tenis Nike", "Roberto Pacheco", "direccion de roberto", provincia, camionero));

		provincia.setPaquetes(paquetes);
		camionero.setPaquetes(paquetes);

		session.beginTransaction();
		session.save(provincia);
		session.save(camionero);
		session.getTransaction().commit();

		// Cerrar sesiones
		session.close();
		sessionFactory.close();

	}

}
