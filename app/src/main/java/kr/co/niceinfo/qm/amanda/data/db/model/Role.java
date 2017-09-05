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

    public Role() {
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleCd='" + roleCd + '\'' +
                ", roleNm='" + roleNm + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (roleCd != null ? !roleCd.equals(role.roleCd) : role.roleCd != null) return false;
        return roleNm != null ? roleNm.equals(role.roleNm) : role.roleNm == null;

    }

    @Override
    public int hashCode() {
        int result = roleCd != null ? roleCd.hashCode() : 0;
        result = 31 * result + (roleNm != null ? roleNm.hashCode() : 0);
        return result;
    }
}
