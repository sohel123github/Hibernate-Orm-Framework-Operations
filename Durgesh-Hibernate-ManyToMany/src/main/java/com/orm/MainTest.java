package com.orm;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainTest {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();

		// Emp set-

		Emp e1 = new Emp();
		Emp e2 = new Emp();

		e1.setE_id(11);
		e1.setName("Ram");
		e2.setE_id(12);
		e2.setName("Sham");

		// Proj set-

		Proj p1 = new Proj();
		Proj p2 = new Proj();

		p1.setP_id(1);
		p1.setProj_name("Collection");
		p2.setP_id(2);
		p2.setProj_name("Jdbc");

		List<Emp> list1 = new ArrayList();
		List<Proj> list2 = new ArrayList();

		list1.add(e1);
		list1.add(e2);

		list2.add(p1);
		list2.add(p2);

		e1.setProj(list2); // 11 ko do project assign hai p2.setEmp(list1);//2nd
							// project assign hai 2 employee ko

		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);

		// Fetch data by using get/load method (from emp-table)-
		/*
		 * Emp e=(Emp)session.get(Emp.class, 11); System.out.println(e.getName());
		 * System.out.println(e.getProj().size());
		 */

		// Fetch data by using get/load method (from Proj-table)-
//		Proj p = (Proj) session.get(Proj.class, 1);
//		System.out.println(p.getProj_name());
//		System.out.println(p.getEmp().size());

		tr.commit();
		session.close();
		factory.close();
		System.out.println("Record inserted successfully..");
	}
}
