package bean;

public class CamelStringModifyBean {

    public String map(String input){
        return input.replace(",", "*");
    }
}
