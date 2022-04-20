package HackerRankInterviewPrep;

public class RepeatedString {

    public static void main(String[] args) {
        //repeatedString("aba", 10);

        System.out.println(repeatedStringMath("abcac", 4));
    }

    public static long repeatedStringMath(String s, long n) {
        long result = 0;

        if (s.length() == 1) {
            if (s.charAt(0) == 'a') {
                return n;
            } else {
                return 0;
            }
        }

        if (n > s.length()) {
            long reminder = n % s.length();
            long repetitions = (n - reminder) / s.length();

            return getCharacterOccurrences(s, 'a', 0, reminder) +
                    (getCharacterOccurrences(s, 'a', 0, s.length()) * repetitions);
        } else {
            return getCharacterOccurrences(s, 'a', 0, n);
        }

    }

    public static int getCharacterOccurrences(String s, Character ch, int i, long j) {
        if (i < j) {
            int count = s.charAt(i) == ch ? 1 : 0;
            return count + getCharacterOccurrences(s, ch, i + 1, j);
        }
        return 0;
    }

    public static long repeatedString(String s, long n) {
        long result = 0;

        long i = 0;
        int j = 0;

        if (s.length() == 1) {
            if (s.charAt(0) == 'a') {
                result = n;
            }
        } else {
            while (i < n) {
                System.out.println(s.charAt(j));
                if (s.charAt(j) == 'a') {
                    result++;
                }
                j = j + 1 == s.length() ? 0 : j + 1;
                i++;
            }
        }

        return result;
    }

}
