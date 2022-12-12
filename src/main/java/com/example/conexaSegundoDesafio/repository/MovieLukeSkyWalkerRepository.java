package com.example.conexaSegundoDesafio.repository;

import com.example.conexaSegundoDesafio.persistence.entity.MovieLukeSkyWalkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieLukeSkyWalkerRepository extends JpaRepository<MovieLukeSkyWalkerEntity, Long> {
    MovieLukeSkyWalkerEntity findByEpisodeId(Integer id);
}
