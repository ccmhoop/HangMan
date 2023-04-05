package ai;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;
public class MastermindAiDrie {
    static ArrayList<String> color = new ArrayList<>();
    static ArrayList<String> combi = new ArrayList<>();
    static ArrayList<String> crack = new ArrayList<>();
    static ArrayList<String> neut = new ArrayList<>();
    static ArrayList<String> colorShrink = new ArrayList<>();
    static int colorC;
    static int teller = 13;
    static int teller2 = 1;
    static Random rn = new Random();
    static int conColor = 0;

    /*
    *-----------------moet-nog-opgeschoond-worden------------
    */
    public static void main(String[] args) {
       arrayCombi();
    }
    public static void color() {
        color.add("Groen");
        color.add("Geel");
        color.add("Blauw");
        color.add("Rood");
        color.add("Zwart");
        color.add("Wit");
        //color.add("Oranje");
        //color.add("Paars");
    }
    public static void arrayCombi() {
        color();
        String b;
        for (int i = 0; i < 4; i++) {
            int a = rn.nextInt(6);
            b = color.get(a);
            combi.add(b);
        }
        System.out.println("Combi Size " + combi.size());
        System.out.println("Guess Code 10 Attempts\n");
        while (true) {
            guess();
            System.out.println(combi + " Combination");
            System.out.println(neut+"\n");
            for (int i = 1; i < 13; i++) {
                try {
                    int l = 0;
                       if (Objects.equals(combi.get(0), neut.get(0))) {
                           l++;
                       }
                       if (Objects.equals(combi.get(1), neut.get(1))) {
                           l++;
                       }
                       if (Objects.equals(combi.get(2), neut.get(2))) {
                           l++;
                       }
                       if (Objects.equals(combi.get(3), neut.get(3))) {
                           l++;
                       }
                       if (l>2) {
                       crack.clear();
                       crack.addAll(neut);
                       System.out.println(combi + " combination");
                       String gu;
                       if (!Objects.equals(combi.get(0), neut.get(0))) {
                           guess(1);
                           gu = neut.get(0);
                           crack.set(0, gu);
                       }
                       if (!Objects.equals(combi.get(1), neut.get(1))) {
                           guess(1);
                           gu = neut.get(0);
                           crack.set(1, gu);
                       }
                       if (!Objects.equals(combi.get(2), neut.get(2))) {
                           guess(1);
                           gu = neut.get(0);
                           crack.set(2, gu);
                       }
                       if (!Objects.equals(combi.get(3), neut.get(3))) {
                           guess(1);
                           gu = neut.get(0);
                           crack.set(3, gu);
                       }
                       color.remove(neut.get(0));
                       colorC = color.size();
                       teller--;
                       System.out.println(crack);
                       System.out.println("Amount of Colors in correct location " + l );
                       neut.clear();
                       neut.addAll(crack);
                       System.out.println("Attempter "+teller+"\n");
                       }if(l==4) {
                           System.out.println("\nComplete");
                           System.out.println(combi + " combination");
                           System.out.println(neut + " Crack");
                           System.out.println("Amount of Games : "+ teller2+" attempts "+teller);
                           return;
                       } else if(l<3)  {
                           containCheck();
                           System.out.println("Amount of Colors in correct location " + l + "\nNew Attempt\n");
                           colorC = color.size();
                           System.out.println(combi + " combination");
                           guess();
                           System.out.println(neut+" guess");
                           teller--;
                           System.out.println("Attempt "+teller+"\n");
                       }
                       if (teller <= 1) {
                        color.clear();
                        color();
                        System.out.println("New Game\n"+color.size());
                        teller = 12;
                        teller2++;
                        combi.clear();
                        for (i = 0; i < 4; i++) {
                               int a = rn.nextInt(6);
                               b = color.get(a);
                               combi.add(b);
                           }
                        System.out.println(teller2);
                        break;
                       }
                } catch (IndexOutOfBoundsException o) {
                    System.out.println(o);
                }
            }
        }
    }
    public static void guess(){
            int op;
            neut.clear();
            colorC = color.size();
            for (int i = 0; i <= 3; i++) {
                op = rn.nextInt(colorC);
                neut.add(color.get(op));
            }
    }
    public static void guess(int a){
        int op;
        neut.clear();
        colorC = color.size();
        for(int i =0;i<=a;i++){
            op = rn.nextInt(colorC);
            neut.add(color.get(op));
        }
    }
    public static void containCheck() {
        colorShrink.clear();
        int count, compare, swa = 0;
        int bla=0;
        for (String check : neut) {
            if (!colorShrink.contains(check)) {
                colorShrink.add(check);
            }
        }
        colorShrink.retainAll(combi);
        for (String s : colorShrink) {
            compare = Collections.frequency(neut, s);
            count = Collections.frequency(combi, s);
            if(compare==count){
                bla++;
            }
            swa = (swa + compare);
            conColor = (conColor + count);
        }
        if (conColor==4 && bla==1){
            System.out.println("Current guess contains " + (conColor-1)+ " colors 1");
        } else if (conColor>swa && swa==3) {
            System.out.println("Current guess contains " + colorShrink.size() + " colors 2");
        } else if (conColor < swa) {
            System.out.println("Current guess contains " + conColor + " colors 3");
        } else if (conColor > swa) {
            System.out.println("Current guess contains " + swa + " colors 4");
        } else if(conColor==0){
            System.out.println("No Matches");
            for(String cl : neut){
                color.remove(cl);
            }
        }else {
            System.out.println("Current guess contains " + conColor + " colors 5");
        }
        conColor = 0;
    }
}






