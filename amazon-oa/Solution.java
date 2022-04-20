package AmazonOA;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
       /* List<String> listC = new ArrayList<>(Arrays.asList("2"));
        List<String> listR = new ArrayList<>(Arrays.asList("1"));
        List<String> list1 = new ArrayList<>(Arrays.asList("INSERT", "id1", "id2"));
        List<String> list2 = new ArrayList<>(Arrays.asList("INSERT", "id3", "id4"));
        List<String> list3 = new ArrayList<>(Arrays.asList("SHIP", "-"));
        List<String> list4 = new ArrayList<>(Arrays.asList("INSERT", "id5", "id6"));
        List<String> list5 = new ArrayList<>(Arrays.asList("INSERT", "id5", "id6"));
        List<String> list6 = new ArrayList<>(Arrays.asList("SHIP", "-"));
        List<String> list7 = new ArrayList<>(Arrays.asList("SHIP", "-"));

        List<List<String>> list2D = new ArrayList<>(Arrays.asList(
                list1,
                list2,
                list3,
                list4,
                list5,
                list6,
                list7
        ));

        //performWarehouseQueriesEdit(list2D);

        balancePackages(3, new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6)));*/

        processLogs(new ArrayList<>(Arrays.asList("1 2 50", "1 7 70", "1 3 20", "2 2 17")), 2);

    }
    public static List<List<String>> performWarehouseQueriesEdit(List<List<String>> query) {

        Queue<String> queue = new LinkedList<>();
        List<List<String>> result = new LinkedList<>();
        int j = 0, i = 0, columns = 0, rows = 0;
        String ACTION = "";

        if(!query.isEmpty()){
            columns = query.get(0).size();
            rows = query.size();

        }
        while(i < rows){
            if(j == 0){
               ACTION = query.get(i).get(j);
               j++;
            }
            if(ACTION.equals("INSERT")){
                if(j < columns){
                    queue.add(query.get(i).get(j));
                    j++;
                } else {
                    j = 0;
                    i++;
                }
            }
            if(ACTION.equals("SHIP")){
                result.add(queue.size() >= 3 ?
                        new ArrayList<String>(Arrays.asList(queue.poll(), queue.poll(), queue.poll())) :
                        new ArrayList<String>(Arrays.asList("N/A")));
                j = 0;
                i++;
            }
        }
        System.out.println(result.toString());
        return result;

    }

    public static List<List<String>> performWarehouseQueries(List<List<String>> query) {
        // Write your code here

        List<String> queue = new Stack<>();
        List<List<String>> ship = new LinkedList<>();

        if (!query.isEmpty()){
            for (int i = 0; i < query.size(); i++) {
                if(query.get(i).get(0).equals("INSERT")){
                    List<String> q = query.get(i);
                    q.remove(0);
                    while(!query.get(i).isEmpty()){ //
                        queue.add(query.get(0).get(0));
                        query.get(0).remove(0);
                    }
                }else{
                    ship.add(queue.size() == 3 ? queue : new ArrayList<>(Arrays.asList("N/A")));
                }
            }
        }

        return ship;
    }

    public static long balancePackages(int K, List<Integer> packages){

        int i = 0;
        int j = 0;
        long result = 0;

        while(i < packages.size()){
            if(j < packages.size()){
                if(i != j){
                    int r = packages.get(i);
                    int l = packages.get(j);
                    if(Math.max(l, r) - Math.min(l, r) >= K){
                        result++;
                    }
                }
                j++;
            } else {
                j = i;
                i++;
            }
        }
        System.out.println(result);
        return result;
    }

    static class Transaction {
        public Transaction(String sender_user_id, String recipient_use_id, String amount_of_transactions, int i) {
            this.sender_user_id = sender_user_id;
            this.recipient_use_id = recipient_use_id;
            this.amount_of_transactions = amount_of_transactions;
            this.i = i;
        }

        String sender_user_id;
        String recipient_use_id;
        String amount_of_transactions;
        int i;

    }

    public static List<String> processLogs(List<String> logs, int threshold) {
        // Write your code here

        List<String> result = new LinkedList<>();

        int i = 0;
        int j = 0;

        HashMap<String, Integer> totalTransactions = new LinkedHashMap<>();
        List<Transaction> transactions = new ArrayList<>();

        while(i < logs.size()){
            String[] log = logs.get(i).split(" ");
            Transaction transaction = new Transaction(log[0], log[1], log[2], i);
            transactions.add(transaction);
            if(transactions.size() > 1){
                String sender_user_id = transaction.sender_user_id;
                String recipient_use_id = transaction.recipient_use_id;
                if(transactions.stream().anyMatch(s -> s.recipient_use_id.equals(sender_user_id))){
                }
                if(transactions.stream().anyMatch(r -> r.recipient_use_id.equals(recipient_use_id))){

                }
            }

        }

        return result;
    }
}

