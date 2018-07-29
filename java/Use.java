import java.util.Vector;

public class Use {
    public static void main(String[] args) throws erroriInput, erroriOp {
        //matrici r
        try {
            MatriceR mr1=new MatriceR(1,2);
            System.out.println(mr1.toString());
        } catch (erroriInput erroriInput) {
            System.out.println("mr1 exception");
        }
        try {
            MatriceR mr2=new MatriceR(-1,2);
            System.out.println(mr2.toString());
        } catch (erroriInput erroriInput) {
            System.out.println("mr2 exception");
        }
        ////////////////////////////////////////////////////////
        Vector <Integer> v1 = new Vector<Integer>();
        for(int i=0;i<6;i++){
            v1.add(i,i);
        }
        Vector <Integer> v2 = new Vector<Integer>();
        for(int i=0;i<6;i++){
            v2.add(i,i+1);
        }
        ////////////////////////////////////////////////////////
        System.out.println("-----------" );
        MatriceR mr1 = new MatriceR(3, 2, v1);
        System.out.println("mr1: " + mr1.toString());
        MatriceR mr2 = new MatriceR(3, 2, v2);
        System.out.println("mr2: " + mr2.toString());
        MatriceR d= mr1.differenza(mr2);
        System.out.println("mr1-mr2= " + d.toString() );
        MatriceR s = mr1.somma(mr2);
        System.out.println("mr1+mr2= " + s.toString() );
        Vector<Integer> v3 = new Vector<Integer>();
        for(int i=0;i<2;i++){
            v3.add(i,i+2);
        }
        MatriceR mr3 = new MatriceR(2,1,v3);
        System.out.println("mr3= " + mr3.toString() );
        MatriceR p = mr1.prodotto(mr3);
        System.out.println("mr1*mr3= " + p.toString() );

        MatriceR ps = mr3.prodotto(3);
        System.out.println("mr3*3= "+ ps.toString());

        MatriceR trans = mr2.trasposta();
        System.out.println("mr2 trasposta= "+ trans.toString());

        //matriceQ
        MatriceQ mq = new MatriceQ(2);
        System.out.println("mq = " + mq.toString());
        Vector<Integer> vq1= new Vector<Integer>();
        Vector<Integer> vq2= new Vector<Integer>();
        for (int i=0;i<4;i++){
            vq1.add(i,i);
            vq2.add(i,4-i);
        }
        MatriceQ mq1 = new MatriceQ(2,vq1);
        System.out.println("mq1 = " + mq1.toString());
        MatriceQ mq2 = new MatriceQ(2,vq2);
        System.out.println("mq2 = " + mq2.toString());
        MatriceQ pq = (MatriceQ) mq1.prodotto(mq2);
        System.out.println("mq1*mq2 = " + pq.toString());
        MatriceR pp= mq1.prodotto(mr3);
        System.out.println("mq1*mq3 = " + pp.toString());

        int tr= mq1.traccia();
        System.out.println("la traccia di mq1 = " + tr);
        System.out.println("mq1 è simmetrica?  " + mq1.isSimmetrica());
        System.out.println("mq è simmetrica?  " + mq.isSimmetrica());

        //somma e differenze sbagliate

        Vector<Integer> v4= new Vector<Integer>();
        for(int i=0;i<9;i++){
            v4.add(i,2);
        }
        MatriceQ mq3=new MatriceQ(3,v4);
        System.out.println("mq3 = " + mq3.toString());
        MatriceQ mq4=mq3.esponenziale(2);
        System.out.println("mq3^2 = " + mq4.toString());

        Vector<Integer> vi1= new Vector<Integer>();
        for(int i=0;i<9;i++){
            vi1.add(i,i);
        }
        Insieme in1 = new Insieme(9,vi1);
        System.out.println("insieme1 = "+in1.toString());

        Vector<Integer> vi2= new Vector<Integer>();
        for(int i=0;i<9;i++){
            vi2.add(i,i*-1);
        }

        Insieme in2 = new Insieme(9,vi2);
        System.out.println("insieme2 = "+in2.toString());

        Insieme in3;
        in3 = in1.differenza(in2);
        System.out.println("insieme1-Insieme2 = "+in3.toString());
        Insieme in4= in1.unione(in2);
        System.out.println("insieme1 U Insieme2 = "+in4.toString());
        Insieme in5= in1.intersezione(in2);
        System.out.println("insieme1 intersecato Insieme2 = "+in5.toString());


        System.out.println("Fine Test");
    }
}