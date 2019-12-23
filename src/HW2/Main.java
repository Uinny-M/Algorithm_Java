package HW2;

import java.util.Random;

public class Main {
    private static int ARR_SIZE = 10000; //комп слабенький, на ляме элементов безбожно тупил
    static long startTime;
    static long deltaTime;

    public static void main(String[] args) {


//создание 3 одинаковых массивов
        int[] list1 = new int[ARR_SIZE];
        Random random = new Random();
        for (int i = 0; i < list1.length; i++) {
            list1[i] = random.nextInt(10);
        }

        int[] list2 = list1.clone();
        int[] list3 = list1.clone();

//       print(list1);
//       print(list2);
//       print(list3);

        sortBubble(list1);
        sortInsert(list2);
        sortSelect(list3);
    }

    //вывод массива
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    //добавение элемента
    public static void add(int[] arr, int item) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = item;
                break;
            }
        }
    }

    //удаление элемента
    public static void remove(int[] arr, int index) {
        int temp = 0;
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0;
       print(arr);
    }

    //поиск элемента
    public static void found(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                System.out.println("Индекс искомого элемента: " + i);
                break;
            }
        }
    }

    private static void change(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    //пузырьковая сортировка
    public static void sortBubble(int[] arr) {
        startTime = System.currentTimeMillis();

        int out, in;
        for (out = arr.length - 1; out >= 1; out--) {
            for (in = 0; in < out; in++) {
                if (arr[in] > arr[in + 1]) {
                    change(arr, in, in + 1);
                }
            }
        }


        deltaTime = System.currentTimeMillis() - startTime;
        System.out.println("Время сортировки пузырьком: " + deltaTime);
 //       print(arr);
    }

    //Сортировка методом выбора
    public static void sortSelect(int[] arr) {
        startTime = System.currentTimeMillis();

        int out, in, mark;
        for (out = 0; out < arr.length; out++) {
            mark = out;
            for (in = out + 1; in < arr.length; in++) {
                if (arr[in] < arr[mark]) {
                    mark = in;
                }
            }
            change(arr, out, mark);
        }


        deltaTime = System.currentTimeMillis() - startTime;
        System.out.println("Время сортировки выбором: " + deltaTime);
    //    print(arr);
    }

    //Сортировка методом вставки
    public static void sortInsert(int[] arr) {
        startTime = System.currentTimeMillis();

        int in, out;
        for(out = 1;out < arr.length; out++){
            int temp = arr[out];
            in = out;
            while(in > 0 && arr[in-1] >=temp){
                arr[in] = arr[in-1];
                --in;
            }
            arr[in] = temp;
        }


        deltaTime = System.currentTimeMillis() - startTime;
        System.out.println("Время сортировки вставкой: " + deltaTime);
     //   print(arr);
    }


}
