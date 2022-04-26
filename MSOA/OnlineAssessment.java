import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class OnlineAssessment {
    public static void main(String[] args) {

        Set<Integer> block1 = new HashSet<>();
        block1.add(0);
        block1.add(1);
        block1.add(2);
        block1.add(3);
        block1.add(4);
        block1.add(5);

        Set<Integer> block2 = new HashSet<>();
        block2.add(6);
        block2.add(7);
        block2.add(8);
        block2.add(9);
        block2.add(0);
        block2.add(1);

        solution(block1, block2);

    }
    private static Set<Integer> solution(Set<Integer> block1, Set<Integer> block2){

        Set<Integer> result = new LinkedHashSet<>();

        for(int i = 0; i < 100; i++){

            int l = i / 10;
            int r = i % 10;

            if((!block1.contains(l) || !block2.contains(r)) && (!block1.contains(r) || !block2.contains(l))){
                result.add(i);
            }

        }
        System.out.println(result.toString());
        return result;
    }
}
