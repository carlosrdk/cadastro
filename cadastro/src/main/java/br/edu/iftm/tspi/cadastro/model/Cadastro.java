package br.edu.iftm.tspi.cadastro.model;

public class Cadastro {
    
    private Long id;
    private String inputNome;
    private String inputEmail;
    private String inputEndereco;
    private String inputTelefone;

    
    public Cadastro(Long id, String inputNome, String inputEmail, String inputEndereco, String inputTelefone) {
        this.id = id;
        this.inputNome = inputNome;
        this.inputEmail = inputEmail;
        this.inputEndereco = inputEndereco;
        this.inputTelefone = inputTelefone;
    }

    public Cadastro(){
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getInputNome() {
        return inputNome;
    }
    public void setInputNome(String inputNome) {
        this.inputNome = inputNome;
    }
    public String getInputEmail() {
        return inputEmail;
    }
    public void setInputEmail(String inputEmail) {
        this.inputEmail = inputEmail;
    }
    public String getInputEndereco() {
        return inputEndereco;
    }
    public void setInputEndereco(String inputEndereco) {
        this.inputEndereco = inputEndereco;
    }
    public String getInputTelefone() {
        return inputTelefone;
    }
    public void setInputTelefone(String inputTelefone) {
        this.inputTelefone = inputTelefone;
    }


}
