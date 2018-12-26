package cn.base.entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "charges")
public class ChargeEntity implements java.io.Serializable {
    private static final long serialVersionUID = -4376187824011546736L;

    private Integer id;
    private Integer amount;
    private String method;
    private Date time;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable = false)
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Column(length = 50 , nullable = false , unique = true)
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Column(name = "time", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "PersonEntity [id=" + id + ", method =" + method + ", time = " + time + "]";
    }

}

