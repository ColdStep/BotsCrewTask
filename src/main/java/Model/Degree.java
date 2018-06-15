package Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "degree", schema = "university_db", catalog = "")
public class Degree {
    private int degreeId;
    private String degreeName;

    @Id
    @Column(name = "degree_id", nullable = false)
    public int getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(int degreeId) {
        this.degreeId = degreeId;
    }

    @Basic
    @Column(name = "degree_name", nullable = false, length = 45)
    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }



    @Override
    public int hashCode() {

        return Objects.hash(degreeId, degreeName);
    }

    @Override
    public String toString() {
        return "Degree{" +
                "degreeId=" + degreeId +
                ", degreeName='" + degreeName + '\'' +
                '}';
    }
}
