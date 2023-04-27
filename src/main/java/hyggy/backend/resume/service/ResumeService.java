package hyggy.backend.resume.service;

import hyggy.backend.resume.dto.ResumeRequestDto;
import hyggy.backend.resume.entity.Resume;
import hyggy.backend.resume.entity.User;
import hyggy.backend.resume.entity.Subject;
import hyggy.backend.resume.repository.ResumeRepository;
import hyggy.backend.resume.repository.UserRepository;
import hyggy.backend.resume.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import hyggy.backend.resume.exceptions.ContentLengthExceededException;


@Service
public class ResumeService {

    //이 클래스에서 이들 레포지토리 인터페이스를 사용하여 데이터베이스에서 사용자, 주제, 이력서 정보를 검색하고 저장할 것입니다.
    private final UserRepository userRepository;
    private final SubjectRepository subjectRepository;
    private final ResumeRepository resumeRepository;

    @Autowired
    public ResumeService(UserRepository userRepository, SubjectRepository subjectRepository, ResumeRepository resumeRepository) {
        this.userRepository = userRepository;
        this.subjectRepository = subjectRepository;
        this.resumeRepository = resumeRepository;
    }


    //이 메소드는 새 이력서를 저장하는 역할을 합니다.
    //ResumeRequestDto 객체를 인자로 받아 사용자 ID, 주제 ID, 이력서 내용을 검색하고, 이를 사용하여 새로운 Resume 객체를 생성
    //User와 Subject 객체를 각각 UserRepository와 SubjectRepository에서 조회합니다. 만약 해당 ID로 사용자나 주제를 찾을 수 없는 경우,
    //RuntimeException을 발생시킵니다.
    //생성된 Resume 객체에 사용자, 주제, 내용을 설정한 후, ResumeRepository를 사용하여 이력서를 데이터베이스에 저장합니다.

    public Resume saveResume(ResumeRequestDto resumeRequestDto) {

        //resumeRequestDto 객체에서 이력서의 내용(content)을 가져와 content 변수에 저장합니다.
        //455자가 넘을 경우 ContentLengthExceededException 예외를 발생시키고, 오류 메시지를 전달합니다.
        // 이 오류 메시지는 이력서 내용의 길이가 455자를 초과하면 안 된다는 것을 알려줍니다.
        //숫자 자체는 mysql에서 설정한 제한 수를 수정하여 사용 가능합니다.

        String content = resumeRequestDto.getContent();
        if (content.length() > 455) {
            throw new ContentLengthExceededException("Content length should not exceed 455 characters");
        }

        Resume resume = new Resume();
        User user = userRepository.findById(resumeRequestDto.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        Subject subject = subjectRepository.findById(resumeRequestDto.getSubjectId()).orElseThrow(() -> new RuntimeException("Subject not found"));
        resume.setUser(user);
        resume.setSubject(subject);
        resume.setContent(resumeRequestDto.getContent());
        return resumeRepository.save(resume);
    }

    //이 메소드는 기존 이력서를 수정하는 역할을 합니다.
    //ResumeRequestDto 객체를 인자로 받아 이력서 ID, 사용자 ID, 주제 ID, 이력서 내용을 검색합니다.
    //Resume 객체를 ResumeRepository에서 조회합니다. 만약 해당 ID로 이력서를 찾을 수 없는 경우, RuntimeException을 발생시킵니다.
    //User와 Subject 객체를 각각 UserRepository와 SubjectRepository에서 조회합니다.
    //만약 해당 ID로 사용자나 주제를 찾을 수 없는 경우, RuntimeException을 발생시킵니다.
    //조회된 Resume 객체에 사용자, 주제, 내용을 설정한 후, ResumeRepository를 사용하여 이력서를 데이터베이스에 저장합니다.
    // 이미 있는 이력서가 수정되므로, 새 이력서가 생성되지 않습니다.

    public Resume updateResume(ResumeRequestDto resumeRequestDto) {


        //resumeRequestDto 객체에서 이력서의 내용(content)을 가져와 content 변수에 저장합니다.
        //455자가 넘을 경우 ContentLengthExceededException 예외를 발생시키고, 오류 메시지를 전달합니다.
        // 이 오류 메시지는 이력서 내용의 길이가 455자를 초과하면 안 된다는 것을 알려줍니다.
        //숫자 자체는 mysql에서 설정한 제한 수를 수정하여 사용 가능합니다.

        String content = resumeRequestDto.getContent();
        if (content.length() > 455) {
            throw new ContentLengthExceededException("Content length should not exceed 455 characters");
        }


        Resume resume = resumeRepository.findById(resumeRequestDto.getResumeId()).orElseThrow(() -> new RuntimeException("Resume not found"));
        User user = userRepository.findById(resumeRequestDto.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        Subject subject = subjectRepository.findById(resumeRequestDto.getSubjectId()).orElseThrow(() -> new RuntimeException("Subject not found"));

        resume.setUser(user);
        resume.setSubject(subject);
        resume.setContent(resumeRequestDto.getContent());

        return resumeRepository.save(resume);
    }


    // 이력서 목록 가져오기를 위한 API
    public List<Resume> getAllResumes() {
        return resumeRepository.findAll();
    }


    //이 메서드는 기존 이력서를 찾아 복사한 후 새로운 이력서로 저장합니다.
    //resumeId를 인자로 받아 resumeRepository에서 해당 ID를 가진 이력서를 찾습니다.
    //만약 이력서가 없으면, "Resume not found" 예외를 발생시킵니다.
    //이 후, 새로운 Resume 객체를 생성하고 기존 이력서의 사용자, 과목, 내용을 복사합니다.
    //새로운 이력서를 resumeRepository에 저장하고 반환합니다.


    public Resume copyAndRegisterResume(int resumeId) {
        Resume existingResume = resumeRepository.findById(resumeId).orElseThrow(() -> new RuntimeException("Resume not found"));
        Resume newResume = new Resume();
        newResume.setUser(existingResume.getUser());
        newResume.setSubject(existingResume.getSubject());
        newResume.setContent(existingResume.getContent());
        return resumeRepository.save(newResume);
    }

}