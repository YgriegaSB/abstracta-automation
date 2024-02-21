package Page.ExceptionPage;

public class ExceptionWithoutTrace extends RuntimeException {
    private String mensaje;
    public ExceptionWithoutTrace(String mensaje){
        this.mensaje = mensaje;
    }
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
    @Override
    public String getMessage() {return mensaje;}
}
