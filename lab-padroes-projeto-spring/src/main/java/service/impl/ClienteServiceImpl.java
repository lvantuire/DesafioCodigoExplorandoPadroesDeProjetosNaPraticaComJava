package service.impl;

import model.Cliente;
import model.ClienteRepository;
import model.Endereco;
import model.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ClienteService;
import service.ViaCepService;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    //injetar os componestes do Spring com @Autowired
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() { return clienteRepository.findAll();}

    @Override
    public Cliente buscarPorId(Long id) {
    //BUSCAR POR ID
        Optional<Cliente>  cliente = clienteRepository.findById(id);
        return cliente.get();}


    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);

    }



    @Override
    public void atualizar(Long id, Cliente cliente) {
        //buscar cliente por id
        Optional<Cliente>  clienteDb = clienteRepository.findById(id);
        if (clienteDb.isPresent()) {
            salvarClienteComCep(cliente);
        }


    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }



    private void salvarClienteComCep(Cliente cliente) {
        //verificar se o endereco já existe
        String cep= cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(()-> {
            //caso não exista, integrar viaCEp
            Endereco novoendereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoendereco);
            return null;
        });
        cliente.setEndereco(endereco);
        //inserir cliente
        clienteRepository.save(cliente);
    }
}
