package br.com.tiagocrais.publi.api.service.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UfEstadoDictionary {

    private final Map<String, String> ufEstadoMap;

    private final String UF_INVALIDA = "UF Inválida";

    public UfEstadoDictionary() {
        ufEstadoMap = new HashMap<>();
        ufEstadoMap.put("ro", "Rondônia");
        ufEstadoMap.put("ac", "Acre");
        ufEstadoMap.put("am", "Amazonas");
        ufEstadoMap.put("rr", "Roraima");
        ufEstadoMap.put("pa", "Pará");
        ufEstadoMap.put("ap", "Amapá");
        ufEstadoMap.put("to", "Tocantins");
        ufEstadoMap.put("ma", "Maranhão");
        ufEstadoMap.put("pi", "Piauí");
        ufEstadoMap.put("ce", "Ceará");
        ufEstadoMap.put("rn", "Rio Grande do Norte");
        ufEstadoMap.put("pb", "Paraíba");
        ufEstadoMap.put("pe", "Pernambuco");
        ufEstadoMap.put("al", "Alagoas");
        ufEstadoMap.put("se", "Sergipe");
        ufEstadoMap.put("ba", "Bahia");
        ufEstadoMap.put("mg", "Minas Gerais");
        ufEstadoMap.put("es", "Espírito Santo");
        ufEstadoMap.put("rj", "Rio de Janeiro");
        ufEstadoMap.put("sp", "São Paulo");
        ufEstadoMap.put("pr", "Paraná");
        ufEstadoMap.put("sc", "Santa Catarina");
        ufEstadoMap.put("rs", "Rio Grande do Sul");
        ufEstadoMap.put("ms", "Mato Grosso do Sul");
        ufEstadoMap.put("mt", "Mato Grosso");
        ufEstadoMap.put("go", "Goiás");
        ufEstadoMap.put("df", "Distrito Federal");
    }

    public String getEstadoFromUf(String uf) {
        return ufEstadoMap.get(uf.toLowerCase());
    }

    public String obterEstado(String uf) {
        String estado = getEstadoFromUf(uf);
        if(estado == null) {
            return UF_INVALIDA;
        }
        return estado;
    }
}
