package Controller;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//This class was created for connection with database
public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFaactory();

    private static SessionFactory buildSessionFaactory(){
        try {

            return new Configuration().configure().buildSessionFactory();

        }catch (Throwable ex){
            System.out.println("Initial session failed"+ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown(){
        sessionFactory.close();
    }
}