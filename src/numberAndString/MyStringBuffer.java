package numberAndString;
import numberAndString.IStringBuffer;

public class MyStringBuffer implements IStringBuffer{
    public static void main(String[] args) {
        try{
            MyStringBuffer mb = new MyStringBuffer("Abc");
            System.out.println(mb.value);
            mb.insert(-1,"XYZ");
        }
        catch (IndexIsNagetiveException | IndexIsOutofRangeException e){
            if(e instanceof IndexIsNagetiveException){
                System.out.println("下标为负异常");
                e.printStackTrace();
            }
            if(e instanceof IndexIsOutofRangeException){
                System.out.println("下标越界异常");
            }
            e.printStackTrace();
        }
    }
    int capacity=16;
    int length=0;
    char[] value;
    public MyStringBuffer(){
        value = new char[capacity];
    }

    public MyStringBuffer(String str){
        this();
        if(null==str){
            return;
        }

        if(capacity<value.length){
            capacity=value.length*2;
            value = new char[capacity];
        }
        else{
            System.arraycopy(str.toCharArray(),0,value,0,str.length());
        }
        length=str.length();


    }

    @Override
    public void append(String str) throws IndexIsNagetiveException,IndexIsOutofRangeException {
        insert(length,str);
    }

    @Override
    public void append(char c) throws IndexIsNagetiveException,IndexIsOutofRangeException {
        append(String.valueOf(c));
    }

    @Override
    public void insert(int pos, char b) throws IndexIsNagetiveException,IndexIsOutofRangeException{
        insert(pos,String.valueOf(b));

    }

    @Override
    public void insert(int pos, String b) throws IndexIsNagetiveException,IndexIsOutofRangeException{
        if(pos<0){
            throw new IndexIsNagetiveException("下标为负异常");
        }
        if(pos>length){
            throw new IndexIsOutofRangeException("下标越界异常");
        }
        //扩容
        while(length+b.length()>capacity){
            capacity = (int)((length+b.length())*1.5f);
            char[] newValue = new char[capacity];
            System.arraycopy(value,0,newValue,0,length);
            value = newValue;
        }
        char temp[] = b.toCharArray();
        //插入位后移
        System.arraycopy(value,pos,value,pos+temp.length,length-pos);
        //执行插入
        System.arraycopy(temp,0,value,pos,temp.length);

        length +=temp.length;

    }

    @Override
    public void delete(int start) {
        delete(0,length);
    }

    @Override
    public void delete(int start, int end) {
        if(start<0||start>length){
            return;
        }
        if(end<0||end>length){
            return;
        }
        if(end<start){
            return;
        }
        System.arraycopy(value,end,value,start,length-end);
        length-=(end-start);
    }

    @Override
    public void reverse() {
        for(int i=0;i<length/2;i++){
            char temp = value[i];
            value[i]=value[length-i-1];
            value[length-i-1]=temp;
        }

    }

    @Override
    public int length() {
        return length;
    }
}

//下标为负异常
class IndexIsNagetiveException extends Exception{
    public IndexIsNagetiveException(){ }
    public IndexIsNagetiveException(String s){
        super(s);
    }
}
//下标超出范围异常
class  IndexIsOutofRangeException extends Exception{
    public IndexIsOutofRangeException(){ }
    public IndexIsOutofRangeException(String s){
        super(s);
    }

}

