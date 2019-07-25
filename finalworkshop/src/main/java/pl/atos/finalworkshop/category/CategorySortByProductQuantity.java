package pl.atos.finalworkshop.category;

import java.util.Comparator;

public class CategorySortByProductQuantity implements Comparator<Category> {
    @Override
    public int compare(Category o1, Category o2) {
        return o2.getProductQuantity() - o1.getProductQuantity();
    }
}
