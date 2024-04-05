package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<FormaPagamento> listar(){
        return manager.createQuery("From FormaPagamento", FormaPagamento.class)
                .getResultList();
    }

    @Override
    public FormaPagamento buscar(Long id){
        return manager.find(FormaPagamento.class, id);
    }

    @Transactional
    @Override
    public FormaPagamento salvar(FormaPagamento formaPagamento){
        return manager.merge(formaPagamento);
    }

    @Transactional
	@Override
	public void remover(FormaPagamento formaPagamento) {
    	formaPagamento = buscar(formaPagamento.getId());
    	manager.remove(formaPagamento);
		
	}

}
