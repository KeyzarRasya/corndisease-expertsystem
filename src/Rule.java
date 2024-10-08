import java.util.List;

public class Rule {
    public List<String> antecedent;
    public String consequent;

    public Rule(List<String> antecedent, String consequent){
        this.antecedent = antecedent;
        this.consequent = consequent;
    }

    public String getConsequent() {
        return consequent;
    }

    public List<String> getAntecedent() {
        return antecedent;
    }
}
