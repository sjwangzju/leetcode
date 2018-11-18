package Twitter;

import java.util.HashMap;

public class HackLandElection {
    public String electionWinner(String[] votes) {
        HashMap<String, Integer> map = new HashMap<>();
        int max = 1;
        String winner = votes[0];
        for (String vote: votes) {
            int cur = map.getOrDefault(vote, 0) + 1;
            if (cur >= max) {
                max = cur;
                winner = vote.compareTo(winner) > 0 ? vote : winner;
            }
            map.put(vote, cur);
        }
        return winner;
    }

    public static void main(String[] args) {
        String[] votes = {"Alex","Michael","Harry","Dave","Michael","Victor","Harry","Alex","Marry","Marry"};
        System.out.println(new HackLandElection().electionWinner(votes));
    }
}
