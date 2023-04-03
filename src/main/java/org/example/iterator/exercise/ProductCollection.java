package org.example.iterator.exercise;

import java.util.ArrayList;
import java.util.List;

public class ProductCollection {
  private List<Product> products = new ArrayList<>();

  public void add(Product product) {
    products.add(product);
  }

  public ListIterator createListIterator() {
    return new ListIterator(this);
  }

  public class ListIterator implements Iterator<Product> {

    private final ProductCollection collection;
    private int count;

    public ListIterator(ProductCollection collection) {
      this.collection = collection;
      this.count = 0;
    }

    @Override
    public boolean hasNext() {
      return count < collection.products.size();
    }

    @Override
    public Product current() {
      return collection.products.get(count);
    }

    @Override
    public void next() {
      count++;
    }
  }
}
