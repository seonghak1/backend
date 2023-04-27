package hyggy.backend.resume.entity;

import javax.persistence.*;

//// 이 클래스는 데이터베이스의 subject 테이블과 매핑되는 Java 객체입니다.

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "year")
    private int year;

    @Column(name = "semester")
    private int semester;

    @Column(name = "p_name")
    private String pName;

    @Column(name = "time")
    private String time;

    @Column(name = "dtype")
    private int dtype;

    @Column(name = "major")
    private String major;

    @Column(name = "domain")
    private String domain;


}
