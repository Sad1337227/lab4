import java.util.Random;

public class Robber extends Customer {
  
  private Boolean Color;
  private int ChanceToRob;

  public Boolean TryRob() {
    Random rand = new Random();
    return (ChanceToRob > rand.nextInt(100));
  };

  Robber() {
    Color = true;
    Random rand = new Random();
    ChanceToRob = rand.nextInt(100);
  }
}