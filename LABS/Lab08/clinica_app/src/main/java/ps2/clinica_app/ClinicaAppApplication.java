package ps2.clinica_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import static ps2.clinica_app.ES.*;

import ps2.clinica_app.model.*;
import ps2.clinica_app.repository.*;

import java.util.Optional;

@SpringBootApplication
public class ClinicaAppApplication implements CommandLineRunner {

    @Autowired
    private MedicoRepo medicoRepo;

    @Autowired
    private PacienteRepo pacienteRepo;

    @Autowired
    private ProntuarioRepo prontuarioRepo;

    public static void main(String[] args) {
        SpringApplication.run(ClinicaAppApplication.class, args);
    }

    // ======= MÉDICO =======
    private void criarMedico() {
        Medico m = new Medico();
        m.setNome(input("Nome do médico: "));
        m.setEspecialidade(input("Especialidade: "));
        medicoRepo.save(m);
        print("Médico criado com ID " + m.getId());
    }

    private void listarMedicos() {
        medicoRepo.findAll().forEach(System.out::println);
    }

    private void buscarMedico() {
        String nome = input("Nome do médico: ");
        medicoRepo.findByNomeContainingIgnoreCase(nome).forEach(System.out::println);
    }

    private void alterarMedico() {
        Long id = Long.parseLong(input("ID do médico a alterar: "));
        Optional<Medico> opt = medicoRepo.findById(id);
        if (opt.isPresent()) {
            Medico m = opt.get();
            m.setNome(input("Novo nome: "));
            m.setEspecialidade(input("Nova especialidade: "));
            medicoRepo.save(m);
            print("Médico atualizado!");
        } else print("Médico não encontrado.");
    }

    private void apagarMedico() {
        Long id = Long.parseLong(input("ID do médico a apagar: "));
        medicoRepo.deleteById(id);
        print("Médico removido!");
    }

    // ======= PACIENTE =======
    private void criarPaciente() {
        Paciente p = new Paciente();
        p.setNome(input("Nome do paciente: "));
        p.setIdade(Integer.parseInt(input("Idade: ")));
        pacienteRepo.save(p);
        print("Paciente criado com ID " + p.getId());
    }

    private void listarPacientes() {
        pacienteRepo.findAll().forEach(System.out::println);
    }

    private void buscarPaciente() {
        String nome = input("Nome do paciente: ");
        pacienteRepo.findByNomeContainingIgnoreCase(nome).forEach(System.out::println);
    }

    private void alterarPaciente() {
        Long id = Long.parseLong(input("ID do paciente a alterar: "));
        Optional<Paciente> opt = pacienteRepo.findById(id);
        if (opt.isPresent()) {
            Paciente p = opt.get();
            p.setNome(input("Novo nome: "));
            p.setIdade(Integer.parseInt(input("Nova idade: ")));
            pacienteRepo.save(p);
            print("Paciente atualizado!");
        } else print("Paciente não encontrado.");
    }

    private void apagarPaciente() {
        Long id = Long.parseLong(input("ID do paciente a apagar: "));
        pacienteRepo.deleteById(id);
        print("Paciente removido!");
    }

    // ======= PRONTUÁRIO =======
    private void criarProntuario() {
        Prontuario pr = new Prontuario();
        pr.setDescricao(input("Descrição: "));
        pr.setData(input("Data (dd/mm/aaaa): "));
        prontuarioRepo.save(pr);
        print("Prontuário criado com ID " + pr.getId());
    }

    private void listarProntuarios() {
        prontuarioRepo.findAll().forEach(System.out::println);
    }

    private void buscarProntuario() {
        String desc = input("Descrição do prontuário: ");
        prontuarioRepo.findByDescricaoContainingIgnoreCase(desc).forEach(System.out::println);
    }

    private void alterarProntuario() {
        Long id = Long.parseLong(input("ID do prontuário a alterar: "));
        Optional<Prontuario> opt = prontuarioRepo.findById(id);
        if (opt.isPresent()) {
            Prontuario pr = opt.get();
            pr.setDescricao(input("Nova descrição: "));
            pr.setData(input("Nova data: "));
            prontuarioRepo.save(pr);
            print("Prontuário atualizado!");
        } else print("Prontuário não encontrado.");
    }

    private void apagarProntuario() {
        Long id = Long.parseLong(input("ID do prontuário a apagar: "));
        prontuarioRepo.deleteById(id);
        print("Prontuário removido!");
    }

    // ======= MENUS =======
    private void menuMedico() {
        boolean voltar = false;
        while (!voltar) {
            String op = input("""
                \n--- Menu Médico ---
                (1) Listar todos
                (2) Buscar por nome
                (3) Criar novo
                (4) Alterar
                (5) Apagar
                (0) Voltar
                Opção: """);
            switch (op) {
                case "1" -> listarMedicos();
                case "2" -> buscarMedico();
                case "3" -> criarMedico();
                case "4" -> alterarMedico();
                case "5" -> apagarMedico();
                case "0" -> voltar = true;
                default -> print("Opção inválida!");
            }
        }
    }

    private void menuPaciente() {
        boolean voltar = false;
        while (!voltar) {
            String op = input("""
                \n--- Menu Paciente ---
                (1) Listar todos
                (2) Buscar por nome
                (3) Criar novo
                (4) Alterar
                (5) Apagar
                (0) Voltar
                Opção: """);
            switch (op) {
                case "1" -> listarPacientes();
                case "2" -> buscarPaciente();
                case "3" -> criarPaciente();
                case "4" -> alterarPaciente();
                case "5" -> apagarPaciente();
                case "0" -> voltar = true;
                default -> print("Opção inválida!");
            }
        }
    }

    private void menuProntuario() {
        boolean voltar = false;
        while (!voltar) {
            String op = input("""
                \n--- Menu Prontuário ---
                (1) Listar todos
                (2) Buscar por descrição
                (3) Criar novo
                (4) Alterar
                (5) Apagar
                (0) Voltar
                Opção: """);
            switch (op) {
                case "1" -> listarProntuarios();
                case "2" -> buscarProntuario();
                case "3" -> criarProntuario();
                case "4" -> alterarProntuario();
                case "5" -> apagarProntuario();
                case "0" -> voltar = true;
                default -> print("Opção inválida!");
            }
        }
    }

    @Override
    public void run(String... args) {
        print("# GERENCIADOR DE CLÍNICA #");
        boolean sair = false;

        while (!sair) {
            String op = input("""
                \n=== MENU PRINCIPAL ===
                (1) Médicos
                (2) Pacientes
                (3) Prontuários
                (0) Sair
                Escolha uma opção: """);
            switch (op) {
                case "1" -> menuMedico();
                case "2" -> menuPaciente();
                case "3" -> menuProntuario();
                case "0" -> sair = true;
                default -> print("Opção inválida!");
            }
        }
        print("Sistema encerrado.");
    }
}
