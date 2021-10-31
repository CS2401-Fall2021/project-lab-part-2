public class Room {

  //Attributes
  private String welcomeMessage;
  private boolean isLocked;
  public int roomID;
  private boolean hasTreasure;
  private Key[] keys;
  private Room left;
  private Room right;
  private Room previous;
  String[] messages = {"WR1","WR2","WR3","WR4","WR5","WR6","WR7","WR8","WR9","WR10"};

  //Default Constructor
  public Room() {}

  //Other Constructor
  public Room(String welcomeMessageIn, boolean isLockedIn, int roomIDIn, boolean hasTreasureIn, Key[] keysIn, Room leftIn, Room rightIn, Room prevRoomIn){
    this.welcomeMessage = welcomeMessageIn;
    this.isLocked = isLockedIn;
    this.roomID = roomIDIn;
    this.hasTreasure = hasTreasureIn;
    this.keys = keysIn;
    this.left = leftIn;
    this.right = rightIn;
    this.previous = prevRoomIn;
  }
////
  public Room(int numKeys){
    this.welcomeMessage = messages[(int)(Math.random()*10)];
    this.roomID = (int)(Math.random()*numKeys);
    this.hasTreasure = Math.random()<=.5?true:false;
    this.isLocked = Math.random()<=.25?true:false;
    int temp = (int)(Math.random()*5.0);
    System.out.println(temp);
    this.keys = new Key[temp];
    for(int i=0;i<this.keys.length;i++){
      this.keys[i]=new Key((int)Math.random()*numKeys);
    }
  }
//
  //Methods
  public boolean unlock(int key){
    if(key == this.roomID){
      this.isLocked = false;
      return true;
    }
    return false;
  }

  public boolean getIsLocked(){
    return this.isLocked;
  }

  public int getRoomID(){
    return this.roomID;
  }

  public String getWelcomeMsg(){
    return this.welcomeMessage;
  }

  public boolean getHasTreasure(){
    return this.hasTreasure;
  }

  public Key[] getKeys(){
    return this.keys;
  }

  public Room getLeft(){
    return this.left;
  }

  public Room getRight(){
    return this.right;
  }

  public Room getParent(){
    return this.previous;
  }

  public void setLeftChild(Room left) {
    this.left = left;
  }

  public void setRightChild(Room right){
    this.right = right;
  }

  public void setParent(Room parent){
    this.previous = parent;
  }

  public void setHasTreasure(boolean treasure){
    this.hasTreasure = treasure;
  }

}
