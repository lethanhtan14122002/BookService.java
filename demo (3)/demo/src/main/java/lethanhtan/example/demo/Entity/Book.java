package lethanhtan.example.demo.Entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;
import lombok.Data;


@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="title")
    @NotEmpty(message = "title must not be empty")
    @Size(max = 50 , min =1 , message = "title must be less than 50 characters")
    private String title;

    @Column(name ="author")
    private String author;

    @Column(name ="price")
    @NotNull(message = "price is required")
    @Positive(message = "price must be greater than 0")
    private Double price;

    @ManyToOne

    @JoinColumn(name = "category_id" , referencedColumnName = "id")

    private Category category;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")

    private User user;
    public Long getId() {
        return id;
    }

    public Book() {
    }

    public Book(Long id, String title, String author, Double price, Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.category = category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}