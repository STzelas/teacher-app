package gr.aueb.cf.teacher.teacherapp.core.exceptions;

public class AppServerException extends EntityGenericException {

    public AppServerException(String code, String message){
        super(code, message);

    }
}
