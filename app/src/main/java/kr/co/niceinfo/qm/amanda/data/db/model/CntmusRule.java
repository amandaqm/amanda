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
}
