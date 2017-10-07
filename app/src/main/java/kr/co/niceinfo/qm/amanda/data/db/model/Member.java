package kr.co.niceinfo.qm.amanda.data.db.model;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fruitbites on 2017-10-07.
 */

public class Member {
    String uid;
    String name;
    String department;
    String email;
    String tel;
    String etel;

    public Member(String uid, String name, String department, String email, String tel, String etel) {
        this.uid = uid;
        this.name = name;
        this.department = department;
        this.email = email;
        this.tel = tel;
        this.etel = etel;
    }
    public Member() {
        this("","","","","","");
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEtel() {
        return etel;
    }

    public void setEtel(String etel) {
        this.etel = etel;
    }


    @Override
    public String toString() {
        return "Member{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", etel='" + etel + '\'' +
                '}';
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("name", name);
        result.put("department", department);
        result.put("email",email);
        result.put("tel", tel);
        result.put("etel", etel);

        return result;
    }
}
