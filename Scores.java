/**
 * Created by user on 16/02/21.
 */
public class Scores {
    public static final int maxEntries = 10;
    private int numEntries;
    private GameEntry[] entries;

    public Scores() {
        entries = new GameEntry[maxEntries];
        numEntries = 0;
    }
    public String toString() {
        String s = "[";
        for (int i = 0; i < numEntries; i++) {
            if (i > 0)
                s += ", ";
            s += entries[i];
        }
        return s + "]";
    }

    public void add(GameEntry e) {
        int newScore = e.getScore();

        if (numEntries == maxEntries) { // the array is full
            if (newScore <= entries[numEntries-1].getScore())
                return;

            else
            {
                int i ;
                for ( i = numEntries-1; i >=1 ; i--) {
                    entries[i] = entries[i-1] ; // shift right
                }
                entries[i] = e; // add the new score to entries
            }

        }
        else // the array is not full
            numEntries++;
        int i;
        for (i = numEntries-1 ; (i >= 1) && (newScore > entries[i-1].getScore()); i--)
            entries[i] = entries[i - 1]; // shift right

        entries[i] = e; // add the new score to entries
    }

    public GameEntry remove(int i)  {
        if ((i < 0) || (i >= numEntries))
            System.out.println("Invalid index: " + i);

        GameEntry temp = entries[i];
        for (int j = i; j < numEntries - 1; j++)
            entries[j] = entries[j+1]; // shift left
        entries[numEntries -1 ] = null; // last one become null
        numEntries--;
        return temp; // return the removed object
    }
}
