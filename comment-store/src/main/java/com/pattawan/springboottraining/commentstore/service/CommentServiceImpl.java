package com.pattawan.springboottraining.commentstore.service;


import com.pattawan.springboottraining.model.CommentModel;
import com.pattawan.springboottraining.spamdetection.SpamDetector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired //tell spring to auto wire this field
    private CommentModelRepository repository;

    @Autowired
    private SpamDetector spamDetector;

    @Override
    @Transactional
    public String put(CommentModel model) throws IOException {
        if (StringUtils.isEmpty(model.getId())) {
            model.setId(UUID.randomUUID().toString());
        }
        if(spamDetector.containsSpam(model.getUsername()) ||
            spamDetector.containsSpam(model.getEmailAddress()) ||
                spamDetector.containsSpam(model.getComment())) {
            model.setSpam(true);
        }

        final CommentModel dbModel = get(model.getId());
        if (dbModel != null) {
            dbModel.setUsername(model.getUsername());
            dbModel.setComment(model.getComment());
            dbModel.setLastModificationDate(Calendar.getInstance());
            repository.save(dbModel);
        }
        else {
            model.setCreationDate(Calendar.getInstance());
            model.setLastModificationDate(Calendar.getInstance());
            repository.save(model);
        }
        return model.getId();
    }

    @Override
    public List<CommentModel> list(String pageId) throws IOException {
        return null;
    }

    @Override
    public CommentModel get(String id) {
        return repository.findOne(id);
    }

    @Override
    public List<CommentModel> listSpamComments(String pageId) throws IOException {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
