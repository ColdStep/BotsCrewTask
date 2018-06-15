package Controller;

import Model.Departments;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class ConsoleMethods {
//    All methods for console interface
private SessionFactory sessionFactory;

    public ConsoleMethods() {
        sessionFactory=new HibernateUtil().getSessionFactory();
    }

    public void endSesionFactory(){
        sessionFactory.close();
    }

    public String headOfDepartment(String departmentName){
        String head;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List list1 = session.createQuery("select headOfDepartment from Departments where departmentName='"+departmentName+"'").list();
        head="\n----------------------- Head of "+ departmentName + " department is "+list1.get(0)+" -----------------------\n";
        session.close();
        return head;
    }

    public String showStatistic(String departmentName){
        String result="";
        List list = new ArrayList();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        list.add(session.createQuery("select count(l.lectorName) from Lectors l, Departments d, DepartmentsLectors dl , Degree de where l.lectorId=dl.lectorId" +
                " and d.departmentId=dl.departmentId and l.degreeId=de.degreeId and de.degreeName='Assistant' and d.departmentName='" +
                departmentName+"'" ).list());

        list.add(session.createQuery("select count(l.lectorName) from Lectors l, Departments d, DepartmentsLectors dl , Degree de where l.lectorId=dl.lectorId" +
                " and d.departmentId=dl.departmentId and l.degreeId=de.degreeId and de.degreeName='Associate professor' and d.departmentName='" +
                departmentName+"'" ).list());
        list.add(session.createQuery("select count(l.lectorName) from Lectors l, Departments d, DepartmentsLectors dl , Degree de where l.lectorId=dl.lectorId" +
                " and d.departmentId=dl.departmentId and l.degreeId=de.degreeId and de.degreeName='Professor' and d.departmentName='" +
                departmentName+"'" ).list());

        session.close();

        result+="--------------------------------------\n";
        result+= "Asistans - "+list.get(0)+"\n";
        result+= "Associate professors - "+list.get(1)+"\n";
        result+= "Professors - "+list.get(2)+"\n";
        result+="--------------------------------------\n";

        return result;

    }

    public String avarageSalary(String departmentName){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List list = session.createQuery("select avg (l.salary) from Lectors l, Departments d, DepartmentsLectors dl " +
                "where l.lectorId=dl.lectorId and d.departmentId=dl.departmentId and d.departmentName='" +
                departmentName+"'").list();
        double avarage = (double) list.get(0);
        session.close();
        return "\n----------------------- Avarage salary in"+departmentName+" = "+avarage+"-----------------------\n";
    }

    public String countOfEmployee(String departmentName){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List list = session.createQuery("select l.lectorName from Lectors l, Departments d, DepartmentsLectors dl " +
                "where l.lectorId=dl.lectorId and d.departmentId=dl.departmentId and d.departmentName='" +
                departmentName+"'").list();
        session.close();
        return "\n----------------------- Count of employees in "+departmentName+" = "+list.size()+" -----------------------\n";
    }

    public String globalSearch(String name){
        String result="";
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List list = session.createQuery(" select l.lectorName from Lectors l where l.lectorName like '%"+ name+"%'").list();
        for (Object obj : (List<String>)list){
               result+="\n----------------------- "+obj+" -----------------------\n";
        }
        session.close();
        return result;
    }

}
