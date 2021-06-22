package resort;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class resort {
    @Id @GeneratedValue
    private long id;
    private String phonenum;
    private int member;
    private Date visit;
    private Date exit;
    static long count=0;
    public resort(String phonenum, int member, Date visit, Date exit){
        this.id=++count;

        this.phonenum= phonenum;
        this.member = member;
        this.visit = visit;
        this.exit= exit;
    }

    public String getPhonenum() {
        return this.phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public int getMember() {
        return this.member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public Date getVisit() {
        return this.visit;
    }

    public void setVisitDate(Date visit) {
        this.visit = visit;
    }

    public Date getExit() {
        return this.exit;
    }

    public void setExit(Date exit) {
        this.exit = exit;
    }

}
