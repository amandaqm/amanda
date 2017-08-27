package kr.co.niceinfo.qm.amanda.data.db.model;

/**
 * Created by Woo-Young on 2017-08-27.
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
