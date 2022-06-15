package project.base.order;

public class OneCall {
    private String drink_name;
    private char size;
    private double sugar;
    private double ice;
    private String[] toppings;
    private int amount;

    public OneCall(String drink_name, char size, double sugar, double ice, String[] toppings) {
        this.drink_name = drink_name;
        this.size = size;
        this.sugar = sugar;
        this.ice = ice;
        this.toppings = toppings;
        this.amount = 1;
    }

    public void increase_amount(){
        this.amount += 1;
    }
    public void decrease_amount(){
        if (this.amount > 0) {
            this.amount -= 1;
        } else {
            System.out.println("Not allow negative ammount");
        }
    }

    public double get_money(){
        double total = 0;
        //TODO
        //tra lại tổng số tiền trong 1 call, bao gồm tiền của đồ uống, phụ thuộc vào size + tiền của topping
        //viết lệnh sql query

        return total*this.amount;
    }
}
