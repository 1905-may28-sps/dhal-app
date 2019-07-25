package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.DhalPlaylists;


@Repository
public interface PlaylistsRepository extends JpaRepository<DhalPlaylists, Integer>{
	
	DhalPlaylists findByPlaylistId(int id);

	
}