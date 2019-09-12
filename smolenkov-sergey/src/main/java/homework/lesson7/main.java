package homework.lesson7;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {

    //1.  В каждой строке найти и  удалить заданную подстроку.
    //2.  В  каждой  строке  стихотворения  найти  и  заменить  заданную  подстроку на  подстроку иной длины.
    //3.  В каждой строке найти слова, начинающиеся с  гласной буквы.
    //4.  Найти  и  вывести  слова  текста,  для  которых  последняя  буква  одного  слова совпадает с
    // первой буквой следующего слова.
    //5.  Найти в каждой строке самое длинное и самое короткое слово.
    //6.  В каждой  строке  подсчитать  частоту  повторяемости  каждого  слова  из  заданного  списка
    // и  вывести  эти  слова  в  порядке возрастания частоты повторяемости.
    //7.  В  каждом  слове  заменить  первую  букву  слова на  прописную.
    //8.  Определить частоту повторяемости букв и слов в тексте.

    private static final String SRC = String.format("smolenkov-sergey%ssrc%smain%sresources%stheFifthEl.txt",
            File.separator,
            File.separator,
            File.separator,
            File.separator);


    public static void main(String[] args) {

        System.out.println();

//        findAndDeleteSubstring("is");
//        findAndChangeSubstring("His","Your");
//        findWordsStartingWithVowelSound();
//        findWordsWithSameLastLetterOfFirstWordAndFirstLetterOfSecondWord();
//        findTheLongestAndTheShortestWords();

    }


    private static void findAndDeleteSubstring(String text) {

        try (BufferedReader reader = new BufferedReader(new FileReader(SRC));
             BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(String.format(
                                     "smolenkov-sergey%ssrc%smain%sresources%stheFifthEl_find&DeleteSubstring.txt",
                                     File.separator,
                                     File.separator,
                                     File.separator,
                                     File.separator)))){

            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                writer.write(line.replaceAll(text, ""));
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void findAndChangeSubstring (String text1, String text2){

        try (BufferedReader reader = new BufferedReader(new FileReader(SRC));
             BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(String.format(
                                     "smolenkov-sergey%ssrc%smain%sresources%stheFifthEl_find&ChangeSubstring.txt",
                                     File.separator,
                                     File.separator,
                                     File.separator,
                                     File.separator)))){

            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                writer.write(line.replaceAll(text1, text2));
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void findWordsStartingWithVowelSound (){
        try (BufferedReader reader = new BufferedReader(new FileReader(SRC));
             BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(String.format(
                                     "smolenkov-sergey%ssrc%smain%sresources%stheFifthEl_findWordsStartWithVowel.txt",
                                     File.separator,
                                     File.separator,
                                     File.separator,
                                     File.separator)))){

            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                Pattern sentence = Pattern.compile("\\b([aeiouyAEIOUY][a-z]{1,})\\b");
                Matcher group = sentence.matcher(line);
                while (group.find()){
                writer.write(group.group() + " ");
                }

                writer.newLine();

            }
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void findWordsWithSameLastLetterOfFirstWordAndFirstLetterOfSecondWord (){

        try (BufferedReader reader = new BufferedReader(new FileReader(SRC));
             BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(String.format(
                                     "smolenkov-sergey%ssrc%smain%sresources%stheFifthEl_findSameLastFirstLetters.txt",
                                     File.separator,
                                     File.separator,
                                     File.separator,
                                     File.separator)))){

            String lastLetter = "";
            String word ="";
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                Pattern sentence = Pattern.compile("\\b([a-zA-Z]{1,})\\b");
                Matcher group = sentence.matcher(line);
                while (group.find()){
                    String[] string = (group.group().toLowerCase()).split("");

                    if (lastLetter.equals(string[0])){
                        writer.write(word + " , " + group.group());

                    }
                    writer.newLine();
                    word = group.group();
                    lastLetter = string[string.length-1];

                }
                writer.newLine();

            }
            writer.flush(); 

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private static void findTheLongestAndTheShortestWords (){
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(SRC));
//             BufferedWriter writer =
//                     new BufferedWriter(
//                             new FileWriter(String.format(
//                                     "smolenkov-sergey%ssrc%smain%sresources%stheFifthEl_findTheL&TheSWords.txt",
//                                     File.separator,
//                                     File.separator,
//                                     File.separator,
//                                     File.separator)))){
//
//            int min = 100;
//            int max = 0;
//            String theLongestWord = "";
//            String theShortsWord = "";
//            while (true) {
//                String line = reader.readLine();
//                if (line == null) break;
//                Pattern sentence = Pattern.compile("\\b([a-zA-Z]{1,})\\b");
//                Matcher group = sentence.matcher(line);
//                while (group.find()) {
//                    String[] string = group.group().split("");
//                    int length = string.length;
//                    if (length<min){
//                        min = length;
//                        theShortsWord=group.group();
//                    }else if (length>max){
//                        max = length;
//                        theLongestWord=group.group();
//
//                    }
//                    writer.write("The shortest word: " + theShortsWord + ";" + " The longest word :"+ theLongestWord +";");
//                }
//                writer.newLine();
//
//            }
//            writer.flush();
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }

    private static void findTheLongestAndTheShortestWords (){

        InputStream is = main.class.getClassLoader().getResourceAsStream("theFifthEl.txt");

        if (is != null) {

            try (BufferedOutputStream os
                         = new BufferedOutputStream(new FileOutputStream("theFifthEl_findTheL&TheSWords.txt"))){

                Scanner scanner = new Scanner(is);
                scanner.useDelimiter(Pattern.compile("\\s"));



                while (scanner.hasNext()) {
                    String line = scanner.next();
                    int shortestWord = 0;
                    int longestWord = 0;
                    String theShortestWord = "";
                    String theLongestWord = "";
                    int tempLenght;
                    String[] eachWordArray = line.split(" ");
                    boolean firstTime = false;
                    for (String eachWord : eachWordArray) {
                        tempLenght = eachWord.length();
                        if(firstTime == false){
                            firstTime = true;
                            shortestWord = tempLenght;
                            theShortestWord = eachWord;
                            longestWord = tempLenght;
                            theLongestWord = eachWord;
                        }

                        if (tempLenght > 0) {
                            if (tempLenght <shortestWord){
                                shortestWord = tempLenght;
                                theShortestWord = eachWord;
                            } else if ( tempLenght > longestWord){
                                longestWord = tempLenght;
                                theLongestWord = eachWord;
                            }
                        }
                    }
                    System.out.println("The shortest word: " + theShortestWord + ";" + " The longest word :"+ theLongestWord +";");
                    os.write(line.getBytes());
                }

                scanner.close();

                os.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }

    }



}



