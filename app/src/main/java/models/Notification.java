package models;

/**
 * Created by jesus on 20-04-2015.
 */
public class Notification {
    private String title;
    private String receivedDate;
    private String content;

    public Notification(String title, String receivedDate, String content) {
        this.title = title;
        this.receivedDate = receivedDate;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }
}
