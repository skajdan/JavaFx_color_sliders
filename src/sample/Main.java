package sample;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage)  {
        BorderPane borderPane = new BorderPane();

        FlowPane flowPane = new FlowPane();
        flowPane.setHgap(30);
        flowPane.setVgap(5);
        borderPane.setMargin(flowPane,new Insets(10,0,0,10));

        Group group = new Group();
        borderPane.setMargin(group, new Insets(15,0,0,10));


        HBox h1 = new HBox();
        HBox h2 = new HBox();

        Slider r1slider = initSlider();
        Slider g1slider = initSlider();
        Slider b1slider = initSlider();


        h1.getChildren().addAll(r1slider,g1slider,b1slider);
        h1.setPadding(new Insets(0,15,0,0));

        flowPane.getChildren().add(h1);

        Slider r2slider = initSlider();
        Slider g2slider = initSlider();
        Slider b2slider = initSlider();

        h2.getChildren().addAll(r2slider,g2slider,b2slider);

        flowPane.getChildren().add(h2);


        IntegerProperty r1 = new SimpleIntegerProperty(r1slider.valueProperty().intValue());
        IntegerProperty g1 = new SimpleIntegerProperty(g1slider.valueProperty().intValue());
        IntegerProperty b1 = new SimpleIntegerProperty(b1slider.valueProperty().intValue());
        r1.bind(r1slider.valueProperty());
        g1.bind(g1slider.valueProperty());
        b1.bind(b1slider.valueProperty());


        IntegerProperty r2 = new SimpleIntegerProperty(r2slider.valueProperty().intValue());
        IntegerProperty g2 = new SimpleIntegerProperty(g2slider.valueProperty().intValue());
        IntegerProperty b2 = new SimpleIntegerProperty(b2slider.valueProperty().intValue());
        r2.bind(r2slider.valueProperty());
        g2.bind(g2slider.valueProperty());
        b2.bind(b2slider.valueProperty());



        Rectangle rectangle = new Rectangle(150,150);
        group.getChildren().add(rectangle);
        rectangle.setStroke(Color.BLACK);
        rectangle.fillProperty().bind(Bindings.createObjectBinding(() -> Color.rgb(r1.get(),g1.get(),b1.get()),r1,g1,b1));
        rectangle.setX(100);
        rectangle.setY(50);



        Rectangle rectangle2 = new Rectangle(90,90);
        group.getChildren().add(rectangle2);
        rectangle2.fillProperty().bind(Bindings.createObjectBinding(() -> Color.rgb(r2.get(),g2.get(),b2.get()),r2,g2,b2));

        rectangle2.setY(rectangle.getY()+(rectangle.getHeight()/2 - (rectangle2.getHeight()/2)));
        rectangle2.setX(rectangle.getX()+(rectangle.getWidth()/2 - (rectangle2.getWidth()/2)));


        Rectangle rectangle3 = new Rectangle(150,150);
        group.getChildren().add(rectangle3);
        rectangle3.fillProperty().bind(Bindings.createObjectBinding(() -> Color.rgb(r1.get(),g1.get(),b1.get()),r1,g1,b1));
        rectangle3.setX(rectangle.getX());
        rectangle3.setY(rectangle.getHeight()+100);


        Rectangle rectangle4 = new Rectangle((rectangle3.getWidth()/2),(rectangle3.getHeight()/2));
        group.getChildren().add(rectangle4);
        rectangle4.fillProperty().bind(Bindings.createObjectBinding(() -> Color.rgb(r2.get(),g2.get(),b2.get()),r2,g2,b2));
        rectangle4.setX(rectangle3.getX());
        rectangle4.setY(rectangle3.getY());

        Rectangle rectangle5 = new Rectangle((rectangle3.getWidth()/2),(rectangle3.getHeight()/2));
        group.getChildren().add(rectangle5);
        rectangle5.fillProperty().bind(Bindings.createObjectBinding(() -> Color.rgb(r2.get(),g2.get(),b2.get()),r2,g2,b2));
        rectangle5.setX(rectangle4.getX()+rectangle4.getWidth());
        rectangle5.setY(rectangle4.getY()+rectangle4.getHeight());




        borderPane.setLeft(group);
        borderPane.setCenter(flowPane);




        Label text_dol = new Label("GUI-Projekt II,zadanie 1, s22533");
        text_dol.setFont(Font.font("Regular", FontWeight.BOLD,16));
        Background bg = new Background(new BackgroundFill(Color.GREY,
                CornerRadii.EMPTY, Insets.EMPTY));
        text_dol.setBackground(bg);
        text_dol.setMinSize(290,60);
        text_dol.setAlignment(Pos.CENTER);



        TextField rgb_txtfield1 = new TextField(("R:"+r1.getValue().toString()+ "  G:"+g1.getValue().toString()+ "  B:"+b1.getValue().toString()));
        rgb_txtfield1.setMaxWidth(130);


        r1slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

                text_dol.setText("GUI-Projekt II,zadanie 1, s22533");
                text_dol.setFont(Font.font("Regular", FontWeight.BOLD,16));
                text_dol.setTextFill(Color.rgb(r1.getValue(),g1.getValue(),b1.getValue()));
                rgb_txtfield1.setText("R:"+r1.getValue().toString()+ "  G:"+g1.getValue().toString()+ "  B:"+b1.getValue().toString());




            }
        });



        g1slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {


                text_dol.setText("GUI-Projekt II,zadanie 1, s22533");
                text_dol.setFont(Font.font("Regular", FontWeight.BOLD,16));
                text_dol.setTextFill(Color.rgb(r1.getValue(),g1.getValue(),b1.getValue()));
                rgb_txtfield1.setText("R:"+r1.getValue().toString()+ "  G:"+g1.getValue().toString()+ "  B:"+b1.getValue().toString());


            }
        });



        b1slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

                text_dol.setText("GUI-Projekt II,zadanie 1, s22533");
                text_dol.setFont(Font.font("Regular", FontWeight.BOLD,16));
                text_dol.setTextFill(Color.rgb(r1.getValue(),g1.getValue(),b1.getValue()));


                rgb_txtfield1.setText("R:"+r1.getValue().toString()+ "  G:"+g1.getValue().toString()+ "  B:"+b1.getValue().toString());


            }
        });



        TextField rgb_txtfield2 = new TextField(("R:"+r2.getValue().toString()+ "  G:"+g2.getValue().toString()+ "  B:"+b2.getValue().toString()));
        rgb_txtfield2.setMaxWidth(130);



        r2slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

                Background bg = new Background(new BackgroundFill(Color.rgb(r2.getValue(),g2.getValue(),b2.getValue()),
                        CornerRadii.EMPTY, Insets.EMPTY));
                text_dol.setBackground(bg);

                rgb_txtfield2.setText("R:"+r2.getValue().toString()+ "  G:"+g2.getValue().toString()+ "  B:"+b2.getValue().toString());


            }
        });


        g2slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

                Background bg = new Background(new BackgroundFill(Color.rgb(r2.getValue(),g2.getValue(),b2.getValue()),
                        CornerRadii.EMPTY, Insets.EMPTY));
                text_dol.setBackground(bg);
                rgb_txtfield2.setText("R:"+r2.getValue().toString()+ "  G:"+g2.getValue().toString()+ "  B:"+b2.getValue().toString());

            }
        });


        b2slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {


                Background bg = new Background(new BackgroundFill(Color.rgb(r2.getValue(),g2.getValue(),b2.getValue()),
                        CornerRadii.EMPTY, Insets.EMPTY));
                text_dol.setBackground(bg);
                rgb_txtfield2.setText("R:"+r2.getValue().toString()+ "  G:"+g2.getValue().toString()+ "  B:"+b2.getValue().toString());

            }
        });


        flowPane.getChildren().add(rgb_txtfield1);
        flowPane.getChildren().add(rgb_txtfield2);


        flowPane.getChildren().add(text_dol);

        primaryStage.getIcons().add(new Image("rsc/mr-robot-800x450.jpg"));
        primaryStage.setTitle("GUI projekt 2 - zadanie 1");
        primaryStage.setScene(new Scene(borderPane, 470, 420));
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public Slider initSlider() {
        Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(250);
        slider.setMinHeight(300);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(85);
        slider.setShowTickMarks(true);
        slider.setValue(127);

        slider.setOrientation(Orientation.VERTICAL);
        return slider;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
