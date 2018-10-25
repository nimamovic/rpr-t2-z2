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
    public boolean isNull(Interval i){
        if(pocetna == 0 && krajnja == 0 && pocetak == false && kraj == false) return true;
    }
    public boolean isIn(double t){
        if(t >= pocetna && t <= krajnja) return true;
    }
    public Interval intersect(Interval i){
        Interval r;
        if(pocetna>i.pocetna && krajnja>i.krajnja && krajnja<i.pocetna){
            r.pocetna=i.pocetna;
            r.krajnja=krajnja;
        }
        else if(pocetna<i.pocetna && krajnja<i.krajnja && i.krajnja>pocetna){
            r.pocetna=i.pocetna;
            r.krajnja=krajnja;
        }
        return r;
    }

}
