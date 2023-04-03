package org.example.iterator.exercise;

public class Main {

    public static void main(String[] args) {
        ProductCollection productCollection = new ProductCollection();
        productCollection.add(new Product(1, "shoes"));
        productCollection.add(new Product(1, "hats"));
        productCollection.add(new Product(1, "trousers"));

        ProductCollection.ListIterator iterator = productCollection.createListIterator();

        while (iterator.hasNext()) {
            Product current = iterator.current();

            System.out.println(current);

            iterator.next();
        }
    }
}
