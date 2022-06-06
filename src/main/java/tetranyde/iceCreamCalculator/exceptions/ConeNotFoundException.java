package tetranyde.iceCreamCalculator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Cone not found")
public class ConeNotFoundException extends RuntimeException {
    public ConeNotFoundException(String message) {
        super(message);
    }

}
