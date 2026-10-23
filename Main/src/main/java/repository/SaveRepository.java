package repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Config;

import java.io.File;
import java.io.IOException;

public class SaveRepository {
    ObjectMapper mapper = new ObjectMapper();

    public SaveRepository(ObjectMapper mapper){
        this.mapper = mapper;
    }

    public Config ReadConfig(){

        try{
            return mapper.readValue(new File("saves/config.json"), Config.class);
        }catch (IOException error) {
            System.err.println("Erro ao ler as configurações: " + error.getMessage());
            return new Config("0","0","0");
        }
    }

    public void WriteConfig(Config config){

        try {
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File("saves/config.json"),config);

            System.out.println("Ficheiro JSON guardado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no JSON: " + e.getMessage());
    }
}
}
