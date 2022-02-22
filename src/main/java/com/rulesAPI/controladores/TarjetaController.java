package com.rulesAPI.controladores;

import com.rulesAPI.excepciones.NotFoundException;
import com.rulesAPI.modelos.entidades.Conclusion;
import com.rulesAPI.modelos.entidades.Regla;
import com.rulesAPI.servicios.ReglaService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.math.BigDecimal;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/tarjetas")
@Api(value = "Metodos relacionados con las tarjetas", tags = "Metodos sobre tarjetas")
public class TarjetaController {
    private final static Logger logger = LoggerFactory.getLogger(TarjetaController.class);

    @Autowired
    private ReglaService reglaService;

    /**
     * Endpoint para consultar todas las tarjetas mediante un 
     * @param preferencia
     * @param salario
     * @param edad
     * @return Retorna una lista de tipo tarjetas
     * @NotFoundException En caso de que no existan valores en la BD
     * @author EMHH - 17-02-2022
     */
    @PostMapping("/lista/usuarioPerfil")
    @ApiOperation(value = "Actualizar un tarjeta")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Endpoint ejecutado satisfactoriamente"),
            @ApiResponse(code = 404, message = "No hay elementos que coincidan")
    })
    public ResponseEntity<?> obtenerTodosPorPerfilUsuario(@RequestParam("preferencia") String preferencia, @RequestParam("salario") BigDecimal salario, @RequestParam("edad") int edad ){
        List<Conclusion> tarjetas = (List<Conclusion>) reglaService.buscarTarjetaPorTodosParametros(preferencia, salario, edad);
        
        return new ResponseEntity<List<Conclusion>>(tarjetas, HttpStatus.OK);
    }
}