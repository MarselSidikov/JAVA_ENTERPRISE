package ru.itis.models;

/**
 * 11.09.2017
 * Human
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Human {

    private Long id;
    private String name;
    private int age;
    private String color;

    private Human(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.color = builder.color;
        this.age = builder.age;
    }

    public static class Builder {
        private Long id;
        private String name;
        private int age;
        private String color;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Human build() {
            return new Human(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public void setId(long id) {
        this.id = id;
    }
}
