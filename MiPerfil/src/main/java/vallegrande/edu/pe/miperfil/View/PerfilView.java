package vallegrande.edu.pe.miperfil.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PerfilView {
    private VBox contenedor;
    private Label titulo;
    private TextField txtNombre;
    private TextField txtCarrera;
    private TextField txtSemestre;
    private TextField txtDatoAdicional;
    private Button btnMostrar;
    private Button btnLimpiar;
    private Label lblResultado;

    public PerfilView(){
        titulo = new Label("MI PERFIL");
        titulo.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        titulo.setStyle("-fx-text-fill: #2b579a;");

        txtNombre = new TextField();
        txtNombre.setPromptText("Ingrese su nombre completo");

        txtCarrera = new TextField();
        txtCarrera.setPromptText("Ingrese su carrera profesional");

        txtSemestre = new TextField();
        txtSemestre.setPromptText("Ingrese su semestre académico");

        txtDatoAdicional = new TextField();
        txtDatoAdicional.setPromptText("Dato adicional (hobby, videojuego, meta...)");

        for (TextField tf : new TextField[]{txtNombre, txtCarrera, txtSemestre, txtDatoAdicional}) {
            tf.setStyle("-fx-padding: 6; -fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: #cccccc;");
        }

        btnMostrar = new Button("Mostrar Perfil");
        btnMostrar.setStyle("-fx-background-color: #2b579a; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 5;");

        btnLimpiar = new Button("Limpiar");
        btnLimpiar.setStyle("-fx-background-color: #e0e0e0; -fx-text-fill: #333333; -fx-font-weight: bold; -fx-background-radius: 5;");

        HBox botones = new HBox(10, btnMostrar, btnLimpiar);
        botones.setAlignment(Pos.CENTER);

        lblResultado = new Label();
        lblResultado.setWrapText(true);
        lblResultado.setStyle("-fx-font-size: 14px; -fx-text-fill: #333333;");

        contenedor = new VBox(12);
        contenedor.setPadding(new Insets(25));
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setStyle("-fx-background-color: #f5f7fa;");
        contenedor.getChildren().addAll(
                titulo,
                txtNombre,
                txtCarrera,
                txtSemestre,
                txtDatoAdicional,
                botones,
                lblResultado
        );
    }

    public VBox getContenedor(){
        return contenedor;
    }
    public TextField getTxtNombre(){
        return txtNombre;
    }
    public TextField getTxtCarrera(){
        return txtCarrera;
    }
    public TextField getTxtSemestre(){
        return txtSemestre;
    }
    public TextField getTxtDatoAdicional(){
        return txtDatoAdicional;
    }
    public Button getBtnMostrar(){
        return btnMostrar;
    }
    public Button getBtnLimpiar(){
        return btnLimpiar;
    }
    public Label getLblResultado(){
        return lblResultado;
    }
}