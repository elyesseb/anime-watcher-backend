package com.sutorimingu.no.sekai.repository;

import com.sutorimingu.no.sekai.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sei3
 * on 31/07/2021.
 */
@Service
public interface CommentRepository extends CrudRepository<Comment, Long> {

    List<Comment> findByAnime_Id(Long id);

}
