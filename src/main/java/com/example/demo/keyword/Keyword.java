package com.example.demo.keyword;

import com.example.demo.paper.Paper;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

//@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//@JsonIgnoreProperties(value = {"keywords"})
@Setter
@Getter
public class Keyword /*implements Serializable*/ {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String keyword;

    @ManyToMany(mappedBy = "keywords")
//    @JsonIgnoreProperties("keywords")
//    @JsonBackReference
//    @JsonManagedReference
//    @JsonIgnore
//    @Transient
    private Set<Paper> papers;

//    @JsonBackReference
//    @JsonIgnoreProperties(value = {"keywords"})
//    public Set<Paper> getPapers() {
//        return papers;
//    }

/*
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setPapers(Set<Paper> papers) {
        this.papers = papers;
    }

    public Integer getId() {
        return id;
    }

    public String getKeyword() {
        return keyword;
    }

    public Set<Paper> getPapers() {
        return papers;
    }

 */
}
