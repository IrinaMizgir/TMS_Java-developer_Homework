public class Exercise4 {
    public static void main(String[] args) {
        //В переменной n хранится вещественное число с ненулевой дробной частью. Создайте
        //программу, округляющую число n до ближайшего целого и выводящую результат на
        //экран.

        float n = 3.7f;
        float decimal = n % 1;
        int number = decimal < 0.5f ? (int) n : (int) n + 1;
        System.out.println(number);
    }
}
