package com.baizhi.entity;

public class Document {
    private String id;
    private String originalName;
    private String newName;
    private String extension;
    private String storagePath;
    private Double fileSize;
    private String fileType;
    private String isImage;
    private Integer downloadTimes;
    private String userId;

    public Document() {
    }

    public Document(String id, String originalName, String newName, String extension, String storagePath, Double fileSize, String fileType, String isImage, Integer downloadTimes, String userId) {
        this.id = id;
        this.originalName = originalName;
        this.newName = newName;
        this.extension = extension;
        this.storagePath = storagePath;
        this.fileSize = fileSize;
        this.fileType = fileType;
        this.isImage = isImage;
        this.downloadTimes = downloadTimes;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(String storagePath) {
        this.storagePath = storagePath;
    }

    public Double getFileSize() {
        return fileSize;
    }

    public void setFileSize(Double fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getIsImage() {
        return isImage;
    }

    public void setIsImage(String isImage) {
        this.isImage = isImage;
    }

    public Integer getDownloadTimes() {
        return downloadTimes;
    }

    public void setDownloadTimes(Integer downloadTimes) {
        this.downloadTimes = downloadTimes;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", originalName='" + originalName + '\'' +
                ", newName='" + newName + '\'' +
                ", extension='" + extension + '\'' +
                ", storagePath='" + storagePath + '\'' +
                ", fileSize=" + fileSize +
                ", fileType='" + fileType + '\'' +
                ", isImage='" + isImage + '\'' +
                ", downloadTimes=" + downloadTimes +
                '}';
    }
}
