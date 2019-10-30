public class Worker extends Unit { // new object type
    
    private int jobsPerformed;
    
    public Worker (Tile position, double hp, String faction) { //constructor method
      super(position, hp, 2, faction);
      this.jobsPerformed = 0;
    }
      public void takeAction(Tile a) {
     Tile myTile = this.getPosition();
      if(myTile==a) {
        if(a.isImproved()==false) {
          this.jobsPerformed=(this.jobsPerformed)+1;
          a.buildImprovement();
          if(this.jobsPerformed==10) {
            a.removeUnit(this);
          }
          
        }
      }
  }
      
      public boolean equals(Object a) {
        if((super.equals(a)==true)&&(this instanceof Worker)&&(a instanceof Worker)){
          int myJobs = ((Worker)a).jobsPerformed;
          if((this.jobsPerformed==myJobs)) {
            return true;
          }
          return false;
        }
        return false;
      }
  }