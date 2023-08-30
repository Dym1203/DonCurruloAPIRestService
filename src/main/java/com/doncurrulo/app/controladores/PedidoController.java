package com.doncurrulo.app.controladores;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.doncurrulo.app.entity.dto.GenerarPedidoDTO;
import com.doncurrulo.app.entity.dto.PedidoConDetallesDTO;
import com.doncurrulo.app.service.PedidoService;
import com.doncurrulo.app.utilidades.GenericResponse;

import java.util.List;

@RestController
@RequestMapping("api/pedido")
public class PedidoController
{
	private final PedidoService service;
	
	public PedidoController(PedidoService service)
	{
		this.service = service;
	}
	
	//LISTAR PEDIDOS CON DETALLES
	@GetMapping("/misPedidos/{idCli}")
	public GenericResponse<List<PedidoConDetallesDTO>> devolverMisComprasConDetalle(@PathVariable int idCli)
	{
		return this.service.devolverMisCompras(idCli);
	}
	
	//GUARDAR PEDIDO
	@SuppressWarnings("rawtypes")
	@PostMapping
	public GenericResponse guardarPedido(@RequestBody GenerarPedidoDTO dto)
	{
		return this.service.guardarPedido(dto);
	}
	
	//ANULAR PEDIDO
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public GenericResponse anularPedido(@PathVariable int id)
	{
		return this.service.anularPedido(id);
	}
	
	//EXPORTAR PDF DE ORDEN
	@GetMapping("exportInvoice")
	public ResponseEntity<Resource> exportInvoice(@RequestParam int idCli, @RequestParam int idPed, @RequestParam int idOrden)
	{
		return this.service.exportInvoice(idCli, idPed, idOrden);
	}
}