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

    public Dept() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dept dept = (Dept) o;

        if (deptCd != null ? !deptCd.equals(dept.deptCd) : dept.deptCd != null) return false;
        if (compCd != null ? !compCd.equals(dept.compCd) : dept.compCd != null) return false;
        if (deptNm != null ? !deptNm.equals(dept.deptNm) : dept.deptNm != null) return false;
        if (upperDeptCd != null ? !upperDeptCd.equals(dept.upperDeptCd) : dept.upperDeptCd != null)
            return false;
        return deptDepth != null ? deptDepth.equals(dept.deptDepth) : dept.deptDepth == null;

    }

    @Override
    public int hashCode() {
        int result = deptCd != null ? deptCd.hashCode() : 0;
        result = 31 * result + (compCd != null ? compCd.hashCode() : 0);
        result = 31 * result + (deptNm != null ? deptNm.hashCode() : 0);
        result = 31 * result + (upperDeptCd != null ? upperDeptCd.hashCode() : 0);
        result = 31 * result + (deptDepth != null ? deptDepth.hashCode() : 0);
        return result;
    }
}
