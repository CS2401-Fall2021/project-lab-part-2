import java.util.Locale;
import java.util.Scanner;
import java.util.HashMap;

public class Game {
//
  static HashMap <Integer,Integer> keysHash = new HashMap<Integer,Integer>();
//
  public static void main(String[] args) {
    //Variables and objects
    int numKeys = 7;
    int maxDepth = 3;
    boolean[] keysFound = new boolean[numKeys];
    //Initialize keysFound to be false
    for(boolean key : keysFound){
      key = false;
    }
    Room start=generateRandomTreeGame(numKeys,maxDepth);
    printTreeRoom(start, keysFound);
  }

  static Room generateRandomTreeGame(int numKeys, int maxDepth){
    return generateRandomTreeGameAux(null, numKeys, maxDepth);
  }

  public static Room generateRandomTreeGameAux(Room parent, int numKeys, int maxDepth){
    Room room = new Room(numKeys);

    if(parent!=null){
      room.setParent(parent);
    }
    System.out.println("D: " + maxDepth);
    if(maxDepth >= 0){
      if (maxDepth == 0){
        room.setHasTreasure(true);
      }
      if(Math.random()<=.75){
        System.out.println("D: " + maxDepth + " L");
        room.setLeftChild(generateRandomTreeGameAux(room,numKeys,maxDepth-1));
      }
      if(Math.random()<=.75){
        System.out.println("D: " + maxDepth + " R");
        room.setRightChild(generateRandomTreeGameAux(room,numKeys,maxDepth-1));
      }
    }
    return room;
  }

  public static void printTreeRoom(Room room, boolean[] keysFound){
    System.out.println("\n>>>>>>>>>ROOM<<<<<<<<<");
    //Print welcome message
    System.out.println(room.getWelcomeMsg());
    //Check for treasure
    if(room.getHasTreasure()){
      System.out.println("Congratulations! You found the treasure!");
      return;
    }
    //Update keys
    for(Key key : room.getKeys()){
      int id = key.getId();
      keysHash.put(id,id);
      if(id>=0 && id< keysFound.length){
        keysFound[id] = true;
      }
    }
    System.out.println("Keys found:");
    System.out.println(keysHash.values());

    boolean valid=false;
    while(!valid) {
      System.out.println("OPTIONS:");
      if (room.getParent() != null) {
        System.out.println("(B) go back");
      }
      if (room.getLeft() != null) {
        System.out.println(
                "(L) go left. Door is " + (keysFound[room.getLeft().roomID] || !room.getIsLocked() ? "Unlocked" : "Locked"));
      }
      if (room.getRight() != null) {
        System.out.println(
                "(R) go right. Door is " + (keysFound[room.getRight().roomID] || !room.getIsLocked() ? "Unlocked" : "Locked"));
      }

      Scanner scanner = new Scanner(System.in);
      String line = scanner.nextLine();
      char sel = line.toLowerCase().charAt(0);
      Room selRoom = new Room();
      valid=true;
      if(sel == 'b') {
        selRoom = room.getParent();
      }
      else if(sel == 'l'){
        selRoom = room.getLeft();
      }
      else if(sel == 'r'){
        selRoom = room.getRight();
      }
      else{
        System.out.println("Not a valid answer. Choose B, L, or R.");
        valid=false;
      }

      //Unlock if possible and show the room status
      int id = selRoom.getRoomID();
      if(!room.getIsLocked()){
        printTreeRoom(selRoom,keysFound);
      }
      else if(room.getIsLocked() && keysFound[id]){
        selRoom.unlock(id);
        printTreeRoom(selRoom,keysFound);
      }
      else{
        System.out.println("Door is locked!");
      }

    }

  }

}
