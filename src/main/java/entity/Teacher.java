package entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Teacher extends User {

    private String teacherNumber;

    @Enumerated(value = EnumType.STRING)
    private TeacherType teacherType;

    public Teacher(String firstName, String lastName, String userName, String password, String teacherNumber, TeacherType teacherType) {
        super(firstName, lastName, userName, password);
        this.teacherNumber = teacherNumber;
        this.teacherType = teacherType;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id = " + getId() + '\'' +
                " teacherNumber= '" + teacherNumber + '\'' +
                ", teacherType= " + teacherType +
                '}';
    }
}