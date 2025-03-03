package imaks.hillelbootjpa.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomExceptionResponse {

    private int status;
    private String message;
    private LocalDateTime timestamp;
}
