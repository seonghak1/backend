package hyggy.backend.search.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//해당 코드는 Spring MVC에서 발생하는 예외를 처리하는 컨트롤러 어드바이스 클래스입니다.
//GlobalExceptionHandler 클래스는 SubjectNameLengthExceededException 예외를 처리하는 메서드를 제공합니다.
//@ExceptionHandler 어노테이션은 해당 메서드가 처리할 예외 타입을 지정합니다.
//handleSubjectNameLengthExceededException 메서드는 SubjectNameLengthExceededException 예외를 처리하며,
//해당 예외 객체의 메시지와 HTTP 응답 상태 코드 HttpStatus.BAD_REQUEST를 포함하는 ResponseEntity 객체를 반환합니다.
//따라서, SubjectNameLengthExceededException 예외가 발생하면 해당 메서드가 호출되어
//HTTP 응답으로 예외 메시지와 400(Bad Request) 상태 코드가 반환됩니다.

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SubjectNameLengthExceededException.class)
    public ResponseEntity<String> handleSubjectNameLengthExceededException(SubjectNameLengthExceededException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}