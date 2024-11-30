package org.me.learning.springmongodb;

import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringMongoDbApplication {

    //        now i want to just to know how to use swagger so i have to copy past some code here

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public-apis")
                .pathsToMatch("/**") // here to define you url to match it
                .build();
    }

    @Bean
    public io.swagger.v3.oas.models.OpenAPI customOpenAPI() {
        return new io.swagger.v3.oas.models.OpenAPI()
                .info(new Info()
                        .title("Job Post")
                        .description("all my project Apis")
                        .version("1.0.0"));
    }




    public static void main(String[] args) {
        SpringApplication.run(SpringMongoDbApplication.class, args);

    }

}
