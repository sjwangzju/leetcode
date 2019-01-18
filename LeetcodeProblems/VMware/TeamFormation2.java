package VMware;

import java.util.LinkedList;
import java.util.List;

public class TeamFormation2 {
     public int countTeams(int[] skills, int k, int l, int r) {
         List<Integer> team = new LinkedList<>();
         for (int skill: skills) {
             if (skill >= l && skill <= r) {
                 team.add(skill);
             }
         }
         int[] cnt = new int[1];
         buildTeam(team, 0, new LinkedList<>(), k, cnt);
         return cnt[0];
     }

     public void buildTeam(List<Integer> team, int start, List<Integer> cur, int k, int[] cnt) {
        for (int i = start; i < team.size(); i++) {
            cur.add(team.get(i));
            if (cur.size() >= k) cnt[0]++;
            buildTeam(team, i + 1, cur, k, cnt);
            cur.remove(cur.size() - 1);
        }
     }

     public static void main(String[] args) {
         int[] skills = {12,4,6,13,5,10};
         System.out.println(new TeamFormation2().countTeams(skills, 3, 5, 10));
     }
}
