package entity;

import base.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Course extends BaseEntity<Integer> {

    @ManyToOne(fetch = FetchType.LAZY)
    private Lesson lesson;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Teacher teacher;

    @OneToMany(mappedBy = "course")
    @ToString.Exclude
    private Set<ReportCard> reportCard;

    @Embedded
    private Term term;


    public Course(Lesson lesson, Teacher teacher, Term term) {
        this.lesson = lesson;
        this.teacher = teacher;
        this.term = term;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id = " + getId() +
                " lesson= " + lesson +
                ", teacher= " + teacher +
                ", reportCard= " + reportCard +
                ", term= " + term +
                "} ";
    }
}