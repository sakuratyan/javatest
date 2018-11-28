package com.test_groupId.innerclass;

/**
 * TestOuter
 */
public class TestOuter extends TestFunc{

    /**
     * InnerTestOuter
     */
    public class PubInner  {
        String name = "PubInner";

        PubInner(){
            // hi();
            System.out.println(this);
        }
        public void hiPubInner(){

        }
        @Override
        public String toString() {
            return name;
        }
    }

    protected class ProInner{

    }

    class DefInner {

    }

    void test(){
        
    }

    /**
     * [Java] The type TestOuter.PriInner is never used locally
     *
    private class PriInner{

    }
    */
}