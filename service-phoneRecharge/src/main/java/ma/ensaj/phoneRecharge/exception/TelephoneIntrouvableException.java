package ma.ensaj.phoneRecharge.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class TelephoneIntrouvableException extends RuntimeException {
	public TelephoneIntrouvableException(String s) {
		super(s);
	}
}
