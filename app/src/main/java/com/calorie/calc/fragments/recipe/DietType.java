package com.calorie.calc.fragments.recipe;

import com.calorie.calc.R;

import java.util.Map;

public enum DietType {
    VEGAN(R.string.vegan,R.string.vegan_text,"https://i.ytimg.com/vi/Alnm1uF0NdA/hqdefault.jpg"),
    VEGATARIAN(R.string.vegetarian,R.string.vegetarian_text,"https://www.gaziantep27.net/d/news/99735.jpg"),
    GLUTEN_FREE(R.string.gluten_free,R.string.gluten_free_text,"https://pbs.twimg.com/media/EXlKcllXkAAUtCe.jpg"),
    KETOGONIC(R.string.ketogenic,R.string.ketogenic_text,"https://www.hola.com/us/images/0257-0de01f27a7f3-50c6dc73ac97-1000/horizontal-800/alimentos-saludables1.jpg"),
    PESTERIAN(R.string.pescetarian,R.string.pescetarian_text,"https://fishmongerapproved.com/wp-content/uploads/2019/11/AdobeStock_281762298-700x467.jpeg"),
    PALEO(R.string.paleo,R.string.paleo_text,"https://t2.uc.ltmcdn.com/images/6/2/9/img_alimentos_permitidos_en_la_dieta_paleo_45926_orig.jpg");

   private int titleRes;
    private int textRes;
    private String imageUrl;
    private Map<String,Object> map;

    DietType(int titleRes, int textRes, String imageUrl) {
        this.titleRes = titleRes;
        this.textRes = textRes;
        this.imageUrl = imageUrl;
    }

    public int getTitleRes() {
        return titleRes;
    }

    public void setTitleRes(int titleRes) {
        this.titleRes = titleRes;
    }

    public int getTextRes() {
        return textRes;
    }

    public void setTextRes(int textRes) {
        this.textRes = textRes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
