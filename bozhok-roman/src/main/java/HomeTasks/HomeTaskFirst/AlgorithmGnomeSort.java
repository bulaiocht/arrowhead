package main.java.HomeTasks.HomeTaskFirst;

import java.util.Arrays;

public class AlgorithmGnomeSort {
    public static void main(String[] args) {
        int[]gnome = new int[]{3,4,2,6,8,4,8,4,3,5};
        System.out.println(Arrays.toString(gnome));
        gnome = GnomeSort(gnome);
        System.out.println(Arrays.toString(gnome));

    }
    public static int[]GnomeSort(int[]gnome){
        int i = 1;
        while (i<gnome.length){
            if(i==0||gnome[i-1]<=gnome[i]){
                i++;
            }else {
                int temp = gnome[i];
                gnome[i] = gnome[i-1];
                gnome[i-1]= temp;
                i--;
            }
        }

        return gnome;
    }
}
