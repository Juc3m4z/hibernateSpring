package com.anncode.transporteshibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anncode.transporteshibernate.Camion.Camion;
import com.anncode.transporteshibernate.Camion.CamionDao;

public class Principal {

	public static String matricula = "", modelo = "", tipo = "";
	public static Double potencia = 0.0;
	public static int id = 0, opca= 0, opcb = 0;
	public static Scanner sc = new Scanner(System.in);
	public static SessionFactory sessionFactory;

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();

		int opc = 0;// variable que maneja el menú
		do {
			System.out.println("Menú");
			System.out.println("1.- Búsqueda de camiones");
			System.out.println("2.- Agregar un camión");
			System.out.println("3.- Eliminar un camión");
			System.out.println("4.- Salir");
			opc = sc.nextInt();

			switch (opc) {
			case 1:
				int opc1 = 0;// variable que maneja el sub menú 1
				do {
					System.out.println("Búsqueda:");
					System.out.println("1. Id");
					System.out.println("2. Matrícula");
					System.out.println("3. Modelo");
					System.out.println("4. Salir");
					opc1 = sc.nextInt();
					opca = opc1;
					switch (opc1) {
					case 1:
						buscarParam();
						break;
					case 2:
						buscarParam();
						break;
					case 3:
						buscarParam();
						break;
					case 4:
						System.out.println("Ha salido de búsqueda");
						break;
					default:
						System.out.println("Opción invalida");

					}

				} while (opc1 > 0 & opc1 < 4); // sub menú 1
				break;

			case 2:
				int opc2 = 0;// variable que maneja el sub menú 2
				do {
					System.out.println("Agregar:");
					System.out.println("1. Parametros");
					System.out.println("2. Salir");
					opc2 = sc.nextInt();
					switch (opc2) {
					case 1:
						insertarParam();
						System.out.println("Se han agregado los datos correctamente");
						break;
					case 2:
						System.out.println("Ha salido de agregar");
						break;
					default:
						System.out.println("Opción invalida");
					}
				} while (opc2 > 0 & opc2 < 2);// sub menú 2
				break;

			case 3:
				int opc3 = 0;// variable que maneja el sub menú 3
				do {
					System.out.println("Eliminar:");
					System.out.println("1. Por Id");
					System.out.println("2. Por Matrícula");
					System.out.println("3. Por Modelo");
					System.out.println("4. Salir");
					opc3 = sc.nextInt();
					opcb = opc3;
					switch (opc3) {
					case 1:
						eliminarParam();
						break;
					case 2:
						eliminarParam();
						break;
					case 3:
						eliminarParam();
						break;
					case 4:
						eliminarParam();
						break;
					default:
						System.out.println("Opción invalida");
					}
				} while (opc3 > 0 & opc3 < 4);// sub menú 3
				break;
			}
		} while ((opc > 0 & opc < 4)); // menú principal
		System.out.println("Adios!");
	}

	public static void buscarParam() {
		Camion camion = new Camion();
		HashMap<String, Object> columMap = new HashMap<String, Object>();
		if (opca == 1) {
			System.out.println("Introduce el id:");
			id = sc.nextInt();
			camion.setId(id);
			columMap.put("id", camion.getId());
		}
		if (opca == 2) {
			System.out.println("Introduce la matrícula:");
			matricula = sc.next();
			camion.setMatricula(matricula);
			columMap.put("matricula", camion.getMatricula());
		}
		if (opca == 3) {
			System.out.println("Introduce el modelo:");
			modelo = sc.next();
			camion.setMatricula(modelo);
			columMap.put("modelo", camion.getModelo());
		}

		Session session = sessionFactory.openSession();
		CamionDao camionDao = new CamionDao();
		camionDao.obtenerRegistrosParametros(columMap, session);
		session.close();
		sessionFactory.close();

	}

	public static void insertarParam() {

		System.out.println("Introduce la matrícula:");
		matricula = sc.next();
		System.out.println("Introduce la potencia:");
		potencia = sc.nextDouble();
		System.out.println("Introduce el modelo:");
		modelo = sc.next();
		System.out.println("Introduce el tipo:");
		tipo = sc.next();
		Camion camion = new Camion(matricula, potencia, modelo, tipo);
		Session session = sessionFactory.openSession();
		CamionDao camionDao = new CamionDao();
		camionDao.insertar(camion, session);
		session.close();
		sessionFactory.close();

	}
	
	
	public static void eliminarParam() {
		Camion camion = new Camion();
		HashMap<String, Object> columMap = new HashMap<String, Object>();
		if (opcb == 1) {
			System.out.println("Introduce el id:");
			id = sc.nextInt();
			camion.setId(id);
			columMap.put("id", camion.getId());
		}
		if (opcb == 2) {
			System.out.println("Introduce la matrícula:");
			matricula = sc.next();
			camion.setMatricula(matricula);
			columMap.put("matricula", camion.getMatricula());
		}
		if (opcb == 3) {
			System.out.println("Introduce el modelo:");
			modelo = sc.next();
			camion.setMatricula(modelo);
			columMap.put("modelo", camion.getModelo());
		}

		Session session = sessionFactory.openSession();
		CamionDao camionDao = new CamionDao();
		camionDao.eliminarParametros(columMap, session);
		session.close();
		sessionFactory.close();

	}

}
