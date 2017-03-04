package com.pattawan.springboottraining.commentstore.service;


import com.pattawan.springboottraining.model.CommentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired //tell spring to auto wire this field
    private CommentModelRepository repository;

//    @Autowired
//    private SpamDetector spamDetector;

    @Override
    public String put(CommentModel model) throws IOException {
        return null;
    }

    @Override
    public List<CommentModel> list(String pageId) throws IOException {
        return null;
    }

    @Override
    public CommentModel get(String id) {
        return null;
    }

    @Override
    public List<CommentModel> listSpamComments(String pageId) throws IOException {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
