import java.util.Vector;

public class MatriceQ extends MatriceR {
    public MatriceQ(int n) throws erroriInput {
        super(n,n);
        if(n<0){
            throw new erroriInput("Dato non valido");
        }
    }

    public MatriceQ(int n,Vector<Integer> e) throws erroriInput {
        super(n,n,e);
    }

    public int traccia(){
        int t=0;
        int n=this.getColonne();
        for ( int i=0; i<n*n; i+=n+1)
            t+=this.elementi.elementAt(i);
        return t;
    }

    public boolean isSimmetrica(){
        int n = this.getRighe();
        boolean b=true;
        for(int r=0;r<n && b;r++){
            for(int c=0;c<n &&b;c++){
                try {
                    if(this.getElemento(c,r) != this.getElemento(r,c)){
                        b= false;
                    }
                } catch (erroriOp erroriOp) {

                }
            }
        }
        return b;
    }

    public MatriceQ esponenziale(int x) throws erroriInput, erroriOp {
        MatriceQ mExp = new MatriceQ(this.colonne,(Vector<Integer>) this.elementi.clone());
        for(int i=1;i<x;i++){
            mExp= (MatriceQ) mExp.prodotto(new MatriceQ(this.colonne,(Vector<Integer>) this.elementi.clone()));
        }
        return mExp;
    }
}
