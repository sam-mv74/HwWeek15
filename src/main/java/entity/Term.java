package entity;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Term {

    private Integer year;

    @Enumerated(value = EnumType.STRING)
    private MidTerm midTerm;

}
