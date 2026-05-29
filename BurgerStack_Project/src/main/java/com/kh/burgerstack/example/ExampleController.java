package com.kh.burgerstack.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("example")
public class ExampleController {
	@GetMapping()
	public String index() {
		return "example/exampleIndex";
	}
}
