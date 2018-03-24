package main.java.com.xalbec.trees;

import javafx.animation.KeyValue;
import processing.core.PApplet;
import processing.event.KeyEvent;

public class Screen extends PApplet {

    static final int WIDTH  = 1280;
    static final int HEIGHT = 720;

    float angle = PI/4;
    float len = 200;
    float fract = 0.5f;
    float offSet = -PI/12;

    float t = 0;

    public static void main(String[] args){

        PApplet.main(new String[] {Screen.class.getName()});

    }

    public void setup(){



    }

    public void settings(){

        size(WIDTH, HEIGHT);

    }

    public void draw(){

        background(0);

        stroke(255);
        translate(WIDTH/2, HEIGHT);
        branch(len, angle, fract);

    }

    public void branch(float len, float angle, float fract){

        line(0,0,0, -len);
        translate(0,-len);

        if(len*fract > 1){

            pushMatrix();
            rotate(angle);
            branch(len*fract, angle, fract);
            popMatrix();
            pushMatrix();
            rotate(-angle);
            branch(len*fract, angle, fract);
            popMatrix();

        }

    }

    public void tribranch(float len, float angle, float fract){

        line(0,0,0,-len);
        translate(0, -len);

        if(len*fract > 1){

            pushMatrix();
            rotate(angle);
            tribranch(len*fract, angle, fract);
            popMatrix();
            pushMatrix();
            tribranch(len*fract, angle, fract);
            popMatrix();
            pushMatrix();
            rotate(-angle);
            tribranch(len*fract, angle, fract);
            popMatrix();

        }

    }

    public void branch(float len, float angle, float fract, float offSet){

        line(0,0,0,-len);
        translate(0, -len);

        if(len*fract > 2){

            pushMatrix();
            rotate(angle + offSet);
            branch(len*fract, angle, fract, offSet);
            popMatrix();
            pushMatrix();
            rotate(offSet);
            branch(len*fract, angle, fract, offSet);
            popMatrix();

        }

    }

    @Override
    public void keyPressed(KeyEvent event) {

        if(keyCode == UP){
            angle += 0.05;
        }
        if(keyCode == DOWN){
            angle -= 0.05;
        }
        if(keyCode == LEFT && fract < 0.8){
            fract -= 0.01f;
        }
        if(keyCode == RIGHT && fract < 0.8){
            fract += 0.01f;
        }


    }
}


