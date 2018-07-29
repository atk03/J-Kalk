public class erroriOp extends Errori{
    public erroriOp(int e){
        super("");
        if(e == 1){
            this.setExc("Le matrici hanno dimensione incompatibile");
        }else if(e == 2){
            this.setExc("Le matrici hanno tipo incompatibile");
        }else if(e == 3){
            this.setExc("Indice fuori dal range");
        }else if(e == 4){
            this.setExc("Il vettore è vuoto");
        }
    }
}