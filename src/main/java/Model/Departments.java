package Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "departments", schema = "university_db")
public class Departments implements Serializable {
    private int departmentId;
    private String departmentName;
    private String headOfDepartment;

    public Departments() {
    }

    public Departments( String departmentName, String headOfDepartment) {
        this.departmentName = departmentName;
        this.headOfDepartment = headOfDepartment;
    }

    @Id
    @Column(name = "department_id", nullable = false)
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId)
    {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "department_name", nullable = false, length = 255)
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Basic
    @Column(name = "head_of_department", nullable = false, length = 255)
    public String getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(String headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    @Override
    public String toString() {
        return "Departments{" +
                "departmentId=" + departmentId +"\n"+
                " departmentName=" + departmentName + "\n" +
                " headOfDepartment=" + headOfDepartment + "\n" +
                '}';
    }
}
