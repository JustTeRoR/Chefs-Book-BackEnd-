package com.justterror.chefsbook.utils;

public enum Categories {
    Dessert("Десерт"),
    Beef("Говядина"),
    Vegetarian("Вегетерианское"),
    Starter("Первое"),
    Miscellaneous("Разнородное"),
    Side("Гарнир"),
    Chicken("Курица"),
    Seafood("Морепродукты"),
    Breakfast("Завтрак"),
    Pork("Свинина"),
    Pasta("Макаронные изделия"),
    Lamb("Ягненок"),
    Goat("Козленок");

    private final String category;
    Categories(String category) {
        this.category = category;
    }

    public String toString() {
        return category;
    }
}
