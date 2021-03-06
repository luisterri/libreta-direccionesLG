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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Persona;
import view.vistaPersonaController;

/**
 *
 * @author dam
 */
public class LibretaDirecciones extends Application {
    //Novedades clase 10/01/2018
     private ObservableList datosPersona = FXCollections.observableArrayList();
     private Stage escenarioPrincipal;
     private BorderPane layoutPrincipal;
     private AnchorPane vistaPersona;
     
     //Vamos a crear un oonstructor
     public LibretaDirecciones(){
         
         datosPersona.add(new Persona("·Jairo", "García Rincón"));
         datosPersona.add(new Persona("Andrea", "Chenier Lopez"));
         datosPersona.add(new Persona("Pol", "Jobs"));
         datosPersona.add(new Persona("Mónica", "de Santos Sánchez"));
         datosPersona.add(new Persona("Jesús","Ruano Martínez"));

     }
     
      //Método para devolver los datos como lista observable de personas
    public ObservableList getDatosPersona() {
        return datosPersona;
    }
    
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
        
           //Doy acceso al controlador VistaPersonaCOntroller a LibretaDirecciones
        vistaPersonaController controller = loader.getController();
        controller.setLibretaDirecciones(this);
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
