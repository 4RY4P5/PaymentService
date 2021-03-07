package com.cts.rom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cts.rom.service.CardService;

@RestController
public class CardController {
	@Autowired
	private CardService cardService;
	
	/*
	 * 
	 * 1.Service take the creditcard number and processing charge as input
	 * 
	 * 2.retrieve card from database 
	 * 
	 * 3.deduct the processing charge from card limit
	 * 
	 * 		3.1 if cardlimit>0 then update the card limit in database and return the
	 * 					cardlimit
	 * 
	 *  	3.2 else return -1
	 * 
	 * 
	 */
	
	

	@GetMapping("/card/{cardNumber}/{charge}")
	public double getBalance(@PathVariable String cardNumber,@PathVariable double charge) {
		return cardService.processPayment(cardNumber,charge);
	}
}