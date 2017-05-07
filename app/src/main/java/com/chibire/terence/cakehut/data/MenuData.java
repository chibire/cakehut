package com.chibire.terence.cakehut.data;

import java.util.ArrayList;

/**
 * Created by root on 4/16/17.
 */

public class MenuData {
    public static String[] menuArray = {"Breakfast", "Burgers", "Bakery", "Drinks", "Lunch", "Salads", "Sandwiches", "Snacks"};

    public static ArrayList<restMenu> menuList() {
        ArrayList<restMenu> list = new ArrayList<>();
        for (int i = 0; i < menuArray.length; i++) {
            restMenu place = new restMenu();
            place.name = menuArray[i];
            place.imageName = menuArray[i].replaceAll("\\s+", "").toLowerCase();
            if (i == 2 || i == 5) {
                place.isFav = true;
            }
            list.add(place);
        }
        return (list);
    }
    public static ArrayList<restMenu> menuImageList(String name) {
        ArrayList<restMenu> list = new ArrayList<>();
        restMenu place = new restMenu();
        place.name = name;
        place.imageName = name.replaceAll("\\s+", "").toLowerCase();
        list.add(place);

        return (list);
    }
    public static String[] allArray = {"Apple Cake", "Beef Burger", "Beef Sandwich", "Blackforest Cake", "Blue Berry Cake", "Caesar Salad", "Cheese Cake", "Cheese Sandwich", "Chicken Burger", "Chicken Salad", "Choccocino Cake", "Chocolate Cake", "Chocolate Fudge Cake", "Club Sandwich", "Coffee", "Egg Burger", "Fresh Juice", "Fruit Cake", "Fruit Salad", "Garden Salad", "Madeira Cake", "Milk Shakes", "Passion Cake","Red Velvet Cake", "Sacher Torte Cake", "Sandwich Salad", "Smoothie","Strawberry Cake", "Tea", "Tiramisu Cake", "Vanilla Cake", "Vegetable Burger", "Vegetable Sandwich", "Whiteforest Cake"};
    public static String[] allPrices = {"KES 300/Piece", "1 for KES 400", "1 for KES 200", "KES 250/Piece", "KES 300/Piece", "1 for KES 400", "KES 300/Piece", "1 for KES 200", "1 for KES 450", "1 for KES 400", "KES 400/Piece", "KES 300/Piece", "KES 300/Piece", "2 for KES 500","1 for KES 160", "1 for KES 300","1 for KES 150", "KES 250/Piece","1 for KES 300", "1 for KES 250", "KES 220/Piece", "1 for KES 340", "KES 300/Piece", "KES 300/Piece", "KES 300/Piece", "1 for KES 300", "1 for KES 240", "KES 300/Piece", "1 for KES 130", "KES 300/Piece", "KES 300/Piece", "1 for KES 300", "1 for KES 350", "KES 300/Piece"};

    public static ArrayList<restMenu> allList() {
        ArrayList<restMenu> list = new ArrayList<>();
        for (int i = 0; i < allArray.length; i++) {
            restMenu place = new restMenu();
            place.name = allArray[i];
            place.price = allPrices[i];
            place.imageName = allArray[i].replaceAll("\\s+", "").toLowerCase();
            if (i == 2 || i == 5) {
                place.isFav = true;
            }
            list.add(place);
        }
        return (list);
    }
}