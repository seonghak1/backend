package hyggy.backend.team.entity;

import javax.persistence.*;


//// 이 클래스는 데이터베이스의 User 테이블과 매핑되는 Java 객체입니다.
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "login_id")
    private String loginId;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "school_id")
    private int schoolId;

    @Column(name = "role")
    private int role;

    @Column(name = "nickname")
    private String nickname;

}