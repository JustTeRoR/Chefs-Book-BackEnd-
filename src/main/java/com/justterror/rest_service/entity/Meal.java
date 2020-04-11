package com.justterror.rest_service.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@Entity
@Table(name="Meals")
public class Meal implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @Column(name="name")
    @NotNull
    private String name;

    @Column(name="category")
    @NotNull
    private String category;

    @Column(name="country")
    @NotNull
    private String country;

    @Column(name="recipe")
    @NotNull
    private String recipe;

    @Column(name="tags")
    @NotNull
    private String tags;

    @Column(name="ingredients")
    @NotNull
    private String ingridients;

    @Column(name="youTube_url")
    @NotNull
    private String youtubeUrl;

    @Column(name="image")
    @NotNull
    private String image;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getIngridients() {
        return ingridients;
    }

    public void setIngridients(String ingridients) {
        this.ingridients = ingridients;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Meal meal = (Meal) o;

        if (id != meal.id) return false;
        if (name != null ? !name.equals(meal.name) : meal.name != null) return false;
        if (category != null ? !category.equals(meal.category) : meal.category != null) return false;
        if (country != null ? !country.equals(meal.country) : meal.country != null) return false;
        if (recipe != null ? !recipe.equals(meal.recipe) : meal.recipe != null) return false;
        if (tags != null ? !tags.equals(meal.tags) : meal.tags != null) return false;
        if (ingridients != null ? !ingridients.equals(meal.ingridients) : meal.ingridients != null) return false;
        if (youtubeUrl != null ? !youtubeUrl.equals(meal.youtubeUrl) : meal.youtubeUrl != null) return false;
        return image != null ? image.equals(meal.image) : meal.image == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (recipe != null ? recipe.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (ingridients != null ? ingridients.hashCode() : 0);
        result = 31 * result + (youtubeUrl != null ? youtubeUrl.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", country='" + country + '\'' +
                ", recipe='" + recipe + '\'' +
                ", tags='" + tags + '\'' +
                ", ingridients='" + ingridients + '\'' +
                ", youtubeUrl='" + youtubeUrl + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
