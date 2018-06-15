package Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "lectors", schema = "university_db")
public class Lectors implements Serializable {
    private int lectorId;
    private String lectorName;
    private String salary;
    private int degreeId;

    @Id
    @Column(name = "lector_id", nullable = false)
    public int getLectorId() {
        return lectorId;
    }

    public void setLectorId(int lectorId) {
        this.lectorId = lectorId;
    }

    @Basic
    @Column(name = "lector_name", nullable = false, length = 45)
    public String getLectorName() {
        return lectorName;
    }

    public void setLectorName(String lectorName) {
        this.lectorName = lectorName;
    }

    @Basic
    @Column(name = "salary", nullable = false, length = 45)
    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Id
    @Column(name = "degree_id", nullable = false)
    public int getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(int degreeId) {
        this.degreeId = degreeId;
    }


    @Override
    public int hashCode() {

        return Objects.hash(lectorId, lectorName, salary, degreeId);
    }

    @Override
    public String toString() {
        return "Lectors{" +
                "lectorId=" + lectorId +
                ", lectorName='" + lectorName + '\'' +
                ", salary='" + salary + '\'' +
                ", degreeId=" + degreeId +
                '}';
    }
}
