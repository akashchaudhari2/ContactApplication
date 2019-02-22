package com.example.demo.test;

import org.springframework.stereotype.Component;

public class HelloServiceImpl implements HelloService {
	@Override
	public void say() {
		System.out.println("default hello service");
	}

}
