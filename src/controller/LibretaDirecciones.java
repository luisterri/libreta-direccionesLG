/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author dam
 */
public class LibretaDirecciones extends Application {
     private Stage escenarioPrincipal;
     private BorderPane layoutPrincipal;
     private AnchorPane vistaPersona;
    @Override
    public void start(Stage escenarioPrincipal) {
 
        
        this.escenarioPrincipal = escenarioPrincipal;
        //Para que esto funcione, no puedo trabajar directa/ con eP, lo hacemos así
        this.escenarioPrincipal.setTitle("Libreta de direcciones");
        //Ahora llamo a dos métodos que tengo que crear
        initLayoutPrincipal();
        //Muestra la vista persona.
        muestraVistaPersona();
        
     
    }
    
    //Estos métodos tienen que ser PÚBLICOS porque lo usan los controladores
    public void initLayoutPrincipal(){
        //HAY QUE HACER ESTOS 4 PASOS PARA CARGAR LA ESCENA
        //Cargo el layout principal a partir de la vista VistaPrincipal.fxml
        //PASO 1
        FXMLLoader loader = new FXMLLoader();
        //PASO 2
        URL location = LibretaDirecciones.class.getResource("../view/vistaPrincipal.fxml");
        //PASO 3
        loader.setLocation(location);
        //PASO 4
         try {
             layoutPrincipal = loader.load();
         } catch (IOException ex) {
             Logger.getLogger(LibretaDirecciones.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         //Cargo y muestro la escena que contiene ese layout principal
         Scene escena = new Scene(layoutPrincipal);
         //Ponemos la escena y la mostramos:
         escenarioPrincipal.setScene(escena);
         escenarioPrincipal.show();
         
    }
    
    public void muestraVistaPersona(){
        //Aquí meto todo lo que está en un panel
        FXMLLoader loader = new FXMLLoader();
         
        URL location = LibretaDirecciones.class.getResource("../view/viewPersona.fxml");
         loader.setLocation(location);
        
         try {
             vistaPersona = loader.load();
         } catch (IOException ex) {
             Logger.getLogger(LibretaDirecciones.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         layoutPrincipal.setCenter(vistaPersona);
    }
    
    public Stage getPrimaryStage(){
        return escenarioPrincipal;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
