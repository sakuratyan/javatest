
package com.test_groupId.datastruct;

class ChainTableNode {
    protected ChainTableNode preTableNode = this, nextTableNode = this;
}

public class ChainTable extends ChainTableNode {
    public static ChainTableNode nodeHead;
    private static int length = 0;

    int addChainTable(ChainTableNode c) {
        if (length == 0) {
            nodeHead = c;
            length++;
            return 0;
        }

        c.nextTableNode = nodeHead;
        c.preTableNode = nodeHead.preTableNode;

        nodeHead.preTableNode.nextTableNode = c;
        nodeHead.preTableNode = c;
        length++;

        return 0;
    }

    // 0开头计数
    ChainTableNode delChainTable(int index) {
        ChainTableNode temp = nodeHead;

        if (length == 0) {
            System.out.println("已经没有了，删除不了");
            return null;
        }
        if (length == 1) {
            nodeHead = preTableNode = nextTableNode = null;
            length--;
            return null;
        }
        if (index == 0) {
            nodeHead = nodeHead.nextTableNode;
        }

        while (0 != index--) {
            temp = temp.nextTableNode;
        }

        temp.preTableNode.nextTableNode = temp.nextTableNode;
        temp.nextTableNode.preTableNode = temp.preTableNode;
        length--;

        return temp;
    }

    void setHeadNode(int index){
        while(0 != index--){
            nodeHead = nodeHead.nextTableNode;
        }
    }

    void getInfoAll() {
        ChainTableNode t = nodeHead;
        System.out.println("    void getInfoAll(){");
        for (int i = 0; i < length; i++) {
            System.out.print(t);
            t = t.nextTableNode;
        }
        System.out.println();
    }

    public int getLength() {
        // System.out.println(" public int getLength(){");
        return length;
    }

}