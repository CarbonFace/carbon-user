package cn.carbonface.carbonuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableDiscoveryClient
@EnableOpenApi
public class CarbonUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarbonUserApplication.class, args);
    }

}
