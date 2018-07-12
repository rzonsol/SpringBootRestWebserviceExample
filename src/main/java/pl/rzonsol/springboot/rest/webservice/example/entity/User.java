package pl.rzonsol.springboot.rest.webservice.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class User {

    private Integer id;

    @Size(min = 2, message = "Name should have at least 2 character!")
    private String name;

    @Past
    private Date birthDate;
}
