package repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Config;
import model.Conquista;

import java.io.File;
import java.io.IOException;

public class SaveRepository {
    ObjectMapper mapper = new ObjectMapper();

    public SaveRepository(ObjectMapper mapper){
        this.mapper = mapper;
    }

    public <E> E readFile(String caminho, Class<E> classe,E padrao){

        try{
            return mapper.readValue(new File(caminho), classe);
        }catch (IOException error) {
            System.err.println("Erro ao ler o arquivo: " + error.getMessage());
            return padrao;
        }
    }
    public <E> void writeFile(String caminho, E classe){

        try {
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(caminho),classe);

            System.out.println("Ficheiro JSON guardado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no JSON: " + e.getMessage());
    }
}
}
