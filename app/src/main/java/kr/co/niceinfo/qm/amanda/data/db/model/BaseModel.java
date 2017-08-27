package kr.co.niceinfo.qm.amanda.data.db.model;

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



public class BaseModel {

    /*공통 속성*/
    private String status;              //상태
    private String regDt;              //등록일시
    private String regId;              //등록자
    private String modDt;              //수정일시
    private String modId;              //수정자
    private int ver;                    //버전

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
}
