package kr.co.niceinfo.qm.amanda.data.db.model;

/**
 * Created by Woo-Young on 2017-08-27.
 */

//위기단계정보 + 위기단계 발령 정보 + 수신정보
public class EmgcStep extends BaseModel{

    private String emgcStepCo;      // 위기단계코드
    private String emgcType;        // 위기 구분(장애, 보안)
    private String emgcStepType;    // 위기단계 구분(관심, 주의, 경계, 심각)
    private String emgcStepCriteria; // 위기단계 기준

    private String emgcStepIssueNo; //위기단계발령번호
    private String emgcStepIssueDt; //위기단계발령일시(발령시 직접입력)

    private String userId;          // 사용자 정보(수신자)

    public String getEmgcStepCo() {
        return emgcStepCo;
    }

    public void setEmgcStepCo(String emgcStepCo) {
        this.emgcStepCo = emgcStepCo;
    }

    public String getEmgcType() {
        return emgcType;
    }

    public void setEmgcType(String emgcType) {
        this.emgcType = emgcType;
    }

    public String getEmgcStepType() {
        return emgcStepType;
    }

    public void setEmgcStepType(String emgcStepType) {
        this.emgcStepType = emgcStepType;
    }

    public String getEmgcStepCriteria() {
        return emgcStepCriteria;
    }

    public void setEmgcStepCriteria(String emgcStepCriteria) {
        this.emgcStepCriteria = emgcStepCriteria;
    }

    public String getEmgcStepIssueNo() {
        return emgcStepIssueNo;
    }

    public void setEmgcStepIssueNo(String emgcStepIssueNo) {
        this.emgcStepIssueNo = emgcStepIssueNo;
    }

    public String getEmgcStepIssueDt() {
        return emgcStepIssueDt;
    }

    public void setEmgcStepIssueDt(String emgcStepIssueDt) {
        this.emgcStepIssueDt = emgcStepIssueDt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "EmgcStep{" +
                "emgcStepCo='" + emgcStepCo + '\'' +
                ", emgcType='" + emgcType + '\'' +
                ", emgcStepType='" + emgcStepType + '\'' +
                ", emgcStepCriteria='" + emgcStepCriteria + '\'' +
                ", emgcStepIssueNo='" + emgcStepIssueNo + '\'' +
                ", emgcStepIssueDt='" + emgcStepIssueDt + '\'' +
                ", userId='" + userId + '\'' +
                "} " + super.toString();
    }
}
