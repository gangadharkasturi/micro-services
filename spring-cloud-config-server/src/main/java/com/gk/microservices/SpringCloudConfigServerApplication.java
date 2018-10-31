package com.gk.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
/**
 * 
 * @author Gangadhar
 * http://localhost:8888/limits-service/default - hit this
 *http://localhost:8888/limits-service/qa for qa properties as config
 *http://localhost:8888/limits-service/dev for dev properties as config
 */
public class SpringCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerApplication.class, args);
	}
}
