package pl.rzonsol.springboot.rest.webservice.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class User {

    private Integer id;

    private String name;

    private Date birthDate;
}
