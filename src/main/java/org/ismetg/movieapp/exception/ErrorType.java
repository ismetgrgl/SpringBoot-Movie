package org.ismetg.movieapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {
	MOVIE_NOT_FOUND(5001,
			"Böyle bir movie bulunamadı.",
			HttpStatus.NOT_FOUND),
	USERNAME_OR_PASSWORD_WRONG(5002,
			"Kullanıcı adı veya parola yanlış.",
			HttpStatus.I_AM_A_TEAPOT),
	URUN_NOT_FOUND(5003,
			"Böyle bir Ürün bulunamadı.",
			HttpStatus.NOT_FOUND),
	MUSTERI_NOT_FOUND(5004,
			"Böyle bir müşteri bulunamadı.",
			HttpStatus.NOT_FOUND);
	private Integer code;
	private String message;
	private HttpStatus httpStatus;
	
}