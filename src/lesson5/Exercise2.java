package lesson5;

import java.util.Arrays;

/**
 * @author Ирина Мизгир
 * @date 15.03.2026 13:00
 */

//Задача 2:
//Создать программу для раскраски шахматной доски с помощью цикла. Создать
//двумерный массив String 8х8. С помощью циклов задать элементам массива значения
//B(Black) или W(White). При выводе результат работы программы должен быть
//следующим:
//W B W B W B W B
//B W B W B W B W
//W B W B W B W B
//B W B W B W B W
//W B W B W B W B
//B W B W B W B W
//W B W B W B W B
//B W B W B W B W
public class Exercise2 {
    public static void main(String[] args) {
        String[][] chessboard = new String[8][8];
        for (int index = 0; index < chessboard.length; index++) {
            for (int nestedIndex = 0; nestedIndex < chessboard[index].length; nestedIndex++) {
                if ((index + nestedIndex) % 2 == 0) {
                    chessboard[index][nestedIndex] = "W";
                } else {
                    chessboard[index][nestedIndex] = "B";
                }
            }
        }
        for (String[] line : chessboard) {
            System.out.println(Arrays.toString(line));
        }

    }
}
