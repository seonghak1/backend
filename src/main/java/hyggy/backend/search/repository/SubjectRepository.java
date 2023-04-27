package hyggy.backend.search.repository;

import hyggy.backend.search.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


//Spring Data JPA를 사용하여 Subject 엔티티를 조회하는 레포지토리 클래스입니다.
//SubjectRepository 인터페이스는 JpaRepository 인터페이스를 상속받으며, Subject 엔티티와 관련된 DB 작업을 수행할 수 있습니다.
//findByNameContainingOrCodeContaining 메서드는 메서드 이름 자체가 쿼리의 조건절 역할을 합니다.
//해당 메서드는 name 또는 code 컬럼 값 중에서 파라미터로 전달된 문자열이 포함된 모든 Subject 엔티티를 조회합니다.
//이때, name 또는 code 중 하나라도 포함된 경우 조회되므로, OR 조건으로 검색이 이루어집니다.

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    List<Subject> findByNameContainingOrCodeContaining(String name, String code);
}

