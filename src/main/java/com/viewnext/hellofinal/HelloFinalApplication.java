package com.viewnext.hellofinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class HelloFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloFinalApplication.class, args);
	}
	@GetMapping("/")
	public String hello(@RequestParam(value = "name", defaultValue = "Oscar") String name) {
		return String.format("Hello %s!", name);
	}
	@GetMapping("/spring")
	public String hola(@RequestParam(value = "name2", defaultValue = "MundoSpring") String name2){
		return String.format("Hello %s!", name2);
	}
	@RequestMapping("/suma")
	public @ResponseBody
	Float add(
			@RequestParam (name="a") Float a,
			@RequestParam (name="b") Float b) {
		return a + b;
	}


}
