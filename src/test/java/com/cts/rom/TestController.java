package com.cts.rom;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.rom.controller.CardController;
import com.cts.rom.service.CardService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(value = CardController.class)
public class TestController {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	CardService cardService;
	
	@Test
	public void testGetCall() throws Exception {
		when(cardService.processPayment(Mockito.anyString(), Mockito.anyDouble())).thenReturn(2000.0);
		String cardnumber="cde123";
		Double amt=5000.0;
		
		mockMvc.perform(get("/card/{cardNumber}/{charge}",cardnumber,amt)).andExpect(status().isOk());
		
	}
	
	
	
}
