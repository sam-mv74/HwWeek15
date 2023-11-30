package service.dto;

import entity.Teacher;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TeacherPaySlip implements Serializable {

        private Teacher teacher;

        private Long teachingUnits;

        private double salary;
}