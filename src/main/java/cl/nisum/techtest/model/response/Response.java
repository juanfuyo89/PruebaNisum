package cl.nisum.techtest.model.response;

/**
 * Clase que modela una respuesta con un mensaje al cliente Rest
 */
public class Response {

    public static final String EMAIL_ERROR_MSG = "Formato de email incorrecto";
    public static final String PASSWORD_ERROR_MSG = "Formato de contraseña incorrecto";
    public static final String EMAIL_ALREADY_EXISTS_MSG = "El correo ya registrado";
    public static final String GENERAL_ERR_MSG = "Error interno, intentelo mas tarde";
    public static final String OK_MSG = "OK";

    private static Response instanceToReturn;
    private String responseMessage;

    /**
     * Constructor privado para implementar el patron Singleton
     *
     * @param responseMessage
     */
    private Response(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Response(){

    }
    /**
     * Metodo para obtener la unica instancia en memoria
     *
     * @param msg
     * @return
     */
    public static Response getIntance(String msg) {
        if (instanceToReturn == null) {
            instanceToReturn = new Response(msg);
        } else {
            instanceToReturn.setResponseMessage(msg);
        }
        return instanceToReturn;
    }

    /**
     * @return the responseMessage
     */
    public String getResponseMessage() {
        return responseMessage;
    }

    /**
     * @param responseMessage
     *            the responseMessage to set
     */
    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

}