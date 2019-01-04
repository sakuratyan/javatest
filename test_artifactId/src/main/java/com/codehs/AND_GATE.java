package com.codehs;

/**
 * AND_GATE
 */
public class AND_GATE {

    private boolean in0, in1;
    boolean out;

    void run() {
        this.out = in0 & in1;
    }

    /**
     * @param in0 the in0 to set
     */
    public void setIn0(boolean in0) {
        this.in0 = in0;
        this.run();
    }
    /**
     * @param in1 the in1 to set
     */
    public void setIn1(boolean in1) {
        this.in1 = in1;
        this.run();
    }

}