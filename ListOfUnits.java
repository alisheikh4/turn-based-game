public class ListOfUnits {
  
  private Unit [] unitList;
  private int unitsInList;
  
  public ListOfUnits () {
    this.unitList = new Unit [10];
    this.unitsInList = 0;
  }
  
  public int size () {
    int listSize = this.unitsInList;
    
    return listSize;
  }
  
  public Unit [] getUnits () {
    
    Unit [] myUnits = new Unit [this.unitsInList];
    if(myUnits.length==0){
      return myUnits;
    }
    for (int i = 0; i<this.unitsInList; i++) {
      myUnits[i] = this.unitList[i];
    }
    return myUnits;
    
  }
  
  public Unit get (int listPosition) {
    Unit myUnit = this.unitList[listPosition];
    return myUnit;
  }
  
  public void add(Unit newUnit) {
    if (this.unitList[this.unitList.length-1]!=null) {
      Unit [] bigger = new Unit [this.unitList.length+this.unitList.length/2 + 1];
      for (int i = 0; i<this.unitList.length; i++) {
        bigger [i] = this.unitList[i];
      }
    }
    for (int i =0; i<this.unitList.length;i++) {
      if (this.unitList[i]==null) {
        this.unitList[i] = newUnit;
        this.unitsInList=this.unitsInList+1;
        break;
      }
      
    }
  }
  
  public int indexOf(Unit a) { 
    if(this.unitsInList==0) {
      return -1;
    }
    for (int i = 0; i<this.unitList.length;i++) {
      if (this.unitList[i].equals(a)) {
        return i;
      }
    }
    return -1;
  }
  public boolean remove(Unit a) {
    int location = indexOf(a);
    if (location == -1) {
      return false;
    }
    this.unitList[location] = null;
    for (int i =location;i<this.unitList.length;i++) {
      this.unitList[i] = this.unitList[i+1];
      this.unitsInList=this.unitsInList-1;
      return true;
    }
    return false;
  }
  
  public MilitaryUnit [] getArmy() { 
    int militaryUnitsInList=0;
    for(int i = 0; i<this.unitList.length;i++) {
      if (this.unitList[i]instanceof MilitaryUnit) {
        militaryUnitsInList=militaryUnitsInList+1;
      }
    }
    MilitaryUnit [] myMilitaryUnits = new MilitaryUnit [militaryUnitsInList];
    for(int i = 0; i<this.unitList.length;i++) {
      if (this.unitList[i]instanceof MilitaryUnit) {
        myMilitaryUnits[i] = (MilitaryUnit)this.unitList[i];
      }
    }
    return myMilitaryUnits;
  }
  
  
  
  
  
} 