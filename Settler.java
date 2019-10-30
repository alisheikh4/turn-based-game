public class Settler extends Unit { // new object type
  
  public Settler (Tile position, double hp, String faction) { // constructor method
    super(position, hp, 2, faction);

  }
  
    public void takeAction(Tile a) {
     Tile myTile = this.getPosition();
      if(myTile==a) {
        if(a.isCity()==false) {
          a.foundCity();
          a.removeUnit(this);
        }
      }
  }
    
    public boolean equals(Object a) {
      if((super.equals(a))&&(this instanceof Settler)&&(a instanceof Settler)){
        return true;
      }
      return false;
    }
}