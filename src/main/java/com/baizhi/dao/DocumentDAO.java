package com.baizhi.dao;

import com.baizhi.entity.Document;

import java.util.List;

public interface DocumentDAO {
    void add(Document document);
    void delete(String id);
    void update(Document document);
    List<Document>queryAll(String userId);
}
