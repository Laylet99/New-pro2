package javafxapplication1;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.DepthTest;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.*;

public class JavaFXApplication1 extends Application {
    Rectangle rect=new Rectangle(10, 35, 30, 40);
    Box box;
    
    final String content = "Lorem ipsum";
    final Text text = new Text(10, 20, "Lorem ipsum");
 
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(ev->{
            box.setTranslateX(box.getTranslateX()+12);
            box.setTranslateY(box.getTranslateY()+4);
            
            box.setRotate(box.getRotate()+12);
            
            final Timeline timeline = new Timeline();
            timeline.setCycleCount(1);
            timeline.setAutoReverse(false);
            
            final KeyValue kv0 = new KeyValue(rect.translateXProperty(), 0);
            final KeyFrame kf0 = new KeyFrame(Duration.millis(0), kv0);
            
            final KeyValue kv1 = new KeyValue(rect.translateXProperty(), 50);
            final KeyFrame kf1 = new KeyFrame(Duration.millis(1000), kv1);
                    
            final KeyValue kv2 = new KeyValue(rect.translateXProperty(), 250);
            final KeyFrame kf2 = new KeyFrame(new Duration(2000), kv2);

            final KeyValue kv3 = new KeyValue(rect.translateXProperty(), 300);
            final KeyFrame kf3 = new KeyFrame(Duration.millis(3000), kv3);
            
            final KeyValue kv4 = new KeyValue(rect.translateYProperty(), 100);
            final KeyFrame kf4 = new KeyFrame(Duration.millis(4000), kv4);  
            
            timeline.getKeyFrames().add(kf0);
            timeline.getKeyFrames().add(kf1);
            timeline.getKeyFrames().add(kf2);
            timeline.getKeyFrames().add(kf3);
            timeline.getKeyFrames().add(kf4);
            
            timeline.play();
        });
        root.getChildren().add(btn);

        text.setId("text");
        root.getChildren().add(text);
        FadeTransition ft = new FadeTransition(Duration.millis(3000), text);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();
        
//         final Animation animation = new Transition() {
//     {
//         setDelay(Duration.seconds(1));
//         setCycleDuration(Duration.seconds(1));
//     }
// 
//     protected void interpolate(double frac) {
//         final int length = content.length();
//         final int n = Math.round(length * (float) frac);
//         text.setText(content.substring(0, n));
//     }
// 
// };
//  animation.play(); 
        
        rect.setFill(Color.BLUEVIOLET);
        root.getChildren().add(rect);
        
        box = new Box(27, 37, 45);
        box.setRotationAxis(new Point3D(12, -12, 5));
        root.getChildren().add(box);
        
        Scene scene = new Scene(root, 400, 350);
        scene.getStylesheets().add
            (JavaFXApplication1.class.getResource("CascadeSS.css").toExternalForm());

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
