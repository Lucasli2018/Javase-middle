package com.spring.bean;

public class Hero {
    
    private String heroName;
    private String type;
    private String description;
    
    public String getHeroName() {
        return heroName;
    }
    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "Hero [heroName=" + heroName + ", type=" + type + ", description=" + description + "]";
    }

}