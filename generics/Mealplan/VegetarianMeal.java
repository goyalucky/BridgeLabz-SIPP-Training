public class VegetarianMeal implements MealPlan {
    @Override
    public String getPlanName() {
        return "Vegetarian";
    }

    @Override
    public int getCalories() {
        return 1800;
    }

    @Override
    public void displayMealDetails() {
        System.out.println("Vegetarian Meal: Includes vegetables, grains, legumes, dairy. Calories: " + getCalories());
    }
}
