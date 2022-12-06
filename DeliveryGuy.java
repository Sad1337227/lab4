import java.util.Random;

public class DeliveryGuy extends Customer {
  public void TryDeliver(Shop shop) {
    Random rand = new Random();
    for (int i = 0; i < shop.Products.size(); ++i) {
      Product prod = shop.Products.get(i);
      if (prod.GetQuantity() < 1 && (rand.nextInt(2)) == 1) {
        int rand_quantity = rand.nextInt(10 - 3) + 3;

        int price_to_pay =
            (int) (rand_quantity * prod.GetPrice() / shop.ApplyDiscount(prod.GetQuantity()));
        prod.SetQuantity(rand_quantity);

        if (shop.GetMoney() < price_to_pay) {
          System.out.println(("The shop couldn't order " + rand_quantity + " " + prod.GetName()
              + " because they do not have money."));
          break;
        }
        shop.SetMoney(shop.GetMoney() - price_to_pay);

        System.out.println(GetName() + " has delivered " + rand_quantity + " " + prod.GetName());
      }
    }

    return;
  }

  DeliveryGuy() {
    super();
    SetMoney(new Random().nextInt(5500 - 2500) + 2500);
  }
}