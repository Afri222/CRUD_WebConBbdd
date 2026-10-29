package modelo;

import java.sql.Date;

/**
 *
 * @author afric
 */
public class Empleado {
    private int empno;
    private String ename;
    private String job;
    private Integer mgr;
    private Date hireDate;
    private int sal;
    private Integer comm;
    private int deptno;

    public Empleado(int empno, String ename, String job, Integer mgr, Date hireDate, int sal, Integer comm, int deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hireDate = hireDate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public Integer getComm() {
        return comm;
    }

    public void setComm(Integer comm) {
        this.comm = comm;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    @Override
    public String toString() {
        return "Empleado{" + "empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hireDate=" + hireDate + ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + '}';
    }
    
    
    
}
