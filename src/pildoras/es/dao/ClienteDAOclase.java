package pildoras.es.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pildoras.es.controlador.entity.Cliente;

@Repository
public class ClienteDAOclase implements ClienteDAO {

	// esta variable se tiene que llamar como esta en el archivo de configuracion
	// spring-crud-sevlet.xml
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Cliente> getClientes() {
		// obtener la session
		Session miSession = sessionFactory.getCurrentSession();
		// Crear la consulta(Query)
		Query<Cliente> miQuery = miSession.createQuery("from Cliente", Cliente.class);
		System.out.println("miQuery-->" + miQuery.getFirstResult());
		System.out.println("miQuery-->" + miQuery.getQueryString());

		// ejecutar Query y devolver resultado
		List<Cliente> clientes = miQuery.getResultList();
		return clientes;
	}

	@Override
	@Transactional
	public void insertaCliente(Cliente elCLiente) {
		// obtener la session
		Session miSession = sessionFactory.getCurrentSession();
		// insertar cliente en la base de datos
		miSession.save(elCLiente);

	}

}
