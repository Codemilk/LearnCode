package jdbc_template;

import java.util.Date;

public class EMP {
    private  Integer id;
    private String ename;
    private Integer job_id;
    private Integer mgr;
    private Date joindate;
    private Double salsary;//这样的封装类允许值是null
    private Double bounds;
    private Integer dept_id;

    public Integer getId() {
        return id;
    }

    public String getEname() {
        return ename;
    }

    public Integer getJob_id() {
        return job_id;
    }

    public Integer getMgr() {
        return mgr;
    }

    public Date getJoindate() {
        return joindate;
    }

    public Double getSalsary() {
        return salsary;
    }

    public Double getBounds() {
        return bounds;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    @Override
    public String toString() {
        return "EMP{" +
                "id=" + id +
                ", ename='" + ename + '\'' +
                ", job_id=" + job_id +
                ", mgr=" + mgr +
                ", joindate=" + joindate +
                ", salsary=" + salsary +
                ", bounds=" + bounds +
                ", dept_id=" + dept_id +
                '}';
    }
}
