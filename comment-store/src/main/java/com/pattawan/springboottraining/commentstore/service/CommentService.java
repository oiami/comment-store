package com.pattawan.springboottraining.commentstore.service;


import com.pattawan.springboottraining.model.CommentModel;

import java.io.IOException;
import java.util.List;

public interface CommentService {

    String put(CommentModel model) throws IOException;

    List<CommentModel> list(String pageId) throws IOException;

    CommentModel get(String id);

    List<CommentModel> listSpamComments(String pageId) throws IOException;

    void delete(String id);
}
