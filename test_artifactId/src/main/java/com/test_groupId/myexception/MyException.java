


package com.test_groupId.myexception;

/**
 * MyException
 */
public class MyException extends Exception{
    private int id;
    //static final long serialVersionUID = 1L;
    public MyException(String message,int id){
        super(message);
        this.id = id;
    }
    public MyException(){
        testfun3(0);
    }

    public int getId(){
        return id;
    }

    public void testfun1(int num) throws ArithmeticException {
        if(num == 0)
            throw new ArithmeticException("input number is 0");
        System.out.println("public void testfun1(int num){");
    }

    public void testfun2(int num)throws ArithmeticException{
        testfun1(num);
        System.out.println("public void testfun2(int num)");
    }

    public void testfun3(int num){
        try {
            testfun2(num);
            System.out.println("public void testfun3(int num)");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("test");
    }
}