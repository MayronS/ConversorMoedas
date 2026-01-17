package br.com.desafio.conversorMoedas.api;

public class ExchangeRate {
    private String moedaIncial;
    private String moedaFinal;

    public String api(){
        return "https://v6.exchangerate-api.com/v6/5315d46f760680655c57ba6apair/" + moedaIncial + "/" + moedaFinal;
    }


    public void setMoedaIncial(String moedaIncial) {
        this.moedaIncial = moedaIncial;
    }

    public void setMoedaFinal(String moedaFinal) {
        this.moedaFinal = moedaFinal;
    }

    public String getMoedaFinal() {
        return moedaFinal;
    }

    public String getMoedaIncial() {
        return moedaIncial;
    }
}
