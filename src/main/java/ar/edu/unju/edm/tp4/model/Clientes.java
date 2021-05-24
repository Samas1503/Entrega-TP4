package ar.edu.unju.edm.tp4.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "CLIENTES")
@Component
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idUsuario;

    @Column
    private int nroDocumento;

    @Column
    private int edad;

    @Column
    private int codAreaTelefono;

    @Column
    private int nroTelefono;

    @Column
    private String nombreApellido;

    @Column
    private String email;

    @Column
    private String tipoDoc;

    @Column
    private String password;

    @Column
    private String datos;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNac;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaUltimaCompra;

    public Clientes() {
    }

    public Clientes(Integer idUsuario, int nroDocumento, int edad, int codAreaTelefono, int nroTelefono,
            String nombreApellido, String email, String tipoDoc, String password, String datos, LocalDate fechaNac,
            LocalDate fechaUltimaCompra) {
        this.idUsuario = idUsuario;
        this.nroDocumento = nroDocumento;
        this.edad = edad;
        this.codAreaTelefono = codAreaTelefono;
        this.nroTelefono = nroTelefono;
        this.nombreApellido = nombreApellido;
        this.email = email;
        this.tipoDoc = tipoDoc;
        this.password = password;
        this.datos = datos;
        this.fechaNac = fechaNac;
        this.fechaUltimaCompra = fechaUltimaCompra;
    }
    @Override
    public String toString() {
        return "Clientes [codAreaTelefono=" + codAreaTelefono + ", " + (datos != null ? "datos=" + datos + ", " : "")
                + "edad=" + edad + ", " + (email != null ? "email=" + email + ", " : "")
                + (fechaNac != null ? "fechaNac=" + fechaNac + ", " : "")
                + (fechaUltimaCompra != null ? "fechaUltimaCompra=" + fechaUltimaCompra + ", " : "")
                + (idUsuario != null ? "idUsuario=" + idUsuario + ", " : "")
                + (nombreApellido != null ? "nombreApellido=" + nombreApellido + ", " : "") + "nroDocumento="
                + nroDocumento + ", nroTelefono=" + nroTelefono + ", "
                + (password != null ? "password=" + password + ", " : "")
                + (tipoDoc != null ? "tipoDoc=" + tipoDoc : "") + "]";
    }
    public Integer getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(int nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCodAreaTelefono() {
        return codAreaTelefono;
    }

    public void setCodAreaTelefono(int codAreaTelefono) {
        this.codAreaTelefono = codAreaTelefono;
    }

    public int getNroTelefono() {
        return nroTelefono;
    }

    public void setNroTelefono(int nroTelefono) {
        this.nroTelefono = nroTelefono;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public LocalDate getFechaUltimaCompra() {
        return fechaUltimaCompra;
    }

    public void setFechaUltimaCompra(LocalDate fechaUltimaCompra) {
        this.fechaUltimaCompra = fechaUltimaCompra;
    }    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codAreaTelefono;
        result = prime * result + ((datos == null) ? 0 : datos.hashCode());
        result = prime * result + edad;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((fechaNac == null) ? 0 : fechaNac.hashCode());
        result = prime * result + ((fechaUltimaCompra == null) ? 0 : fechaUltimaCompra.hashCode());
        result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
        result = prime * result + ((nombreApellido == null) ? 0 : nombreApellido.hashCode());
        result = prime * result + nroDocumento;
        result = prime * result + nroTelefono;
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((tipoDoc == null) ? 0 : tipoDoc.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) obj;
        if (codAreaTelefono != other.codAreaTelefono) {
            return false;
        }
        if (datos == null) {
            if (other.datos != null) {
                return false;
            }
        } else if (!datos.equals(other.datos)) {
            return false;
        }
        if (edad != other.edad) {
            return false;
        }
        if (email == null) {
            if (other.email != null) {
                return false;
            }
        } else if (!email.equals(other.email)) {
            return false;
        }
        if (fechaNac == null) {
            if (other.fechaNac != null) {
                return false;
            }
        } else if (!fechaNac.equals(other.fechaNac)) {
            return false;
        }
        if (fechaUltimaCompra == null) {
            if (other.fechaUltimaCompra != null) {
                return false;
            }
        } else if (!fechaUltimaCompra.equals(other.fechaUltimaCompra)) {
            return false;
        }
        if (idUsuario == null) {
            if (other.idUsuario != null) {
                return false;
            }
        } else if (!idUsuario.equals(other.idUsuario)) {
            return false;
        }
        if (nombreApellido == null) {
            if (other.nombreApellido != null) {
                return false;
            }
        } else if (!nombreApellido.equals(other.nombreApellido)) {
            return false;
        }
        if (nroDocumento != other.nroDocumento) {
            return false;
        }
        if (nroTelefono != other.nroTelefono) {
            return false;
        }
        if (password == null) {
            if (other.password != null) {
                return false;
            }
        } else if (!password.equals(other.password)) {
            return false;
        }
        if (tipoDoc == null) {
            if (other.tipoDoc != null) {
                return false;
            }
        } else if (!tipoDoc.equals(other.tipoDoc)) {
            return false;
        }
        return true;
    }
}
