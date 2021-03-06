
import java.util.Random;
import java.util.ArrayList;

public class MarkovModel extends AbstractMarkovModel{
    private int N;
    
    public MarkovModel(int numChar) {
        myRandom = new Random();
        N = numChar;
    }

    public void setTraining(String s){
        myText = s.trim();
    }
    
    public String getRandomText(int numChars){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-N);
        String key = myText.substring(index,index+N);
        sb.append(key);
        for(int k=0; k < numChars-N; k++){
            ArrayList<String> follows = getFollows(key);
            if(follows.size() == 0){
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1) + next;
        }
        return sb.toString();
    }
    
    public String toString() {
        return "Markov model of order " + N;
    }
    
}