package com.example.curso.boot.dao.em;


import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.curso.boot.domain.Funcionario;


@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

	public List<Funcionario> findByNome(String nome) {
		return createQuery("select f from Funcionario f where f.nome like concat('%',?1,'%') ", nome);
	}

	@Override
	public List<Funcionario> findByCargoId(Long id) {
		return createQuery("select f from Funcionario f where f.cargo.id = ?1", id);
	}

	@Override
	public List<Funcionario> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida) {
		String jpql = new StringBuilder("select f from Funcionario f ")
				.append("where f.dataEntrada >= ?1 and f.dataSaida <= ?2 ")
				.append("order by f.dataEntrada asc")
				.toString();
		return createQuery(jpql, entrada, saida);
	}

	@Override
	public List<Funcionario> findByDataEntrada(LocalDate entrada) {
		String jpql = new StringBuilder("select f from Funcionario f ")
				.append("where f.dataEntrada = ?1 ")
				.append("order by f.dataEntrada asc")
				.toString();
		return createQuery(jpql, entrada);
	} 

	@Override
	public List<Funcionario> findByDataSaida(LocalDate saida) {
		String jpql = new StringBuilder("select f from Funcionario f ")
				.append("where f.dataSaida = ?1 ")
				.append("order by f.dataEntrada asc")
				.toString();
		return createQuery(jpql, saida);
	}	
	
	
//    public Funcionario recuperarPorPlaylistIdEMusicaId(long playlistId, long musicaId) {
//        return getEntityManager().createQuery("select m from Musica m where m.playlist.id = :playlistId and m.id = :musicaId", Funcionario.class)
//                .setParameter("playlistId", playlistId)
//                .setParameter("musicaId", musicaId)
//                .getSingleResult();
//    }
	
//	 public List<Funcionario> recuperarPorPlaylist(long playlistId) {
//	        return getEntityManager().createQuery("select m from Musica m where m.playlist.id = :playlistId", Funcionario.class)
//	                .setParameter("playlistId", playlistId)
//	                .getResultList();
//	    }
}