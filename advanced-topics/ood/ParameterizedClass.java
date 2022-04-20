package OOD;

public class ParameterizedClass<T> {
    T object;
    ParameterizedClass(T object){
        this.object = object;
    }

    public T getObject() {
        return this.object;
    }
    public <T> void genericMethod(T element){

    }
}

class Main {
    public static void main(String[] args) {
        ParameterizedClass<Integer> integerParameterizedClass = new ParameterizedClass<>(20);
        ParameterizedClass<String> stringParameterizedClass = new ParameterizedClass<>("Hello World");

    }
}
