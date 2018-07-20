package pl.rzonsol.springboot.rest.webservice.example.filters;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@JsonFilter("DtoForTestingFilter")
@Getter
@Setter
public class DotForFiltering {

    private String field1;
    private String field2;
    private String field3;

}
