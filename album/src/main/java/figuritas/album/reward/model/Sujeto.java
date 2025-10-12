package figuritas.album.reward.model;


import figuritas.album.reward.state.IObserver;

import java.util.ArrayList;
import java.util.List;

public class Sujeto {

    private final List<IObserver> observadores = new ArrayList<>();

    public void agregarObservador(IObserver observador) {
        observadores.add(observador);
    }

    public void removerObservador(IObserver observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores(UserReward userReward) {
        for (IObserver observador : observadores) {
            observador.actualizar(userReward);
        }
    }
}

