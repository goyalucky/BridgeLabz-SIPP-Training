public class MealPlanUtils {
    public static <T extends MealPlan> void generatePlan(Meal<T> meal) {
        System.out.println("✅ Personalized Meal Plan Generated:");
        meal.showMeal();
    }
}
