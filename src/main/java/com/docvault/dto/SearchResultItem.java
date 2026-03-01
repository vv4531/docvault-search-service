package com.docvault.dto;

import java.util.List;
import java.util.Map;

public class SearchResultItem {
    private String id, title, author, department, storageTier, mimeType, uploadedAt;
    private long fileSizeBytes;
    private double score;
    private Map<String, List<String>> highlights;

    public String getId()          { return id; }
    public void setId(String v)    { this.id = v; }
    public String getTitle()       { return title; }
    public void setTitle(String v) { this.title = v; }
    public String getAuthor()      { return author; }
    public void setAuthor(String v){ this.author = v; }
    public String getDepartment()  { return department; }
    public void setDepartment(String v) { this.department = v; }
    public String getStorageTier() { return storageTier; }
    public void setStorageTier(String v) { this.storageTier = v; }
    public String getMimeType()    { return mimeType; }
    public void setMimeType(String v) { this.mimeType = v; }
    public String getUploadedAt()  { return uploadedAt; }
    public void setUploadedAt(String v) { this.uploadedAt = v; }
    public long getFileSizeBytes() { return fileSizeBytes; }
    public void setFileSizeBytes(long v) { this.fileSizeBytes = v; }
    public double getScore()       { return score; }
    public void setScore(double v) { this.score = v; }
    public Map<String, List<String>> getHighlights() { return highlights; }
    public void setHighlights(Map<String, List<String>> v) { this.highlights = v; }
}
