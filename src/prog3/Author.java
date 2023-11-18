package src.prog3;

public class Author {
    private int authorID;
    private String authorName;
    private char sex;

    public Author(int authorId, String authorName, char sex) {
        this.authorID = authorId;
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

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorID +
                ", authorName='" + authorName + '\'' +
                ", sex=" + sex +
                '}';
    }
}

