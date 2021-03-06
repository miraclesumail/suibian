package cn.base.entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "person")
public class PersonEntity implements java.io.Serializable {
    private static final long serialVersionUID = -4376187124011546736L;

    private Integer id;
    private String name;
    private Date time;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(length = 50 , nullable = false , unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "PersonEntity [id=" + id + ", name=" + name + ", time = " + time + "]";
    }

}

