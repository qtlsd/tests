package collection;

import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    public Node<T> leftNode;

    public Node<T> rightNode;

    public Object value;

    public void addNumber(T v){
        if(value==null){
            value=v;
        }
        else{
            if((int)v<=(int)value){
                if(leftNode==null){
                    leftNode=new Node<>();
                }
                leftNode.addNumber(v);
            }else{
                if(rightNode==null){
                    rightNode = new Node<>();
                }
                rightNode.addNumber(v);
            }
        }
    }

    public static void main(String[] args) {
        int randoms1[] = new int[] { 67, 7, 30, 73, 10, 0, 78, 81, 10, 74 };
        Node<Integer> root = new Node<>();
        for(int i:randoms1){
            root.addNumber(i);
        }

        System.out.println(root.preOrder());
    }

    public static List<Object> preOrderList = new ArrayList<>();
    public List<Object> preOrder(){
        if(value!=null){
            preOrderList.add((int)value);
        }
        if(leftNode!=null){
            leftNode.preOrder();
        }
        if(rightNode!=null){
            rightNode.preOrder();
        }
        return preOrderList;
    }

}
