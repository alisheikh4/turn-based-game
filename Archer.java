public class Archer extends MilitaryUnit{  // new object type
  
  private int arrowsAvailable;
  
  public Archer (Tile position, double hp, String faction) { // constructor method
    super(position, hp, 2, faction, 15.0, 2, 0);
    this.arrowsAvailable = 5; 
  }
  
  public void takeAction(Tile a) {
    if(this.arrowsAvailable==0){
      this.arrowsAvailable = 5;
    }
    else {
      this.arrowsAvailable=this.arrowsAvailable-1;
      super.takeAction(a);
    }
  }
  public boolean equals(Object a) {
    if((super.equals(a)==true)&&(this instanceof Archer)&&(a instanceof Archer)){
      int myArrows = ((Archer)a).arrowsAvailable;
      if((this.arrowsAvailable==myArrows)) {
        return true;
      }
      return false;
    }
    return false;
  }
}