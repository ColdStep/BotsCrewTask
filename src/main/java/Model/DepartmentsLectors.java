package Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "departments_lectors", schema = "university_db", catalog = "")
public class DepartmentsLectors implements Serializable {
    private int departmentId;
    private int lectorId;

    @Id
    @Column(name = "department_id", nullable = false)
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Id
    @Column(name = "lector_id", nullable = false)
    public int getLectorId() {
        return lectorId;
    }

    public void setLectorId(int lectorId) {
        this.lectorId = lectorId;
    }


    @Override
    public int hashCode() {

        return Objects.hash(departmentId, lectorId);
    }
}
