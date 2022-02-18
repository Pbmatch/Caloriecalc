package com.calorie.calc.edamam.holders.recipeholders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Digest implements Serializable{


        @SerializedName("label")
        @Expose
        private String label;
        @SerializedName("tag")
        @Expose
        private String tag;
        @SerializedName("schemaOrgTag")
        @Expose
        private String schemaOrgTag;
        @SerializedName("total")
        @Expose
        private double total;
        @SerializedName("hasRDI")
        @Expose
        private boolean hasRDI;
        @SerializedName("daily")
        @Expose
        private double daily;
        @SerializedName("unit")
        @Expose
        private String unit;
        @SerializedName("sub")
        @Expose
        private List<Sub> sub = new ArrayList<>();
        private final static long serialVersionUID = -5937539990709276729L;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSchemaOrgTag() {
        return schemaOrgTag;
    }

    public void setSchemaOrgTag(String schemaOrgTag) {
        this.schemaOrgTag = schemaOrgTag;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isHasRDI() {
        return hasRDI;
    }

    public void setHasRDI(boolean hasRDI) {
        this.hasRDI = hasRDI;
    }

    public double getDaily() {
        return daily;
    }

    public void setDaily(double daily) {
        this.daily = daily;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<Sub> getSub() {
        return sub;
    }

    public void setSub(List<Sub> sub) {
        this.sub = sub;
    }

    public class Sub implements Serializable {

            @SerializedName("label")
            @Expose
            private String label;
            @SerializedName("tag")
            @Expose
            private String tag;
            @SerializedName("schemaOrgTag")
            @Expose
            private Object schemaOrgTag;
            @SerializedName("total")
            @Expose
            private double total;
            @SerializedName("hasRDI")
            @Expose
            private boolean hasRDI;
            @SerializedName("daily")
            @Expose
            private double daily;
            @SerializedName("unit")
            @Expose
            private String unit;
            private final static long serialVersionUID = -6290743900513314735L;

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public Object getSchemaOrgTag() {
            return schemaOrgTag;
        }

        public void setSchemaOrgTag(Object schemaOrgTag) {
            this.schemaOrgTag = schemaOrgTag;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public boolean isHasRDI() {
            return hasRDI;
        }

        public void setHasRDI(boolean hasRDI) {
            this.hasRDI = hasRDI;
        }

        public double getDaily() {
            return daily;
        }

        public void setDaily(double daily) {
            this.daily = daily;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }
    }
}
