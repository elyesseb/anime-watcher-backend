package com.sutorimingu.no.sekai.repository;

import com.sutorimingu.no.sekai.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByAnime_Id(Long id);

}
