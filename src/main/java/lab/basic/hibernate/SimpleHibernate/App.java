package lab.basic.hibernate.SimpleHibernate;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		try {
			//// Load Configuration
			/*
			 * Configuration cfg = new Configuration();
			 * cfg.addAnnotatedClass(lab.basic.hibernate.SimpleHibernate.User.class);
			 * cfg.configure(); SessionFactory sessionFactory = cfg.buildSessionFactory();
			 * Session session = sessionFactory.openSession();
			 */

			///// Save Data into Database
			SessionFactory sessionFactory = new AnnotationConfiguration().configure(new File("hibernate.cfg.xml"))
					.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			User u = new User();
			u.setName("Saurabh");

			session.save(u);
			transaction.commit();

			/// LoadExample
			load(sessionFactory);
			// getExample
			get(sessionFactory);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void load(SessionFactory sessionFactory) {
		//////////////
		try {
			Session session2 = sessionFactory.openSession();
			User getUser = (User) session2.load(User.class, 101);
			System.out.println(getUser.getName());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void get(SessionFactory sessionFactory) {
		//////////////
		try {
			Session session2 = sessionFactory.openSession();
			User getUser = (User) session2.get(User.class, 101);
			System.out.println(getUser.getName());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
