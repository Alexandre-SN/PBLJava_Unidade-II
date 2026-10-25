package repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Config;
import model.Conquista;

import java.io.File;
import java.io.IOException;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class SaveRepository {
    ObjectMapper mapper = new ObjectMapper();

    public SaveRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public <E> E readFile(String caminho, Class<E> classe, E padrao) {

        try {
            return mapper.readValue(new File(caminho), classe);
        } catch (IOException error) {
            System.err.println("Erro ao ler o arquivo: " + error.getMessage());
            return padrao;
        }
    }

    public boolean existe(String caminho) {
        return new File(caminho).exists();
    }

    public <E> boolean writeFile(String caminho, E objeto){
        Path destino = Path.of(caminho).toAbsolutePath();
        Path temp = null;
        try {
            Files.createDirectories(destino.getParent());
            temp = Files.createTempFile(destino.getParent(), destino.getFileName().toString(), ".tmp");
            mapper.writerWithDefaultPrettyPrinter().writeValue(temp.toFile(), objeto);
            try {
                Files.move(temp, destino, StandardCopyOption.ATOMIC_MOVE);
            } catch (AtomicMoveNotSupportedException e) {
                Files.move(temp, destino, StandardCopyOption.REPLACE_EXISTING);
            }
            return true;
        } catch (IOException | RuntimeException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
            if (temp != null) {
                try { Files.deleteIfExists(temp); } catch (IOException ignored) {}
            }
            return false;
        }
    }
}
