package csu.web.mypetstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;
    //购物车的项
public class CartItem implements Serializable {
  private static final long serialVersionUID = 6620528781626504362L;

  private Item item;
  private int quantity;//数量
  private boolean inStock;//库存
  private BigDecimal total;//总价

  public boolean isInStock() {
    return inStock;
  }

  public void setInStock(boolean inStock) {
    this.inStock = inStock;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
    calculateTotal();
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
    System.out.println(quantity);
    calculateTotal();
  }

  public void incrementQuantity() {
    quantity++;
    calculateTotal();
  }

  private void calculateTotal() {
    if (item != null && item.getListPrice() != null) {
      total = item.getListPrice().multiply(new BigDecimal(quantity));
    } else {
      total = null;
    }
  }

}
