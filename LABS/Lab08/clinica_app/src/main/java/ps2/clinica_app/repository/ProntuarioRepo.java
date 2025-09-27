package ps2.clinica_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ps2.clinica_app.model.Prontuario;
import java.util.List;

public interface ProntuarioRepo extends JpaRepository<Prontuario, Long> {
    List<Prontuario> findByDescricaoContainingIgnoreCase(String descricao);
}
