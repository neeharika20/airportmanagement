package com.main;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.model.Admin;
import com.model.Hangar;
import com.model.Manager;
import com.model.Pilot;
import com.model.Plane;

@Transactional
public class Main {

	public static void main(String[] args) {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("com/config/hibernate.cfg.xml")
				.build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Admin admin = new Admin();
		admin.setAdminFirstName("niharika");
		admin.setAdminLastName("vaddi");
		admin.setAdminAge(20);
		admin.setAdminContactNumber(123);
		admin.setAdminGender("female");
		admin.setAdminPassword("hello");
		session.save(admin);
		Manager manager = new Manager();
		manager.setManagerFirstName("nobita");
		manager.setManagerLastName("doraemon");
		manager.setManagerGender("male");
		manager.setManagerAge(5);
		manager.setManagerContactNumber(456);
		manager.setManagerPassword("dora");
		session.save(manager);
		Plane plane = new Plane();
		plane.setPlaneName("Boeing");
		Hangar hangar = new Hangar();
		hangar.setPlane(plane);
		hangar.setHangarLocation("1A");
		Pilot pilot = new Pilot();
		pilot.setPilotName("Niharika");
		pilot.setPilotLocation("Hyderabad");
		pilot.setPlane(plane);
		session.save(plane);
		session.save(pilot);
		session.save(hangar);
	}

}
