# Project Lab Part 2:

In this portion of your lab you will create Rooms in a tree structure and randomly generate a level. You may choose to use the code you wrote for part 1, or use the provided files for you. Please copy your files from the previous lab into this repo.

## Update Room Class: 10 pts
Make your room class able to be a node in a tree. Unlike the trees we've seen in class, the nodes in this tree will know about it's parent. This just means we need both a Left Room and Right Room as well as a Previous (Parent) Room.

You should be able to do this via adding 3 fields

## PrintTreeRoom(Room room, boolean[] keys: 30 pts
Now when we get to the room we want to still perform the following steps (aka no change from part 1)

* Print out the welcome message
* If the treasue is at the point, print a congratulations message and end the game
* If there are KEYS in this room, print a message that a key has been found, and add it to the keys found array. The key's integer is the index in the array.

But instead of "Return to the Hallway", we want to Give the user options. We should check if each room is locked or unlocked and display that to the user as well.
* Left (if it exists) 
* Right(if it exists)
* Back (if it exists)

If a user inputs a valid option, then print out that room. Otherwise, re-prompt the user.

## Implement method public Room generateRandomTreeGame(int numkeys, int maxDepth): 50 pts
In Part 1, we hard-coded a hallway. But in this game, we want to randomly generate a game. To generate a random number between 0 and 1, we can use Math.random(). If we want to generate a random integer between 0 and 10 we would need to do (int)(Math.random()*10)

You want to create an initial starting Room, which will be the Room you return in this method. For every room
* Randomly select the welcome message from an array of 10 strings
* Randomly choose which key unlucks teh room (from 0 to numKeys-1)
* Randomly decide if the room has treasure (Should be a 1 in 10 chance)
* Randomly decide if the room is lockes (Should be a 1 in 4 chance)
* Randomly determine which keys are in that room. There can be 0-numKeys keys, each with equal probability. Randomly select the number of keys.
* Randomly determine if it has a left room (3/4 chance) and a right room (3/4 chance). This should become zero if it's distance from the head is equal to maxDepth.


## Update main() to do the following: 10 pts
* Create a boolean[] of length numKeys to represent foundKeys
* Call generateRandomTreeGame(int numkeys, int maxDepth). maxDepth must be at least 4
* Print the Room generateRandomTreeGame returns. 


## Grading
This lab will be demoed as well, please choose a timeslot on the following sheet
