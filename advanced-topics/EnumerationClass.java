package AdvancedTopics;

public class EnumerationClass {

    public static void main(String[] args) {

        Color blue = Color.BLUE;
        System.out.println(blue.name());
        System.out.println(blue.getValue());

        for (Color color: Color.values()) {
            System.out.println(color.getValue());
        }

    }

}

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY,
    FRIDAY, SATURDAY, SUNDAY
}
enum Color {
    RED("red"), GREEN("green"), BLUE("blue");
    private String value;

    Color(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
