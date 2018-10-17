package ex06;

import java.sql.Date;

public class Board {

    protected int no;
    protected String title;
    protected String content;
    protected int viewCount;
    protected Date createdDate;
    protected int memberNo;
    protected String writer; // 목록에서 작성자의 이름을 출력하기 위해 필드 추가
    protected String email; // 상제조회에서 작성자의 정보를 출력하기위해 필드 추가
    protected String tel;   // 상제조회에서 작성자의 정보를 출력하기위해 필드 추가
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String wirter) {
        this.writer = wirter;
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getViewCount() {
        return viewCount;
    }
    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public int getMemberNo() {
        return memberNo;
    }
    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }


}