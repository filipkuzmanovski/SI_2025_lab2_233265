# Филип Кузмановски 233265

ВТОРО БАРАЊЕ
-------------------------------------------------------------------------------------------------------------
![CFG_diagram_233265_Slika1](https://github.com/user-attachments/assets/966e4717-9415-4568-b131-0902b9d69e5c)
![CFG_diagram_233265_Slika2](https://github.com/user-attachments/assets/55c479fe-49e9-49bb-b03a-06295e81ab1f)
-------------------------------------------------------------------------------------------------------------

ТРЕТО БАРАЊЕ
--------------------------------------------------------------------------------------------------------------------------------------------------------------

Цикломатската комплексност ја најдов на начин којшто ги избројав бројот на предикатни јазли (Decision points) и ја искористив формулата P+1 со што добив 8+1=9

--------------------------------------------------------------------------------------------------------------------------------------------------------------

ЧЕТВРТО БАРАЊЕ
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

[Uploadpackage mk.finki.ukim;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Item {
    String name;
    Integer quantity; //numerical
    Integer price;
    Double discount;

    public Item(String name, Integer quantity, Integer price, Double discount) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public Double getDiscount() {
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
        if (allItems == null){//A
            throw new RuntimeException("allItems list can't be null!");//B
        }

        double sum = 0;//C:(sum=0),(for loop),(int i=0)

        //D:i<allitems.size
        //E:i++
        //F: if statement at the end of the loop

        for (int i = 0; i < allItems.size(); i++){
            Item item = allItems.get(i);//G
            if (item.getName() == null || item.getName().length() == 0){ //G
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
                char c = cardNumber.charAt(j); //S
                if (allowed.indexOf(c) == -1) {//S
                    throw new RuntimeException("Invalid character in card number!");//T
                }
                // We go to N node if if statement fails to check for loop again
            }
            //R node for loop fails we go to goal node
        }
        else{ // if statement fails O node
            throw new RuntimeException("Invalid card number!");
        }

        return sum;//R

        //P=8
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<Item> items=new ArrayList<Item>();

        System.out.println("No. of items:");
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            System.out.println("Name of item:");
            String name=sc.nextLine();
            if(name.isEmpty()){
                name=null; //to test node G
            }
            System.out.println("Quantity of " + name +":");
            int quantity=Integer.parseInt(sc.nextLine());
            System.out.println("Price of " + name +":");
            int price=Integer.parseInt(sc.nextLine());
            System.out.println("Enter the discount for "+name+":");
            double discount=Double.parseDouble(sc.nextLine());

            items.add(new Item(name,quantity,price,discount));
        }
        if(items.isEmpty()){ //to test node A
            items=null;
        }
        System.out.println("Enter the number of your card: ");
        String cardNumber=sc.nextLine();

        //Card number for copying purposes: 1234567898765432
        //Card number for copying purposes for node T: STQREYUIOPASDFGH

        if(cardNumber.isEmpty()){//to test node
            cardNumber=null;
        }
        try{
            Double totalSum=checkCart(items,cardNumber);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}ing SI_2025_Lab2_233265.java…]()

За да е исполнет Every Statement критериумот минималниот број на тест случаи којшто мора да ги има кодот се 5 тие се на прво место 0 за да може да се изврши statementot  if (allItems == null){throw new RuntimeException("allItems list can't be null!");} поради тоа што ако внесеме било што во картичката тој израз нема да се изврши со тоа ги покриваме nodesot A,B. Следен е 1 "" 0,0,"" за да може да се извршат низа од nodes: A,B,C,D,E,G,H најбитно за овој инпут е што може да се изврши nodeot H поради тоа што името на продуктот ќе е null. Следен е инпутот 1,Apple,11,400,2.0,1234567898765432 овој е еден од најзначајните инпути поради тоа што ги извршуваме скоро сите nodes освен edge caseovite како node M O и T, затоа како претпоследен го воведуваме истиов овој инпут само наместо 16 бројки за картата ќе внесеме 16 букви со што ќе се покријат edge caseovite М и T и за крај истиот инпут само за картичката ќе внесеме "" со што ќе биде null и ќе може да се изврши edge caseot О. Кодот е даден погоре може да го разгледате.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
