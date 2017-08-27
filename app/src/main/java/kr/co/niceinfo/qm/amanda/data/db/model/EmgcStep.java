package kr.co.niceinfo.qm.amanda.data.db.model;

/**
 * Created by Woo-Young on 2017-08-27.
 */

//위기단계
public class EmgcStep extends BaseModel{

    private String emgcStepCo;      // 위기단계코드
    private String emgcType;        // 위기 구분(장애, 보안)
    private String emgcStepType;    // 위기단계 구분(관심, 주의, 경계, 심각)
    private String emgcStepCriteria; // 위기단계 기준

    private String emgcStepHist;

}
