package tetranyde.iceCreamCalculator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Condiment not found")
public class CondimentNotFoundException extends RuntimeException {
    public CondimentNotFoundException(String message) {
        super(message);
    }

}
