package br.com.gerenciador.modelo;

import java.util.ArrayList;
import java.util.List;


public class Banco {
    private static List<Empresa> lista = new ArrayList<>();
    private static Integer chaveSequencial = 1;

    static {
        User usuario = new User("isaczin", "123");
        Empresa empresa = new Empresa();
        empresa.setId(chaveSequencial++);
        empresa.setNome("Alura");
        empresa.setUsuario(usuario);
        Empresa empresa2 = new Empresa();
        empresa2.setId(chaveSequencial++);
        empresa2.setNome("Coelum");
        lista.add(empresa);
        lista.add(empresa2);
    }

    public synchronized void adiciona(Empresa empresa) {
        empresa.setId(chaveSequencial++);
        lista.add(empresa);
    }

    public synchronized void remover(Integer id) {
        lista.removeIf(empresa -> empresa.getId().equals(id));
    }

    public List<Empresa> getEmpresas() {
        return new ArrayList<>(lista);
    }

    public Empresa buscaEmpresaPorId(Integer id) {
        for (Empresa empresa : lista) {
            if (empresa.getId().equals(id)) {
                return empresa;
            }
        }
        return null;
    }
}
