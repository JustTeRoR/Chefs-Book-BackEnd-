package com.justterror.chefsbook.utils;

public enum Countries {
    britain("Британская"),
    american("Американская"),
    mexican("Мексиканская"),
    french("Французская"),
    canadian("Канадская"),
    jamaican("Ямайки"),
    chinese("Китайская"),
    italian("Итальянская"),
    dutch("Датская"),
    vietnamese("Вьетнамская"),
    //TODO:: Возможно изменить потом внутреннее значение для блюд с неизвестной страной
    unknown(""),
    indian("Индийская"),
    japanese("Японская"),
    moroccan("Марокканская"),
    tunisian("Тунисская"),
    turkish("Турецкая"),
    irish("Ирландская"),
    greek("Греческая"),
    kenyan("Кенийская"),
    malaysian("Малазийская"),
    thai("Тайская"),
    spanish("Испанская"),
    egyptian("Египетская");

    private final String country;
    Countries(String country) {
        this.country = country;
    }

    public String toString() {
        return country;
    }
}
