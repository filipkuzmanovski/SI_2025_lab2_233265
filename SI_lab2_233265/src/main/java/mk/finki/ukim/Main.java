package mk.finki.ukim;
import java.util.List;

class Item {
    String name;
    int quantity; //numerical
    int price;
    double discount;

    public Item(String name, int quantity, int price, double discount) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}


class SILab2 {
    public static double checkCart(List<Item> allItems, String cardNumber){
        if (allItems == null){ //A
            throw new RuntimeException("allItems list can't be null!"); //B
        }

        double sum = 0;//C:(sum=0),(for loop),(int i=0)

        //D:i<allitems.size
        //E:i++
        //F: if statement at the end of the loop

        for (int i = 0; i < allItems.size(); i++){
            Item item = allItems.get(i);//G
            if (item.getName() == null || item.getName().length() == 0){//G
                throw new RuntimeException("Invalid item!");//H
            }

            if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10){//I
                sum -= 30;//J
            }

            if (item.getDiscount() > 0){//K
                sum += item.getPrice()*(1-item.getDiscount())*item.getQuantity();//L

            }
            else {
                sum += item.getPrice()*item.getQuantity();//M
            }

        }
        if (cardNumber != null && cardNumber.length() == 16) {//F
            String allowed = "0123456789";//N
            char[] chars = cardNumber.toCharArray();//N
            //For loop allowed string and chars array N node
            //int j=0 P node
            //j<cardNumber Q node
            //R node if for loop ends we basically go to goal node
            for (int j = 0; j < cardNumber.length(); j++) {
                char c = cardNumber.charAt(j);//S
                if (allowed.indexOf(c) == -1) {//S
                    throw new RuntimeException("Invalid character in card number!");//T
                }
                // We go to N node if if statement fails to check for loop again
            }
            //R node for loop fails we go to goal node
        }

        else{ // if statement fails O node
            throw new RuntimeException("Invalid card number!");//O
        }

        return sum; //R

    }
}