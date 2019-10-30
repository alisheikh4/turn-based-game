public class Warrior extends MilitaryUnit {
  
  public Warrior (Tile position, double hp, String faction) { // constructor method
    super(position, hp, 1, faction, 20.0, 1, 25);
  }
  
    public void takeAction(Tile a) {
    
  }
    public boolean equals(Object a) {
      if((super.equals(a)==true)&&(this instanceof Warrior)&&(a instanceof Warrior)){
      return true;
    }
  return false;
}
}