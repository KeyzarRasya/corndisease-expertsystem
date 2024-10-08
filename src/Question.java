import java.util.HashMap;
import java.util.Scanner;

public class Question {
    private Scanner sc;
    private String answer;
    HashMap<String, String> qCode = new HashMap<>();

    public Question() {
        this.sc = new Scanner(System.in);
        qCode.put("1", "Is Chlorotic Colored Leaves?");
        qCode.put("6", "Affected leaves look wilted?");
        qCode.put("11", "Small brown or yellow spot on the leaf surface?");
        qCode.put("15", "Swelling Of The Cob?");
        qCode.put("20", "Small Hole in The Leaf?");
        qCode.put("28", "Transverse Hole?");
    }

    public String getAnswer() {
        return answer;
    }

    public void asking() {
        for (String q : this.qCode.keySet()) {
            String answers;
            System.out.println(this.qCode.get(q) + "\n1. Yes  2. No");
            answers = sc.nextLine();
            if (answers.equals("1")) {
                this.answer = q;
                break;
            }
        }
    }
}