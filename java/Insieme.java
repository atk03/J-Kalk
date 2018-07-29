import java.util.Vector;

public class Insieme extends CollezioneDati {
    Insieme(int n){
        super(n);
    }
    Insieme(int n, Vector<Integer> v) throws erroriInput {
        super(n,v);
    }

    @Override
    public CollezioneDati clone() {
        try{
            return new Insieme(this.num,this.elementi);
        } catch (erroriInput erroriInput) {
            return null;
        }

    }

    //quali el del primo non ci sono nel secondo
    @Override
    public Insieme differenza(CollezioneDati cd) throws erroriInput {
        Insieme in= (Insieme)cd;
        Vector<Integer> vd = new Vector<Integer>();
        int j =0;
        for(int i=0;i<this.elementi.size();i++){
            int found = this.elementi.get(i);
            if(!in.elementi.contains(found)){
                vd.add(found);
                j = j+1;
            }
        }
        Insieme ret = new Insieme(j,vd);
        return ret;
    }

    @Override
    public String toString() {
        boolean b=true;
        String s= new String("");
        for(int i=0;i<elementi.size();i++){
            if(b){
                s=s+ String.valueOf(elementi.get(i));
                b=false;
            }else{
                s=s+","+String.valueOf(elementi.get(i));
            }
        }
        s=s+";";
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        boolean b = this.getClass().equals(obj.getClass());
        if(b){
            Insieme i1 = (Insieme)obj;
            if(this.num == i1.num ) {
                boolean found = true;
                for (int i = 0; i < num && found; i++) {
                    int t = this.elementi.get(i);
                    if (!i1.elementi.contains(t)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public Insieme unione(Insieme ins) throws erroriInput {
        Vector<Integer> vd =(Vector<Integer>) this.elementi.clone();
        int dim=num;
        for (int i=0;i<ins.num;i++){
            int found=ins.elementi.get(i);
            if(!this.elementi.contains(found)){
                vd.add(found);
                dim=dim+1;
            }
        }
        Insieme ret = new Insieme(dim,vd);
        return ret;

    }
    public Insieme intersezione(Insieme ins) throws erroriInput {
        Vector<Integer> vd = new Vector<Integer>();
        int dim=0;
        for (int i=0;i<ins.num;i++){
            int found=ins.elementi.get(i);
            if(this.elementi.contains(found)){
                vd.add(found);
                dim=dim+1;
            }
        }
        Insieme ret = new Insieme(dim,vd);
        return ret;

    }


}
