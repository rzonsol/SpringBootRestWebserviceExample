package pl.rzonsol.springboot.rest.webservice.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final Contact DEFAULT_CONTACT = new Contact("", "", "");
    private static final springfox.documentation.service.ApiInfo API_INFO = new ApiInfo("title",
            "String description",
            "String version",
            "String termsOfServiceUrl",
            DEFAULT_CONTACT,
            "String license",
            "String licenseUrl",
            Collections.emptyList());

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(API_INFO);
    }

}
