package math;

public class Calc {

    public int sum(int var1, int var2) {
        System.out.println("Action: " + var1 + "+" + var2);
        return var1 + var2;
    }

    public int sum(String var1, int var2) {
        System.out.println("Action: " + var1 + "+" + var2);

        try {
            int result = Integer.parseInt(var1);
            return result + var2;
        } catch (NumberFormatException n) {
            System.out.println("Catch NumberFormatException");
            double result = Double.parseDouble(var1);
            return (int) result + var2;
        } catch (Exception e) {
            System.out.println("There is an error: " + e.getMessage());
            throw new NumberFormatException("That doesn't work!");
        }
    }

}
