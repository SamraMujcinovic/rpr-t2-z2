package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetna;
    private double krajnja;
    private boolean p_pripada;
    private boolean k_pripada;
    public Interval(double pocetna,double krajnja,boolean p_pripada,boolean k_pripada){
        if(pocetna>krajnja)  throw new IllegalArgumentException("Pocetna tacka mora biti veca od krajnje!");
        this.pocetna=pocetna;
        this.krajnja=krajnja;
        this.p_pripada=p_pripada;
        this.k_pripada=k_pripada;
    }
    public Interval() {
        pocetna = 0;
        krajnja = 0;
        p_pripada = false;
        k_pripada = false;
    }
    public boolean isNull(){
        if(pocetna==0 && krajnja==0 && k_pripada==false && p_pripada==false)
            return true;
        return false;
    }
    public boolean isIn(double tacka){
        boolean pripada=true;
        if(tacka>pocetna && tacka<krajnja) pripada=true;
        else if((tacka>pocetna ||( Math.abs(tacka-pocetna)<0.001 && p_pripada==true)) && (tacka<krajnja || (Math.abs(tacka-krajnja)<0.001 && k_pripada==true))) pripada=true;
        else pripada=false;
        return pripada;
    }
    public Interval intersect(Interval i1){
        Interval i=new Interval();
        if(i1.pocetna>krajnja || pocetna>i1.krajnja) return new Interval();
        if(i1.pocetna>pocetna && i1.krajnja<krajnja) return new Interval(i1.pocetna,i1.krajnja,i1.p_pripada,i1.k_pripada);
        if(pocetna>i1.pocetna && krajnja<i1.krajnja) return new Interval(pocetna,krajnja,p_pripada,k_pripada);

        if(pocetna<i1.pocetna){i.pocetna=i1.pocetna; i.p_pripada=i1.p_pripada;}
        else {i.pocetna=pocetna; i.p_pripada=p_pripada;}
        if(krajnja<i1.krajnja){i.krajnja=krajnja; i.k_pripada=k_pripada;}
        else {i.krajnja=i1.krajnja; i.k_pripada=i1.k_pripada;}
        return i;
    }
    public static Interval intersect(Interval i1,Interval i2){
        return i1.intersect(i2);
    }
    public String toString(){
        if(isNull()) return "()";
        if(isIn(pocetna) && isIn(krajnja))return "["+pocetna+","+krajnja+"]";
        if(isIn(pocetna) && !isIn(krajnja)) return "["+pocetna+","+krajnja+")";
        if(!isIn(pocetna) && isIn(krajnja)) return "("+pocetna+","+krajnja+"]";
        return "("+pocetna+","+krajnja+")";
    }
    public boolean equals(Interval i){
        if(Math.abs(pocetna-i.pocetna)<0.001 && Math.abs(krajnja-i.krajnja)<0.001 && p_pripada==i.p_pripada && k_pripada==i.k_pripada )
            return true;
        return false;
    }





}
