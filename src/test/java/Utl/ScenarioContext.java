package Utl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScenarioContext {
    private static ScenarioContext instance;
    private HashMap<String, Object> data;
    private ScenarioContext() {data = new HashMap<String, Object>();}
    public static ScenarioContext getInstance() {
        if (instance == null) instance = new ScenarioContext();
        return instance;
    }
    public void setContextData(String key, Object value) {
        this.data.put(key,value);
    }
    public <T> T getContextData(String key) {
        if (!this.data.containsKey(key)) throw new IllegalStateException("El elemento solicitado no se encuentra en el contexto actual");
        Object value = this.data.get(key);
        Class<T> clazz = (Class<T>) value.getClass();
        return  clazz.cast(value);
    }
    public void clearContextData() {this.data.clear();}
    public Integer step() throws ClassNotFoundException {
        if (!data.containsKey("step")) setContextData("step",0);
        setContextData("step",(Integer) getContextData("step")+1);
        return (Integer) getContextData("step");
    }
    public String getEnvVariable(String key) throws Exception{
        HashMap<String,String> env = (HashMap<String, String>) this.data.get("env");
        if (!env.containsKey(key)) throw new Exception("Variable de entorno no existe");
        return env.get(key);
    }
}
