package com.calorie.calc.fragments.recipe.query;

public enum HealthType implements QueryType{

    	AlcoholCocktail	("alcohol-cocktail","Alcohol Cocktail" ,	"Describes an alcoholic cocktail"),
    	AlcoholFree	("alcohol-free","Alcohol Free" ,	"No alcohol used or contained"),
    	CeleryFree	("celery-free","Celery Free" ,	"Does not contain celery or derivatives"),
    	CrustceanFree	("crustacean-free","Crustcean Free" ,	"Does not contain crustaceans (shrimp, lobster etc.) or derivatives"),
    	DairyFree	("dairy-free","Dairy Free" ,	"No dairy; no lactose"),
    	DASH	("DASH","DASH" ,	"Dietary Approaches to Stop Hypertension diet"),
    	EggFree	("egg-free","Egg Free" ,	"No eggs or products containing eggs"),
    	FishFree	("fish-free","Fish Free" ,	"No fish or fish derivatives"),
    	FODMAPFree	("fodmap-free","FODMAP Free" ,	"Does not contain FODMAP foods"),
    	GlutenFree	("gluten-free","GlutenFree" ,	"No ingredients containing gluten"),
    	ImmunoSupportive	("immuno-supportive","Immuno Supportive" ,	"Recipes which fit a science-based approach to eating to strengthen the immune system"),
    	KetoFriendly	("keto-friendly","Keto Friendly" ,	"Maximum 7 grams of net carbs per serving"),
    	KidneyFriendly	("kidney-friendly","Kidney Friendly" ,	"Per serving – phosphorus less than 250 mg AND potassium less than 500 mg AND sodium less than 500 mg"),
    	Kosher	("kosher","Kosher" ,	"Contains only ingredients allowed by the kosher diet. However it does not guarantee kosher preparation of the ingredients themselves"),
    	LowPotassium	("low-potassium","Low Potassium" ,	"Less than 150mg per serving"),
    	LowSugar	("low-sugar","Low Sugar" ,	"No simple sugars – glucose, dextrose, galactose, fructose, sucrose, lactose, maltose"),
    	LupineFree	("lupine-free","Lupine Free" ,	"Does not contain lupine or derivatives"),
    	Mediterranean	("Mediterranean","Mediterranean" ,	"Mediterranean diet"),
    	MolluskFree	("mollusk-free","Mollusk Free" ,	"No mollusks"),
    	MustardFree	("mustard-free","Mustard Free" ,	"Does not contain mustard or derivatives"),
    	NoOilAdded	("No-oil-added","No Oil Added" ,	"No oil added except to what is contained in the basic ingredients"),
    	Paleo	("paleo","Paleo" ,	"Excludes what are perceived to be agricultural products; grains, legumes, dairy products, potatoes, refined salt, refined sugar, and processed oils"),
    	PeanutFree	("peanut-free","Peanut Free" ,	"No peanuts or products containing peanuts"),
    	Pescatarian	("pecatarian","Pescatarian" ,	"Does not contain meat or meat based products, can contain dairy and fish"),
    	PorkFree	("pork-free","Pork Free" ,	"Does not contain pork or derivatives"),
    	RedMeatFree	("red-meat-free","Red Meat Free" ,	"Does not contain beef, lamb, pork, duck, goose, game, horse, and other types of red meat or products containing red meat."),
    	SesameFree	("sesame-free","Sesame Free" ,	"Does not contain sesame seed or derivatives"),
    	ShellfishFree	("shellfish-free","Shellfish Free" ,	"No shellfish or shellfish derivatives"),
    	SoyFree	("soy-free","Soy Free" ,	"No soy or products containing soy"),
    	SugarConscious	("sugar-conscious","Sugar Conscious" ,	"Less than 4g of sugar per serving"),
    	SulfiteFree	("sulfite-free","Sulfite Free" ,	"No Sulfites"),
    	TreeNutFree	("tree-nut-free","Tree Nut Free" ,	"No tree nuts or products containing tree nuts"),
    	Vegan	("vegan","Vegan" ,	"No meat, poultry, fish, dairy, eggs or honey"),
    	Vegetarian	("vegetarian","Vegetarian" ,	"No meat, poultry, or fish"),
    	WheatFree	("wheat-free","Wheat Free" ,	"No wheat, can have gluten though");



	String queryString="Health";
	String parametr;
	boolean included = false;
	String label;
	String description;

	HealthType(String parametr, String label, String description) {
		this.parametr = parametr;
		this.label = label;
		this.description = description;
	}

	@Override
	public String getQueryString() {
		return queryString;
	}

	@Override
	public String getParametr() {
		return parametr;
	}

	@Override
	public String getLable() {
		return label;
	}

	@Override
	public String getDescription() {
		return description;
	}


	@Override
	public boolean isIncluded() {
		return included;
	}

	@Override
	public void setInclude(Boolean include) {
		this.included=include;
	}
}
