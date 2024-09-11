package gianlucamessina.BE_U2_S2_L3_springWebData.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
