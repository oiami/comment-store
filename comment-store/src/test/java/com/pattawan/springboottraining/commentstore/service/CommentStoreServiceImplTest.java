package com.pattawan.springboottraining.commentstore.service;

import com.pattawan.springboottraining.model.CommentModel;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest()
public class CommentStoreServiceImplTest {

    @Autowired
    private CommentModelRepository repository;

    @Autowired
    private CommentService service;

    private CommentModel model;

    @Before
    public void setup() {
        model = new CommentModel();
        model.setUsername("testuser");
        model.setId("dqe345e456rf34rw");
        model.setPageId("product0815");
        model.setPageId("user@example.com");
        model.setComment("This is comment");
        repository.deleteAll();
    }

    @Test
    public void testPutAndGet() throws IOException {
        service.put(model);

        CommentModel dbModel = service.get(model.getId());
        assertNotNull(dbModel);
        assertEquals(model.getComment(), dbModel.getComment());
        assertEquals(model.getId(), dbModel.getId());
        assertEquals(model.getPageId(), dbModel.getPageId());
        assertEquals(model.getUsername(), dbModel.getUsername());
        assertEquals(model.getEmailAddress(), dbModel.getEmailAddress());

        assertNotNull(dbModel.getLastModificationDate());
        assertNotNull(dbModel.getCreationDate());
        assertFalse(model.isSpam());
    }

    @Test
    public void testListNotFound() throws IOException {
        service.put(model);
        List<CommentModel> comment = service.list("sdfgskdtgpghoefe");
        assertTrue(comment.isEmpty());
    }

    @Test
    public void testList() throws IOException {
        service.put(model);
        List<CommentModel> comment = service.list(model.getPageId());
        assertNotNull(comment);
        assertEquals(1, comment.size());
        assertEquals(model.getId(), comment.get(0));
    }

    @Test
    public void testListSpam() throws IOException {
        model.setComment("I Love Viagra");
        service.put(model);
        List<CommentModel> comment = service.listSpamComments(model.getPageId());
        assertNotNull(comment);
        assertEquals(1, comment.size());
        assertEquals(model.getId(), comment.get(0).getId());
    }
}