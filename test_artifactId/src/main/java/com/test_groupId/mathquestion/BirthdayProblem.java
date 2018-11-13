package com.test_groupId.mathquestion;



public class BirthdayProblem {

    public double getProbability(int personNum)
    {
        System.out.println(this);
        double probability = 1.0;
        int i =0 ;
        for (i = 0; i < personNum; i++) {
            probability *=(365.0-i)/365;
            //System.out.println(i+1+":"+probability);
        }
        return 1.0-probability;
    }

    public int getPersonNum(double proba)
    {
        System.out.println(this);
        double probability = 1.0;
        int i =0 ;
        for (i = 0; i < 365; i++) {
            probability *=(365.0-i)/365;
            //System.out.println(i+1+":"+probability);
            if (1- probability > proba) {
                break;
            }
        }
        return i+1;
    }

    public String toString(){
        return "I'm BirthdayProblem";
    }
}




