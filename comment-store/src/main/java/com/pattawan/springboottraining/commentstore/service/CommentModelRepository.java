package com.pattawan.springboottraining.commentstore.service;


import com.pattawan.springboottraining.model.CommentModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentModelRepository extends CrudRepository<CommentModel, String>{

//    @Query("Select a from CommentModel a where a.pageID = ?1")
    List<CommentModel> findByPageId(String pageId);

    List<CommentModel> findByPageIdAndSpamIsTrue(String pageId);
}
