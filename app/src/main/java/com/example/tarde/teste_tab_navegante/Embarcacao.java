package com.example.tarde.teste_tab_navegante;

public class Embarcacao {

    public String NomeEmbarcacao, imagem, NomeEmpresa, TipoEmbarcacao;

    public Embarcacao(){

    }

    public String getNomeEmbarcacao() {
        return NomeEmbarcacao;
    }

    public void setNomeEmbarcacao(String nomeEmbarcacao) {
        this.NomeEmbarcacao = nomeEmbarcacao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNomeEmpresa() {
        return NomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.NomeEmpresa = nomeEmpresa;
    }

    public String getTipoEmbarcacao() {
        return TipoEmbarcacao;
    }

    public void setTipoEmbarcacao(String tipoEmbarcacao) {
        this.TipoEmbarcacao = tipoEmbarcacao;
    }

    public Embarcacao(String nomeEmbarcacao, String imagem, String nomeEmpresa, String tipoEmbarcacao) {
        this.NomeEmbarcacao = nomeEmbarcacao;
        this.imagem = imagem;
        this.NomeEmpresa = nomeEmpresa;
        this.TipoEmbarcacao = tipoEmbarcacao;
    }
}
