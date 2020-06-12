package local.sierraog.compflow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class Swagger2Config {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("local.sierraog.compflow"))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(apiEndPointsInfo());
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Compressible Flow Calculator")
                .description("REST API for calculation of compressible flow relations. Includes Isentropic Flows, Normal Shocks, Oblique Shocks, Fanno Flows, and Rayleigh Flows.")
                .contact(new Contact("Sierra Obermoeller-Gilmer",
                        "http://www.sierrao.com",
                        "sierrao@utexas.edu"))
                .license("MIT")
                .licenseUrl("https://github.com/SierraOG/CompressibleFlowCalculator/blob/master/LICENSE")
                .version("1.0.0")
                .build();
    }
}
