package kr.co.niceinfo.qm.amanda.data.db.model;

/**
 * Created by Woo-Young on 2017-08-27.
 */

//사용자
public class User extends BaseModel{

    private String userId;  // 사용자ID
    private String deptCd;  // 부서코드
    private String roleCd;  // 권한코드
    private String userPw;  // 비밀번호
    private String userName;  // 사용자명
    private String extensoinNo;  // 내선번호
    private String emgcContact;  // 비상연락처
    private String InteralMail;  // 내부메일주소

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeptCd() {
        return deptCd;
    }

    public void setDeptCd(String deptCd) {
        this.deptCd = deptCd;
    }

    public String getRoleCd() {
        return roleCd;
    }

    public void setRoleCd(String roleCd) {
        this.roleCd = roleCd;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getExtensoinNo() {
        return extensoinNo;
    }

    public void setExtensoinNo(String extensoinNo) {
        this.extensoinNo = extensoinNo;
    }

    public String getEmgcContact() {
        return emgcContact;
    }

    public void setEmgcContact(String emgcContact) {
        this.emgcContact = emgcContact;
    }

    public String getInteralMail() {
        return InteralMail;
    }

    public void setInteralMail(String interalMail) {
        InteralMail = interalMail;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", deptCd='" + deptCd + '\'' +
                ", roleCd='" + roleCd + '\'' +
                ", userPw='" + userPw + '\'' +
                ", userName='" + userName + '\'' +
                ", extensoinNo='" + extensoinNo + '\'' +
                ", emgcContact='" + emgcContact + '\'' +
                ", InteralMail='" + InteralMail + '\'' +
                "} " + super.toString();
    }
}
