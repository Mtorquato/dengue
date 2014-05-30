/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dengue.modelo;

/**
 *
 * @author Higor
 */
public class Dados {

    private int id;
    private String latitude;
    private String longitude;
    private String dados;
    private int resolvido;
    private String icone;

    public Dados() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }

    public int getResolvido() {
        return resolvido;
    }

    public void setResolvido(int resolvido) {
        this.resolvido = resolvido;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

}
