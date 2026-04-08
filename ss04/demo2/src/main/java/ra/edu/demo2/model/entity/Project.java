package ra.edu.demo2.model.entity;

import java.util.Date;

public class Project {
    private int prjId;
    private String prjName;
    private String prjDesc;
    private String prjDirector;
    private Date prjStartDate;
    private Date prjEndDate;
    private int totalPersonnel;

    public int getPrjId() {
        return prjId;
    }

    public void setPrjId(int prjId) {
        this.prjId = prjId;
    }

    public String getPrjName() {
        return prjName;
    }

    public void setPrjName(String prjName) {
        this.prjName = prjName;
    }

    public String getPrjDesc() {
        return prjDesc;
    }

    public void setPrjDesc(String prjDesc) {
        this.prjDesc = prjDesc;
    }

    public String getPrjDirector() {
        return prjDirector;
    }

    public void setPrjDirector(String prjDirector) {
        this.prjDirector = prjDirector;
    }

    public Date getPrjStartDate() {
        return prjStartDate;
    }

    public void setPrjStartDate(Date prjStartDate) {
        this.prjStartDate = prjStartDate;
    }

    public Date getPrjEndDate() {
        return prjEndDate;
    }

    public void setPrjEndDate(Date prjEndDate) {
        this.prjEndDate = prjEndDate;
    }

    public int getTotalPersonnel() {
        return totalPersonnel;
    }

    public void setTotalPersonnel(int totalPersonnel) {
        this.totalPersonnel = totalPersonnel;
    }

    public Project() {
    }

    public Project(int prjId, String prjName, String prjDesc, String prjDirector, Date prjStartDate, Date prjEndDate, int totalPersonnel) {
        this.prjId = prjId;
        this.prjName = prjName;
        this.prjDesc = prjDesc;
        this.prjDirector = prjDirector;
        this.prjStartDate = prjStartDate;
        this.prjEndDate = prjEndDate;
        this.totalPersonnel = totalPersonnel;
    }
}
