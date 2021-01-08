package IOC.Bean;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Book {

    private String name;

    private String author;

//    公共集合
    private List<String> list;

    public String getAuthor() {
        return author;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", list=" + list +
                '}';
    }
}
