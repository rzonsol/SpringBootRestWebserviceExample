package pl.rzonsol.springboot.rest.webservice.example.filters;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {


    @GetMapping(name = "/filterTest")
    public MappingJacksonValue testFilter(){
        DotForFiltering dto = new DotForFiltering("field1", "field2", "field3");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("DtoForTestingFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(dto);
        mapping.setFilters(filters);

        return mapping;
    }
}
