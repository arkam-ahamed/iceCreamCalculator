package tetranyde.iceCreamCalculator.dto;

import lombok.Data;

/**
 * Project: iceCreamCalculator
 * Package: tetranyde.iceCreamCalculator.dto
 * User: Arkam
 * Date: 6/6/2022
 * Time: 9:12 PM
 * Created with IntelliJ IDEA
 */
@Data
public class Response {
    private Object data;

    public Response() {
    }

    public Response(Object data) {
        this.data = data;
    }
}
