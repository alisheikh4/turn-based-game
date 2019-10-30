public class Tile {
  
  private int xCoordinate;
  private int yCoordinate;
  private boolean hasCity;
  private boolean hasImprovements;
  private ListOfUnits tileUnits;
  
  public Tile (int x, int y) {
    this.xCoordinate = x;
    this.yCoordinate = y;
    this.hasCity = false;
    this.hasImprovements = false;
    this.tileUnits = new ListOfUnits();
    
  }
  
  public int getX () {
    return this.xCoordinate;
  }
  
  public int getY () {
    return this.yCoordinate;
  }
  
  public boolean isCity() {
    if (this.hasCity==true) {
      return true;
    }
    return false;
  }
  
  public boolean isImproved() {
    if (this.hasImprovements==true) {
      return true;
    }
    return false;
  }
  
  public void foundCity (){
    this.hasCity = true;
    
  }
  
  public void buildImprovement () {
    this.hasImprovements = true;
  }
  
  public boolean addUnit(Unit a){ 
    if(a instanceof MilitaryUnit==false) {
    this.tileUnits.add(a);
    return true;
    }
      Unit [] currentUnits = this.tileUnits.getUnits();
      if(currentUnits.length==0){
            this.tileUnits.add(a);
            return true;
      }
      for(int i=0; i<currentUnits.length;i++) {
        if(currentUnits[i].getFaction()!=a.getFaction()) {
          return false;
        }
      }
      return false;
    }

  
  public boolean removeUnit(Unit a) { 
    boolean wasRemoved = this.tileUnits.remove(a);
    //this.tileUnits.remove(a);
    if (wasRemoved == true) {
      return true;
    }
    return false;
  }
  
  public Unit selectWeakEnemy(String faction) {
    Unit [] currentUnits = this.tileUnits.getUnits();
    ListOfUnits enemyUnits = new ListOfUnits();
    for (int i = 0 ; i<currentUnits.length;i++) {
      if (currentUnits[i].getFaction()!=faction) {
        enemyUnits.add(currentUnits[i]);
      }
    }
    if (enemyUnits.size()==0) {
      return null;
    }
    Unit weakEnemy = enemyUnits.get(0);
    for (int i = 0; i<enemyUnits.size();i++) {
      if(weakEnemy.getHP()<enemyUnits.get(i).getHP()) {
        weakEnemy = enemyUnits.get(i);
      }
    }
    return weakEnemy;
  }
  
  public static double getDistance(Tile one, Tile two) {
    
    int x1= one.getX();
      int x2 = two.getX();
      int y1 = one.getY();
      int y2 = two.getY();
      double distance = Math.sqrt((Math.pow((x1-x2),2))+(Math.pow((y1-y2),2)));
      
      
      
      return distance;
  }
  
  
  
}