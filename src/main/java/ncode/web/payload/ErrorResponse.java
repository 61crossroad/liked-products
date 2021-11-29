package ncode.web.payload;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ErrorResponse {

    Integer status;
    String message;

}
