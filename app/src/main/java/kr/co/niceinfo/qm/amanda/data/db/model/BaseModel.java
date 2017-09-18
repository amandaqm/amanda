package kr.co.niceinfo.qm.amanda.data.db.model;

import android.support.annotation.Keep;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Woo-Young on 2017-08-27.
 */

/*

        NO	용어	        약어      	전체
        1	비상	        emgc	    Emergency
        2	대응조치	    cntmus  	Countermeasures
        3	수칙(역할)	    rule	    Rule
        4	채팅	        chat	    chatting
        5	방	            room	    room
        6	연락처	        contact 	contact
        7	게시판	        board	    board
        8	게시글	        posting	    posting
        9	버전	        ver	        version
        10	사용자		    user        user
        11	부서	        dept	    department
        12	코드	        cd	        code
        13	권한	        role	    role
        14	비밀번호	    pw	        password
        15	이름	        nm	        name
        16	내선	        ext	        extension
        17	번호	        no	        number
        18	내부	        internal    internal
        19	메일주소	    mail	    mail
        20	깊이	        depth	    depth
        21	메시지	        msg	        message
        22	단계	        step	    step
        23	구분	        type    	type
        24	기준	        Criteria	Criteria
        25	발령          	issue   	issue
*/



@Keep
public class BaseModel {

    /*공통 속성*/
    private String status;              //상태
    @SerializedName("regDt") private String regDt;              //등록일시
    private String regId;              //등록자
    private String modDt;              //수정일시
    private String modId;              //수정자
    @SerializedName("regDt") private int ver;                    //버전

    public BaseModel() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRegDt() {
        return regDt;
    }

    public void setRegDt(String regDt) {
        this.regDt = regDt;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getModDt() {
        return modDt;
    }

    public void setModDt(String modDt) {
        this.modDt = modDt;
    }

    public String getModId() {
        return modId;
    }

    public void setModId(String modId) {
        this.modId = modId;
    }

    public int getVer() {
        return ver;
    }

    public void setVer(int ver) {
        this.ver = ver;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "status='" + status + '\'' +
                ", regDt='" + regDt + '\'' +
                ", regId='" + regId + '\'' +
                ", modDt='" + modDt + '\'' +
                ", modId='" + modId + '\'' +
                ", ver=" + ver +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseModel baseModel = (BaseModel) o;

        if (ver != baseModel.ver) return false;
        if (status != null ? !status.equals(baseModel.status) : baseModel.status != null)
            return false;
        if (regDt != null ? !regDt.equals(baseModel.regDt) : baseModel.regDt != null) return false;
        if (regId != null ? !regId.equals(baseModel.regId) : baseModel.regId != null) return false;
        if (modDt != null ? !modDt.equals(baseModel.modDt) : baseModel.modDt != null) return false;
        return modId != null ? modId.equals(baseModel.modId) : baseModel.modId == null;

    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (regDt != null ? regDt.hashCode() : 0);
        result = 31 * result + (regId != null ? regId.hashCode() : 0);
        result = 31 * result + (modDt != null ? modDt.hashCode() : 0);
        result = 31 * result + (modId != null ? modId.hashCode() : 0);
        result = 31 * result + ver;
        return result;
    }
}
