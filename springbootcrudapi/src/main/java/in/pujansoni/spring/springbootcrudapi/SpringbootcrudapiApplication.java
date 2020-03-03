package in.pujansoni.spring.springbootcrudapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootcrudapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootcrudapiApplication.class, args);
	}

}
// In the postman the GET request should be: localhost:8080/api/employee
// In the postman the POST request select the body and select raw and select the type of JSON and insert data, url should be: localhost:8080/api/employee. In addition, the data should be passed in the JSON format without the id parameter as it is autoincrement
// In the postman to GET a single employee use the get method and the URL: localhost:8080/api/employee/2. Here 2 is the id and can be any valid id. 