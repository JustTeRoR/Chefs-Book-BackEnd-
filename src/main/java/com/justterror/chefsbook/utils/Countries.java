package com.justterror.chefsbook.utils;

public enum Countries {
    britain("Британия"),
    american("Америка"),
    mexican("Мексика"),
    french("Франция"),
    canadian("Канада"),
    jamaican("Ямайка"),
    chinese("Китай"),
    italian("Италия"),
    dutch("Дания"),
    vietnamese("Вьетнам"),
    //TODO:: Возможно изменить потом внутреннее значение для блюд с неизвестной страной
    unknown("Неизвестно"),
    indian("Индия"),
    japanese("Япония"),
    moroccan("Марокко"),
    tunisian("Тунис"),
    turkish("Турция"),
    irish("Ирландия"),
    greek("Греция"),
    kenyan("Кения"),
    malaysian("Малайзия"),
    thai("Тай"),
    spanish("Испания"),
    egyptian("Египет");

    private final String country;
    Countries(String country) {
        this.country = country;
    }

    public String toString() {
        return country;
    }
}
