package animdemo;

import java.util.Random;
import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimDemo extends Application {
    static int num=500;
    Rectangle[]nodes=new Rectangle[num];
    double   []alfa =new double[num];
    Random random=new Random();
    
    public void start(Stage stage) {
        for(int i=0; i<num; i++) {
            nodes[i]=new Rectangle(2,2,Color.WHITE);
            alfa[i] =2.0*Math.PI*random.nextDouble();
        }
        
        Scene scene = new Scene(new Group(nodes), 400, 250, Color.BLACK);
        stage.setScene(scene);
        stage.show();
        
        new AnimationTimer() {
          public void handle(long now) {
              double rad=Math.sqrt(2)*400;
              for(int i=0; i<num; i++){
                  long t=now%1500000000;
                  double d=t*rad/1500000000.0;
                  nodes[i].setTranslateX(Math.cos(alfa[i])*d + 100);
                  nodes[i].setTranslateY(Math.sin(alfa[i])*d + 70);
              }
          }
        }.start();
        
        
        Timeline timeline=new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        
        double rad=Math.sqrt(2)*400;
        double dx,dy;
        for(int i=0; i<num; i++){
            nodes[i].setX(400);
            nodes[i].setY(300);
            dx=Math.cos(alfa[i])*rad + 400;
            dy=Math.sin(alfa[i])*rad + 300;
            
            KeyValue kvx=new KeyValue(nodes[i].xProperty(), dx);
            KeyFrame kfx=new KeyFrame(Duration.millis(900), kvx);
            timeline.getKeyFrames().add(kfx);
            
            KeyValue kvy=new KeyValue(nodes[i].yProperty(), dy);
            KeyFrame kfy=new KeyFrame(Duration.millis(900), kvy);
            timeline.getKeyFrames().add(kfy);
        }
        timeline.play();
    }
}
