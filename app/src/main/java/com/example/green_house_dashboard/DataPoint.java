package com.example.green_house_dashboard;

public class DataPoint {
int x,y ;

    public DataPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public DataPoint(){
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
