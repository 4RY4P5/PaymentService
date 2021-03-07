package com.cts.rom.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.rom.model.CreditCard;

public interface CardRepo extends JpaRepository<CreditCard, String>{

	Optional<CreditCard> findByCardNumber(String cardNumber);

}
