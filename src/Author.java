package src;

public class Author {
    private int authorID;
    private String authorName;
    private String   sex;

    public Author(int authorID, String authorName, String sex) {
        this.authorID = authorID;
        this.authorName = authorName;
        this.sex = sex;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
