package gianlucamessina.BE_U2_S2_L3_springWebData.exceptions;

import java.util.UUID;

public class NotFoundException extends  RuntimeException{
    public NotFoundException(UUID id){
        super("record con ID: "+id+" non trovato!");
    }
}
