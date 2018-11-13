package com.test_groupId.array;

/**
 * TestArray
 */
public class TestArray {
    int[] intAgrs;

    public TestArray(String[] args) {
        argsToInt(args);
        sortArray();
    }

    public TestArray() {
        Date[] d = {
            new Date(2003, 2, 3),
            new Date(2004, 3, 2),
            new Date(2003,2,2)
        };
        Date.getInfo(d);
        Date.bubbleSort(d);
        Date.getInfo(d);
    }

    int checkArgs(String[] args) {

        return 0;
    }

    int[] argsToInt(String[] args) {
        intAgrs = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            intAgrs[i] = Integer.parseInt(args[i]);
        }
        return intAgrs;
    }

    public void getIntArgs() {
        for (int var : intAgrs) {
            System.out.print(var + " ");
        }
        System.out.println();
    }

    public void sortArray() {

        for (int i = 0; i < intAgrs.length - 1; i++) {
            int temp;
            int minIndex = i;
            for (int j = i + 1; j < intAgrs.length; j++) {
                if (intAgrs[minIndex] > intAgrs[j]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                temp = intAgrs[i];
                intAgrs[i] = intAgrs[minIndex];
                intAgrs[minIndex] = temp;
            }
        }

    }

    public Date invokeDate(){
        System.out.println("return Date invokeDate");
        return new Date (1,1,1);
    }
}

class Date {
    int y, m, d;

    Date(int y, int m, int d) {
        this.y = y;
        this.m = m;
        this.d = d;
    }
    public String toString(){
        return "y:m:d -- " +y+ ":" +m+ ":"+d;
    }

    int compare(Date date){
        
        return 
        y > date.y ? 1 : 
        y < date.y ? -1 :
        m > date.m ? 1 :
        m < date.m ? -1 :
        d > date.d ? 1 :
        d < date.d ? -1 :
        0;

    }

    static void selectSort(Date[] d){
        int index;
        Date temp;
        for (int i = 0; i < d.length-1; i++) {
            index =i;
            for (int j = i+1; j < d.length; j++) {
                if(d[index].compare(d[j]) > 0){
                    index =j;
                }
            }
            if (index!= i) {
                temp  = d[index]; 
                d[index] = d[i];
                d[i] = temp;
            }
        }
    }

    static Date[] bubbleSort(Date[] d){
        Date temp;
        for (int i = d.length-1; i > 0; i--) {
            for (int j = i-1; j >=0; j--) {
                if (d[j].compare(d[j+1]) < 0) {
                    temp = d[j];
                    d[j] =  d[j+1];
                    d[j+1] = temp;
                }
            }
        }
        return d;
    }


    static void getInfo(Date[] d){
        System.out.println("Date.getInfo()");
        for (Date var : d) {
            System.out.println(var);
        }
        
    }
}