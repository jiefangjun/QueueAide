package model;

/**
 * Created by archie on 7/12/17.
 */
public class User {

    private int id;
    private String name;
    private String time;
    private String windowName;
    private String foodName;

    public User(int id, String windowName, String name, String time, String foodName) {
        this.id = id;
        this.windowName = windowName;
        this.name = name;
        this.time = time;
        this.foodName = foodName;
    }

    public String getName() {
        return name;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWindowName() {
        return windowName;
    }

    public void setWindowName(String windowName) {
        this.windowName = windowName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
