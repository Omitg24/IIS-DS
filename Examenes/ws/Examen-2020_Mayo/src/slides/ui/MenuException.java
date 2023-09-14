package slides.ui;

/*
 * Representa una excepción en la interfaz de usuario. La lanzan algunas
 * comprobaciones que se realizan en las operaciones del menú para evitar
 * situaciones que no deberían darse.
 */
public class MenuException extends RuntimeException
{
   private static final long serialVersionUID = 1L;

   public MenuException(String message)
   {
       super(message);
   }
}