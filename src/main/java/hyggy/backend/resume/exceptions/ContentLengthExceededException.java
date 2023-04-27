package hyggy.backend.resume.exceptions;

//이 클래스는 RuntimeException을 상속하며, 이 예외는 이력서 내용의 길이가 허용된 길이를 초과했을 때 발생시키려고 만든 것
//public ContentLengthExceededException(String message): ContentLengthExceededException의 생성자를 정의합니다.
//이 생성자는 message라는 문자열 파라미터를 입력 받아서 부모 클래스인 RuntimeException의 생성자에 전달합니다.
//이렇게 하면 예외가 발생했을 때 어떤 메시지를 전달할지 설정할 수 있습니다.

public class ContentLengthExceededException extends RuntimeException {
    public ContentLengthExceededException(String message) {
        super(message);
    }
}