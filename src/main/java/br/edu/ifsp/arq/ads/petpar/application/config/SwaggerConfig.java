package br.edu.ifsp.arq.ads.petpar.application.config;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.validation.annotation.Validated;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.constraints.NotNull;

@Profile("!test")
@Setter
@Validated
@Configuration
@EnableSwagger2
@ConfigurationProperties("swagger")
public class SwaggerConfig {

    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private String version;

    @Bean
    public Docket docketApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("br.edu.ifsp.arq.ads.petpar"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(metaData())
            .useDefaultResponseMessages(false);
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
            .title(title)
            .description(description)
            .version(version)
            .build();
    }

}
