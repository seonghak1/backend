package hyggy.backend.resume.dto;


//이력서 데이터를 전달하기 위한 DTO입니다. 클라이언트가 이력서를 생성하거나 수정하는 요청을 보낼 때,
//클라이언트는 ResumeRequestDto의 형태로 데이터를 서버에 전송합니다. 서버는 이 데이터를 사용하여 이력서를 생성하거나 수정한 후,
//적절한 응답을 클라이언트에게 반환합니다.
//이력서 생성 및 수정 요청에 필요한 데이터를 전달하는 데 사용되며, 엔티티 클래스와 달리 데이터베이스와 직접적으로 관련되지 않습니다.
public class ResumeRequestDto {

    private int resumeId; // 이력서 수정을 위한 필드
    private int userId;
    private int subjectId;
    private String content;


    // get set
    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
