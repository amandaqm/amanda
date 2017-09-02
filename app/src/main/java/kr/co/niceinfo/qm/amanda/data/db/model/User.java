package kr.co.niceinfo.qm.amanda.data.db.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Woo-Young on 2017-08-27.
 */

//사용자
public class User extends BaseModel{

    @SerializedName("uid") private String uid = null;
    @SerializedName("InteralMail")private String InteralMail;  // 내부메일주소
    @SerializedName("userId")  private String userId;  // 사용자ID
    @SerializedName("userPw")private String userPw;  // 비밀번호

    @SerializedName("deptCd")private String deptCd;  // 부서코드
    @SerializedName("roleCd") private String roleCd;  // 권한코드
    @SerializedName("userName")private String userName;  // 사용자명
    @SerializedName("extensoinNo")private String extensoinNo;  // 내선번호
    @SerializedName("emgcContact")private String emgcContact;  // 비상연락처


    public User(){

    }

    public User(String interalMail, String userPw) {
        InteralMail = interalMail;
        this.userPw = userPw;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getInteralMail() {
        return InteralMail;
    }

    public void setInteralMail(String interalMail) {
        InteralMail = interalMail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
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

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", InteralMail='" + InteralMail + '\'' +
                ", userId='" + userId + '\'' +
                ", userPw='" + userPw + '\'' +
                ", deptCd='" + deptCd + '\'' +
                ", roleCd='" + roleCd + '\'' +
                ", userName='" + userName + '\'' +
                ", extensoinNo='" + extensoinNo + '\'' +
                ", emgcContact='" + emgcContact + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (uid != null ? !uid.equals(user.uid) : user.uid != null) return false;
        if (InteralMail != null ? !InteralMail.equals(user.InteralMail) : user.InteralMail != null)
            return false;
        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (userPw != null ? !userPw.equals(user.userPw) : user.userPw != null) return false;
        if (deptCd != null ? !deptCd.equals(user.deptCd) : user.deptCd != null) return false;
        if (roleCd != null ? !roleCd.equals(user.roleCd) : user.roleCd != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null)
            return false;
        if (extensoinNo != null ? !extensoinNo.equals(user.extensoinNo) : user.extensoinNo != null)
            return false;
        return emgcContact != null ? emgcContact.equals(user.emgcContact) : user.emgcContact == null;

    }

    @Override
    public int hashCode() {
        int result = uid != null ? uid.hashCode() : 0;
        result = 31 * result + (InteralMail != null ? InteralMail.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (userPw != null ? userPw.hashCode() : 0);
        result = 31 * result + (deptCd != null ? deptCd.hashCode() : 0);
        result = 31 * result + (roleCd != null ? roleCd.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (extensoinNo != null ? extensoinNo.hashCode() : 0);
        result = 31 * result + (emgcContact != null ? emgcContact.hashCode() : 0);
        return result;
    }
}
