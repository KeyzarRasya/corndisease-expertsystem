import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main{
    public static void main(String[] args) throws IOException {
       ForwardChaining fc = new ForwardChaining("/home/keyzarrasya/Documents/Programming/java/CornDisease/src/knowledge.txt");
        List<Rule> rules = fc.separateRule();
        Question q = new Question();
        q.asking();
        List<String> knownFact = new ArrayList<>();
        knownFact.add(q.getAnswer());
        List<String> forward = ForwardChaining.doForward(rules, knownFact);
        fc.conclusion(forward);

    }

}