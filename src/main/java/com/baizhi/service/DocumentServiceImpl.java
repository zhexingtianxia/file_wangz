package com.baizhi.service;

import com.baizhi.dao.DocumentDAO;
import com.baizhi.entity.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService{
    @Autowired
    private DocumentDAO documentDAO;

    @Override
    public void add(Document document) {
        documentDAO.add(document);
    }

    @Override
    public void delete(String id) {
        documentDAO.delete(id);
    }

    @Override
    public void update(Document document) {
        documentDAO.update(document);
    }

    @Override
    public List<Document> queryAll(String userId) {
        List<Document> documents = documentDAO.queryAll(userId);
        return documents;
    }
}
