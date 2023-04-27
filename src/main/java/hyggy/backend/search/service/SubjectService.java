package hyggy.backend.search.service;


import hyggy.backend.search.entity.Subject;
import hyggy.backend.search.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

//SubjectRepository를 사용하여 과목을 검색하는 SubjectService 클래스입니다.
//searchSubjects 메서드는 검색어(query)를 받아서 SubjectRepository를 사용하여 과목을 검색합니다.
//findByNameContainingOrCodeContaining 메서드를 사용하여 검색어가 과목명 또는 과목 코드에 포함된 과목을 조회합니다.
//조회된 검색 결과를 리스트로 반환합니다.
//따라서, 이 서비스 클래스를 사용하여 검색어에 대한 과목 검색을 수행할 수 있습니다.
//SubjectRepository의 findByNameContainingOrCodeContaining 메서드를 이용하여 DB에서 과목을 조회하고,
//조회된 결과를 반환하는 역할을 합니다.


@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> searchSubjects(String query) {
        return subjectRepository.findByNameContainingOrCodeContaining(query, query);
    }
}