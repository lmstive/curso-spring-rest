package com.algaworks.algafood.di.notificacao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Profile("dev")
@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
@Component
public class NotificadorEmailMock implements Notificador {

	public NotificadorEmailMock() {
		System.out.println("Notificador Email MOCK");
	}

	@Value("${notificador.email.host-servidor}")
	private String host;
	@Value("${notificador.email.porta-servidor}")
	private Integer porta;

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.println("Host: " + host);
		System.out.println("Porta: " + porta);

		System.out.printf("MOCK: Notificando seria enviada para %s através do e-mail %s: %s\n", cliente.getNome(),
				cliente.getEmail(), mensagem);
	}

}
