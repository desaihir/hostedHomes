// CommentServiceImpl.java
package com.example.service;

import com.example.pojo.Comment;
import com.example.dao.CommentRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void addComment(Comment comment, String username) {
        commentRepository.save(comment, username);
    }

    @Override
    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId);
    }

    @Override
    public void updateComment(Comment comment, String username) {
        commentRepository.save(comment, username);
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
    
    @Override
    public List<Comment> getCommentsByListingId(Long listingId) {
        return commentRepository.findByListingId(listingId);
    }
}
