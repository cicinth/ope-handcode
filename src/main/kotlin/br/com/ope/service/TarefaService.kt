package br.com.ope.service

import br.com.ope.model.Tarefa
import br.com.ope.repository.TarefaRepository
import org.springframework.stereotype.Service

@Service
class TarefaService(val entregaService: EntregaService, 
                    val tarefaRepository: TarefaRepository) {


    fun criarNovaTarefaEGerarEntregas(tarefa: Tarefa) : Tarefa {

        tarefaRepository.save(tarefa)

        val entregasList = entregaService.gerarEntregasDaTarefa(tarefa)

        entregaService.salvar(entregas = entregasList)
        
        return tarefa
    }


}