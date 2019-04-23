package com.baizhi.test;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.Document;
import com.baizhi.entity.User;
import com.baizhi.service.DocumentService;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class TestUnits extends BasicTest{
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserService userService;
    @Autowired
    private DocumentService documentService;

    @Test
    public void testUserLogin(){
        User q = userDAO.login("q");
        System.out.println(q);
    }
    @Test
    public void testMethod(){
        User q = userService.queryByUsername(new User(null,"q",null,null));
        System.out.println(q);
    }

    @Test
    public void testDocumentQueryAll(){
        List<Document> documents = documentService.queryAll("1");
        for (Document document : documents) {
            System.out.println(document);
        }
    }
}
