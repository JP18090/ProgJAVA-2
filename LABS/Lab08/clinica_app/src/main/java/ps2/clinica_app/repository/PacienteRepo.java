package ps2.clinica_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ps2.clinica_app.model.Paciente;
import java.util.List;

public interface PacienteRepo extends JpaRepository<Paciente, Long> {
    List<Paciente> findByNomeContainingIgnoreCase(String nome);
}
