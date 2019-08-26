package br.com.folgas.entity;

public class Colaborador {

    private Integer cod_funcionario;

    private String nome;
    private String login;

    public String getLoginConfirmacao() {
        return loginConfirmacao;
    }

    public void setLoginConfirmacao(String loginConfirmacao) {
        this.loginConfirmacao = loginConfirmacao;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    private String loginConfirmacao;
    private String senha;
    private String perfil;

    public Integer getCod_funcionario() {
        return cod_funcionario;
    }

    public void setCod_funcionario(Integer cod_funcionario) {
        this.cod_funcionario = cod_funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
