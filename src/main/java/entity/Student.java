package entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Student extends User{

    private String studentNumber;

    @ToString.Exclude
    @OneToMany(mappedBy = "student")
    private Set<ReportCard> reportCards;

    public Student(String firstName, String lastName, String userName, String password, String studentNumber) {
        super(firstName, lastName, userName, password);
        this.studentNumber = studentNumber;
    }
}