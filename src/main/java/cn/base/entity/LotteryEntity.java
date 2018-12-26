package cn.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "lottery")
public class LotteryEntity implements  java.io.Serializable {
    private static final long serialVersionUID = -4376187124011546736L;

    private Integer id;

    private String type;
    private String name;
    private Integer popular;

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

    public void setType(String name) {
        this.type = name;
    }

    @Column(length = 50 , nullable = false)
    public String getType() {
        return type;
    }

    @Column(length = 20, nullable = false)
    public Integer getPopular() {
        return popular;
    }

    public void setPopular(Integer popular) {
        this.popular = popular;
    }



    @Override
    public String toString() {
        return "PersonEntity [id=" + id + ", name=" + name + "]";
    }

}

