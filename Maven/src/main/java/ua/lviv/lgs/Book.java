package ua.lviv.lgs;

public class Book {
   public int id;
    private String name;
    private String writer;
     String category;

    public Book(String name, String writer, String category) {
        this.id = id;
        this.name = name;
        this.writer = writer;
        this.category = category;
    }
    public Book(int id,String name, String writer, String category) {
        this.id = id;
        this.name = name;
        this.writer = writer;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWriter() {
        return writer;
    }

    public String getCategory() {
        return category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", writer='" + writer + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
