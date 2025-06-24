public class Book implements Comparable<Book> {
    private String author = "";
    private String isbn = "";
    private String title = "";
    public Book(String author_, String isbn_, String title_) {
        author = author_;
        isbn = isbn_;
        title = title_;
    }
    @Override
    public int compareTo(Book titleInp) {
        if(title.length() > titleInp.title.length()) {
            for(int i = 0; i < titleInp.title.length(); i++) {
                if(titleInp.title.charAt(i) > title.charAt(i)) {
                    return 1;
                } 
                if(titleInp.title.charAt(i) < title.charAt(i)) {
                    return -1;
                }
            }
        } else {
            for(int i = 0; i < title.length(); i++) {
                if(titleInp.title.charAt(i) > title.charAt(i)) {
                    return 1;
                } 
                if(titleInp.title.charAt(i) < title.charAt(i)) {
                    return -1;
                }
            }
        }
        return 0;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
