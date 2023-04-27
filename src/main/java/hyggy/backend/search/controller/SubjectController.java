package hyggy.backend.search.controller;

import hyggy.backend.search.entity.Subject;
import hyggy.backend.search.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import hyggy.backend.search.exception.SubjectNameLengthExceededException;

//SubjectController 클래스는 SubjectService 클래스를 사용하여 과목을 검색하는 역할을 합니다.
//생성자 주입 방식으로 SubjectService 객체를 주입받습니다.
//if문으로 query 매개변수의 길이가 몇자를 초과하는 경우 SubjectNameLengthExceededException 예외를 발생시킵니다.
//검색 결과를 ResponseEntity로 감싸서 반환하며, HTTP 응답 상태 코드는 HttpStatus.OK로 설정됩니다.
//검색 결과는 JSON 형태로 반환됩니다.


@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Subject>> searchSubjects(@RequestParam String query) {

        if (query.length() > 454) {
            throw new SubjectNameLengthExceededException("Error: Subject name exceeds the maximum length of 454 characters.");
        }

        List<Subject> subjects = subjectService.searchSubjects(query);
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }
}