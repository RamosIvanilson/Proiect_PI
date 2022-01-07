package LoginAndRegister;

import java.io.File;


public  class Books  {
     
    public String title;
    public String author;
    public String sinopse;
    public String category;
    public String info;
    public int code;
    public File book;
    book_icon bi;

    public Books(String title, String autor, String sinopse, String category, String info, int code) {
        this.title = title;
        this.author = autor;
        this.sinopse = sinopse;
        this.category = category;
        this.info = info;
        this.code = code;
    }

    public Books(String title, String Autor, String sinopse, String category, String info, int code, File book) {
        this.title = title;
        this.author = Autor;
        this.sinopse = sinopse;
        this.category = category;
        this.info = info;
        this.code = code;
        this.book = book;
        bi = new book_icon();
        bi.setData(title, Autor, sinopse, category, info, code, book);
    }

    public book_icon getBi() {
        return bi;
    }
    

    public Books() {
    } 

    public int getCode() {
        return code;
    }

    public void setBook(File book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Books{" + "title=" + title + ", author=" + author + ", sinopse=" + sinopse + ", category=" + category + ", info=" + info + ", code=" + code + ", book=" + book + ", bi=" + bi + '}';
    }
 
}


