package kr.co.niceinfo.qm.amanda.data.db.model;

/**
 * Created by Woo-Young on 2017-08-27.
 */

public class BaseModel {

    /*공통 속성*/
    private String status;              //상태
    private String reg_dt;              //등록일시
    private String reg_id;              //등록자
    private String mod_dt;              //수정일시
    private String mod_id;              //수정자
    private int ver;                    //버전

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReg_dt() {
        return reg_dt;
    }

    public void setReg_dt(String reg_dt) {
        this.reg_dt = reg_dt;
    }

    public String getReg_id() {
        return reg_id;
    }

    public void setReg_id(String reg_id) {
        this.reg_id = reg_id;
    }

    public String getMod_dt() {
        return mod_dt;
    }

    public void setMod_dt(String mod_dt) {
        this.mod_dt = mod_dt;
    }

    public String getMod_id() {
        return mod_id;
    }

    public void setMod_id(String mod_id) {
        this.mod_id = mod_id;
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
                ", reg_dt='" + reg_dt + '\'' +
                ", reg_id='" + reg_id + '\'' +
                ", mod_dt='" + mod_dt + '\'' +
                ", mod_id='" + mod_id + '\'' +
                ", ver=" + ver +
                '}';
    }
}
