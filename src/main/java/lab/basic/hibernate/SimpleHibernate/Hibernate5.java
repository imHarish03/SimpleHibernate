package lab.basic.hibernate.SimpleHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Hibernate5 {
	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			if (sessionFactory == null) {
				Configuration configuration = new Configuration()
						.configure(User.class.getResource("/hibernate.cfg.xml"));
				StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
				serviceRegistryBuilder.applySettings(configuration.getProperties());
				ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			}
			return sessionFactory;
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}

	public static void main(String[] args) {

		try {
			System.out.println("///////////////Hibernate 5///////////");
			Session session = sessionFactory.openSession();
			User user = (User) session.get(User.class, 1);
			System.out.println(user.getName());

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
