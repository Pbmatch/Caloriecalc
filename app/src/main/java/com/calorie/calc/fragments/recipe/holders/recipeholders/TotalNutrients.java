package com.calorie.calc.fragments.recipe.holders.recipeholders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TotalNutrients implements Serializable {
    private final static long serialVersionUID = -1829849523408963768L;
    List<Nutrient> nutrientList;
    @SerializedName("ENERC_KCAL")
    @Expose
    private EnercKcal enercKcal;
    @SerializedName("FAT")
    @Expose
    private Fat fat;
    @SerializedName("CHOCDF")
    @Expose
    private Chocdf chocdf;      //Carbohydrate
    @SerializedName("PROCNT")
    @Expose
    private Procnt procnt;   //protein

    @SerializedName("FASAT")
    @Expose
    private Fasat fasat;
    @SerializedName("FATRN")
    @Expose
    private Fatrn fatrn;
    @SerializedName("FAMS")
    @Expose
    private Fams fams;
    @SerializedName("FAPU")
    @Expose
    private Fapu fapu;
    @SerializedName("CHOCDF.net")
    @Expose
    private CHOCDFNet cHOCDFNet;
    @SerializedName("FIBTG")
    @Expose
    private Fibtg fibtg;
    @SerializedName("SUGAR")
    @Expose
    private Sugar sugar;
    @SerializedName("SUGAR.added")
    @Expose
    private SUGARAdded sUGARAdded;

    @SerializedName("CHOLE")
    @Expose
    private Chole chole;
    @SerializedName("NA")
    @Expose
    private Na na;
    @SerializedName("CA")
    @Expose
    private Ca ca;
    @SerializedName("MG")
    @Expose
    private Mg mg;
    @SerializedName("K")
    @Expose
    private K k;
    @SerializedName("FE")
    @Expose
    private Fe fe;
    @SerializedName("ZN")
    @Expose
    private Zn zn;
    @SerializedName("P")
    @Expose
    private P p;
    @SerializedName("VITA_RAE")
    @Expose
    private VitaRae vitaRae;
    @SerializedName("VITC")
    @Expose
    private Vitc vitc;
    @SerializedName("THIA")
    @Expose
    private Thia thia;
    @SerializedName("RIBF")
    @Expose
    private Ribf ribf;
    @SerializedName("NIA")
    @Expose
    private Nia nia;
    @SerializedName("VITB6A")
    @Expose
    private Vitb6a vitb6a;
    @SerializedName("FOLDFE")
    @Expose
    private Foldfe foldfe;
    @SerializedName("FOLFD")
    @Expose
    private Folfd folfd;
    @SerializedName("FOLAC")
    @Expose
    private Folac folac;
    @SerializedName("VITB12")
    @Expose
    private Vitb12 vitb12;
    @SerializedName("VITD")
    @Expose
    private Vitd vitd;
    @SerializedName("TOCPHA")
    @Expose
    private Tocpha tocpha;
    @SerializedName("VITK1")
    @Expose
    private Vitk1 vitk1;
    @SerializedName("Sugar.alcohol")
    @Expose
    private SugarAlcohol sugarAlcohol;
    @SerializedName("WATER")
    @Expose
    private Water water;

    public List<Nutrient> getNutrientList() {
        initNutrientsList();
        return nutrientList;
    }

    public void setNutrientList(List<Nutrient> nutrientList) {
        this.nutrientList = nutrientList;
    }

    void initNutrientsList() {
        nutrientList = new ArrayList<>();
        addToList(enercKcal);
        addToList(fat);
        addToList(fasat);

        addToList(fatrn);

        addToList(fams);

        addToList(fapu);

        addToList(chocdf);

        addToList(cHOCDFNet);

        addToList(fibtg);

        addToList(sugar);

        addToList(sUGARAdded);

        addToList(procnt);

        addToList(chole);

        addToList(na);

        addToList(ca);

        addToList(mg);

        addToList(k);

        addToList(fe);

        addToList(zn);

        addToList(p);

        addToList(vitaRae);

        addToList(vitc);

        addToList(thia);

        addToList(ribf);

        addToList(nia);

        addToList(vitb6a);

        addToList(foldfe);

        addToList(folfd);

        addToList(folac);

        addToList(vitb12);

        addToList(vitd);

        addToList(tocpha);

        addToList(vitk1);

        addToList(sugarAlcohol);

        addToList(water);
    }

    void addToList(Nutrient item) {
        nutrientList.add(item);
    }

    public EnercKcal getEnercKcal() {
        return enercKcal;
    }

    public void setEnercKcal(EnercKcal enercKcal) {
        this.enercKcal = enercKcal;
    }

    public Fat getFat() {
        return fat;
    }

    public void setFat(Fat fat) {
        this.fat = fat;
    }

    public Fasat getFasat() {
        return fasat;
    }

    public void setFasat(Fasat fasat) {
        this.fasat = fasat;
    }

    public Fatrn getFatrn() {
        return fatrn;
    }

    public void setFatrn(Fatrn fatrn) {
        this.fatrn = fatrn;
    }

    public Fams getFams() {
        return fams;
    }

    public void setFams(Fams fams) {
        this.fams = fams;
    }

    public Fapu getFapu() {
        return fapu;
    }

    public void setFapu(Fapu fapu) {
        this.fapu = fapu;
    }

    public Chocdf getChocdf() {
        return chocdf;
    }

    public void setChocdf(Chocdf chocdf) {
        this.chocdf = chocdf;
    }

    public CHOCDFNet getcHOCDFNet() {
        return cHOCDFNet;
    }

    public void setcHOCDFNet(CHOCDFNet cHOCDFNet) {
        this.cHOCDFNet = cHOCDFNet;
    }

    public Fibtg getFibtg() {
        return fibtg;
    }

    public void setFibtg(Fibtg fibtg) {
        this.fibtg = fibtg;
    }

    public Sugar getSugar() {
        return sugar;
    }

    public void setSugar(Sugar sugar) {
        this.sugar = sugar;
    }

    public SUGARAdded getsUGARAdded() {
        return sUGARAdded;
    }

    public void setsUGARAdded(SUGARAdded sUGARAdded) {
        this.sUGARAdded = sUGARAdded;
    }

    public Procnt getProcnt() {
        return procnt;
    }

    public void setProcnt(Procnt procnt) {
        this.procnt = procnt;
    }

    public Chole getChole() {
        return chole;
    }

    public void setChole(Chole chole) {
        this.chole = chole;
    }

    public Na getNa() {
        return na;
    }

    public void setNa(Na na) {
        this.na = na;
    }

    public Ca getCa() {
        return ca;
    }

    public void setCa(Ca ca) {
        this.ca = ca;
    }

    public Mg getMg() {
        return mg;
    }

    public void setMg(Mg mg) {
        this.mg = mg;
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public Fe getFe() {
        return fe;
    }

    public void setFe(Fe fe) {
        this.fe = fe;
    }

    public Zn getZn() {
        return zn;
    }

    public void setZn(Zn zn) {
        this.zn = zn;
    }

    public P getP() {
        return p;
    }

    public void setP(P p) {
        this.p = p;
    }

    public VitaRae getVitaRae() {
        return vitaRae;
    }

    public void setVitaRae(VitaRae vitaRae) {
        this.vitaRae = vitaRae;
    }

    public Vitc getVitc() {
        return vitc;
    }

    public void setVitc(Vitc vitc) {
        this.vitc = vitc;
    }

    public Thia getThia() {
        return thia;
    }

    public void setThia(Thia thia) {
        this.thia = thia;
    }

    public Ribf getRibf() {
        return ribf;
    }

    public void setRibf(Ribf ribf) {
        this.ribf = ribf;
    }

    public Nia getNia() {
        return nia;
    }

    public void setNia(Nia nia) {
        this.nia = nia;
    }

    public Vitb6a getVitb6a() {
        return vitb6a;
    }

    public void setVitb6a(Vitb6a vitb6a) {
        this.vitb6a = vitb6a;
    }

    public Foldfe getFoldfe() {
        return foldfe;
    }

    public void setFoldfe(Foldfe foldfe) {
        this.foldfe = foldfe;
    }

    public Folfd getFolfd() {
        return folfd;
    }

    public void setFolfd(Folfd folfd) {
        this.folfd = folfd;
    }

    public Folac getFolac() {
        return folac;
    }

    public void setFolac(Folac folac) {
        this.folac = folac;
    }

    public Vitb12 getVitb12() {
        return vitb12;
    }

    public void setVitb12(Vitb12 vitb12) {
        this.vitb12 = vitb12;
    }

    public Vitd getVitd() {
        return vitd;
    }

    public void setVitd(Vitd vitd) {
        this.vitd = vitd;
    }

    public Tocpha getTocpha() {
        return tocpha;
    }

    public void setTocpha(Tocpha tocpha) {
        this.tocpha = tocpha;
    }

    public Vitk1 getVitk1() {
        return vitk1;
    }

    public void setVitk1(Vitk1 vitk1) {
        this.vitk1 = vitk1;
    }

    public SugarAlcohol getSugarAlcohol() {
        return sugarAlcohol;
    }

    public void setSugarAlcohol(SugarAlcohol sugarAlcohol) {
        this.sugarAlcohol = sugarAlcohol;
    }

    public Water getWater() {
        return water;
    }

    public void setWater(Water water) {
        this.water = water;
    }


    public class EnercKcal extends Nutrient {
        public EnercKcal() {
        }
        public EnercKcal(String label, double v, String g) {
            super(label,v,g);
        }
    }

    public class Fat extends Nutrient {
        public Fat(String label, double v, String g) {
            super(label,v,g);
        }

        public Fat() {
        }
    }
    public class Chocdf extends Nutrient {
        public Chocdf(String label, double v, String g) {
            super(label,v,g);
        }

        public Chocdf() {
        }

    }
    public class Procnt extends Nutrient {
        public Procnt(String label, double v, String g) {
            super(label,v,g);
        }

        public Procnt() {
        }
    }

    public class Fasat extends Nutrient {
    }

    private class Fatrn extends Nutrient {
    }

    private class Fams extends Nutrient {
    }

    private class Fapu extends Nutrient {
    }



    private class CHOCDFNet extends Nutrient {
    }

    private class Fibtg extends Nutrient {
    }

    private class Sugar extends Nutrient {
    }

    private class SUGARAdded extends Nutrient {
    }



    private class Chole extends Nutrient {
    }

    private class Na extends Nutrient {
    }

    private class Ca extends Nutrient {
    }

    private class Mg extends Nutrient {
    }

    private class K extends Nutrient {
    }

    private class Fe extends Nutrient {
    }

    private class Zn extends Nutrient {
    }

    private class P extends Nutrient {
    }

    private class VitaRae extends Nutrient {
    }

    private class Vitc extends Nutrient {
    }

    private class Thia extends Nutrient {
    }

    private class Ribf extends Nutrient {
    }

    private class Nia extends Nutrient {
    }

    private class Vitb6a extends Nutrient {
    }

    private class Foldfe extends Nutrient {
    }

    private class Folfd extends Nutrient {
    }

    private class Vitb12 extends Nutrient {
    }

    private class Folac extends Nutrient {
    }

    private class Vitd extends Nutrient {
    }

    private class Tocpha extends Nutrient {
    }

    private class Vitk1 extends Nutrient {
    }

    private class SugarAlcohol extends Nutrient {
    }

    private class Water extends Nutrient {
    }
}
