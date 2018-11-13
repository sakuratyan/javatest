
package com.test_groupId.datastruct;

/**
 * TestChain
 */

class IntChainTable extends ChainTable {
    int i;

    IntChainTable(int num) {
        i = num;
        if (this.getLength() == 0) {
            this.addChainTable(this);
        }

    }

    IntChainTable(int start, int end) {
        this(start);
        for (int i = start+1; i <= end; i++) {
            this.addIntChainNode(i);
        }

    }

    public String toString() {
        return i + " ";
    }

    public IntChainTable addIntChainNode(int numNode) {
        if (this.getLength() == 0) {
            return new IntChainTable(numNode);
        }
        IntChainTable t = new IntChainTable(numNode);
        this.addChainTable(t);
        return t;
    }

}

public class TestChain {

    public TestChain() {
        IntChainTable i = new IntChainTable(1,500);
        //i.setHeadNode(5);
        System.out.println("Length:" + i.getLength());
        i.getInfoAll();
        while(i.getLength()!=1){
            i.delChainTable(2);
            i.setHeadNode(2);
        }
        


        
        i.getInfoAll();
    }
}