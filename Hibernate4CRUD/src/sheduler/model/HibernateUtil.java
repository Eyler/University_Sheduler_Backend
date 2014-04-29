package sheduler.model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
        private static final SessionFactory sessionFactory;

        private static ServiceRegistry serviceRegistry;

        static{
        	Configuration configuration = new Configuration().configure();

            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        

        public static SessionFactory getSessionFactory() {

                return sessionFactory;

        }
}