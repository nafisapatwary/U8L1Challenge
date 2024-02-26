import java.util.Arrays;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
//        Row 1 should be seats 1-12
//        Row 2 should be seats 13-18
//        Row 3 should be seats 19-24
//        Row 4 should be seats 25 and 26
//        Row 5 should be seats 27-30
//        Row 6 should be seats 31-34

        //null in this 2d array represents empty seats
        String[][] curr = {{"Artyom", "Haroon", "Veronica", "Tracy", null, "Nafisa", "Dariusz", "Tian Ying", "Shakkib", "Noelle", "Adib", "Jason"},
                           {"Siyam", "Leandra", null, "Rafael", "Xin", "Farian"},
                           {"Irsal", "Stanley", "Sharon", null, "Ricky", "Yanbo"},
                           {null, null},
                           {"Christian", "Brandon", "Nikita", "Naya"},
                           {null, "Enamul", "Jack", "Ryan"}};

        //null in this array list represents seats that cannot be used (RIP seat 5)
        ArrayList<Integer> seatNums = new ArrayList<Integer>();
        for (int i = 1; i < 35; i++){
            if (i == 5){
                seatNums.add(null);
            }
            else{
                seatNums.add(i);
            }
        }
        System.out.println(seatNums);
        //every student must go to a new seat: the element of the list cannot equal its index + 1
        //every student must have new neighbors: the element before the number cannot be equal to the number - 1 and the
        //element after cannot be equal to the number + 1
        //no one can sit at seat 5: no number can be at index 4
        //everyone must have at least one neighbor:
        //if someone is at the edge of the row, they cannot be seated next to null
        //if someone is in the middle of a row, either the element before or the element after CANNOT be null

    }
}