package com.rulesAPI.controladores;

import com.rulesAPI.excepciones.NotFoundException;
import com.rulesAPI.modelos.entidades.Preferencia;
import com.rulesAPI.servicios.PreferenciaService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rulesAPI.servicios.PreferenciaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.math.BigDecimal;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/preferencia")
@Api(value = "Metodos para consultar las preferencias", tags = "Metodos sobre preferencias")
public class PreferenciaController {
    private final static Logger logger = LoggerFactory.getLogger(PreferenciaController.class);

    @Autowired
    private PreferenciaService preferenciaService;

    /**
     * Endpoint para consultar todas las preferencias
     * @return Retorna una lista de preferencias.
     * @NotFoundException Si no hay datos en la base de datos
     * @author EMHH  12-02-2022
     */
    @GetMapping("/lista")
    @ApiOperation(value = "Consultar todas las preferencias")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Endpoint ejecutado satisfactoriamente"),
            @ApiResponse(code = 404, message = "No hay elementos en la base de datos")
    })
    public ResponseEntity<?> listarTodas() {
        List<Preferencia> preferencias = (List<Preferencia>) preferenciaService.buscarTodos();
        
        if(preferencias.isEmpty()) throw new NotFoundException("No existen preferencias en la BD.");
        
        return new ResponseEntity<List<Preferencia>>(preferencias, HttpStatus.OK);
    }

    /**
     * Endpoint para consultar una preferencia por id
     * @param preferenciaId Parámetro de búsqueda de la preferencia
     * @return Retorna un objeto de tipo preferencia
     * @NotFoundException En caso de que falle buscando la preferencia
     * @author EMHH  21-02-2022
     */
    @GetMapping("/preferencia/id/{preferenciaId}")
    @ApiOperation(value = "Consultar un preferencia especifica por id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Endpoint ejecutado satisfactoriamente"),
            @ApiResponse(code = 404, message = "No hay elementos que coincidan en la base de datos")
    })
    public ResponseEntity<?> buscarPorId(@PathVariable Long preferenciaId) {
        Optional<Preferencia> oPreferencia = preferenciaService.buscarPorId(preferenciaId);

        if(!oPreferencia.isPresent())
                throw new NotFoundException(String.format("La preferencia con id: %d no existe", preferenciaId));

        return new ResponseEntity<Preferencia>(oPreferencia.get(), HttpStatus.OK);	
    }

    /**
     * Endpoint para guardar un preferencia
     * @param preferencia Parámetros que se guardaran en el preferencia
     * @return Retorna el preferencia guardada
     * @author EMHH  21-02-2022
     */
    @PostMapping("/guardar")
    @ApiOperation(value = "Guardar un preferencia")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Endpoint ejecutado satisfactoriamente"),
            @ApiResponse(code = 400, message = "Errores en el envio de informacion")
    })
    public ResponseEntity<?> guardar(@Valid @RequestBody Preferencia preferencia, BindingResult result) {
        Map<String, Object> validaciones = new HashMap<String, Object>();
        if(result.hasErrors()) {
            List<String> listaErrores = result.getFieldErrors()
                            .stream()
                            .map(errores -> "Campo: '" + errores.getField() + "' " + errores.getDefaultMessage())
                            .collect(Collectors.toList());
            validaciones.put("Lista Errores", listaErrores);
            logger.info(validaciones.toString());
            return new ResponseEntity<Map<String, Object>>(validaciones, HttpStatus.BAD_REQUEST);
        }

        Preferencia preferenciaGuardada = preferenciaService.guardar(preferencia);
        return new ResponseEntity<Preferencia>(preferenciaGuardada, HttpStatus.CREATED);
    }

    /**
     * Endpoint para eliminar un preferencia
     * @param preferenciaId Parámetro de búsqueda de la preferencia a eliminar
     * @return No retorna contenido, solo el status
     * @author EMHH  21-02-2022
     */
    @DeleteMapping("/eliminar/id/{preferenciaId}")
    @ApiOperation(value = "Eliminar un preferencia")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Endpoint ejecutado satisfactoriamente"),
            @ApiResponse(code = 404, message = "No hay elementos que coincidan")
    })
    public ResponseEntity<?> eliminar(@PathVariable Long preferenciaId) {
        Optional<Preferencia> oPreferencia = preferenciaService.buscarPorId(preferenciaId);

        if(!oPreferencia.isPresent())
                throw new NotFoundException(String.format("La preferencia con id: %d no existe", preferenciaId));

        preferenciaService.eliminarPorId(preferenciaId);
        return new ResponseEntity<>("La preferencia con id: " + preferenciaId + " fue eliminada", HttpStatus.NO_CONTENT);
    }
}