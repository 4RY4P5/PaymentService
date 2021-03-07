package com.cts.rom.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.rom.dao.CardRepo;
import com.cts.rom.model.CreditCard;


@Service
public class CardService {

	@Autowired
	CardRepo cardRepo;
	
	@Transactional
	public double processPayment(String cardNumber,double charge) {
		Optional<CreditCard> result = cardRepo.findByCardNumber(cardNumber);
		CreditCard card=result.get();
		
	
		double balance= card.getCardLimit()-charge;
		if(balance>0)
		{
			card.setCardLimit(balance);
			cardRepo.save(card);
			return balance;
			
		}
		else {
			return -1;
		}
	}
}
