package com.doncurrulo.app.service;

import org.springframework.stereotype.Service;

import com.doncurrulo.app.entity.Cliente;
import com.doncurrulo.app.repository.ClienteRepository;
import com.doncurrulo.app.utilidades.GenericResponse;

import javax.transaction.Transactional;
import java.util.Optional;

import static com.doncurrulo.app.utilidades.Global.*;

@Service
@Transactional
public class ClienteService
{
	private final ClienteRepository repository;
	
	public ClienteService(ClienteRepository repository)
	{
		this.repository = repository;
	}
	
	//Método para guardar y actualizar cliente
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GenericResponse<?> save(Cliente c)
	{
		Optional<Cliente> opt = this.repository.findById(c.getId_cliente());
		int idf = opt.isPresent() ? opt.get().getId_cliente() : 0;
		if (idf == 0)
		{
			if (repository.existByDoc(c.getNumDocumento().trim()) == 1)
			{
				return new GenericResponse(TIPO_RESULT, RPTA_WARNING, "Lo sentimos: " +
						"Ya existe un cliente con ese mismo número de documento, " +
						"y si el problema persiste comuniquese con el soporte técnico", null);
			}
			else
			{
				//Guarda
				c.setId_cliente(idf);
				return new GenericResponse(TIPO_DATA, RPTA_OK, "¡Cliente registrado correctamente!",
						this.repository.save(c));
			}
		}
		else
		{
			//Actualizar registro
			if (repository.existByDocForUpdate(c.getNumDocumento().trim(), c.getId_cliente()) == 1)
			{
				return new GenericResponse(TIPO_RESULT, RPTA_WARNING, "Error: Ya existe un cliente con esos mismos datos" +
						"verifique e intente de nuevo", null);
			}
			else
			{
				//Actualiza
				c.setId_cliente(idf);
				return new GenericResponse(TIPO_DATA, RPTA_OK, "¡Datos del cliente actualizado!", this.repository.save(c));
			}
		}
	}
}