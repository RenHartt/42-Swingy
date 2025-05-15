package model;

import java.io.Serializable;

public abstract class Entity implements Serializable {
    String name;
    public Entity(String name) {
        this.name = name;
    }
    
    public String getName() { return name; }
}