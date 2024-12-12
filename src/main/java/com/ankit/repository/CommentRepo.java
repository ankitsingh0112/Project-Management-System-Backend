package com.ankit.repository;

import com.ankit.modal.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Long> {
    List<Comment> findByIssueId(Long IssueId);
}
