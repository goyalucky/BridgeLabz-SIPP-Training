public class VeganMeal implements MealPlan {
    @Override
    public String getPlanName() {
        return "Vegan";
    }

    @Override
    public int getCalories() {
        return 1700;
    }

    @Override
    public void displayMealDetails() {
        System.out.println("Vegan Meal: Includes only plant-based items. Calories: " + getCalories());
    }
}
