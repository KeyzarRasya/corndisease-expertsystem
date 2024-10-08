import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ForwardChaining {

    private HashMap<String, List<String>> symptoms = new HashMap<>();
    private String fileName;

    public ForwardChaining(String knowledgeBase){
        this.fileName = knowledgeBase;
        symptoms.put("Bulai", Arrays.asList("1", "2", "3", "4", "5"));
        symptoms.put("Blight", Arrays.asList("5", "6", "7", "8", "9", "10"));
        symptoms.put("Leaf Rust", Arrays.asList("10", "11", "12", "13", "14"));
        symptoms.put("Burn", Arrays.asList("15", "16", "17", "18", "19"));
        symptoms.put("Stem Borer", Arrays.asList("20", "21", "22", "23", "24", "25", "26", "27"));
        symptoms.put("Cob Borer", Arrays.asList("28", "29", "30", "31"));
    }

    public List<Rule> separateRule() throws IOException {
        FileReader reader = new FileReader(this.fileName);
        BufferedReader buffer = new BufferedReader(reader);

        List<Rule> rules = new ArrayList<>();
        String line;

        while ((line = buffer.readLine()) != null) {
            String[] parts = line.split("-");
            if (parts.length == 2) {
                List<String> antecedents = Arrays.asList(parts[0].split(","));
                String consequent = parts[1].trim();
                rules.add(new Rule(antecedents, consequent));
            }
        }

        buffer.close();
        reader.close();

        if (!rules.isEmpty()) {
            System.out.println("First Rule Antecedents: " + rules.get(0).getAntecedent());
            System.out.println("First Rule Consequent: " + rules.get(0).getConsequent());
        }

        return rules;
    }

    public static List<String> doForward(List<Rule> rules, List<String> knownFacts) {
        List<String> facts = new ArrayList<>(knownFacts);
        boolean inferred;

        do {
            inferred = false;
            for (Rule rule : rules) {

                if (facts.containsAll(rule.getAntecedent()) && !facts.contains(rule.getConsequent())) {
                    facts.add(rule.getConsequent());
                    inferred = true;
                    break;
                }
            }
        } while (inferred);

        return facts;
    }

    public void conclusion(List<String> forward){
        System.out.println("Inferred Facts : ");
        for(String code : forward){
            System.out.print(code+", ");
        }
        for(String key : this.symptoms.keySet()){
            if(this.symptoms.get(key).containsAll(forward)){
                System.out.println("\nDetected Disease : " + key);
                break;
            }
        }
    }
}
