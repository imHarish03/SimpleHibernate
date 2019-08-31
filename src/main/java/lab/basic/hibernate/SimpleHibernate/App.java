package lab.basic.hibernate.SimpleHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
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
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(lab.basic.hibernate.SimpleHibernate.User.class);
			cfg.configure();
			SessionFactory sessionFactory = cfg.buildSessionFactory();
			Session session = sessionFactory.openSession();

			Transaction transaction = session.beginTransaction();
			User u = new User();
			u.setName("Haris");

			session.save(u);
			transaction.commit();

			///
			Session session2 = sessionFactory.openSession();
			System.out.println("/////////Load Method////");
			User getUsrs = (User) session2.get(User.class, 100);
			System.out.println(getUsrs.getName());

			User getUsr = (User) session2.load(User.class, 100);
			System.out.println(getUsr.getName());

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
