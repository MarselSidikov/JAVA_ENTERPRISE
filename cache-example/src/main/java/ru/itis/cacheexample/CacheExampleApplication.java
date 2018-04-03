package ru.itis.cacheexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class CacheExampleApplication extends SpringBootServletInitializer {

	@GetMapping("/page")
    public String getPage() {
	    return "page";
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CacheExampleApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(CacheExampleApplication.class, args);
	}
}
