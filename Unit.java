public abstract class Unit {
  private Tile position;
  private double hp;
  private int range;
  private String faction;
  
  public Unit (Tile position, double hp, int range, String faction) { //constructor method
    this.position = position;
    this.hp = hp;
    this.range = range;
    this.faction = faction;
    (this.position).addUnit(this);
  }
  
  public final Tile getPosition() {  //method that returns position of unit
    Tile myPosition = this.position;
    return myPosition;
  }
  
  public final  double getHP() {  //method that returns HP of unit
    double myHp = this.hp;
    return myHp;
  }
  
  
  public final String getFaction() { //method that returns Faction type of unit
    String myFaction = this.faction;
    return myFaction;
    
  }
  
  public boolean moveTo(Tile deployed) { //add if statement checking range of movement is legal
   // if(){
    (this.position).removeUnit(this);
    deployed.addUnit(this);
    return true;
   // }
  }
  
  public void receiveDamage(double damage) {
    if (this.position.isCity()==true) {
      this.hp = (this.hp)-(damage-(damage/10));
    }
    else {
      this.hp = (this.hp)-damage;
    }
    if (this.hp<1) {
      this.position.removeUnit(this);
    }
    
    
  }
  
  public abstract void takeAction(Tile a);
  
  public boolean equals(Object a) {
    
    Tile myPosition = ((Unit)a).getPosition();
    double myHp = ((Unit)a).getHP();
    String myFaction = ((Unit)a).getFaction();
    if((this.position== myPosition)&&(this.hp==myHp)&&(this.faction==myFaction)&&(this instanceof Unit )&&(a instanceof Unit)){
      return true;
    }
    return false;
  }
  
}




