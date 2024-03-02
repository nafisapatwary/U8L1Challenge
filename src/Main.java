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


        String[] curr = {"Artyom", "Haroon", "Veronica", "Tracy", null, "Nafisa", "Dariusz", "Tian Ying", "Shakkib", "Noelle", "Adib", "Jason", "Siyam", "Leandra", null, "Rafael", "Xin", "Farian",
                "Irsal", "Stanley", "Sharon", null, "Ricky", "Yanbo", null, null, "Christian", "Brandon", "Nikita", "Naya", null, "Enamul", "Jack", "Ryan"};

        //null in this array list represents seats that cannot be used or empty seats (RIP seat 5)
        ArrayList<Integer> seatNums = new ArrayList<Integer>();
        for (int i = 1; i < 35; i++){
            if (i == 5 || i == 14 || i == 22 || i == 25 || i == 26 || i == 31){
                seatNums.add(null);
            }
            else{
                seatNums.add(i);
            }
        }
        for (int i = 0; i < seatNums.size(); i++){
            if (seatNums.get(i) != null){
                int randomIdx = (int)(Math.random() * (seatNums.size()));
                while(randomIdx == i || seatNums.get(randomIdx) == null || seatNums.get(i) == randomIdx + 1){
                    randomIdx = (int)(Math.random() * seatNums.size());
                }
                int temp = seatNums.get(randomIdx);
                seatNums.set(randomIdx, seatNums.get(i));
                seatNums.set(i, temp);

                //check for one neighbor HAS TO BE NEWWW
                if (randomIdx != 0 && randomIdx != seatNums.size() - 1){
                    if (seatNums.get(randomIdx - 1) != null && seatNums.get(randomIdx + 1) != null){
                        int prev = seatNums.get(randomIdx - 1);
                        int next = seatNums.get(randomIdx + 1);
                        while (prev == seatNums.get(randomIdx) - 1 || next == seatNums.get(randomIdx) + 1){
                            randomIdx = (int)(Math.random() * (seatNums.size()));
                            while(randomIdx == i || seatNums.get(randomIdx) == null || seatNums.get(i) == randomIdx + 1){
                                randomIdx = (int)(Math.random() * seatNums.size());
                            }
                            temp = seatNums.get(randomIdx);
                            seatNums.set(randomIdx, seatNums.get(i));
                            seatNums.set(i, temp);
                        }
                    }
                }
            }
        }
        ArrayList<String> newSeats = new ArrayList<String>();
        for (int i = 0; i < seatNums.size(); i++){
            if (seatNums.get(i) != null) {
                newSeats.add(curr[seatNums.get(i) - 1]);
            }
            else{
                newSeats.add(null);
            }
        }
        String[] row1 = new String[12];
        String[] row2 = new String[6];
        String[] row3 = new String[6];
        String[] row4 = new String[2];
        String[] row5 = new String[4];
        String[] row6 = new String[4];

        for (int i = 0; i < newSeats.size(); i++){
            if (i < 12) row1[i] = newSeats.get(i);
            else if (i >= 12 && i < 18) row2[i - 12] = newSeats.get(i);
            else if (i >=18 && i < 24) row3[i - 18] = newSeats.get(i);
            else if (i >= 24 && i < 26) row4[i - 24] = newSeats.get(i);
            else if (i >= 26 && i < 30) row5[i - 26] = newSeats.get(i);
            else row6[i - 30] = newSeats.get(i);
        }

        String[][] seatingChart = {row1, row2, row3, row4, row5, row6};
        int count = 1;
        for (String[] s: seatingChart){
            for (String x: s){
                System.out.print( "[" + count + ". " + x + "] ");
                count++;
            }
            System.out.println();
        }
    }
}