package Week6;
import java.text.ParseException;
import java.util.*;
public class HangMan {
    static Scanner input = new Scanner(System.in);
    static int count=7;
    static int forCount=0;
    static String []end ={"o==[]======[-]====o","   ||       |","   ||     (x.x) ","   ||       |","   ||      /|\\","   ||       | ","   ||      / \\ ","  /||\\"};

    public static void main(String[] args) throws ParseException {
        hangMan();
    }
    public static String words() {
        Random rn = new Random();
        ArrayList<String> complete = new ArrayList<>();
        System.out.println("\nHow many words do you want to add");
        int a =input.nextInt()-1;
        System.out.println("Put between each letter - ");
        for(int i = 0;i<=a;i++){
            System.out.println("Enter word "+(i+1));
            Scanner input = new Scanner(System.in);
            complete.add(input.nextLine());
        }
        int b = rn.nextInt(complete.size());
        System.out.println("Start Game\n");
        return complete.get(b);
    }
    public static void hangMan(){
        String answer = words();
        ArrayList<String> complete = new ArrayList<>(List.of(answer.split("-")));
        String[] raad = new String[complete.size()];
        StringBuilder correct = new StringBuilder();
        StringBuilder word = new StringBuilder();
        String guess;
        for (String s : complete) {
            correct.append(s);
        }
        for (int i = 0; i <20; i++) {
            System.out.println("Enter Letter : attempt "+(i+1));
            System.out.println(Arrays.toString(raad));
            String done = String.valueOf(word);
            word = new StringBuilder();
            answer = String.valueOf(correct);
            if (Objects.equals(done, answer)) {
                System.out.println("correct");
                return;
            }else if(count==8){
                System.out.println("Game Over");
                return;
            }
            guess = input.next();
            if (complete.contains(guess)) {
                System.out.println("Word contains : "+guess);
                for (int j = 0; j < complete.size(); j++) {
                    String a = (complete.get(j));
                        if (Objects.equals(a, guess)) {
                            raad[j] = guess;
                            for (String s : raad) {
                                word.append(s);
                            }
                        }
                    }
                }else{
                count =0;
                forCount++;
                System.out.println("Answer does not Contain Letter : "+guess);
                    for(int jj=0;jj<forCount;jj++) {
                        System.out.println(end[count]);
                        count++;
                    }
                }
            }
        }
   }




