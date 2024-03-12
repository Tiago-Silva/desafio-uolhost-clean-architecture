package br.com.uolhost.infrastructure.services;

import br.com.uolhost.application.dto.external.CodinomeDTO;
import br.com.uolhost.application.dto.external.LigaResponseDTO;
import br.com.uolhost.application.dto.external.VingadorDTO;
import br.com.uolhost.application.dto.external.VingadoresResponseDTO;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class PlayServices {

    public void codinomeIsExists(String grupo, String codinome) {
        if (grupo.equals("VINGADORES")) {
            VingadoresResponseDTO response = (VingadoresResponseDTO)
                callApi(
                    "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json",
                    MediaType.APPLICATION_JSON, new MappingJackson2HttpMessageConverter(),
                    VingadoresResponseDTO.class
                );
            this.verifyCodinomeIsExists(response.getVingadores(), codinome, VingadorDTO::getCodinome);
        } else if (grupo.equals("LIGA DA JUSTIÇA")) {
            LigaResponseDTO response = (LigaResponseDTO)
                callApi(
                    "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml",
                    MediaType.APPLICATION_XML, new MappingJackson2XmlHttpMessageConverter(),
                    LigaResponseDTO.class
                );
            this.verifyCodinomeIsExists(response.getCodinomes(), codinome, CodinomeDTO::getCodinome);
        } else {
            throw new RuntimeException("grupo não existe");
        }
    }

    private Object callApi(String url, MediaType mediaType, AbstractHttpMessageConverter converter, Class responseType) {
        RestTemplate restTemplate = new RestTemplate();

        // Configure the converter
        converter.setSupportedMediaTypes(Arrays.asList(mediaType, MediaType.TEXT_PLAIN));

        // Add the converter to the RestTemplate
        restTemplate.getMessageConverters().add(converter);

        ResponseEntity<?> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, responseType);

        return Objects.requireNonNull(responseEntity.getBody());
    }

    private <T> void verifyCodinomeIsExists(List<T> items, String codinome, Function<T, String> codinomeExtractor) {
        boolean codinomeExists = items.stream()
                .map(codinomeExtractor)
                .anyMatch(codinome::equals);

        if (!codinomeExists) {
            throw new RuntimeException("codinome não existe");
        }
    }
}
