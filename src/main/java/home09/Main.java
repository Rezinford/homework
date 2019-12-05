package home09;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;


    public class Main {
        public static void main(String[] args) {

            new Main().run();
        }
         /*
         7. Задать два стека, поменять информацию местами.
          */
        private void run() {
            Deque<Integer> steck = new ArrayDeque<>();
            Deque<Integer> steck2 = new ArrayDeque<>();

            Deque<Integer> tempSteck = new ArrayDeque<>();
            Deque<Integer> tempSteck2 = new ArrayDeque<>();

            rewriting(steck, tempSteck);
            rewriting(steck2, tempSteck2);

            rewriting(tempSteck2, steck);
            rewriting(tempSteck, steck2);

            printSteck(steck);
            printSteck(steck2);

        }
        private void rewriting(Deque<Integer> steck1, Deque<Integer> steck2) {
            while (!steck1.isEmpty()){
                steck2.push(steck1.pop());
            }
        }
        private void printSteck(Deque<Integer> steck) {
            while (!steck.isEmpty()){
                System.out.print(steck.pop() + "\t");
            }
            System.out.println();
        }



        /*
            10. С использованием множества выполнить попарное суммирование произвольного конечного
            ряда чисел по следующим правилам: на первом этапе суммируются попарно рядом стоящие числа,
            на втором этапе суммируются результаты первого этапа и т. д. до тех пор, пока не останется одно
            число.
         */
        private void run10() {
            double[] nums = {1.1,1000.35,-12.1,-100.34,10.8, 10000000.0};
            Queue<Double> q = new PriorityQueue<>(Comparator.comparingDouble(Math::abs));
            for (Double v : nums) {
                q.add(v);
            }
            while (q.size()>1){
                q.offer(q.poll()+q.poll());

            }
            System.out.println(q.poll());
            double sum = 0;
            for (double v : nums) {
                sum+=v;
            }
            System.out.println(sum);
        }
    /*
        6. Занести стихотворения одного автора в список.
        Провести сортировку по возрастанию длин строк.
     */
        private void run6() {
            try(BufferedReader reader= Files.newBufferedReader(Paths.get("C:\\Java\\TrackEnsure\\practica\\src\\main\\java\\les41219\\sonet1.txt"))) {
                List<String> list = reader.lines().collect(Collectors.toList());
//            Collections.sort(list, Comparator.comparingInt(String::length));
                list.sort(Comparator.comparingInt(String::length));
                list.forEach(System.out::println);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    /*
        4. Создать список из элементов каталога и его подкаталогов.
     */
        private void run4() {
            String s = "C:\\Java\\TrackEnsure";
            List<String> names = new ArrayList<>();
            File file = new File(s);
            scan(file,names);
            names.forEach(System.out :: println);

        }

        private void scan(File file, List<String> names) {
            if(file.isFile()){
                names.add(file.getName());
            }else if  (file.isDirectory()){
                names.add(file.getName());
                File[] files = file.listFiles();
                for (File f : files) {
                    scan(f,names);
                }
            }
        }
        /*
        2. Ввести число, занести его цифры в стек.
        Вывести число, у которого цифры идут в обратном порядке.
     */
        private void run2() {
            Scanner in = new Scanner(System.in);
            int n =  in.nextInt();
            Deque<Integer> steck = new ArrayDeque<>();
            Deque<Integer> steck2 = new ArrayDeque<>();
            while (n>0){
                int r = n%10;
                steck.push(r);
//            steck.offer(r); не подходит в контексте стек
                n/=10;
            }
            while (!steck.isEmpty()){
//            System.out.print(steck.pollLast()); не подходит в контексте стек
//            System.out.print(steck.poll()); не подходит в контексте стек
                steck2.push(steck.pop());
            }
            while (!steck2.isEmpty()){
                System.out.print(steck2.pop());
            }
            System.out.println();


        }
     /*
        1. Ввести строки из файла, записать в список.
            Вывести строки в файл в обратном порядке
     */
        private void run1() {
            try(BufferedReader reader =  new BufferedReader(new FileReader("test.txt"))){
                PrintWriter writer = new PrintWriter("g.txt");
                List<String> list = new ArrayList<>();
                String line;
                while ( (line = reader.readLine())!=null){
                    list.add(line);
                }
                while (!list.isEmpty()){
                    writer.println(list.get(list.size()-1));
                    list.remove(list.size()-1);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
