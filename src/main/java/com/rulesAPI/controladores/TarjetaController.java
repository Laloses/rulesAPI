package com.rulesAPI.controladores;

import com.rulesAPI.excepciones.NotFoundException;
import com.rulesAPI.modelos.entidades.Tarjeta;
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

import com.rulesAPI.servicios.TarjetaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.math.BigDecimal;
import javax.validation.Valid;

@RestController
//@RequestMapping("/tarjeta")
@Api(value = "Metodos para consultar las tarjetas", tags = "Metodos sobre tarjetas")
public class TarjetaController {
    private final static Logger logger = LoggerFactory.getLogger(TarjetaController.class);

    @Autowired
    private TarjetaService tarjetaService;

    /**
     * Endpoint para consultar todas las tarjetas
     * @return Retorna una lista de tarjetas.
     * @NotFoundException Si no hay datos en la base de datos
     * @author EMHH  12-02-2022
     */
    @GetMapping("/lista")
    @ApiOperation(value = "Consultar todas las tarjetas")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Endpoint ejecutado satisfactoriamente"),
            @ApiResponse(code = 404, message = "No hay elementos en la base de datos")
    })
    public ResponseEntity<?> listarTodas() {
        List<Tarjeta> tarjetas = (List<Tarjeta>) tarjetaService.buscarTodos();
        
        if(tarjetas.isEmpty()) throw new NotFoundException("No existen tarjetas en la BD.");
        
        return new ResponseEntity<List<Tarjeta>>(tarjetas, HttpStatus.OK);
    }

    /**
     * Endpoint para consultar una tarjeta por id
     * @param tarjetaId Parámetro de búsqueda de la tarjeta
     * @return Retorna un objeto de tipo tarjeta
     * @NotFoundException En caso de que falle buscando la tarjeta
     * @author EMHH  21-02-2022
     */
    @GetMapping("/tarjeta/id/{tarjetaId}")
    @ApiOperation(value = "Consultar un tarjeta especifica por id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Endpoint ejecutado satisfactoriamente"),
            @ApiResponse(code = 404, message = "No hay elementos que coincidan en la base de datos")
    })
    public ResponseEntity<?> buscarPorId(@PathVariable Long tarjetaId) {
        Optional<Tarjeta> oTarjeta = tarjetaService.buscarPorId(tarjetaId);

        if(!oTarjeta.isPresent())
                throw new NotFoundException(String.format("La tarjeta con id: %d no existe", tarjetaId));

        return new ResponseEntity<Tarjeta>(oTarjeta.get(), HttpStatus.OK);	
    }

    /**
     * Endpoint para guardar un tarjeta
     * @param tarjeta Parámetros que se guardaran en el tarjeta
     * @return Retorna el tarjeta guardada
     * @author EMHH  21-02-2022
     */
    @PostMapping("/guardar")
    @ApiOperation(value = "Guardar un tarjeta")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Endpoint ejecutado satisfactoriamente"),
            @ApiResponse(code = 400, message = "Errores en el envio de informacion")
    })
    public ResponseEntity<?> guardar(@Valid @RequestBody Tarjeta tarjeta, BindingResult result) {
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

        Tarjeta tarjetaGuardada = tarjetaService.guardar(tarjeta);
        return new ResponseEntity<Tarjeta>(tarjetaGuardada, HttpStatus.CREATED);
    }

    /**
     * Endpoint para eliminar un tarjeta
     * @param tarjetaId Parámetro de búsqueda de la tarjeta a eliminar
     * @return No retorna contenido, solo el status
     * @author EMHH  21-02-2022
     */
    @DeleteMapping("/eliminar/id/{tarjetaId}")
    @ApiOperation(value = "Eliminar un tarjeta")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Endpoint ejecutado satisfactoriamente"),
            @ApiResponse(code = 404, message = "No hay elementos que coincidan")
    })
    public ResponseEntity<?> eliminar(@PathVariable Long tarjetaId) {
        Optional<Tarjeta> oTarjeta = tarjetaService.buscarPorId(tarjetaId);

        if(!oTarjeta.isPresent())
                throw new NotFoundException(String.format("La tarjeta con id: %d no existe", tarjetaId));

        tarjetaService.eliminarPorId(tarjetaId);
        return new ResponseEntity<>("La tarjeta con id: " + tarjetaId + " fue eliminada", HttpStatus.NO_CONTENT);
    }

    /**
     * Endpoint para actualizar un tarjeta
     * @param tarjetaId Parámetro de búsqueda de la tarjeta a actualizar
     * @param tarjeta Datos del tarjeta que se cambiaran
     * @return Retorna el tarjeta actualizada
     * @NotFoundException En caso de no existir el tarjeta
     * @author EMHH  21-02-2022
     */
    @PutMapping("/actualizar/id/{tarjetaId}")
    @ApiOperation(value = "Actualizar un tarjeta")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Endpoint ejecutado satisfactoriamente"),
            @ApiResponse(code = 404, message = "No hay elementos que coincidan")
    })
    public ResponseEntity<?> actualizar(@PathVariable Long tarjetaId, @Valid @RequestBody Tarjeta tarjeta, BindingResult result) {
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

        Tarjeta tarjetaActualizada = null;

        try{
            tarjetaActualizada = tarjetaService.actualizar(tarjetaId, tarjeta);
        }
        catch (Exception e) {
            logger.info(e.getMessage());
            throw e;
        }

        return new ResponseEntity<Tarjeta>(tarjetaActualizada, HttpStatus.OK);
    }

    /**
     * Endpoint para consultar tarjetas que cumplan ciertos valores
     * @param preferencia
     * @param salario
     * @param edad
     * @return Retorna una lista del nombre de tarjetas
     * @NotFoundException En caso de que no existan valores en la BD
     * @author EMHH  21-02-2022
     */
    @PostMapping("/lista/perfilUsuario")
    @ApiOperation(value = "Consultar tarjetas que cumplan con el perfil del usuario")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Endpoint ejecutado satisfactoriamente"),
            @ApiResponse(code = 404, message = "No hay elementos que coincidan")
    })
    public ResponseEntity<?> obtenerPorPerfilUsuario(
            @RequestBody String preferencia, 
            @RequestBody BigDecimal salario, 
            @RequestBody int edad
    ){
        List<Tarjeta> tarjetas = tarjetaService.buscarConTodosParametros(preferencia, salario, edad);
        
        List<String> tarjetasNombre = tarjetas
                .stream()
                .map(t -> t.getNombre())
                .collect(Collectors.toList());
        
        return new ResponseEntity<List<String>>(tarjetasNombre, HttpStatus.OK);
    }
}