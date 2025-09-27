package ps2.clinica_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ps2.clinica_app.model.Medico;
import java.util.List;

public interface MedicoRepo extends JpaRepository<Medico, Long> {
    List<Medico> findByNomeContainingIgnoreCase(String nome);
}
