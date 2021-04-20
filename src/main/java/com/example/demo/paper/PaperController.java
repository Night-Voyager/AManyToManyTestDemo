package com.example.demo.paper;

import com.example.demo.keyword.Keyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping(path = "/paper")
public class PaperController {
    @Autowired
    private PaperRepository paperRepository;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Paper> getAllPapers() {
        Iterable<Paper> paperIterable = paperRepository.findAll();
//        paperIterable.forEach(paper -> {
//            Set<Keyword> keywords = paper.getKeywords();
//            keywords.forEach(keyword -> {
//                keyword.setPapers(null);
//            });
//            paper.setKeywords(keywords);
//        });
        return paperIterable;
    }

    @PostMapping(path = "/add")
    @ResponseBody
    public ResponseEntity<?> addNewPaper(@RequestBody Paper paper) {
        paperRepository.save(paper);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(path = "/test")
    @ResponseBody
    public ResponseEntity<?> test() {
        Paper paper = paperRepository.findById(3).get();

        return ResponseEntity.ok().build();
    }
}
