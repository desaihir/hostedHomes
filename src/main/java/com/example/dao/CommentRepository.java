// CommentRepository.java
package com.example.dao;

import java.util.List;

import com.example.pojo.Comment;

public interface CommentRepository {
    void save(Comment comment, String username);
    Comment findById(Long commentId);
    void deleteById(Long commentId);
    List<Comment> findByListingId(Long listingId);
}