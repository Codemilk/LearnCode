package CrowedFunding_Entity;

import java.util.List;
import java.util.Map;

public class Student {
    private Integer stuId;
    private String strName;
    private Address address;
    private List<Subject> SubjectList;
    private Map<String,String> map;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Subject> getSubjectList() {
        return SubjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        SubjectList = subjectList;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", strName='" + strName + '\'' +
                ", address=" + address +
                ", SubjectList=" + SubjectList +
                ", map=" + map +
                '}';
    }
}
