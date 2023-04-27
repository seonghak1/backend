package hyggy.backend.resume.repository;


import hyggy.backend.resume.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//ResumeRepository는 데이터베이스에서 resume 데이터에 대한 CRUD(Create, Read, Update, Delete) 작업을 수행하는 인터페이스입니다.
//ResumeRepository 인터페이스는 JpaRepository를 상속받고 있으며, 이력서 엔티티(Resume)와
//해당 엔티티의 기본 키 타입(Integer)을 제네릭 타입으로 지정하고 있습니다

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Integer> {
}