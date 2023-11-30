package service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDto implements Serializable {

    private String firstName;

    private String lastName;

    private String userName;

    private String password;

}