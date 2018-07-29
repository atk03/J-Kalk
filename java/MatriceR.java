import java.util.Vector;

public class MatriceR extends CollezioneDati{
    protected int righe;
    protected int colonne;


    MatriceR(int r, int c, Vector<Integer> v) throws erroriInput {
        super(r*c,v);
        if(r<0 || c<0){
            throw new erroriInput("dimensioni negative");
        }
        righe=r;
        colonne=c;
    }

    MatriceR(int r, int c) throws erroriInput {
        super(r*c);
        if(r<0 || c<0){
            throw new erroriInput("dimensioni negative");
        }
        righe=r;
        colonne=c;
    }

    MatriceR(){
        super(0);
        righe=0;
        colonne=0;
    }

    public int getRighe(){
        return righe;
    }

    public int getColonne(){
        return colonne;
    }

    public Integer getElemento(int r, int c) throws erroriOp {
        if(r<0 || c<0 || r>=righe || c>=colonne){
            throw new erroriOp(3);
            //return null;
        }else {
            Integer obj = elementi.get(r * this.getColonne() + c);
            return obj;
        }
    }

    public void setElemento(int r, int c, Integer ob) throws erroriOp {
        if(r<0 || c<0 || r>=righe || c>=colonne){
            throw new erroriOp(3);
        }else {
            try {
                elementi.setElementAt(ob,(r * this.getColonne() + c));
            }catch (ArrayIndexOutOfBoundsException e){
                elementi.insertElementAt(ob,(r * this.getColonne() + c));
            }
        }
    }

    @Override
    public MatriceR clone() {
        try {
            return new MatriceR(this.righe,this.colonne,(Vector<Integer>) this.elementi.clone());
        } catch (erroriInput erroriInput) {
            return null;
        }
    }

    @Override
    public MatriceR differenza(CollezioneDati cd) throws erroriOp {
        MatriceR m = (MatriceR)cd;
        MatriceR ret = this.clone();
        if(this.righe==m.righe && this.colonne==m.colonne){
            for(int r=0;r<this.righe;r++){
                for(int c=0;c<this.colonne;c++){
                    ret.setElemento(r,c,(this.getElemento(r,c) - m.getElemento(r,c)));
                }//end colonne
            }//end righe
            return ret;
        }else{//end if dimensione
            throw new erroriOp(1);
        }

    }

    @Override
    public String toString() {
        String s= new String("");
        int c=colonne;
        for(int i=0;i<elementi.size();i++){
            s=s+ String.valueOf(elementi.get(i));
            c--;
            if(c==0){
                s=s+";";
                c=colonne;
            }else{
                s=s+",";
            }
        }
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        boolean b1 = this.getClass().equals(obj.getClass());
        if(b1) {
            if (this.colonne == ((MatriceR) obj).colonne && this.righe == ((MatriceR) obj).righe && this.elementi.equals(((MatriceR) obj).elementi)) {
                return true;
            }
        }
        return false;
    }

    public MatriceR somma(MatriceR m) throws erroriOp {
        if(this.getRighe()==m.getRighe() && this.getColonne()==m.getColonne()){
            MatriceR opAdd = this.clone();
            for(int r=0;r<this.getRighe();r++){
                for(int c=0;c<this.getColonne();c++){
                    opAdd.setElemento(r,c,this.getElemento(r,c)+m.getElemento(r,c));
                }//end colonne
            }//end righe
            return opAdd;
        }else{//end if dimensione
            throw new erroriOp(1);
        }
    }


    public MatriceR prodotto(MatriceR m) throws erroriInput, erroriOp {
        if(this.colonne==m.getRighe()){
            int pr=this.getRighe();
            int pc=m.getColonne();
            int cc=this.getColonne();
            MatriceR moltMatrici;
            if(pr==pc){//righe m1 = colonne m2
                moltMatrici= new MatriceQ(pr);
            }else{
                moltMatrici= new MatriceR(pr,pc);
            }
            for(int r=0;r<pr;r++){
                for(int c=0;c<pc;c++){
                    for(int i=0;i<cc;i++){
                        moltMatrici.setElemento(r,c,this.getElemento(r,i)*m.getElemento(i,c));
                    }// colonne seconda matrice
                }//end for colonne
            } //end for righe
            return moltMatrici;
        }else{//if verifica condizioni per fare la moltiplicazioni
            throw new erroriOp(1);
        }
    }

    public MatriceR prodotto(int scal){
        MatriceR mr= this.clone();
        for(int i=0; i<elementi.size();i++){
            mr.elementi.setElementAt(elementi.elementAt(i)*scal,i);
        }
        return mr;
    }

    public MatriceR trasposta() throws erroriInput, erroriOp {
        MatriceR trans;
        if(this.colonne==this.getRighe()){
            trans=new MatriceQ(this.getColonne());
        }else{
            trans= new MatriceR(this.getColonne(),this.getRighe());
        }
        for(int r=0;r<this.getRighe();r++){
            for(int c=0;c<this.getColonne();c++){
                trans.setElemento(c,r,this.getElemento(r,c));
            }
        }
        return trans;
    }



}
