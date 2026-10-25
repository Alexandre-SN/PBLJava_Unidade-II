package model;

public class Config {
    private String color;
    private String save;
    private String intervalo;

    public Config(){};

    public Config(String cor,String save, String periodo){
        this.color = cor;
        this.save = save;
        this.intervalo = periodo;
    }

    public void changeColor(String newcolor){
        this.color = newcolor;
    }

    public void changeSave(String newsave){
        this.save = newsave;
    }

    public void changeIntervalo(String newintervalo){
        this.intervalo = newintervalo;
    }

    public String getColor() {
        return this.color;
    }
    public String getsave() {
        return this.save;
    }
    public String getIntervalo() {
        return this.intervalo;
    }

    public void executeColor(){
        if (this.getColor().equals("1")) {
            System.out.println("\u001B[31m");
        }
        else{
            System.out.println("\u001B[0m");
        }
    }
}



