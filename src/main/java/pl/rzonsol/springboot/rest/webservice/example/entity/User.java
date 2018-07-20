package pl.rzonsol.springboot.rest.webservice.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "User model description!")
public class User {

    private Integer id;

    @Size(min = 2, message = "Name should have at least 2 character!")
    @ApiModelProperty(notes = "Name should have at least 2 characters!")
    private String name;

    @Past
    @ApiModelProperty(notes = "Date should be in the past!")
    private Date birthDate;
}
