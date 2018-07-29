import java.util.*;

public abstract class CollezioneDati {
    protected  int num;
    protected Vector<Integer> elementi;

    public CollezioneDati(int i){
        num=i;
        elementi=new Vector<Integer>();
        for(int j=0;j<i;j++){
            elementi.add(0);
        }
    }

    public CollezioneDati(int i, Vector<Integer> v) throws erroriInput {
        if(i == v.size()){
            num=i;
            elementi=v;
        }else{
            throw new erroriInput("Dimensioni incompatibili");
        }
    }

    public int getNum(){
        return num;
    }

    public Vector<Integer> getDati(){
        return elementi;
    }


    public abstract  CollezioneDati clone();

    public abstract  CollezioneDati differenza(CollezioneDati cd) throws erroriOp, erroriInput;

    public abstract  String toString();

    public Integer getMin() throws erroriOp {
        if(elementi.size()==0){
            throw new erroriOp(4);
        }
        Integer min=elementi.elementAt(0);
        for(int i=1;i<elementi.size();i++){
            if(min>elementi.elementAt(i)){
                min=elementi.elementAt(i);
            }
        }
        return min;
    }

    public Integer getMax() throws erroriOp {
        if(elementi.size()==0){
            throw new erroriOp(4);
        }
        Integer max=elementi.elementAt(0);
        for(int i=1;i<elementi.size();i++){
            if(max<elementi.elementAt(i)){
                max=elementi.elementAt(i);
            }
        }
        return max;
    }

    @Override
    public abstract boolean equals(Object obj);

}
