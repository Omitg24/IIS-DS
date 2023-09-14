package slides.main;

import java.io.*;

import slides.content.*;
import slides.layout.*;
import slides.layout.layouttypes.GridLayout;
import slides.layout.layouttypes.NormalLayout;
import slides.model.*;
import slides.ui.Menu;

public class Main 
{
    private Presentation presentation;
    private Menu menu;

    public static void main(final String[] args) throws Exception
    {
        new Main().run(args);
    }

    private void run(String[] args) throws IOException
    {
        setUp();
		menu = new Menu(presentation);
        menu.run();
    }
    
    private void setUp() throws IOException
    {
        //config1();
        config2();
    }


    void config1()
    {
        presentation = new Presentation("Presentación en blanco");
    }

    void config2()
    {
        presentation = new Presentation("Presentación con diseños predefinidos");
        
        // Se crean tres diseños:

        // 1. Uno basado en un layout NORMAL, que tiene un único marcador de título
        Layout titleLayout = new Layout(new NormalLayout());
        titleLayout.addPlaceholder("CENTER", new Title());

        // 2. Otro con un título arriba y una lista de viñetas abajo
        //    (también basado en un layout NORMAL)
        Layout titleAndContentLayout = new Layout(new NormalLayout());
        titleAndContentLayout.addPlaceholder("TOP", new Title());
        titleAndContentLayout.addPlaceholder("BOTTOM", new Bullets());

        // 3. Por último, otro que represente una diapositiva con un título arriba
        //    y dos marcadores abajo: una lista en la parte inferior izquierda y
        //    una imagen en la inferior derecha; el layout será, por tanto, de
        //    tipo GRID
        Layout titleBulletsAndPictureLayout = new Layout(new GridLayout());
        titleBulletsAndPictureLayout.addPlaceholder("TOP", new Title());
        titleBulletsAndPictureLayout.addPlaceholder("BOTTOM_LEFT", new Bullets());
        titleBulletsAndPictureLayout.addPlaceholder("BOTTOM_RIGHT", new Image());
        
        // Ahora hay que añadirlos a la presentación como diseños predefinidos,
        // para poder crear nuevas diapositivas a partir de ellos. Darles los
        // siguientes nombres para poder elegirlos desde la interfaz de usuario:
        // 1. Título
        // 2. Título y viñetas
        // 3. Título, viñetas y foto 
        presentation.addMasterLayout("Titulo", titleLayout.clone());
        presentation.addMasterLayout("Titulo y viñetas", titleAndContentLayout.clone());
        presentation.addMasterLayout("Titulo, viñetas y foto", titleBulletsAndPictureLayout.clone());
        
        // TODO: Añadir los diseños creados como diseños predefinidos de la presentación
        // ...
    }
}