package ncode.web.payload;

import lombok.Value;

@Value(staticConstructor = "of")
public class ApiResponse<T> {

    Boolean success;
    T response;
    ErrorResponse error;

}
