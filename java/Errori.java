public abstract class Errori extends Throwable {
    private String exc;
    public Errori(String s){exc=s;}
    public String getExc(){ return exc;}
    protected void setExc(String s){exc=s;}
}

