package com.cts.rom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND,reason="Favorites is empty")
public class CardNotFoundException extends Exception{

}
