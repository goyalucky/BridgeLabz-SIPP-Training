public class HighProteinMeal implements MealPlan {
    @Override
    public String getPlanName() {
        return "High-Protein";
    }

    @Override
    public int getCalories() {
        return 2200;
    }

    @Override
    public void displayMealDetails() {
        System.out.println("High-Protein Meal: Lean meats, legumes, eggs. Calories: " + getCalories());
    }
}
