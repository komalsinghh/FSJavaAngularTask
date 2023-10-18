package com.nagarro.assignment1.main;

import java.util.Scanner;

import com.nagarro.assignment1.entities.Car;
import com.nagarro.assignment1.service.CalculationService;
import com.nagarro.assignment1.service.DisplayService;
import com.nagarro.assignment1.service.InputService;

public class CarInsurance {

	public static void main(String[] args) {
		char ans = ' ';
		Car car = new Car();
		Scanner sc1 = new Scanner(System.in);
		do{
			try {
			InputService carDetails = new InputService();
			car = carDetails.getInputFromUser();

			CalculationService insuranceDetails = new CalculationService();
			car = insuranceDetails.calculateInsurance(car);

			DisplayService showDetails = new DisplayService(car);
			System.out.println(showDetails.toString());

			System.out.println("Do you want to enter details of any other car (y/n)?");
			ans = sc1.next().charAt(0);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}

		}while (ans == 'y');
		sc1.close();
	}

}
