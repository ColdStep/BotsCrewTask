import Model.Degree;
import Model.Departments;
import Model.Lectors;
import Controller.HibernateUtil;
import org.hibernate.Session;

import javax.management.Query;
import java.util.List;
//This class was created for testing a new methods
public class Test {
    public static void main(String[] args) {


        try {
            HibernateUtil hibernateUtil = new HibernateUtil();
            Session session = hibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            System.out.println("Begin transaction");

            List list1 = session.createQuery("from Departments ").list();
            for (Departments departments1 : (List<Departments>) list1) {
                System.out.println(departments1.toString());
            }
            System.out.println();
            List list2 = session.createQuery("from Degree ").list();
            for (Degree degree : (List<Degree>) list2) {
                System.out.println(degree.toString());
            }
            System.out.println();
            List list3 = session.createQuery("from Lectors ").list();
            for (Lectors lectors : (List<Lectors>) list3) {
                System.out.println(lectors.toString());
            }
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            new HibernateUtil().shutdown();
        }
    }
}
