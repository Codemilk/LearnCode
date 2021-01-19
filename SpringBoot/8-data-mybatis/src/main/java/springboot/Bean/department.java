package springboot.Bean;

public class department {
    private Integer id;
    private String departmentName;

    public department(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public department() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
