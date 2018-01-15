
package view;

import controller.LibretaDirecciones;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class vistaPersonaController {
    //Pulsar ctrl+shift+i y se importa todos los @FXML
    @FXML
    private TableView tablaPersonas;//Se asocia con la tabla de viewPersona.fxml
    @FXML
    private TableColumn nombreColumn;//Se asocia con el nombre de la tabla de viewPersona.fxml
    @FXML
    private TableColumn apellidosColumn;//Se asocia con los apellidos de la tabla de viewPersona.fxml
    @FXML
    private Label nombreLabel;
    @FXML
    private Label apellidosLabel;
    @FXML
    private Label direccionLabel;
    @FXML
    private Label codigoPostalLabel;
    @FXML
    private Label ciudadLabel;
    @FXML
    private Label fechaDeNacimientoLabel;

    // Referencia a la clase principal
    private LibretaDirecciones libretaDirecciones;
    
    //El constructor es llamado ANTES del método initialize
    public vistaPersonaController(){
    }

    //Inicializa la clase controller y es llamado justo después de cargar el archivo FXML
    @FXML
    private void initialize() {

//        //Inicializo la tabla con las dos primera columnas
//        nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
//        apellidosColumn.setCellValueFactory(cellData -> cellData.getValue().apellidosProperty());
//CON EXPRESIÓN LANDA ME DA ERROR, CAMBIAMOS EL CÓDIGO Y HACEMOS ESTO:
        String nombre = "nombre";
        String apellidos = "apellidos";
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>(nombre));
        apellidosColumn.setCellValueFactory(new PropertyValueFactory<>(apellidos));

    }
    
    //Es llamado por la apliación principal para tener una referencia de vuelta de si mismo
    public void setLibretaDirecciones(LibretaDirecciones libretaDirecciones) {
        
        this.libretaDirecciones = libretaDirecciones;

        //Añado la lista obervable a la tabla
           tablaPersonas.setItems(libretaDirecciones.getDatosPersona());
    }
}
