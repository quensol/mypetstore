package csu.web.mypetstore.persistence;

import csu.web.mypetstore.domain.Product;

import java.util.List;

public interface ProductDAO {


    List<Product> getProductListByCategory(String categoryId);

    Product getProduct(String productId);

    List<Product> searchProductList(String keywords);
}
