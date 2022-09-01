package kbsc.kbsc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any()) //swagger api 문서로 만들기 원하는 basePackage 경로
                .paths(PathSelectors.any()) //apis() 중 path에 맞는 api 필터링
                .build();
    }

    // Swagger로 설정하는 API 정보
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Chevita API")
                .description("Chevita API for Developers")
                .termsOfServiceUrl("https://github.com/chevita-2022")
                .build();
    }
}
