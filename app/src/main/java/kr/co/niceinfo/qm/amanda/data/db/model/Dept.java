package kr.co.niceinfo.qm.amanda.data.db.model;

/**
 * Created by Woo-Young on 2017-08-27.
 */

//부서정보 (조직도)
public class Dept extends BaseModel{

    private String deptCd;      // 부서코드
    private String compCd;      // 회시코드(dummy)
    private String deptNm;      // 부서명
    private String upperDeptCd; // 상위부서 코드
    private String deptDepth;   // 부서 depth

    public String getDeptCd() {
        return deptCd;
    }

    public void setDeptCd(String deptCd) {
        this.deptCd = deptCd;
    }

    public String getCompCd() {
        return compCd;
    }

    public void setCompCd(String compCd) {
        this.compCd = compCd;
    }

    public String getDeptNm() {
        return deptNm;
    }

    public void setDeptNm(String deptNm) {
        this.deptNm = deptNm;
    }

    public String getUpperDeptCd() {
        return upperDeptCd;
    }

    public void setUpperDeptCd(String upperDeptCd) {
        this.upperDeptCd = upperDeptCd;
    }

    public String getDeptDepth() {
        return deptDepth;
    }

    public void setDeptDepth(String deptDepth) {
        this.deptDepth = deptDepth;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptCd='" + deptCd + '\'' +
                ", compCd='" + compCd + '\'' +
                ", deptNm='" + deptNm + '\'' +
                ", upperDeptCd='" + upperDeptCd + '\'' +
                ", deptDepth='" + deptDepth + '\'' +
                "} " + super.toString();
    }
}
