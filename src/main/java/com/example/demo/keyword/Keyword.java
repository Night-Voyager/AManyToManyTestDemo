package com.example.demo.keyword;

import com.example.demo.paper.Paper;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//@JsonIgnoreProperties(value = {"keywords"})
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
}
