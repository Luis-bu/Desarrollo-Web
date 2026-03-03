package co.javeriana.dw.thymeleaf.Miembros;

public class Member {

    private int codigo;
    private String nombreVisible;
    private String cargo;
    private String correoContacto;

    public Member(int codigo, String nombreVisible, String cargo, String correoContacto) {
        this.codigo = codigo;
        this.nombreVisible = nombreVisible;
        this.cargo = cargo;
        this.correoContacto = correoContacto;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombreVisible() {
        return nombreVisible;
    }

    public String getCargo() {
        return cargo;
    }

    public String getCorreoContacto() {
        return correoContacto;
    }
}
