package figuritas.album.trade.state;

public enum TradeStateEnum {
    CREADO {
        @Override
        public IEstadoIntercambio obtenerEstado() {
            return new Creado();
        }
    },
    ACEPTADO {
        @Override
        public IEstadoIntercambio obtenerEstado() {
            return new Aceptado();
        }
    },
    RECHAZADO {
        @Override
        public IEstadoIntercambio obtenerEstado() {
            return new Rechazado();
        }
    },
    CANCELADO {
        @Override
        public IEstadoIntercambio obtenerEstado() {
            return new Cancelado();
        }
    },
    CERRADO{
        @Override
        public IEstadoIntercambio obtenerEstado() {
            return new Cerrado();
        }

    },
    OFERTADO{
        @Override
        public IEstadoIntercambio obtenerEstado() {
            return new Ofertado();
        }

    };

    public abstract IEstadoIntercambio obtenerEstado();
}

