package org.example.session03.model;

public enum StudentStatus {
    DANG_HOC("Đang học", "status-active"),
    BAO_LUU("Bảo lưu", "status-paused"),
    TOT_NGHIEP("Tốt nghiệp", "status-graduated");

    private final String displayName;
    private final String cssClass;

    StudentStatus(String displayName, String cssClass) {
        this.displayName = displayName;
        this.cssClass = cssClass;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getCssClass() {
        return cssClass;
    }
}

