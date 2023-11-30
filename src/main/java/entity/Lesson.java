package entity;

import base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Lesson extends BaseEntity<Integer> {
    private String title;
    private Long unit;

    @Override
    public String toString() {
        return "Lesson{" +
                "id = " + getId() +'\'' +
                " title='" + title + '\'' +
                ", unit=" + unit +
                "} ";
    }
}