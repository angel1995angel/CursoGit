package pildoras.es.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pildoras.es.controlador.entity.Cliente;
import pildoras.es.dao.ClienteDAO;

@Controller
@RequestMapping("/cliente")
public class Controlador {
	@Autowired
	private ClienteDAO clienteDao;

	@RequestMapping("/lista")
	public String listaCliente(Model elModelo) {

		// obtener los clientes desde el dao
		List<Cliente> losCliente = clienteDao.getClientes();
		// Agregar los clientes al modelo
		elModelo.addAttribute("clientes", losCliente);
		return "lista-clientes";
	}

	@RequestMapping("/muestraFormularioAgregar")
	public String muestraFormularioAgregar(Model elModelo) {

//		bind de datos del cliente
		Cliente elCliente = new Cliente();
		elModelo.addAttribute("cliente", elCliente);
		return "formularioCliente";
	}

	@PostMapping("/insertarCliente")
	public String insertarCliente(@ModelAttribute("cliente") Cliente elCLiente) {
		// insertar clientes en la base de datos
		clienteDao.insertaCliente(elCLiente);

		return "redirect:/cliente/lista";

	}

}
