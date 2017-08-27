package kr.co.niceinfo.qm.amanda.data.db.model;

/**
 * Created by Woo-Young on 2017-08-27.
 */

//권한
public class Role extends BaseModel{

    private String roleCd;  //권한 코드
    private String roleNm;  //권한명

    public String getRoleCd() {
        return roleCd;
    }

    public void setRoleCd(String roleCd) {
        this.roleCd = roleCd;
    }

    public String getRoleNm() {
        return roleNm;
    }

    public void setRoleNm(String roleNm) {
        this.roleNm = roleNm;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleCd='" + roleCd + '\'' +
                ", roleNm='" + roleNm + '\'' +
                "} " + super.toString();
    }
}
