package defaultMethodsInInterfaces;

public class TestDefaultMethod {

    public static void main(String[] args) {
        CustomList list = new CustomArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        list.forEach(i -> System.out.println(i*i));
    }
}
