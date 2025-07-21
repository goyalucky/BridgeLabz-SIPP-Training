public class KetoMeal implements MealPlan {
    @Override
    public String getPlanName() {
        return "Keto";
    }

    @Override
    public int getCalories() {
        return 2000;
    }

    @Override
    public void displayMealDetails() {
        System.out.println("Keto Meal: High fat, low carb foods. Calories: " + getCalories());
    }
}
