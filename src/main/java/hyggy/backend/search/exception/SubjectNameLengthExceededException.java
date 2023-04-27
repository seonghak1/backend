package hyggy.backend.search.exception;

//해당 코드는 RuntimeException 클래스를 상속받아서,
//과목 이름의 길이가 최대 길이를 초과하는 경우 발생하는 예외 클래스인 SubjectNameLengthExceededException을 정의합니다.
//SubjectNameLengthExceededException 클래스는 생성자에서 예외 메시지를 받아서
//RuntimeException의 생성자를 호출하여 예외 객체를 생성합니다.

public class SubjectNameLengthExceededException extends RuntimeException {
    public SubjectNameLengthExceededException(String message) {
        super(message);
    }
}