package com.learningSpringBoot.internalWorkingOfSpring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InternalWorkingOfSpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(InternalWorkingOfSpringApplication.class, args);
	}
	private RazorPayPaymentService paymentService;
	public InternalWorkingOfSpringApplication(RazorPayPaymentService paymentService){
		this.paymentService = paymentService;
	}


	@Override
	public void run(String... args) throws  Exception{
		String payment = paymentService.pay();
		System.out.println("Payment success!");
	}

}
