package entity;

import base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass
public class User extends BaseEntity<Integer> {

    private String firstName;

    private String lastName;
    @Column(unique = true)
    private String userName;
    private String password;

}