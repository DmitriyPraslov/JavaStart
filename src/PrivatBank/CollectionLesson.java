package PrivatBank;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionLesson {
    public static void main(String[] args) {
        //---------------------------2------------------------//
//        Scanner scanner = new Scanner(System.in);
//        int number = Integer.parseInt(scanner.nextLine());
//        System.out.println(inverseNumber(number));

        //---------------------------1------------------------//
//        Path path = Paths.get("D:\\Java\\Projects\\JavaStart\\src\\PrivatBank\\test.txt");
//        try (Stream<String> lines = Files.lines(path)) {
//            List<String> strings = lines.collect(Collectors.toList());
//            PrintWriter printWriter = new PrintWriter("D:\\Java\\Projects\\JavaStart\\src\\PrivatBank\\test1.txt");
//            for (int i=strings.size()-1;i>=0;i--){
//                printWriter.write(strings.get(i)+"\n");
//            }
//            printWriter.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //----------------------4-------------------------//
//        List<Integer> list = new ArrayList<>(Arrays.asList(-2,2,5,-7,1,0));
//        Comparator<Integer> integerComparator = (w,z)->z-w;
//        list.sort(integerComparator);
//        System.out.println(list);
//
//        List<Integer> list1 = new ArrayList<>(Arrays.asList(-2,2,5,-7,1,-3));
//        for (int i=0;i<list1.size();i++){
//            if (list1.get(i)<0){
//                Integer temp = list1.remove(i);
//                list1.add(temp);
//            }
//        }
//        System.out.println(list1);

        //---------------------------3------------------------//
        File file = new File("D:\\Java\\test");
        scanFolder(file);
    }

    public static File[] scanFolder (File file){
        File[] fileList = file.listFiles();
        for (File temp : fileList){
            if (temp.isDirectory()){
                System.out.println(temp.getName());
                scanFolder(temp);
            } else {
                System.out.println("    " + temp.getName());
            }
        }
        return fileList;
    }

    public static int inverseNumber (int number){
        boolean check = number<0?true:false;
        if (check){
            number*=(-1);
        }
        String stringOfNumber = Integer.toString(number);
        StringBuffer result = new StringBuffer("");
        Stack<Integer> digits = new Stack<>();
        for (int i=0; i<stringOfNumber.length(); i++){
            digits.push(Integer.parseInt(String.valueOf(stringOfNumber.charAt(i))));
        }
        while (digits.size()>0) {
        result.append(digits.pop());
        }
        return check?Integer.parseInt(result.toString())*(-1):Integer.parseInt(result.toString());
    }
}
