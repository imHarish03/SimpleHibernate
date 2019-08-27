package lab.basic.hibernate.SimpleHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
