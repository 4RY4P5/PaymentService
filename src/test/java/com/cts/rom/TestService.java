package com.cts.rom;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

import com.cts.rom.dao.CardRepo;
import com.cts.rom.model.CreditCard;
import com.cts.rom.service.CardService;

@ExtendWith(MockitoExtension.class)
public class TestService {

	/*
	 * @BeforeAll public void init() { MockitoAnnotations.initMocks(this); }
	 */
	@Mock
	CardRepo repo;
	
	@Mock
	CreditCard card;
	
	@InjectMocks
	CardService service;
	
	@Test
	public void testProcessPayment() {
		
		card=new CreditCard("def123",4000);
		when(repo.findByCardNumber("def123")).thenReturn(card);
		when(repo.save(any(CreditCard.class))).thenReturn(card);
		
		
		assertEquals(2000.0,service.processPayment("def123", 2000),0.00);
		assertEquals(-1,service.processPayment("def123", 5000),0.0);
		
	}
}
