public class Main {
    public static void main(String[] args) {
        // 
        VegetarianMeal veg = new VegetarianMeal();
        VeganMeal vegan = new VeganMeal();
        KetoMeal keto = new KetoMeal();
        HighProteinMeal highProtein = new HighProteinMeal();

        Meal<VegetarianMeal> vegMeal = new Meal<>(veg);
        Meal<VeganMeal> veganMeal = new Meal<>(vegan);
        Meal<KetoMeal> ketoMeal = new Meal<>(keto);
        Meal<HighProteinMeal> proteinMeal = new Meal<>(highProtein);

        MealPlanUtils.generatePlan(vegMeal);
        MealPlanUtils.generatePlan(veganMeal);
        MealPlanUtils.generatePlan(ketoMeal);
        MealPlanUtils.generatePlan(proteinMeal);
    }
}
