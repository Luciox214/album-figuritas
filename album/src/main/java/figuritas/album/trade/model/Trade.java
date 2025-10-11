package figuritas.album.trade.model;

import figuritas.album.trade.state.IEstadoIntercambio;
import figuritas.album.trade.state.TradeStateEnum;
import figuritas.album.usuario.model.Usuario;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "trades")
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creador_id", nullable = false)
    private Usuario creador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receptor_id", nullable = false)
    private Usuario receptor;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private TradeStateEnum estadoDB;

    @Transient
    private IEstadoIntercambio estado;

    @OneToMany(mappedBy = "trade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TradeItem> items = new ArrayList<>();

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "closed_at")
    private LocalDateTime closedAt;

    @PostLoad
    private void inicializarEstado() {
        if (estadoDB != null) {
            this.estado = this.estadoDB.obtenerEstado();
        }
    }

    public void ofertar() {
        this.estado.ofertar(this);
    }

    public void aceptar() {
        this.estado.aceptar(this);
    }

    public void rechazar() {
        this.estado.rechazar(this);
    }

    public void cancelar() {
        this.estado.cancelar(this);
    }

    public void cerrar() {
        this.estado.cerrar(this);
    }

    public void cambiarEstado(IEstadoIntercambio nuevoEstado) {
        this.estado = nuevoEstado;
        this.estadoDB = nuevoEstado.getEstadoEnum();
    }

    public void addItem(TradeItem item) {
        items.add(item);
        item.setTrade(this);
    }
}

