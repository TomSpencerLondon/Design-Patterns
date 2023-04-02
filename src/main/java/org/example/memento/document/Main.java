package org.example.memento.document;

public class Main {

    public static void main(String[] args) {
        Document document = new Document();
        History history = new History();
        document.setContent("content1");
        document.setFontName("font1");
        document.setFontSize(1);
        history.push(document.createState());

        document.setContent("content2");
        document.setFontName("font2");
        document.setFontSize(2);
        history.push(document.createState());
        document.setContent("content3");
        document.setFontName("font3");
        document.setFontSize(3);

        document.restore(history.pop());
        document.restore(history.pop());

        System.out.println(document);

    }
}
