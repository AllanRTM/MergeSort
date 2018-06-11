package com.company;

import java.util.Arrays;
import java.util.Random;

//@SuppressWarnings("unused")
public class Main {
    private static long inicio=System.nanoTime();;

//    private static int Length_of_array;

    public static void main(String[] args) {
        // write your code here
        int n=100;
        while (n<1000000){
            int []aArray=new int[n];
            long startime=System.nanoTime();
            fillRandomArray(aArray);
            ordenacionMergeSort(aArray);
            long endtime=System.nanoTime();
            long deltatime=endtime-startime;
            System.out.println(""+ n + " , " +deltatime);
            n+=n;

        }
        System.out.println("*******************************");
    }
    private static void fillRandomArray(int[]rArray){
        Random r =new Random();
        for (int i = 0; i <rArray.length ; i++) {
            rArray[i]=r.nextInt();
        }
    }

    public static void ordenacionMergeSort(int vec[]){
        if(vec.length<=1) return;
        int mitad= vec.length/2;
        int izq[]=Arrays.copyOfRange(vec, 0, mitad);
        int der[]=Arrays.copyOfRange(vec, mitad, vec.length);
        ordenacionMergeSort(izq);
        ordenacionMergeSort(der);
        combinarVector(vec, izq, der);
    }

    public static void combinarVector(int v[], int izq[],int der[]){
        int i=0;
        int j=0;
        for(int k=0;k<v.length;k++){
            if(i>=izq.length){
                v[k]=der[j];
                j++;
                continue;
            }
            if(j>=der.length){
                v[k]=izq[i];
                i++;
                continue;
            }
            if(izq[i]<der[j]){
                v[k]=izq[i];
                i++;
            }else{
                v[k]=der[j];
                j++;
            }
        }
    }

    public static void imprimirVector(int vec[]){
        for(int i=0;i<vec.length;i++){
            System.out.print(vec[i]+" ");
        }
    }




}
