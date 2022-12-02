package p02Articles;

public class Article {
    //полета -> характеристики
    private String title;
    private String content;
    private String author;

    //конструктор -> създава нови обекти от класа
    //alt + insert -> constructor

    public Article(String title, String content, String author) {
        //нов обект
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //метод -> Поведение
    public void edit(String newContent) {
        //съдържанието да се промени
        this.content = newContent;
    }

    public void changeAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    public void rename(String newTitle) {
        this.title = newTitle;
    }

    //вграден метод toString -> превръща обекта в текст
    @Override // пренаписвам някакъв default method -> да работи по начин по който ние искаме
    public String toString() {
        //Заглавието - Съдържанието: автора
        return this.title + " - " + this.content + ": " + this.author;
    }
}
