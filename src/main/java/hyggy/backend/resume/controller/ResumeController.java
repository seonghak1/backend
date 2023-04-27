package hyggy.backend.resume.controller;

import hyggy.backend.resume.dto.ResumeRequestDto;
import hyggy.backend.resume.entity.Resume;
import hyggy.backend.resume.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import hyggy.backend.resume.exceptions.ContentLengthExceededException;

// 웹 애플리케이션에서의 컨트롤러 역할을 수행합니다. 컨트롤러는 클라이언트의 요청을 받아 적절한 처리를 수행한 후 응답을 반환하는 역할
// 클라이언트가 이력서를 생성하거나 수정하는 요청을 보낼 때, ResumeController는 요청을 받아 ResumeService를
// 사용하여 이력서를 생성하거나 수정하고 적절한 응답을 반환합니다.
// ResumeController는 웹 애플리케이션의 진입점 역할을 하며, 클라이언트와 서버 간의 통신을 관리하고 요청을 처리합니다.

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

    private final ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    //resumeService.saveResume(): ResumeService의 saveResume() 메소드를 호출하여 이력서를 생성합니다.

    @PostMapping
    public ResponseEntity<Resume> saveResume(@RequestBody ResumeRequestDto resumeRequestDto) {
        Resume savedResume = resumeService.saveResume(resumeRequestDto);
        return new ResponseEntity<>(savedResume, HttpStatus.CREATED);
    }

    //resumeService.updateResume(): ResumeService의 updateResume() 메소드를 호출하여 이력서를 수정합니다.

    @PutMapping("/{resumeId}")
    public ResponseEntity<Resume> updateResume(@PathVariable int resumeId, @RequestBody ResumeRequestDto resumeRequestDto) {
        resumeRequestDto.setResumeId(resumeId);
        Resume updatedResume = resumeService.updateResume(resumeRequestDto);
        return new ResponseEntity<>(updatedResume, HttpStatus.OK);
    }

    //public ResponseEntity<List<Resume>> getAllResumes()
    // 이 메서드는 이력서 목록을 가져오는 작업을 수행합니다.
    // 반환 타입은 ResponseEntity<List<Resume>>로, 이는 HTTP 응답 본문에 이력서 목록을 포함하게 됩니다.

    //List<Resume> resumes = resumeService.getAllResumes();:
    //이 줄은 resumeService 객체의 getAllResumes() 메서드를 호출하여 모든 이력서를 가져옵니다.
    //가져온 이력서 목록은 resumes 변수에 저장됩니다.

    // return new ResponseEntity<>(resumes, HttpStatus.OK);
    // 이 줄은 가져온 이력서 목록을 HTTP 응답 본문에 포함하여 클라이언트에 전송합니다.

    @GetMapping
    public ResponseEntity<List<Resume>> getAllResumes() {
        List<Resume> resumes = resumeService.getAllResumes();
        return new ResponseEntity<>(resumes, HttpStatus.OK);
    }


    //이 메서드는 클라이언트로부터 resumeId를 받아 이를 ResumeService의 copyAndRegisterResume 메서드에 전달합니다.
    //그 후, 새로 생성된 이력서를 클라이언트에 반환합니다.
    //@PostMapping 어노테이션으로 엔드포인트를 정의하고, /copy/{resumeId}를 URL로 사용합니다.
    //resumeId는 경로 변수로 전달되며, 이 값을 메서드의 인자로 받습니다.
    //ResumeService의 copyAndRegisterResume 메서드를 호출하여 새로운 이력서를 생성하고 저장합니다.
    //새로 생성된 이력서를 ResponseEntity 객체에 담아 HttpStatus.CREATED (HTTP 상태 코드 201)와 함께 클라이언트에 반환합니다.
    //프론트엔드에서 해당 API 엔드포인트를 호출하고, 이력서를 복사하고 등록하는 작업을 수행
    //사용자 인터페이스를 통해 이 기능을 사용할 수 있도록 해야합니다.

    @PostMapping("/copy/{resumeId}")
    public ResponseEntity<Resume> copyAndRegisterResume(@PathVariable int resumeId) {
        Resume copiedResume = resumeService.copyAndRegisterResume(resumeId);
        return new ResponseEntity<>(copiedResume, HttpStatus.CREATED);
    }


    //ContentLengthExceededException 예외를 처리하는 핸들러 메서드를 추가하여,
    //이 예외가 발생했을 때 클라이언트에 적절한 응답을 제공하도록 합니다

    //2번째 줄은 handleContentLengthExceededException 메서드를 정의합니다.
    //이 메서드는 입력 파라미터로 발생한 ContentLengthExceededException 객체를 받아서 처리하며,
    //오류 메시지를 담은 ResponseEntity 객체를 반환합니다.

    //3번째줄은 ContentLengthExceededException 객체에서 오류 메시지를 가져와서 ResponseEntity 객체를 생성하고,
    // HTTP 상태 코드를 BAD_REQUEST(400)로 설정하여 반환합니다.
    // 이렇게 하면 클라이언트는 이 예외가 발생했을 때 적절한 오류 메시지와 함께 400 상태 코드를 받게 됩니다.

    @ExceptionHandler(ContentLengthExceededException.class)
    public ResponseEntity<String> handleContentLengthExceededException(ContentLengthExceededException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}