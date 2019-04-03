package model;

public class ContactUsMessage {
    private String subjectHeading;
    private String email;
    private String orderRef;
    private String filePath;
    private String message;

    public ContactUsMessage(String subjectHeading, String email, String orderRef, String filePath, String message) {
        this.subjectHeading = subjectHeading;
        this.email = email;
        this.orderRef = orderRef;
        this.filePath = filePath;
        this.message = message;
    }

    public String getSubjectHeading() {
        return subjectHeading;
    }

    public String getEmail() {
        return email;
    }

    public String getOrderRef() {
        return orderRef;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getMessage() {
        return message;
    }
}
