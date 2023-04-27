package hyggy.backend.search.entity;

import javax.persistence.*;

//DTO는 주로 요청 및 응답의 복잡한 데이터 구조를 캡슐화하거나, 여러 엔티티를 결합하여 사용자에게 제공할 때 사용합니다
//현재 코드에서는 단순히 과목의 이름을 이용하여 데이터를 검색하고, 검색된 결과를 그대로 반환하는 것이기 때문에
//별도의 DTO를 사용하지 않았습니다.
// 이 패키지에는 데이터베이스 테이블과 매핑되는 엔티티 클래스를 생성
// 이 클래스는 데이터베이스의 subject 테이블과 매핑되는 Java 객체입니다.

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getDtype() {
        return dtype;
    }

    public void setDtype(int dtype) {
        this.dtype = dtype;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

}
