package com.calorie.calc.fragments.recipe.diet;

import com.calorie.calc.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum DietMainPageType {
    ALL(R.string.all_diet,R.string.all_text,"https://slenderform.ru/wp-content/uploads/2020/08/intuitivnoe-pitanie-768x512.jpg",null,null),
    VEGAN(R.string.vegan,R.string.vegan_text,"https://i.ytimg.com/vi/Alnm1uF0NdA/hqdefault.jpg","health","vegan"),
    VEGATARIAN(R.string.vegetarian,R.string.vegetarian_text,"https://www.gaziantep27.net/d/news/99735.jpg","health","vegetarian"),
    GLUTEN_FREE(R.string.gluten_free,R.string.gluten_free_text,"https://pbs.twimg.com/media/EXlKcllXkAAUtCe.jpg","health","gluten-free"),
    KETOGONIC(R.string.ketogenic,R.string.ketogenic_text,"https://www.hola.com/us/images/0257-0de01f27a7f3-50c6dc73ac97-1000/horizontal-800/alimentos-saludables1.jpg","health","keto-friendly"),
    PESTERIAN(R.string.pescetarian,R.string.pescetarian_text,"https://fishmongerapproved.com/wp-content/uploads/2019/11/AdobeStock_281762298-700x467.jpeg","health","pescatarian"),
    PALEO(R.string.paleo,R.string.paleo_text,"https://t2.uc.ltmcdn.com/images/6/2/9/img_alimentos_permitidos_en_la_dieta_paleo_45926_orig.jpg","health","paleo");

   private int titleRes;
    private int textRes;
    private String imageUrl;
    private boolean select = false;
    private Map<String,String> map = new HashMap<String,String>();
    List<String> checkboxText = new ArrayList<>();

    DietMainPageType(int titleRes, int textRes, String imageUrl, String key, String value) {
        if(key!=null)
        map.put(key, value);
        checkboxText.add("Снижает вес");
        checkboxText.add("Улучшает работу сердца");
        checkboxText.add("Повышает уровень энергии");
        checkboxText.add("Помогает в лечение диабета");
        checkboxText.add("Положительно влияет на симптомы СПКЯ ");
        this.titleRes = titleRes;
        this.textRes = textRes;
        this.imageUrl = imageUrl;
    }
    public static void refreshSelected()
    {
        for(DietMainPageType type: DietMainPageType.values())
            type.setSelect(false);

    }

    public List<String> getCheckboxText() {
        return checkboxText;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public void setCheckboxText(List<String> checkboxText) {
        this.checkboxText = checkboxText;
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

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
