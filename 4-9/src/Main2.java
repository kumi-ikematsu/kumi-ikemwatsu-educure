public class Main2 {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30};

        ArrayAccessor accessor = new ArrayAccessor(numbers);

        try {
            System.out.println("位置1の要素");
            System.out.println(accessor.getElement(1));

            System.out.println("位置5の要素");
            System.out.println(accessor.getElement(5));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}