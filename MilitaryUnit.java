abstract class MilitaryUnit extends Unit { // new object type
  
  private double attackDamage;
  private int attackRange;
  private int armor;
  
  public  MilitaryUnit (Tile position, double hp,int range, String faction, double attackDamage, int attackRange, int armor) { //constructor method
    super(position, hp, range, faction);
    this.attackDamage = attackDamage;
    this.attackRange = attackRange;
    this.armor = armor;
  }
  
  public void takeAction(Tile a) {
    Tile myTile = this.getPosition();
    if((Tile.getDistance(myTile,a)>=(this.attackRange))==false) {
      Unit weakEnemy = a.selectWeakEnemy(this.getFaction());
      if(myTile.isImproved()) {
        weakEnemy.receiveDamage(this.attackDamage+((this.attackDamage)*0.05));
      }
      else {
        weakEnemy.receiveDamage(this.attackDamage);
      }
        }
        
      }
  
  public void receiveDamage(double damage) {
    double multiplier = 100/(100+this.armor);
    double newDamage= damage*multiplier;
    super.receiveDamage(newDamage);
    
  }
  
}