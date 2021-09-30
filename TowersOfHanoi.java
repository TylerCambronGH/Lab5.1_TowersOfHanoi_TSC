/**
 * TowersOfHanoi represents the classic Towers of Hanoi puzzle.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class TowersOfHanoi
{
    private int totalDisks;
    private int[] disksOnTower;
    private int totalMoves;

    /**
     * Sets up the puzzle with the specified number of disks.
     *
     * @param disks the number of disks 
     */
    public TowersOfHanoi(int disks)
    {
    	totalMoves = 0;
        totalDisks = disks;
        disksOnTower = new int[3];
        disksOnTower[0] = disks;
        disksOnTower[1] = 0;
        disksOnTower[2] = 0;
    }

    /**
     * Performs the initial call to moveTower to solve the puzzle.
     * Moves the disks from tower 1 to tower 3 using tower 2.
     */
    public void solve()
    {
        moveTower(totalDisks, 1, 3, 2);
    }		

    /**
     * Moves the specified number of disks from one tower to another
     * by moving a subtower of n-1 disks out of the way, moving one
     * disk, then moving the subtower back. Base case of 1 disk.
     *
     * @param numDisks  the number of disks to move
     * @param start     the starting tower
     * @param end       the ending tower
     * @param temp      the temporary tower
     */
    private void moveTower(int numDisks, int start, int end, int temp)
    {
        if (numDisks == 1)
            moveOneDisk(start, end);
        else
        {
            moveTower(numDisks-1, start, temp, end);
            moveOneDisk(start, end);
            moveTower(numDisks-1, temp, end, start);
        }
    }

    /**
     * Prints instructions to move one disk from the specified start
     * tower to the specified end tower.
     *
     * @param start  the starting tower
     * @param end    the ending tower
     */
    private void moveOneDisk(int start, int end)
    {
        System.out.println("Move one disk from " + start + " to " + end);
        disksOnTower[start-1]--;
        disksOnTower[end-1]++;
        displayTowers();
        totalMoves++;
    }
    
    public void displayTowers() {
    	String towerStr = "";
    	for (int h=totalDisks; h>0; h--) {
	    	for (int i: disksOnTower) {
	    		if (h <= i) {
	    			towerStr += "_ ";
	    		} else {
	    			towerStr += "  ";
	    		}
	    	}
	    	towerStr += "\n";
    	}
    	towerStr += "1 2 3";
    	System.out.println(towerStr);
    }
    
    public int getTotalMoves() {
    	return totalMoves;
    }
}		
