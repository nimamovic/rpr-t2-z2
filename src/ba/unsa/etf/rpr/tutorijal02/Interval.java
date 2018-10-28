package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetna, krajnja;
    private boolean pocetak, kraj;
    public Interval(double p, double k,boolean da_li_pocetak, boolean da_li_kraj){
        if(p > k) throw (new IllegalArgumentException());
        pocetna = p;
        krajnja = k;
        pocetak = da_li_pocetak;
        kraj = da_li_kraj;
    }
    public Interval(){
        pocetna = 0;
        krajnja = 0;
        pocetak = false;
        kraj = false;
    }
    public boolean isNull(){
        if(pocetna == 0 && krajnja == 0 &&  pocetak == false && kraj == false) return true;
        return false;
    }
    public boolean isIn(double t){
        if((t > pocetna ||  (t == pocetna && pocetak == true)) && (t < krajnja || (t == krajnja && kraj == true))) return true;
        return false;
    }
    public Interval intersect(Interval i){
        Interval r = new Interval();
        if(pocetna<i.pocetna) {
            r.pocetna=i.pocetna;
            r.pocetak=i.pocetak;
        }
        else {
            r.pocetna=pocetna;
            r.pocetak=pocetak;
        }
        if(krajnja<i.krajnja) {
            r.krajnja=krajnja;
            r.kraj=kraj;
        }
        else {
            r.krajnja=i.krajnja;
            r.kraj=i.kraj;
        }
        if((pocetna>i.pocetna) || (i.pocetna>krajnja)){
            Interval prazan=new Interval();
            return prazan;
        }
        return r;
    }
    public static Interval intersect(Interval i1, Interval i2){
        return i1.intersect(i2);
    }

    @Override
    public boolean equals(Object obj) {
        Interval interval=(Interval) obj;
        if (interval.pocetna == pocetna && interval.krajnja == krajnja && pocetak == interval.pocetak && kraj == interval.kraj)
            return true;
        return false;
    }

    @Override
    public String toString() {
        String s = "";
        if (pocetna == 0 && krajnja == 0) s = "()";
        else {
            if (pocetak == false) s += "(";
            else s += "[";
            s += pocetna + "," + krajnja;
            if (kraj == false) s += ")";
            else s += "]";
        }
        return s;
    }
}
