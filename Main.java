package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File myObj = new File("input2.txt");
            Scanner myReader = new Scanner(myObj);
            HashSet<String> dataHashSet = new HashSet<>();
            int maxlength=0;
            while (myReader.hasNext()) {
                String data = myReader.next();
                boolean good_word = true;
                if (data.length() > 18) {
                    good_word = false;
                } else {
                    for (int i = 0; i < data.length(); i++) {
                        char c = data.charAt(i);
                        if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')||(c=='\'')||(c=='-'))) {
                            good_word = false;
                        }
                    }

                    if((data.charAt(0)=='\'')||(data.charAt(0)=='-')||
                            (data.charAt(data.length()-1)=='\'')||(data.charAt(data.length()-1)=='-')){
                        good_word = false;
                    }

                }
                if (good_word) {
                    dataHashSet.add(data);
                    if (data.length() > maxlength) {
                        maxlength = data.length();
                    }
                }
            }
            myReader.close();
            FileWriter myWriter = new FileWriter("output2.txt");
            for (String slovo : dataHashSet) {
                if(slovo.length()==maxlength) {
                    myWriter.write(slovo+"\n");

                }
            }
            myWriter.write(String.valueOf(maxlength));
            myWriter.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}