package com.example.demo2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;  /*service에 작성하는걸 추천추천*/

    /*
    *[GET]/post/1
    */
    @GetMapping("/{id}")
    public Map<String, Object> find(@PathVariable Long id){
        String selectSql = "SELECT ID, TITLE, CONTENT, CREATED_BY, CREATED_AT, LAST_MODIFIED_AT FROM POST WHERE id=?";
        return jdbcTemplate.queryForMap(selectSql, id);
    }

    /*
     *[POST]/post
     */
    @PostMapping("/")
    public Integer create(@RequestBody Map<String, Object> body){
        String insertSql = "INSERT INTO POST(TITLE, CONTENT, CREATED_BY, CREATED_AT, LAST_MODIFIED_AT) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(insertSql, body.get("title"), body.get("content"), body
        .get("created_by"), LocalDateTime.now(), LocalDateTime.now());
    }

    @PutMapping("/")
    public Integer edit(@RequestBody Map<String, Object> body){
        String updateSql = "UPDATE POST SET TITLE =?, CONTENT=?, LAST_MODIFIED_AT=? WHERE ID =?";
        return jdbcTemplate.update(updateSql, body.get("title"), body.get("content"), LocalDateTime.now(), body.get("id"));
    }

    /*
     *[DELETE]/post/1
     */
    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id){
        String deleteSql = "DELETE FROM POST WHERE ID = ?";
        jdbcTemplate.update(deleteSql, id);
    }
}
