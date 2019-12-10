package practica;

import practica.logic.Graph;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run1();
    }

    /*
    3. Реализовать класс Graph, представляющий собой неориентированный
    взвешенный граф. В конструкторе класса передается количество
    вершин в графе. Методы должны поддерживать быстрое добавление и
    удаление ребер.
    Дополнительное задание. Написать программу, которая выводит
    информацию о кратчайших путях между всеми вершинами графа.
     */
    //посмотреть алгоритс дейстра
    //алгоритм флойда
    private void run() {
        Graph g = new Graph(5);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 5);
        g.addEdge(2, 3, 3);
        g.addEdge(2, 5, 7);
        g.addEdge(3, 5, 4);
        g.addEdge(2, 4, 10);
        g.addEdge(5, 4, 1);

        int[][] w = g.findWays();
        for (int i = 1; i < w.length; i++) {
            for (int j = 1; j < w[i].length; j++) {
                System.out.print(w[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
    2. В кругу стоят N человек, пронумерованных от 1 до N. При ведении
    счета по кругу вычеркивается каждый второй человек, пока не
    останется один.
    Составить две программы, моделирующие процесс. Одна из программ
    должна использовать класс ArrayList, а вторая — LinkedList. Какая из
    двух программ работает быстрее? Почему?
    */
    private void run2() {
        List<Integer> list = new LinkedList<>();

        for (int i = 1; i <= 1_000_000; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();
        boolean f = false;
        while (list.size() > 1) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                it.next();
                if (f) it.remove();
                f = !f;
            }
        }
        System.out.println(list.get(0));
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }

    /*
    1. Задан список целых чисел и число X. Не используя вспомогательных
    объектов и не изменяя размера списка, переставить элементы списка
    так, чтобы сначала шли числа, не превосходящие X, а затем числа,
    больше X
    */
    private void run1() {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 2, 4, 6, 7, 0, -3, -4, -7, 11, -16));
        int x = new Scanner(System.in).nextInt();
        boolean isSorted = false;

        int a = 0;
        int b = list.size() - 1;
        while (!isSorted) {
            isSorted = true;
            for (int i = a; i < b; i++) {

                if (list.get(i) > x) {
                    isSorted = false;
                    swap(i,i+1,list);
                } else {
                    a = i;
                }
            }
            for (int j = b; j > a; j--) {

                if (list.get(j) <= x) {
                    isSorted = false;
                    swap(j ,j- 1,list);
                } else {
                    b = j;
                }
            }
        }
        System.out.println(list);
    }
    private void swap(int index1, int index2, List<Integer> list) {
        int buf;
        buf = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, buf);
    }

}