package com.example.demo.paper;

import com.example.demo.keyword.Keyword;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

//@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//@JsonIgnoreProperties(value = {"papers"})
public class Paper /*implements Serializable*/ {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    @ManyToMany(cascade = CascadeType.PERSIST) // 给当前设置的实体操作另一个实体的权限。
//    @JsonIgnore
//    @Transient
//    @JsonManagedReference
//    @JsonBackReference
//    @JsonSerialize(using = KeywordSerializerForPaper.class)
    private Set<Keyword> keywords;

//    @JsonBackReference
//    @JsonIgnoreProperties(value = {"papers"})
//    public Set<Keyword> getKeywords() {
//        return keywords;
//    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setKeywords(Set<Keyword> keywords) {
        this.keywords = keywords;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Set<Keyword> getKeywords() {
        return keywords;
    }
}
