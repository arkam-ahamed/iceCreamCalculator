package tetranyde.iceCreamCalculator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Base flavour not found")
public class BaseFlavourNotFoundException extends RuntimeException {
    public BaseFlavourNotFoundException(String message) {
        super(message);
    }

}
