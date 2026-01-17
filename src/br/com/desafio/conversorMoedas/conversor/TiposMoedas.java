package br.com.desafio.conversorMoedas.conversor;

import br.com.desafio.conversorMoedas.api.ExchangeRate;

public class TiposMoedas {
    private String moeda;

    public void moedas(String moeda){
        this.moeda = moeda;
    }

    public TiposMoedas(){

    }
    public void tipos(ExchangeRate exchangeRate){
        if(moeda.equals("1")){
            exchangeRate.setMoedaFinal("ARS");
            exchangeRate.setMoedaIncial("USD");
        }
        else if(moeda.equals("2")){
            exchangeRate.setMoedaFinal("USD");
            exchangeRate.setMoedaIncial("ARS");
        }
        else if(moeda.equals("3")){
            exchangeRate.setMoedaFinal("USD");
            exchangeRate.setMoedaIncial("BRL");
        }
        else if(moeda.equals("4")){
            exchangeRate.setMoedaFinal("BRL");
            exchangeRate.setMoedaIncial("USD");
        }
        else if(moeda.equals("5")){
            exchangeRate.setMoedaFinal("USD");
            exchangeRate.setMoedaIncial("COP");
        }
        else if(moeda.equals("6")){
            exchangeRate.setMoedaFinal("COP");
            exchangeRate.setMoedaIncial("USD");
        }
    }

}
