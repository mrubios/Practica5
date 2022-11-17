package org.iesch.practica1.practica5.modelo;

import com.google.gson.annotations.SerializedName;

public class Pizza {
    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private int id;
    @SerializedName("description")
    private String description;
    @SerializedName("image")
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
