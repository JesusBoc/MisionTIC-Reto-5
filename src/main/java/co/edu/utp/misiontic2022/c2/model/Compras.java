package co.edu.utp.misiontic2022.c2.model;

public class Compras {
    private Integer id;
    private String constructora;
    private String bancoVinculado;

    

    public Compras(Integer id, String constructora, String bancoVinculado) {
        this.id = id;
        this.constructora = constructora;
        this.bancoVinculado = bancoVinculado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConstructora() {
        return constructora;
    }

    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }

    public String getBancoVinculado() {
        return bancoVinculado;
    }

    public void setBancoVinculado(String bancoVinculado) {
        this.bancoVinculado = bancoVinculado;
    }
    
    
}
