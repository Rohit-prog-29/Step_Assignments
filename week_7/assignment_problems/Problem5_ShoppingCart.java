class Cart {
    private final String cartId;
    private final double[] prices;
    private int itemCount;

    Cart(String cartId, int maximumItems) {
        if (cartId == null || cartId.trim().isEmpty() || maximumItems < 0) {
            throw new IllegalArgumentException("A cart ID and non-negative capacity are required.");
        }
        this.cartId = cartId;
        this.prices = new double[maximumItems];
    }

    boolean addItem(double price) {
        if (price < 0 || Double.isNaN(price) || Double.isInfinite(price)
                || itemCount == prices.length) {
            return false;
        }
        prices[itemCount++] = price;
        return true;
    }

    double getTotal() {
        double total = 0;
        for (int index = 0; index < itemCount; index++) {
            total += prices[index];
        }
        return total;
    }

    int getItemCount() {
        return itemCount;
    }

    String getCartId() {
        return cartId;
    }
}

public class Problem5_ShoppingCart {
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Cart ID: " + cart.getCartId());
        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}