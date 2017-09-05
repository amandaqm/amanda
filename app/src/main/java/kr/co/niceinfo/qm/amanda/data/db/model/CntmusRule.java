package kr.co.niceinfo.qm.amanda.data.db.model;

/**
 * Created by Woo-Young on 2017-08-27.
 */

//위기단계별 조직대응수칙
public class CntmusRule extends BaseModel{

    private String cntmsuRuleCd;        //비상대응수칙 코드
    private String emgcStepCode;        // 위기단계코드(보안-심각)
    private String deptCd;              // 부서코드
    private String emgcStepContent;     // 위기단계 정보

    public CntmusRule() {
    }

    public String getCntmsuRuleCd() {
        return cntmsuRuleCd;
    }

    public void setCntmsuRuleCd(String cntmsuRuleCd) {
        this.cntmsuRuleCd = cntmsuRuleCd;
    }

    public String getEmgcStepCode() {
        return emgcStepCode;
    }

    public void setEmgcStepCode(String emgcStepCode) {
        this.emgcStepCode = emgcStepCode;
    }

    public String getDeptCd() {
        return deptCd;
    }

    public void setDeptCd(String deptCd) {
        this.deptCd = deptCd;
    }

    public String getEmgcStepContent() {
        return emgcStepContent;
    }

    public void setEmgcStepContent(String emgcStepContent) {
        this.emgcStepContent = emgcStepContent;
    }

    @Override
    public String toString() {
        return "CntmusRule{" +
                "cntmsuRuleCd='" + cntmsuRuleCd + '\'' +
                ", emgcStepCode='" + emgcStepCode + '\'' +
                ", deptCd='" + deptCd + '\'' +
                ", emgcStepContent='" + emgcStepContent + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CntmusRule that = (CntmusRule) o;

        if (cntmsuRuleCd != null ? !cntmsuRuleCd.equals(that.cntmsuRuleCd) : that.cntmsuRuleCd != null)
            return false;
        if (emgcStepCode != null ? !emgcStepCode.equals(that.emgcStepCode) : that.emgcStepCode != null)
            return false;
        if (deptCd != null ? !deptCd.equals(that.deptCd) : that.deptCd != null) return false;
        return emgcStepContent != null ? emgcStepContent.equals(that.emgcStepContent) : that.emgcStepContent == null;

    }

    @Override
    public int hashCode() {
        int result = cntmsuRuleCd != null ? cntmsuRuleCd.hashCode() : 0;
        result = 31 * result + (emgcStepCode != null ? emgcStepCode.hashCode() : 0);
        result = 31 * result + (deptCd != null ? deptCd.hashCode() : 0);
        result = 31 * result + (emgcStepContent != null ? emgcStepContent.hashCode() : 0);
        return result;
    }
}
