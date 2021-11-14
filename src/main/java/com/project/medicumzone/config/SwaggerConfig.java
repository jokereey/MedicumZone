package com.project.medicumzone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    @Bean
    public Docket postMatchApi() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.project.medicumzone"))
                .paths(PathSelectors.ant("/api/**")).build();
    }
}
